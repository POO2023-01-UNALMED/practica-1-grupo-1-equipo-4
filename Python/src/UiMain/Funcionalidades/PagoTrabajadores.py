import tkinter as tk
from tkinter import ttk,Frame,messagebox
import sys
sys.path.append('../')  # Retrocede un nivel al directorio padre
import Objetos as prueba
from gestorAplicacion.gestion.Factura import Factura
from gestorAplicacion.produccion.Fabrica import Fabrica
from gestorAplicacion.gestion.CuentaBancaria import CuentaBancaria
from gestorAplicacion.gestion.Operario import Operario
from gestorAplicacion.gestion.Vendedor import Vendedor
from gestorAplicacion.gestion.Conductor import Conductor


class PagoTrabajadores(Frame):
    def __init__(self, window):
        super().__init__(window)

        listaFacturas = Factura.getListaFacturas()
                
        #-----------------------------Eventos -------------------------------------------------------------
        
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
            desplegableTrabajadores['values'] = values
            frameTipos12.grid()

        def opcionTrabajador(evento):
            global trabajadorEscogido
            global pagoTrabajo

            opc = desplegableTrabajadores.get()

            for trabajador in listaMostrar:
                if trabajador.getNombre() == opc:
                    trabajadorEscogido = trabajador
            datosTrabajador.config(text=trabajadorEscogido.__str__())

            pagoTrabajo = CuentaBancaria.calcularPago(trabajadorEscogido)
            textoInfoTrabajador = f"Al trabajador se le pagará {pagoTrabajo} por trabajar {trabajadorEscogido.getTrabajo()} veces"
            infoTrabajador.config(text=textoInfoTrabajador)
            
            frameInfo.grid()

        def opcionPagoSinMeta():      
            messagebox.showinfo(f"Pago existoso",f"Comprobante de pago\nPago asociado a los envios realizados: {pagoTrabajo}\nPago asociado al cumplimiento de metas: {0}\nTotal: {pagoTrabajo}")
            frameTipos12.grid_remove()
            frameInfo.grid_remove()
            frameMetas.grid_remove()

        def opcionMetaSi():

            indice = trabajadorEscogido.getIndiceMeta()

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
                textoMetasTrabajador += f"Meta {i+1}"
                textoMetasTrabajador += listaMetas[i].__str__()

            textoMetas.config(text=textoMetasTrabajador)
            frameMetas.grid()

        def opcionMeta(evento):
            opc = desplegableMetas.get()
            global pagoMeta
            
            if opc == "Meta 1":

                
                textoInfoMeta.config(text="")
                pagoMeta = 0
                frameMetas2.grid()
                botonPago.grid()
                
            elif opc == "Meta 2":

                textoInfoMeta.config(text="")
                pagoMeta = 0
                frameMetas2.grid()
                botonPago.grid()
            

        def opcionPagoConMeta():
            messagebox.showinfo(f"Pago existoso",f"Comprobante de pago\nPago asociado a los envios realizados: {pagoTrabajo}\nPago asociado al cumplimiento de metas: {pagoMeta}\nTotal: {pagoTrabajo+pagoMeta}")
            frameTipos12.grid_remove()
            frameInfo.grid_remove()
            frameMetas.grid_remove()

        #----------------------------------Divisiones filas y columnas-------------------------------------
        for i in range(12):
            self.rowconfigure(i, weight=1)

        for j in range(4):
            self.columnconfigure(j, weight=1)

        #---------------------------------Título y descripción---------------------------------------------
        frameCabecera = tk.Frame(self)
        frameCabecera.grid(row=0, column=1, columnspan=2,padx=5, pady=5)
        titulo = tk.Label(frameCabecera, text='Pagar a trabajadores', font=("Arial", 15))
        titulo.pack()
        textoDescripcion = """Aquí podra seleccionar alguno de los trabajadores disponibles según su función 
        (Conductores,Operarios y Vendedores), pagarles por sus respectivas horas trabajadas 
        y además verificar sus metas dando bonificaciones por el cumpliento de las mismas."""
        descripcion = tk.Label(frameCabecera, text=textoDescripcion,font=("Arial", 10))
        descripcion.pack()

        #-----------------------------------Trabajador ----------------------------------------------------
        #Tipo
        frameTipos1 = tk.Frame(self)
        frameTipos1.grid(row=1, column=1, columnspan=2, padx=5, pady=5)

        frameTipos11 = tk.Frame(frameTipos1)
        frameTipos11.grid(row=1, column=1, padx=5, pady=5)

        textoTipos = tk.Label(frameTipos11, text='Tipos de trabajadores', font=("Arial", 12))
        textoTipos.pack(side='top', anchor='center')

        tipoPredeterminado = tk.StringVar(value='Seleccionar tipo')
        desplegableTipos = ttk.Combobox(frameTipos11, values=["Operarios", "Conductores", "Vendedores"], textvariable=tipoPredeterminado, state='readonly')
        desplegableTipos.pack(side='top', anchor='center')
        desplegableTipos.bind("<<ComboboxSelected>>", opcionTipoTrabajador)

        #Trabajador
        frameTipos12 = tk.Frame(frameTipos1)
        frameTipos12.grid(row=1, column=2, padx=5, pady=5)
        frameTipos12.grid_remove()

        textoTrabajadores = tk.Label(frameTipos12, text='Trabajadores', font=("Arial", 12))
        textoTrabajadores.pack(side='top', anchor='center')

        trabajadorPredeterminado = tk.StringVar(value='Seleccionar trabajador')
        desplegableTrabajadores = ttk.Combobox(frameTipos12, textvariable=trabajadorPredeterminado, state='readonly')  # Cambio aquí
        desplegableTrabajadores.pack(side='top', anchor='center')
        desplegableTrabajadores.bind("<<ComboboxSelected>>",opcionTrabajador)

        #------------------------------Información trabajador seleccionado y Pregunta metas---------------
        frameInfo = tk.Frame(self)
        frameInfo.grid(row=2, column=1, columnspan=2 ,padx=5, pady=5)
        frameInfo.grid_remove()

        #Información del trabajador
        #datos = "Edad:  10 \nCédula: 92345 \nTienda: La tienda de la esquina"
        datosTrabajador = tk.Label(frameInfo,font=("Arial", 10))#, bg ="#56E5D1"
        datosTrabajador.pack()

        #Información de lo que se le va a pagar
        #info = """A Pepito se le pagará 5000 por trabajar 4 veces"""
        infoTrabajador = tk.Label(frameInfo,font=("Arial", 10))#,bg ="#DFE556"
        infoTrabajador.pack()

        pregunta = "¿Desea analizar y bonificar al trabajador por sus metas cumplidas?"
        textoPregunta = tk.Label(frameInfo, text=pregunta, font=("Arial", 12))
        textoPregunta.pack()

        frameInfoBotones = tk.Frame(frameInfo)
        frameInfoBotones.pack()

        #Estilo botones
        estilo = ttk.Style()
        estilo.configure("Estilo.TButton", font=("Arial", 10), padding=10, width=30)
        #Botón Si
        botonSi = ttk.Button(frameInfoBotones, text="Sí", style="Estilo.TButton",command=opcionMetaSi)
        botonSi.pack(side="left", padx=10)
        #Botón No
        textPago = """No, proceder con el pago"""
        botonNo = ttk.Button(frameInfoBotones, text=textPago, style="Estilo.TButton", command=opcionPagoSinMeta)
        botonNo.pack(side="right", padx=10)

        #-------------------------------------Bonificación metas-----------------------------------------

        frameMetas = tk.Frame(self)
        frameMetas.grid(row=3, column=1, columnspan=2, rowspan=3 ,padx=5, pady=5)
        frameMetas.grid_remove()

        #Metas dependiendo del tipo
        #metas = "Meta 1: Vender más de 5 productos \nBonificación: 10000\nMeta 2: Vender más de 20 productos\nBonificación: 4000"
        textoMetas = tk.Label( frameMetas, font=("Arial", 10)) #, bg ="#B856E5"
        textoMetas.grid(row=3, column=1,columnspan=2,padx=5, pady=5)

        #Elección de meta 
        frameMetas1 = tk.Frame(frameMetas)
        frameMetas1.grid(row=4, column=1, padx=5, pady=5)

        textoMetas = tk.Label(frameMetas1, text='Metas', font=("Arial", 12))
        textoMetas.pack(side='top', anchor='center')

        metasPredeterminada = tk.StringVar(value='Seleccionar meta')
        desplegableMetas = ttk.Combobox(frameMetas1, values=["Meta 1", "Meta 2"], textvariable=metasPredeterminada, state='readonly')
        desplegableMetas.pack(side='top', anchor='center')
        desplegableMetas.bind("<<ComboboxSelected>>", opcionMeta)

        #Información de la meta
        frameMetas2 = tk.Frame(frameMetas)
        frameMetas2.grid(row=4, column=2, padx=5, pady=5)
        frameMetas2.grid_remove()

        textoInfoMeta= tk.Label(frameMetas2,font=("Arial", 10))
        textoInfoMeta.pack(anchor='center')

        #Botón de pago
        botonPago = ttk.Button(frameMetas, text="Pagar total", style="Estilo.TButton",command=opcionPagoConMeta)
        botonPago.grid(row=5, column=1, columnspan=2,padx=5, pady=5)
        botonPago.grid_remove()