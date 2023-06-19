import tkinter as tk
from tkinter import ttk, Frame
import sys
from gestorAplicacion.gestion.Conductor import Conductor
sys.path.append('../') 

from gestorAplicacion.produccion.TipoTransporte import TipoTransporte
from gestorAplicacion.produccion.Transporte import Transporte
from gestorAplicacion.produccion.Fabrica import Fabrica
from gestorAplicacion.gestion.Cliente import Cliente
from gestorAplicacion.gestion.Factura import Factura


class EnviarPedido(Frame):
    
    
    clienteSeleccionado = None
    tiendaSeleccionada = None
    
    listaProductos = []
    
    cantidadProductos = 0
    productoSeleccionado1 = None
    productoSeleccionado2 = None
    productoSeleccionado3 = None

    pesoProductos= float
    tipoTransporte = None
    transporteSeleccionado = None
    listaFiltradaTransportes = []

    pesoProducto1 = float
    pesoProducto2 = float
    pesoProducto3 = float
    opcNum = int
    
    Dia=int
    
    
    def __init__(self, window):
        super().__init__(window)
        self.config(bg="#b6fce6")

        #--------------Divisiones filas y columnas --------------
        for i in range(12):
            self.rowconfigure(i, weight=1)

        for j in range(3):
            self.columnconfigure(j, weight=1)
            
        #----------------TITULO
        frameCabecera = tk.Frame(self) 
        frameCabecera.grid(row=0, column=1, padx=5, pady=5)
        
       #GRID
        frameCabecera.columnconfigure(0, weight=1)  # Columna 0 con peso 1
        frameCabecera.rowconfigure(0, weight=1)     # Fila 0 con peso 1
        frameCabecera.rowconfigure(1, weight=1)     # Fila 0 con peso 1
        
        titulo = tk.Label(frameCabecera, text='Envío de Pedidos', font=("Arial", 15, "bold"), bg ="#33a8d6", relief="raised", border=3 )
        titulo.grid(row=0, column=0,pady=2, sticky="nsew")  # TITULO Centrado vertical y horizontalmente
        
        #---------------------Descripción
        textoDescripcion = """Aquí podrá seleccionar el cliente, productos a enviar, cliente de 
        transporte y descuentos aplicables al pedido.
        Todo lo necesario para gestionar los pedidos de la empresa.
        Intervienen las clases: Cliente, Tienda, Producto y Transporte. """ 
        descripcion = tk.Label(frameCabecera, text=textoDescripcion, font=("Arial", 12), bg ="#93cfbc", relief="sunken", border=1 )
        descripcion.grid(row=1, column=0,pady=4,padx=3 , sticky="nsew")  # Centrado vertical y horizontalmente

        
        #-------------------------Eventos----------------------

        def clienteSeleccionado(evento):
            opc = desplegableClientes.get()
            frameTienda12.grid() #llama a la siguiente 
            
            clienteSeleccionado = encontrarObjeto(desplegableClientes, Cliente.getListaClientes())[0]
            print(clienteSeleccionado.getNombre())
            
        #aqui poner para seleccionar tienda 
        def tiendaSeleccionada(evento):
            opc=desplegableTiendas.get()
            frameNumero22.grid()

            tiendaSeleccionada = encontrarObjeto(desplegableTiendas, Fabrica.getListaFabricas()[0].getListaTienda())[0]
            print(tiendaSeleccionada.getNombre())

        def numeroProductos(evento):
            global opcNum
            opcNum = desplegableNumProductos.get()
            cantidadProductos = opcNum
            if opcNum == "1":
                desplegableProductos2.configure(state="disabled")
                desplegableProductos3.configure(state="disabled")
                frameproducto31.grid()
                frameproducto32.grid()
                frameproducto33.grid()
            elif opcNum =="2":
                desplegableProductos2.configure(state="readonly")
                desplegableProductos3.configure(state="disabled")
                frameproducto31.grid()
                frameproducto32.grid()
                frameproducto33.grid()
            
            elif opcNum == "3":
                desplegableProductos2.configure(state="readonly")
                desplegableProductos3.configure(state="readonly")
                frameproducto31.grid()
                frameproducto32.grid()
                frameproducto33.grid()
    
        # def numproductosSeleccionado1(evento):
        #     opc1 = desplegableProductos1.get()
               
        #     EnviarPedido.productoSeleccionado1 = encontrarObjeto(desplegableProductos1, Fabrica.getListaFabricas()[0].getListaProductos())[0]
        #     EnviarPedido.pesoProducto1 = float(EnviarPedido.productoSeleccionado1.getPeso())
            
        #     EnviarPedido.pesoProductos = EnviarPedido.pesoProducto1

        #     if EnviarPedido.pesoProductos != 0:    
        #         EnviarPedido.listaFiltradaTransportes = TipoTransporte.crearTipoTransporteSegunCarga(EnviarPedido.pesoProductos)
        #         desplegableTransporte['values']=[x.value[0] for x in EnviarPedido.listaFiltradaTransportes]  
        #         print("está entando a esta mondá") 
        #     frameTransporte42.grid()
                    
        # def numproductosSeleccionado2(evento):        
    
        #     opc1 = desplegableProductos1.get()
        #     opc2 = desplegableProductos2.get()

        #     EnviarPedido.productoSeleccionado1 = encontrarObjeto(desplegableProductos1, Fabrica.getListaFabricas()[0].getListaProductos())[0]
        #     EnviarPedido.pesoProducto1 = float(EnviarPedido.productoSeleccionado1.getPeso())
        #     EnviarPedido.productoSeleccionado2 = encontrarObjeto(desplegableProductos2, Fabrica.getListaFabricas()[0].getListaProductos())[0]
        #     EnviarPedido.pesoProducto2 = float(EnviarPedido.productoSeleccionado2.getPeso())
            
        #     EnviarPedido.pesoProductos = EnviarPedido.pesoProducto1 + EnviarPedido.pesoProducto2
            
            
        #     if EnviarPedido.pesoProductos != 0 and EnviarPedido.pesoProducto2 != 0:    
        #         EnviarPedido.listaFiltradaTransportes = TipoTransporte.crearTipoTransporteSegunCarga(EnviarPedido.pesoProductos)
        #         desplegableTransporte['values']=[x.value[0] for x in EnviarPedido.listaFiltradaTransportes]   
        #     frameTransporte42.grid()
            
                        

        def numproductosSeleccionado3(evento):           
            frameTransporte42.grid()
            
            op = desplegableNumProductos.get()
            
            opc1 = desplegableProductos1.get()
            opc2 = desplegableProductos2.get()
            opc3 = desplegableProductos3.get()
            if opcNum == "1":
                EnviarPedido.productoSeleccionado1 = encontrarObjeto(desplegableProductos1, Fabrica.getListaFabricas()[0].getListaProductos())
                EnviarPedido.productoSeleccionado1 = EnviarPedido.productoSeleccionado1[0]
                EnviarPedido.pesoProducto1 = float(EnviarPedido.productoSeleccionado1.getPeso())
                
                EnviarPedido.pesoProductos = EnviarPedido.pesoProducto1
                EnviarPedido.listaProductos.append(EnviarPedido.productoSeleccionado1)
            
            if opcNum == "2":
                if desplegableProductos1 != 'Seleccionar Productos':
                    EnviarPedido.productoSeleccionado1 = encontrarObjeto(desplegableProductos1, Fabrica.getListaFabricas()[0].getListaProductos())
                    EnviarPedido.productoSeleccionado1 = EnviarPedido.productoSeleccionado1[0]
                    EnviarPedido.pesoProducto1 = float(EnviarPedido.productoSeleccionado1.getPeso())
                    
                   
                
                if desplegableProductos2 != 'Seleccionar Productos':
                    EnviarPedido.pesoProductos = EnviarPedido.pesoProducto1
                    EnviarPedido.productoSeleccionado2 = encontrarObjeto(desplegableProductos2, Fabrica.getListaFabricas()[0].getListaProductos())
                    EnviarPedido.productoSeleccionado2 = EnviarPedido.productoSeleccionado2[0]
                    EnviarPedido.pesoProducto2 = float(EnviarPedido.productoSeleccionado2.getPeso())
                    
                    EnviarPedido.pesoProductos = EnviarPedido.pesoProducto1 + EnviarPedido.pesoProducto2
                    EnviarPedido.listaProductos.append(EnviarPedido.productoSeleccionado1)
                    EnviarPedido.listaProductos.append(EnviarPedido.productoSeleccionado2)
                
            if opcNum == "3":
                
                if desplegableProductos1 != 'Seleccionar Productos':
                    EnviarPedido.productoSeleccionado1 = encontrarObjeto(desplegableProductos1, Fabrica.getListaFabricas()[0].getListaProductos())
                    EnviarPedido.productoSeleccionado1 = EnviarPedido.productoSeleccionado1[0]
                    EnviarPedido.pesoProducto1 = float(EnviarPedido.productoSeleccionado1.getPeso())
                    
                    
                if desplegableProductos2 != 'Seleccionar Productos':
                    EnviarPedido.productoSeleccionado2 = encontrarObjeto(desplegableProductos2, Fabrica.getListaFabricas()[0].getListaProductos())
                    EnviarPedido.productoSeleccionado2 = EnviarPedido.productoSeleccionado2[0]
                    EnviarPedido.pesoProducto2 = float(EnviarPedido.productoSeleccionado2.getPeso())
                
                if desplegableProductos3 != 'Seleccionar Productos': 
                    EnviarPedido.productoSeleccionado3 = encontrarObjeto(desplegableProductos3, Fabrica.getListaFabricas()[0].getListaProductos())
                    EnviarPedido.productoSeleccionado3 = EnviarPedido.productoSeleccionado3[0]
                    EnviarPedido.pesoProducto3 = float(EnviarPedido.productoSeleccionado3.getPeso())

                    EnviarPedido.pesoProductos = EnviarPedido.pesoProducto1 + EnviarPedido.pesoProducto2 + EnviarPedido.pesoProducto3
                    EnviarPedido.listaProductos.append(EnviarPedido.productoSeleccionado1)
                    EnviarPedido.listaProductos.append(EnviarPedido.productoSeleccionado2)
                    EnviarPedido.listaProductos.append(EnviarPedido.productoSeleccionado2)
                
            EnviarPedido.listaFiltradaTransportes = TipoTransporte.crearTipoTransporteSegunCarga(EnviarPedido.pesoProductos)
            desplegableTransporte['values']=[x.value[0] for x in EnviarPedido.listaFiltradaTransportes]   
            
            print("el 1 --------------")
            print(EnviarPedido.productoSeleccionado1)
            print("el 2----------------")
            print(EnviarPedido.productoSeleccionado2)
            print("----------- el 3 ")
            print(EnviarPedido.productoSeleccionado3)

                
                
        def DiaDelMes(evento): 
            frameDiaMes62.grid()
            EnviarPedido.tipoTransporte = list(filter(lambda x: x.value[0]==desplegableTransporte.get(),TipoTransporte))[0]


            print("########## el transporte ##################")
            print(EnviarPedido.tipoTransporte)
            
            EnviarPedido.Dia = desplegableDiaMes62.get()
            print(EnviarPedido.Dia)
           
            EnviarPedido.tipoTransporte = list(filter(lambda x: x.value[0]==desplegableTransporte.get(),TipoTransporte))[0]

            
            
        def GenerarFactura():
            #factura = Factura(tienda, cliente, transporte, listaProductos, fecha_actual, disclaimer, operario)
            transporte = Transporte(EnviarPedido.tipoTransporte,
                                    EnviarPedido.tipoTransporte.value[2], EnviarPedido.tipoTransporte.value[1], Conductor.getListaConductores()[0])
            
            facturaNueva= Factura(EnviarPedido.tiendaSeleccionada, EnviarPedido.clienteSeleccionado, transporte, EnviarPedido.listaProductos, EnviarPedido.Dia, "Nada", operario= Fabrica.getListaFabricas()[0].getOperario())
            print(facturaNueva)
            
            

        
        #métodos necesarios 
        def encontrarObjeto(comboBox,listaObjetos):
            nombre = comboBox.get()
            Objetos = None
            Objetos = list(filter(lambda x: x.getNombre()==nombre,listaObjetos))
            return Objetos

        #para seleccionar cliente 

        frameClientes1 = tk.Frame(self, bg="#33a8d6",relief="raised", border=2)
        frameClientes1.grid(row=1, column=1, padx=5, pady=5)

        for a in range(3):
            frameClientes1.columnconfigure(a,weight=1)

        for b in range(6):
            frameClientes1.rowconfigure(b,weight=1)

        frameClientes11 = tk.Frame(frameClientes1, relief="raised", border=3)
        frameClientes11.grid(row=0, column=0, padx=5, pady=5, sticky="nsew")
        frameClientes11.rowconfigure(1,weight=1)
        frameClientes11.rowconfigure(1,weight=1)
        frameClientes11.columnconfigure(0,weight=1)
        textoClientes = tk.Label(frameClientes11, text='Clientes', font=("Arial", 12))
        textoClientes.grid(row=0, column=0)

        clientePredeterminado = tk.StringVar(value='Seleccionar cliente')
        desplegableClientes = ttk.Combobox(frameClientes11, values =[x.getNombre() for x in Cliente.getListaClientes()], textvariable=clientePredeterminado, state='readonly')
        desplegableClientes.grid(row=1, column=0, padx=5, pady=5)
        desplegableClientes.bind("<<ComboboxSelected>>", clienteSeleccionado)

        #para seleccionar tienda 

        frameTienda12 = tk.Frame(frameClientes1, relief="raised", border=3)
        frameTienda12.grid(row=0, column=2, padx=5, pady=5, sticky="nsew")
        frameTienda12.grid_remove()
        frameTienda12.rowconfigure(0,weight=1)
        frameTienda12.rowconfigure(1,weight=1)
        frameTienda12.columnconfigure(0,weight=1)

        textoTiendas = tk.Label(frameTienda12, text='Tiendas', font=("Arial", 12))
        textoTiendas.grid(row=0, column=2, padx=5, pady=5)

        trabajadorPredeterminado = tk.StringVar(value='Seleccionar Tienda')
        desplegableTiendas = ttk.Combobox(frameTienda12, values=[x.getNombre() for x in Fabrica.getListaFabricas()[0].getListaTienda()], textvariable=trabajadorPredeterminado,state='readonly')
        desplegableTiendas.grid(row=1, column=2, padx=5, pady=5)
        desplegableTiendas.bind("<<ComboboxSelected>>",tiendaSeleccionada)



        #para seleccionar una cantidad de productos

        frameNumero22 = tk.Frame(frameClientes1, relief="raised", border=3)
        frameNumero22.grid(row=1, column=1, padx=5, pady=5, sticky="nsew")
        frameNumero22.grid_remove()
        frameNumero22.rowconfigure(0,weight=1)
        frameNumero22.rowconfigure(1,weight=1)
        frameNumero22.columnconfigure(0,weight=1)

        textoNumProductos = tk.Label(frameNumero22, text='Numero de Productos', font=("Arial", 12))
        textoNumProductos.grid(row=0, column=1, padx=5, pady=5)

        numeroPredeterminado = tk.StringVar(value='Seleccionar numero de productos')
        desplegableNumProductos = ttk.Combobox(frameNumero22,values=["1", "2", "3"], textvariable=numeroPredeterminado, state='readonly')  
        desplegableNumProductos.grid(row=1, column=1,padx=5, pady=5, sticky="nsew")
        desplegableNumProductos.bind("<<ComboboxSelected>>",numeroProductos)

        #----------------Primera casilla de productos---------------

        frameproducto31 = tk.Frame(frameClientes1, relief="raised", border=3)
        frameproducto31.grid(row=2, column=1, padx=5, pady=5, sticky="nsew")
        frameproducto31.grid_remove()
        frameproducto31.rowconfigure(0,weight=1)
        frameproducto31.rowconfigure(1,weight=1)
        frameproducto31.columnconfigure(0,weight=1)

        textoSeleccProductos = tk.Label(frameproducto31, text='Productos', font=("Arial", 12))
        textoSeleccProductos.grid(row=0, column=1, padx=5, pady=5)

        productoPredeterminado = tk.StringVar(value='Seleccionar productos')
        desplegableProductos1 = ttk.Combobox(frameproducto31, values=[x.getNombre() for x in Fabrica.getListaFabricas()[0].getListaProductos()], textvariable=productoPredeterminado, state='readonly')  
        desplegableProductos1.grid(row=1, column=1, padx=5, pady=5)
        desplegableProductos1.bind("<<ComboboxSelected>>",numproductosSeleccionado3)

