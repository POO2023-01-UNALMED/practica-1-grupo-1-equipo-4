import tkinter as tk
from tkinter import ttk,Frame,messagebox
import sys
sys.path.append('../')  # Retrocede un nivel al directorio padre

from excepciones import NoTrabajadores
from gestorAplicacion.gestion.Factura import Factura
from gestorAplicacion.produccion.Fabrica import Fabrica
from gestorAplicacion.gestion.CuentaBancaria import CuentaBancaria
from gestorAplicacion.gestion.Operario import Operario
from gestorAplicacion.gestion.Vendedor import Vendedor
from gestorAplicacion.gestion.Conductor import Conductor


class PagoTrabajadores(Frame):
    def __init__(self, window):
        super().__init__(window)

        self.config(bg="#b6fce6")

        listaFacturas = Factura.getListaFacturas()
                
        #-----------------------------Eventos -------------------------------------------------------------
        
        #Cuando escoge un tipo del desplegable de tipos
        def opcionTipoTrabajador(evento):
            global listaMostrar
            global num

            opc = desplegableTipos.get()         
            if opc == "Conductores":
                num = 2
            elif opc == "Operarios":
                num = 1
            elif opc == "Vendedores":
                num = 3
            else:
                frameTipos12.grid_remove()
                desplegableTrabajadores['values'] = ()

            listaMostrar = Fabrica.busquedaTrabajo(listaFacturas,num)
            values = []
            for trabajador in listaMostrar:
                values.append(trabajador.getNombre())
            
            #Excepción
            try:
                if values == []:
                    raise NoTrabajadores()
                else:
                    desplegableTrabajadores['values'] = list(set(values))
                    frameTipos12.grid()
            except NoTrabajadores:
                    messagebox.showerror("No es posible el pago", NoTrabajadores()) 

        #Cuando escoge un trabajador del desplegable de trabajadores
        def opcionTrabajador(evento):

            global trabajadorEscogido
            global pagoTrabajo
            global pagoMeta
            pagoMeta = 0

            opc = desplegableTrabajadores.get()

            for trabajador in listaMostrar:
                if trabajador.getNombre() == opc:
                    trabajadorEscogido = trabajador
            datosTrabajador.config(text=trabajadorEscogido.__str__())

            pagoTrabajo = CuentaBancaria.calcularPago(trabajadorEscogido)
            textoInfoTrabajador = f"Al trabajador se le pagará {pagoTrabajo} por trabajar {trabajadorEscogido.getTrabajo()} veces"
            infoTrabajador.config(text=textoInfoTrabajador)
            
            frameInfo.grid()

        #Cuando desea analizar y bonificar metas
        def opcionMetaSi():
            
            global listaMetas

            if num == 1:
                listaMetas = Operario.getMetasOperario()
                textoIndice = "Indice: número de productos vendidos\n"
            elif num == 2:
                listaMetas = Conductor.getMetasConductor()
                textoIndice = "Indice: peso de productos transportados\n"
            elif num ==3:
                listaMetas = Vendedor.getMetasVendedor()
                textoIndice = "Indice: número de productos vendidos\n"


            textoMetasTrabajador = textoIndice
            for i in range(len(listaMetas)):
                textoMetasTrabajador += f"Meta {i+1}\n"
                textoMetasTrabajador += listaMetas[i].__str__()

            textoMetas.config(text=textoMetasTrabajador)
            frameMetas.grid()

            #Deshabilitar los desplegables
            desplegableTipos.config(state='disabled')
            desplegableTrabajadores.config(state='disabled')

        #Cuando escoge una meta del desplegable de metas
        def opcionMeta(evento):
            global posicionMeta
            global pagoMeta
            opc = desplegableMetas.get()
            cumple = ""
           
            if opc == "Meta 1":
                posicionMeta = 0
                metaEscogida = listaMetas[0]                
                
            elif opc == "Meta 2":
                posicionMeta = 1
                metaEscogida = listaMetas[1]        

            indice = trabajadorEscogido.getIndiceMeta()
            verificadorMeta = metaEscogida.cumpleMeta(indice)
            estadisticasMeta = metaEscogida.porcentajesCumplidos(indice)
            
            listaVerificadores = trabajadorEscogido.getVerificadorMetasCumplidas()
            if listaVerificadores[posicionMeta] == False:
                if verificadorMeta == True:
                    pagoMeta = metaEscogida.getPago()
                    cumple = "Meta cumplida\n"
                textoInfoMeta.config(text=cumple+estadisticasMeta)
            else:
                textoInfoMeta.config(text="""Ya se ha dado la bonificación por esta meta,\nseleccione otra opción o proceda a pagar""")      

            frameMetas2.grid()
            botonPago.grid()
            
            
        #Cuando paga
        def opcionPago():
            trabajadorEscogido.recibirSueldo(pagoTrabajo + pagoMeta)
            messagebox.showinfo(f"Pago existoso",f"Comprobante de pago\nPago asociado a los envios realizados: {pagoTrabajo}\nPago asociado al cumplimiento de metas: {pagoMeta}\nTotal: {pagoTrabajo+pagoMeta}")

            #Asignamos de nuevo 0 al trabajo, para que si se le paga de nuevo,
            #no se le pague más de una vez por el mismo trabajo
            trabajadorEscogido.setTrabajo(0)
            if pagoMeta != 0:
                trabajadorEscogido.getVerificadorMetasCumplidas()[posicionMeta] = True
            
            #Habilitar los desplegables
            desplegableTipos.config(state='readonly')
            desplegableTrabajadores.config(state='readonly')

            #Remover los frames mostrados y textos del trabajador pasado
            desplegableTipos.set('')
            desplegableTrabajadores.set('')
            frameTipos12.grid_remove()
            frameInfo.grid_remove()
            desplegableMetas.set('')
            frameMetas.grid_remove()
            textoInfoMeta.config(text="")
            frameMetas2.grid_remove()
            botonPago.grid_remove()

        #----------------------------------Divisiones filas y columnas-------------------------------------
        for i in range(12):
            self.rowconfigure(i, weight=1)

        for j in range(4):
            self.columnconfigure(j, weight=1)

        #---------------------------------Título y descripción---------------------------------------------
        frameCabecera = tk.Frame(self, bg="#b6fce6")
        frameCabecera.grid(row=0, column=1, columnspan=2,padx=5, pady=5)
        titulo = tk.Label(frameCabecera, text='Pagar a trabajadores', font=("Arial", 15, "bold"), bg ="#33a8d6", relief="raised", border=3 )
        titulo.pack(fill="x", pady=3, padx=4)
        textoDescripcion = """Aquí podra seleccionar alguno de los trabajadores disponibles según su función 
        (Conductores,Operarios y Vendedores), pagarles por sus respectivas horas trabajadas 
        y además verificar sus metas dando bonificaciones por el cumpliento de las mismas."""
        descripcion = tk.Label(frameCabecera, text=textoDescripcion,font=("Arial", 12), bg ="#93cfbc", border=2,relief="sunken")
        descripcion.pack(pady=2, padx=4)

        #-----------------------------------Trabajador ----------------------------------------------------
        #Tipo
        frameTipos1 = tk.Frame(self, bg="#33a8d6",relief="raised", border=2)
        frameTipos1.grid(row=1, column=1, columnspan=2, padx=5, pady=5)

        frameTipos11 = tk.Frame(frameTipos1,relief="raised", border=2)
        frameTipos11.grid(row=1, column=1, padx=5, pady=5)

        textoTipos = tk.Label(frameTipos11, text='Tipos de trabajadores', font=("Arial", 12, "bold"))
        textoTipos.pack(side='top', anchor='center', pady=3, padx=3)

        tipoPredeterminado = tk.StringVar(value='Seleccionar tipo')
        desplegableTipos = ttk.Combobox(frameTipos11, values=["Operarios", "Conductores", "Vendedores"], textvariable=tipoPredeterminado, state='readonly')
        desplegableTipos.pack(side='top', anchor='center', pady=3, padx=3)
        desplegableTipos.bind("<<ComboboxSelected>>", opcionTipoTrabajador)
        

        #Trabajador
        frameTipos12 = tk.Frame(frameTipos1,relief="raised", border=2)
        frameTipos12.grid(row=1, column=2, padx=5, pady=5)
        frameTipos12.grid_remove()

        textoTrabajadores = tk.Label(frameTipos12, text='Trabajadores', font=("Arial", 12, "bold"))
        textoTrabajadores.pack(side='top', anchor='center', pady=3, padx=3)

        trabajadorPredeterminado = tk.StringVar(value='Seleccionar trabajador')
        desplegableTrabajadores = ttk.Combobox(frameTipos12, textvariable=trabajadorPredeterminado, state='readonly')  # Cambio aquí
        desplegableTrabajadores.pack(side='top', anchor='center', pady=3, padx=3)
        desplegableTrabajadores.bind("<<ComboboxSelected>>",opcionTrabajador)
        

        #------------------------------Información trabajador seleccionado y Pregunta metas---------------
        frameInfo = tk.Frame(self, bg="#33a8d6",relief="raised", border=2)
        frameInfo.grid(row=2, column=1, columnspan=2 ,padx=5, pady=5)
        frameInfo.grid_remove()

        #Información del trabajador
        datosTrabajador = tk.Label(frameInfo,font=("Arial", 10), border=2,relief="sunken" )#, bg ="#56E5D1"
        datosTrabajador.pack(pady=3, padx=3)

        #Información de lo que se le va a pagar
        infoTrabajador = tk.Label(frameInfo,font=("Arial", 10), bg ="#2a32bf", fg="#ffffff", border=2,relief="sunken" )#,bg ="#DFE556"
        infoTrabajador.pack(pady=3, padx=3)

        pregunta = "¿Desea analizar y bonificar al trabajador por sus metas cumplidas?"
        textoPregunta = tk.Label(frameInfo, text=pregunta, font=("Arial", 12, "bold"), border=2,relief="sunken" )
        textoPregunta.pack(pady=3, padx=3)

        frameInfoBotones = tk.Frame(frameInfo, border=2,relief="sunken")
        frameInfoBotones.pack(pady=6, padx=3)

        #Estilo botones
        estilo = ttk.Style()
        estilo.configure("Estilo.TButton", font=("Arial", 10), padding=5, width=25, bg="#93cfbc")
        #Botón Si
        botonSi = ttk.Button(frameInfoBotones, text="Sí", style="Estilo.TButton",command=opcionMetaSi)
        botonSi.pack(side="left", padx=10)
        #Botón No
        textPago = """No, proceder con el pago"""
        botonNo = ttk.Button(frameInfoBotones, text=textPago, style="Estilo.TButton", command=opcionPago)
        botonNo.pack(side="right", padx=10)

        #-------------------------------------Bonificación metas-----------------------------------------

        frameMetas = tk.Frame(self,bg="#33a8d6",relief="raised", border=2)
        frameMetas.grid(row=3, column=1, columnspan=2, rowspan=3 ,padx=5, pady=5)
        frameMetas.grid_remove()

        #Metas dependiendo del tipo
        textoMetas = tk.Label( frameMetas, font=("Arial", 10, ), border=2,relief="sunken") #, bg ="#B856E5"
        textoMetas.grid(row=3, column=1,columnspan=2,padx=5, pady=5)

        #Elección de meta 
        frameMetas1 = tk.Frame(frameMetas, relief="raised", border=2)
        frameMetas1.grid(row=4, column=1, padx=5, pady=5)

        textoTituloMetas = tk.Label(frameMetas1, text='Metas', font=("Arial", 12, "bold"))
        textoTituloMetas.pack(side='top', anchor='center', padx=2, pady=2)

        metasPredeterminada = tk.StringVar(value='Seleccionar meta')
        desplegableMetas = ttk.Combobox(frameMetas1, values=["Meta 1", "Meta 2"], textvariable=metasPredeterminada, state='readonly')
        desplegableMetas.pack(side='top', anchor='center', padx=2, pady=2)
        desplegableMetas.bind("<<ComboboxSelected>>", opcionMeta)

        #Información de la meta
        frameMetas2 = tk.Frame(frameMetas)
        frameMetas2.grid(row=4, column=2, padx=5, pady=5)
        frameMetas2.grid_remove()

        textoInfoMeta= tk.Label(frameMetas2,font=("Arial", 10), border=2,relief="sunken")
        textoInfoMeta.pack(anchor='center')

        #Botón de pago
        botonPago = ttk.Button(frameMetas, text="Pagar total", style="Estilo.TButton",command=opcionPago)
        botonPago.grid(row=5, column=1, columnspan=2,padx=5, pady=5)
        botonPago.grid_remove()