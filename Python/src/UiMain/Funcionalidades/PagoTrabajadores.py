import tkinter as tk
from tkinter import ttk,Frame
#from gestorAplicacion.produccion.Fabrica import Fabrica
#from gestorAplicacion.gestion.Factura import Factura

class PagoTrabajadores(Frame):
    def __init__(self, window):
        super().__init__(window)

        #--------------Eventos --------------
        def opcionTipoTrabajador(evento):
            opc = desplegableTipos.get()
            #listaFacturas = Factura.getListaFacturas()

            if opc == "Conductores":
                frameTipos12.grid()
                #listaMostrar = Fabrica.busquedaTrabajo(listaFacturas,2)
                desplegableTrabajadores['values'] = ["Conductor 1", "Conductor 2", "Conductor 3"]
            elif opc == "Operarios":
                frameTipos12.grid()
                #listaMostrar = Fabrica.busquedaTrabajo(listaFacturas,1)
                desplegableTrabajadores['values'] = ["Operario 1", "Operario 2", "Operario 3"]
            elif opc == "Vendedores":
                frameTipos12.grid()
                #listaMostrar = Fabrica.busquedaTrabajo(listaFacturas,3)
                desplegableTrabajadores['values'] = ["Vendedor 1", "Vendedor 2", "Vendedor 3"]
            else:
                frameTipos12.grid_remove()
                desplegableTrabajadores['values'] = ()

        def opcionTrabajador(evento):
            frameInfo.grid()

        def opcionMetaSi(evento):
            pass

        def opcionMetaNo(evento):
            pass

        #--------------Divisiones filas y columnas --------------
        for i in range(12):
            self.rowconfigure(i, weight=1)

        for j in range(4):
            self.columnconfigure(j, weight=1)

        #--------------Título y descripción --------------
        frameCabecera = tk.Frame(self)
        frameCabecera.grid(row=0, column=1, columnspan=2,padx=5, pady=5)
        titulo = tk.Label(frameCabecera, text='Pagar a trabajadores', font=("Arial", 15))
        titulo.pack()
        textoDescripcion = """Aquí podra seleccionar alguno de los trabajadores disponibles según su función 
        (Conductores,Operarios y Vendedores), pagarles por sus respectivas horas trabajadas 
        y además verificar sus metas dando bonificaciones por el cumpliento de las mismas."""
        descripcion = tk.Label(frameCabecera, text=textoDescripcion,font=("Arial", 12))
        descripcion.pack()

        #--------------Tipo de trabajador --------------
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

        #--------------Trabajadores --------------
        frameTipos12 = tk.Frame(frameTipos1)
        frameTipos12.grid(row=1, column=2, padx=5, pady=5)
        frameTipos12.grid_remove()

        textoTrabajadores = tk.Label(frameTipos12, text='Trabajadores', font=("Arial", 12))
        textoTrabajadores.pack(side='top', anchor='center')

        trabajadorPredeterminado = tk.StringVar(value='Seleccionar trabajador')
        desplegableTrabajadores = ttk.Combobox(frameTipos12, textvariable=trabajadorPredeterminado, state='readonly')  # Cambio aquí
        desplegableTrabajadores.pack(side='top', anchor='center')
        desplegableTrabajadores.bind("<<ComboboxSelected>>",opcionTrabajador)

        #--------------Información trabajador seleccionado y Pregunta metas --------------

        frameInfo = tk.Frame(self)
        frameInfo.grid(row=2, column=1, columnspan=2 ,padx=5, pady=5)
        frameInfo.grid_remove()

        info = """Aquí se muestra la información del pago al trabajador por las horas
        trabajadas"""
        infoTrabajador = tk.Label(frameInfo, text=info, font=("Arial", 12))
        infoTrabajador.pack()

        pregunta = "¿Desea analizar y bonificar al trabajador por sus metas cumplidas?"
        textoPregunta = tk.Label(frameInfo, text=pregunta, font=("Arial", 12))
        textoPregunta.pack()

        frameInfoBotones = tk.Frame(frameInfo)
        frameInfoBotones.pack()

        #Estilo botones
        estilo = ttk.Style()
        estilo.configure("Estilo.TButton", font=("Arial", 12), padding=5, width=5)
        # Crear el botón "Sí"
        botonSi = ttk.Button(frameInfoBotones, text="Sí", style="Estilo.TButton",command=opcionMetaSi)
        botonSi.pack(side="left", padx=10)
        # Crear el botón "No"
        botonNo = ttk.Button(frameInfoBotones, text="No", style="Estilo.TButton", command=opcionMetaNo)
        botonNo.pack(side="right", padx=10)

        #--------------Bonificación metas --------------

        #--------------Pago --------------
        