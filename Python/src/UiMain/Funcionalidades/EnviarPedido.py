import tkinter as tk
from tkinter import ttk, Frame
import Objetos
import sys
sys.path.append('../') 

from gestorAplicacion.produccion.TipoTransporte import TipoTransporte
from gestorAplicacion.produccion.Transporte import Transporte

class EnviarPedido(Frame):
    def __init__(self, window):
        super().__init__(window)

        clienteSeleccionado = None
        tiendaSeleccionada = None
        global listaProductos
        listaProductos = []
        cantidadProductos = 0
        productoSeleccionado1 = None
        productoSeleccionado2 = None
        productoSeleccionado3 = None
        global PesoProductos
        PesoProductos= 0
        tipoTransporte = None
        listaFiltradaTransportes = None
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
        transporte y descuentos aplicables al pedido. Todo lo necesario para gestionar los pedidos de la empresa.
         Intervienen las clases: Cliente, Tienda, Producto y Transporte.  """
        descripcion = tk.Label(frameCabecera, text=textoDescripcion, font=("Arial", 10))
        descripcion.grid(row=1, column=0, sticky="nsew")  # Centrado vertical y horizontalmente


        #-------------------------Eventos----------------------

        def clienteSeleccionado(evento):
            opc = desplegableClientes.get()
            frameTienda12.grid() #llama a la siguiente 
            
            clienteSeleccionado = encontrarObjeto(desplegableClientes, Objetos.ListaClientes)[0]
            print(clienteSeleccionado.getNombre())
            
        #aqui poner para seleccionar tienda 
        def tiendaSeleccionada(evento):
            opc=desplegableTiendas.get()
            frameNumero22.grid()

            tiendaSeleccionada = encontrarObjeto(desplegableTiendas, Objetos.tiendas)[0]
            print(tiendaSeleccionada.getNombre())

        def numeroProductos(evento):
            global opcNum
            opcNum = desplegableNumProductos.get()
            cantidadProductos = opcNum
            if opcNum == "1":
                frameproducto31.grid()       

            elif opcNum =="2":
                frameproducto31.grid()
                frameproducto32.grid()
            
                
            elif opcNum == "3":
                frameproducto31.grid()
                frameproducto32.grid()
                frameproducto33.grid()
    
        def productosSeleccionados(evento):
            opc1 = desplegableProductos1.get()
            opc2 = desplegableProductos2.get()
            opc3 = desplegableProductos3.get
            frameTransporte42.grid()
            if opcNum == "1":
                if opc1 != 'Seleccionar productos':
                    EnviarPedido.productoSeleccionado1 = encontrarObjeto(desplegableProductos1, Objetos.fabrica.getListaProductos())[0]
                    EnviarPedido.productoSeleccionado1 = encontrarObjeto(desplegableProductos1, Objetos.catalogoProductos)[0]
                    PesoProductos = 0
                    pesoProductos += float(EnviarPedido.productoSeleccionado1.getPeso())
                    print("el peso: " + str(pesoProductos))
                
            elif opcNum =="2":
                if opc2 != 'Seleccionar productos':
                    EnviarPedido.productoSeleccionado1 = encontrarObjeto(desplegableProductos1, Objetos.catalogoProductos)[0]
                    EnviarPedido.productoSeleccionado2 = encontrarObjeto(desplegableProductos2, Objetos.catalogoProductos)[0]
                    PesoProductos = 0
                    pesoProductos += float(EnviarPedido.productoSeleccionado1.getPeso())
                    pesoProductos += float(EnviarPedido.productoSeleccionado2.getPeso())
                    print("el peso: " + str(pesoProductos))

            elif opcNum == "3":
                if opc3 != 'Seleccionar productos':
                    EnviarPedido.productoSeleccionado1 = encontrarObjeto(desplegableProductos1, Objetos.catalogoProductos)[0]
                    EnviarPedido.productoSeleccionado2 = encontrarObjeto(desplegableProductos2, Objetos.catalogoProductos)[0]
                    EnviarPedido.productoSeleccionado3 = encontrarObjeto(desplegableProductos3, Objetos.catalogoProductos)[0]
                    PesoProductos = 0
                    pesoProductos += float(EnviarPedido.productoSeleccionado1.getPeso())
                    pesoProductos += float(EnviarPedido.productoSeleccionado2.getPeso())
                    pesoProductos += float(EnviarPedido.productoSeleccionado3.getPeso())
                    print("el peso: " + str(pesoProductos))


        def transporteSeleccionado(evento):
            frameEnvioGratis52.grid()
            #seleccionar transporte y usar la lista de transporte filtrada

        def EnvioGratisAplicado(evento):
            opc = desplegableEnvioGratis.get()
            if opc == "Si":
                print("El envío será gratis")
                #Aquí pooner lo de envío gratis, recordar precio y reestablecer.
            elif opc == "No":
                print("El envío cuesta")
        
        #métodos necesarios 
        def encontrarObjeto(comboBox,listaObjetos):
            nombre = comboBox.get()
            Objetos = None
            Objetos = list(filter(lambda x: x.getNombre()==nombre,listaObjetos))
            return Objetos
        

        #para seleccionar cliente 

        frameClientes1 = tk.Frame(self)
        frameClientes1.grid(row=1, column=1, columnspan=2, padx=5, pady=5)

        frameClientes11 = tk.Frame(frameClientes1)
        frameClientes11.grid(row=1, column=1, padx=5, pady=5)

        textoClientes = tk.Label(frameClientes11, text='Clientes', font=("Arial", 12))
        textoClientes.pack(side='top', anchor='center')

        clientePredeterminado = tk.StringVar(value='Seleccionar cliente')
        desplegableClientes = ttk.Combobox(frameClientes11, values =[x.getNombre() for x in Objetos.ListaClientes], textvariable=clientePredeterminado, state='readonly')
        desplegableClientes.pack(side='top', anchor='center')
        desplegableClientes.bind("<<ComboboxSelected>>", clienteSeleccionado)

        #para seleccionar tienda 

        frameTienda12 = tk.Frame(frameClientes1)
        frameTienda12.grid(row=1, column=3, padx=5, pady=5)
        frameTienda12.grid_remove()

        textoTiendas = tk.Label(frameTienda12, text='Tiendas', font=("Arial", 12))
        textoTiendas.pack(side='top', anchor='center')

        trabajadorPredeterminado = tk.StringVar(value='Seleccionar Tienda')
        desplegableTiendas = ttk.Combobox(frameTienda12, values=[x.getNombre() for x in Objetos.fabrica.getListaTienda()], textvariable=trabajadorPredeterminado,state='readonly')
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
        desplegableProductos1 = ttk.Combobox(frameproducto31, values=[x.getNombre() for x in Objetos.fabrica.getListaProductos()], textvariable=productoPredeterminado, state='readonly')
        #desplegableProductos1 = ttk.Combobox(frameproducto31,values=["pan", "agua", "unicornios"], textvariable=productoPredeterminado, state='readonly')  
        desplegableProductos1.pack(side='top', anchor='center')
        desplegableProductos1.bind("<<ComboboxSelected>>",productosSeleccionados)
        opc1=desplegableProductos1.get()
        # productoSeleccionado1 = Objetos.fabrica.getListaProductos().get(opc1)

        #----------------Segunda casilla de productos------------------

        frameproducto32 = tk.Frame(frameClientes1)
        frameproducto32.grid(row=3, column=2, padx=5, pady=5)
        frameproducto32.grid_remove()

        textoSeleccProductos = tk.Label(frameproducto32, text='Productos', font=("Arial", 12))
        textoSeleccProductos.pack(side='top', anchor='center')

        productoPredeterminado = tk.StringVar(value='Seleccionar productos')
        desplegableProductos2 = ttk.Combobox(frameproducto32,values=[x.getNombre() for x in Objetos.fabrica.getListaProductos()], textvariable=productoPredeterminado, state='readonly')  
        desplegableProductos2.pack(side='top', anchor='center')
        desplegableProductos2.bind("<<ComboboxSelected>>",productosSeleccionados)

        #---------------tercera casilla de productos--------------
        frameproducto33 = tk.Frame(frameClientes1)
        frameproducto33.grid(row=3, column=3, padx=5, pady=5)
        frameproducto33.grid_remove()

        textoSeleccProductos = tk.Label(frameproducto33, text='Productos', font=("Arial", 12))
        textoSeleccProductos.pack(side='top', anchor='center')

        productoPredeterminado = tk.StringVar(value='Seleccionar productos')
        desplegableProductos3 = ttk.Combobox(frameproducto33,values=[x.getNombre() for x in Objetos.fabrica.getListaProductos()], textvariable=productoPredeterminado, state='readonly')  
        desplegableProductos3.pack(side='top', anchor='center')
        desplegableProductos3.bind("<<ComboboxSelected>>",productosSeleccionados)

        #-----------------para seleccionar transporte-------------
        frameTransporte42 = tk.Frame(frameClientes1)
        frameTransporte42.grid(row=4, column=2, padx=5, pady=5)
        frameTransporte42.grid_remove()

        textoSeleccTransporte = tk.Label(frameTransporte42, text='Transportes', font=("Arial", 12))
        textoSeleccTransporte.pack(side='top', anchor='center')
        TransportePredeterminado = tk.StringVar(value='Seleccionar transporte')
        #EnviarPedido.cantidadProducto = desplegableNumProductos.get()
        # EnviarPedido.listaFiltradaTransportes = TipoTransporte.crearTipoTransporteSegunCarga(EnviarPedido.productoSeleccionado1.getPeso())
        # desplegableTransporte = ttk.Combobox(frameTransporte42,values=[x.value[0] for x in EnviarPedido.listaFiltradaTransportes], textvariable=TransportePredeterminado, state='readonly') 
        desplegableTransporte = ttk.Combobox(frameTransporte42, values = ["mercedes", "lambo", "El diablo en patines"], textvariable=TransportePredeterminado, state='readonly')   
        desplegableTransporte.pack(side='top', anchor='center')
        desplegableTransporte.bind("<<ComboboxSelected>>",transporteSeleccionado)

        #-----------------decidir si envío gratis-----------

        frameEnvioGratis52 = tk.Frame(frameClientes1)
        frameEnvioGratis52.grid(row=5, column=2, columnspan=2, rowspan=3 ,padx=5, pady=5)
        frameEnvioGratis52.grid_remove()
        textoEnvioGratis = tk.Label(frameTransporte42, text='Desea aplicar envío gratis?', font=("Arial", 12))
        textoEnvioGratis.pack(side='top', anchor='center')
        EnvioPredeterminado = tk.StringVar(value='Alplicar Envío Gratis')
        desplegableEnvioGratis = ttk.Combobox(frameTransporte42,values=["Si", "No"], textvariable=EnvioPredeterminado, state='readonly')  
        desplegableEnvioGratis.pack(side='top', anchor='center')
        desplegableEnvioGratis.bind("<<ComboboxSelected>>",EnvioGratisAplicado)


