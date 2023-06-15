import tkinter as tk
from tkinter import ttk, Frame

class EnviarPedido(Frame):
    def __init__(self, window):
        super().__init__(window)


        #--------------Divisiones filas y columnas --------------
        for i in range(12):
            self.rowconfigure(i, weight=1)

        for j in range(4):
            self.columnconfigure(j, weight=1)
            
        #----------------TITULO
        frameCabecera = tk.Frame(self)
        frameCabecera.grid(row=0, column=0, columnspan=4, padx=5, pady=5)
        
       #GRID
        frameCabecera.columnconfigure(0, weight=1)  # Columna 0 con peso 1
        frameCabecera.rowconfigure(0, weight=1)     # Fila 0 con peso 1

        titulo = tk.Label(frameCabecera, text='Envío de Pedidos', font=("Arial", 15))
        titulo.grid(row=0, column=0, sticky="nsew")  # TITULO Centrado vertical y horizontalmente
        
        #---------------------Descripción
        textoDescripcion = """Aquí podrá seleccionar el cliente, productos a enviar, cliente de 
        transporte y descuentos aplicables al pedido. Todo lo necesario para gestionar los pedidos de la empresa """
        descripcion = tk.Label(frameCabecera, text=textoDescripcion, font=("Arial", 10))
        descripcion.grid(row=1, column=0, sticky="nsew")  # Centrado vertical y horizontalmente


        #-------------------------Eventos----------------------

        def clienteSeleccionado(evento):
            opc = desplegableClientes.get()
            frameTienda12.grid() #llama a la siguiente 
            
        #aqui poner para seleccionar tienda 
        def tiendaSeleccionada(evento):
            opc=desplegableTiendas.get()
            frameNumero22.grid()

        def numeroProductos(evento):
            opc = desplegableNumProductos.get()
            if opc == "1":
                frameproducto31.grid()
            elif opc =="2":
                frameproducto31.grid()
                frameproducto32.grid()
            elif opc == "3":
                frameproducto31.grid()
                frameproducto32.grid()
                frameproducto33.grid()

        def productosSeleccionados(evento):
            frameTransporte42.grid()

        def transporteSeleccionado(evento):
            if True:
                print("Hasta aquí llego, a momir ")
            #frameEnvioGratis52.grid()

        # def EnvioGratisAplicado(evento):
        #     if True:
        #         print("acá irá algo")
        
        # def EnvioCuesta(evento):
        #     if True:
        #         print("acá irá algo... o no?")     
            
            

        #para seleccionar cliente 

        frameClientes1 = tk.Frame(self)
        frameClientes1.grid(row=1, column=1, columnspan=2, padx=5, pady=5)

        frameClientes11 = tk.Frame(frameClientes1)
        frameClientes11.grid(row=1, column=1, padx=5, pady=5)

        textoClientes = tk.Label(frameClientes11, text='Clientes', font=("Arial", 12))
        textoClientes.pack(side='top', anchor='center')

        clientePredeterminado = tk.StringVar(value='Seleccionar cliente')
        desplegableClientes = ttk.Combobox(frameClientes11, values=["Cliente1", "Cliente2 ", "Cliente3"], textvariable=clientePredeterminado, state='readonly')
        desplegableClientes.pack(side='top', anchor='center')
        desplegableClientes.bind("<<ComboboxSelected>>", clienteSeleccionado)

        #para seleccionar tienda 

        frameTienda12 = tk.Frame(frameClientes1)
        frameTienda12.grid(row=1, column=3, padx=5, pady=5)
        frameTienda12.grid_remove()

        textoTiendas = tk.Label(frameTienda12, text='Tiendas', font=("Arial", 12))
        textoTiendas.pack(side='top', anchor='center')

        trabajadorPredeterminado = tk.StringVar(value='Seleccionar Tienda')
        desplegableTiendas = ttk.Combobox(frameTienda12,values = ["Tienda1", "Tienda2 ", "Tienda3"], textvariable=trabajadorPredeterminado, state='readonly')  # Cambio aquí
        desplegableTiendas.pack(side='top', anchor='center')
        desplegableTiendas.bind("<<ComboboxSelected>>",tiendaSeleccionada)



        #para seleccionar una cantidad de productos

        frameNumero22 = tk.Frame(frameClientes1)
        frameNumero22.grid(row=2, column=2, padx=5, pady=5)
        frameNumero22.grid_remove()

        textoNumProductos = tk.Label(frameNumero22, text='Numero de Productos', font=("Arial", 12))
        textoNumProductos.pack(side='top', anchor='center')

        numeroPredeterminado = tk.StringVar(value='Seleccionar numero de productos')
        desplegableNumProductos = ttk.Combobox(frameNumero22,values=["1", "2", "3"], textvariable=numeroPredeterminado, state='readonly')  
        desplegableNumProductos.pack(side='top', anchor='center')
        desplegableNumProductos.bind("<<ComboboxSelected>>",numeroProductos)

        #----------------Primera casilla de productos---------------

        frameproducto31 = tk.Frame(frameClientes1)
        frameproducto31.grid(row=3, column=1, padx=5, pady=5)
        frameproducto31.grid_remove()

        textoSeleccProductos = tk.Label(frameproducto31, text='Productos', font=("Arial", 12))
        textoSeleccProductos.pack(side='top', anchor='center')

        productoPredeterminado = tk.StringVar(value='Seleccionar productos')
        desplegableProductos1 = ttk.Combobox(frameproducto31,values=["pan", "agua", "unicornios"], textvariable=productoPredeterminado, state='readonly')  
        desplegableProductos1.pack(side='top', anchor='center')
        desplegableProductos1.bind("<<ComboboxSelected>>",productosSeleccionados)

        #----------------Segunda casilla de productos------------------

        frameproducto32 = tk.Frame(frameClientes1)
        frameproducto32.grid(row=3, column=2, padx=5, pady=5)
        frameproducto32.grid_remove()

        textoSeleccProductos = tk.Label(frameproducto32, text='Productos', font=("Arial", 12))
        textoSeleccProductos.pack(side='top', anchor='center')

        productoPredeterminado = tk.StringVar(value='Seleccionar productos')
        desplegableProductos2 = ttk.Combobox(frameproducto32,values=["pan", "agua", "unicornios"], textvariable=productoPredeterminado, state='readonly')  
        desplegableProductos2.pack(side='top', anchor='center')
        desplegableProductos2.bind("<<ComboboxSelected>>",productosSeleccionados)

        #---------------tercera casilla de productos--------------
        frameproducto33 = tk.Frame(frameClientes1)
        frameproducto33.grid(row=3, column=3, padx=5, pady=5)
        frameproducto33.grid_remove()

        textoSeleccProductos = tk.Label(frameproducto33, text='Productos', font=("Arial", 12))
        textoSeleccProductos.pack(side='top', anchor='center')

        productoPredeterminado = tk.StringVar(value='Seleccionar productos')
        desplegableProductos3 = ttk.Combobox(frameproducto33,values=["pan", "agua", "unicornios"], textvariable=productoPredeterminado, state='readonly')  
        desplegableProductos3.pack(side='top', anchor='center')
        desplegableProductos3.bind("<<ComboboxSelected>>",productosSeleccionados)

        #-----------------para seleccionar transporte-------------
        frameTransporte42 = tk.Frame(frameClientes1)
        frameTransporte42.grid(row=4, column=2, padx=5, pady=5)
        frameTransporte42.grid_remove()

        textoSeleccTransporte = tk.Label(frameTransporte42, text='Transportes', font=("Arial", 12))
        textoSeleccTransporte.pack(side='top', anchor='center')
        TransportePredeterminado = tk.StringVar(value='Seleccionar transporte')
        desplegableTransporte = ttk.Combobox(frameTransporte42,values=["Camion", "Lambo", "Barco"], textvariable=TransportePredeterminado, state='readonly')  
        desplegableTransporte.pack(side='top', anchor='center')
        desplegableTransporte.bind("<<ComboboxSelected>>",transporteSeleccionado)

        #-----------------decidir si envío gratis-----------
        # frameEnvioGratis52 = tk.Frame(frameClientes1)
        # frameEnvioGratis52.grid(row=5, column=2, columnspan=2, rowspan=3 ,padx=5, pady=5)
        # frameEnvioGratis52.grid_remove()

        # BotonEnvioGratis =ttk.Button(frameEnvioGratis52, text="Aplicar Envío Gratis", command=EnvioGratisAplicado)

        # frameInfo = tk.Frame(self)
        # frameInfoBotones = tk.Frame(frameInfo)
        # frameInfoBotones.pack()
        # #Estilo botones
        # estilo = ttk.Style()
        # estilo.configure("Estilo.TButton", font=("Arial", 10), padding=10, width=30)
        # #Botón Si
        # botonSi = ttk.Button(frameInfoBotones, text="Sí", style="Estilo.TButton",command=EnvioGratisAplicado)
        # botonSi.pack(side="left", padx=10)
        # #Botón No
        # textPago = """No, proceder con el pago"""
        # botonNo = ttk.Button(frameInfoBotones, text=textPago, style="Estilo.TButton", command=EnvioCuesta)
        # botonNo.pack(side="right", padx=10)