# -----------------segunda casilla productos------------------------
        frameproducto32 = tk.Frame(frameClientes1, relief="raised", border=3)
        frameproducto32.grid(row=2, column=0, padx=5, pady=5, sticky="nsew")
        frameproducto32.grid_remove()
        frameproducto32.rowconfigure(0,weight=1)
        frameproducto32.rowconfigure(1,weight=1)
        frameproducto32.columnconfigure(0,weight=1)

        textoSeleccProductos = tk.Label(frameproducto32, text='Productos', font=("Arial", 12))
        textoSeleccProductos.grid(row=0, column=1,padx=5, pady=5)

        productoPredeterminado = tk.StringVar(value='Seleccionar productos')
        desplegableProductos2 = ttk.Combobox(frameproducto32,values=[x.getNombre() for x in Fabrica.getListaFabricas()[0].getListaProductos()], textvariable=productoPredeterminado, state='readonly')  
        desplegableProductos2.grid(row=1, column=1,padx=5, pady=5)
        desplegableProductos2.bind("<<ComboboxSelected>>",numproductosSeleccionado3)

        #---------------tercera casilla de productos--------------
        frameproducto33 = tk.Frame(frameClientes1, relief="raised", border=3)
        frameproducto33.grid(row=2, column=2, padx=5, pady=5, sticky="nsew")
        frameproducto33.grid_remove()
        frameproducto33.rowconfigure(0,weight=1)
        frameproducto33.rowconfigure(1,weight=1)
        frameproducto33.columnconfigure(0,weight=1)

        textoSeleccProductos = tk.Label(frameproducto33, text='Productos', font=("Arial", 12))
        textoSeleccProductos.grid(row=0, column=1)

        productoPredeterminado = tk.StringVar(value='Seleccionar productos')
        desplegableProductos3 = ttk.Combobox(frameproducto33,values=[x.getNombre() for x in Fabrica.getListaFabricas()[0].getListaProductos()], textvariable=productoPredeterminado, state='readonly')  
        desplegableProductos3.grid(row=1, column=1,padx=5, pady=5)
        desplegableProductos3.bind("<<ComboboxSelected>>", numproductosSeleccionado3)


        #-----------------para seleccionar transporte-------------
        frameTransporte42 = tk.Frame(frameClientes1, relief="raised", border=3)
        frameTransporte42.grid(row=3, column=1, padx=5, pady=5, sticky="nsew")
        frameTransporte42.grid_remove()
        frameTransporte42.rowconfigure(0,weight=1)
        frameTransporte42.rowconfigure(1,weight=1)
        frameTransporte42.columnconfigure(0,weight=1)

        textoSeleccTransporte = tk.Label(frameTransporte42, text='Transportes', font=("Arial", 12))
        textoSeleccTransporte.grid(row=0, column=1)
        TransportePredeterminado = tk.StringVar(value='Seleccionar transporte')
        desplegableTransporte = ttk.Combobox(frameTransporte42,values=["no disponible aún"], textvariable=TransportePredeterminado, state='readonly') 
        desplegableTransporte.grid(row=1, column=1,padx=5, pady=5, sticky="nsew")
        desplegableTransporte.bind("<<ComboboxSelected>>", DiaDelMes)

        #----------------seleccionar fecha--------------------
        
        frameDiaMes62 = tk.Frame(frameClientes1, relief="raised", border=3)
        frameDiaMes62.grid(row=5, column=1, padx=5, pady=5, sticky="nsew")
        frameDiaMes62.grid_remove()
        diaPredeterminado = tk.StringVar(value='Elegir día')
        frameDiaMes62.rowconfigure(0,weight=1)
        frameDiaMes62.rowconfigure(1,weight=1)
        frameDiaMes62.columnconfigure(0,weight=1)
        
        textoSeleccDia = tk.Label(frameDiaMes62, text='Dia', font=("Arial", 12))
        textoSeleccDia.grid(row=0, column=1)
        

        desplegableDiaMes62 = ttk.Combobox(frameDiaMes62,values=["1", "2", "3", "4", "5"], textvariable=diaPredeterminado, state='readonly')  
        desplegableDiaMes62.grid(row=1, column=1,padx=5, pady=5)
        desplegableDiaMes62.bind("<<ComboboxSelected>>", DiaDelMes)

        frameDiaMes71 = tk.Frame(self, relief="raised", border=3)
        frameDiaMes71.grid(row=3, column=1, padx=1, pady=3)
        boton = tk.Button(frameDiaMes71, text="Realizar Envio \n Generar Factura", width=10, height=2, bg="#1c71b8", font=("Franklin Gothic", 10, "bold"), border=2, relief="raised", command= GenerarFactura)
        boton.grid(row=0, column=0)
        #boton.grid_remove()

        


