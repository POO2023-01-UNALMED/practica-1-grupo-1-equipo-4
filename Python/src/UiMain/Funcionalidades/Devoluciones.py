import tkinter as tk
from tkinter import ttk, Frame, DISABLED, messagebox
import sys
sys.path.append('../')  # Retrocede un nivel al directorio padre

from gestorAplicacion.produccion.Fabrica import Fabrica
from gestorAplicacion.gestion.Factura import Factura
from gestorAplicacion.gestion.Cliente import Cliente 
from gestorAplicacion.produccion.Producto import Producto 
from gestorAplicacion.gestion.CuentaBancaria import CuentaBancaria
#from gestorAplicacion.gestion.Cliente import Cliente.getProductos

class Devoluciones(Frame):
    #atributos de clase
    listaFacturas = []
    clienteElegido: Cliente
    listaProductos = []
    productoElegido = None
    def __init__(self, window):
        super().__init__(window)
        
        #----  Funciones ----
        def opcionFactura(event):
            
            Devoluciones.clienteElegido = desplegableFactura.get()

            for factura in Factura.getListaFacturas():
                if f"{factura.getCliente()}" == Devoluciones.clienteElegido:
                    Devoluciones.clienteElegido = factura.getCliente()

            listaParaRecorrer = Devoluciones.clienteElegido.getProductos()

            for producto in listaParaRecorrer:
                if producto.isDevuelto() == False:
                    Devoluciones.listaProductos.append(producto.getNombre())

            Productos.grid()
            desplegableProducto['value'] = Devoluciones.listaProductos
            Devoluciones.listaProductos = [] #se resetea la lista por si escoge otro cliente
            

        def opcionProducto(event):
            
            boton.grid()

        def devolverProducto():

            Devoluciones.productoElegido = desplegableProducto.get()

            for producto in Devoluciones.clienteElegido.getProductos():
                if f"{producto.getNombre()}" == Devoluciones.productoElegido:
                    Devoluciones.productoElegido = producto
                    break

            #se regresa el dinero al cliente
            CuentaBancaria.devolverDinero(Devoluciones.clienteElegido.getCuentaBancaria(),Devoluciones.productoElegido.getValor(), Devoluciones.clienteElegido)   

            #quita el dinero de la cuenta de la distribuidora
            CuentaBancaria.descontarFondos(Fabrica.getListaFabricas()[0].getCuentaBancaria(), Devoluciones.productoElegido.getValor())

            #Cambiar el estado del producto para que no vuelva a salir en la lista en la proxima devolución
            dev = True
            Devoluciones.productoElegido.setDevuelto(dev)

            #quitarle el producto al cliente
            Devoluciones.clienteElegido.getProductos().remove(Devoluciones.productoElegido)

            messagebox.showinfo("¡Devolucion Exitosa!",f"El producto devuelto fue:\n{Devoluciones.productoElegido.getNombre()}")

            desplegableFactura.set('')
            desplegableProducto.set('')
            desplegableProducto.config(values=Devoluciones.listaProductos)
            Devoluciones.productoElegido = None
            Devoluciones.clienteElegido = None
            Productos.grid_remove()
            boton.grid_remove()
            
        #-----------Divisiones filas y columnas--------
        self.config(bg="#b6fce6")
        for i in range(6):
            self.rowconfigure(i, weight=1)
        for j in range(3):
            self.columnconfigure(j, weight=1)

        Cabecera = tk.Frame(self, bg="#b6fce6")
        for k in range(3):
            Cabecera.columnconfigure(k, weight=1)
        Cabecera.rowconfigure(0, weight=1)
        Cabecera.rowconfigure(1, weight=1)
        Cabecera.grid(row=0, column=1,padx=5, pady=5, sticky="nsew")
        tituloCabecera = tk.Label(Cabecera, text='Gestionar Devoluciones', font=("Arial", 15, "bold"), bg ="#33a8d6", relief="raised", border=3 )
        tituloCabecera.grid(row=0, column=1,padx=10, pady=10, sticky="nsew")
        variableD = """En este apartado se pueden realizar devoluciones de los productos
        de una una factura en base al nombre del cliente"""
        descripcionCabecera = tk.Label(Cabecera, text=variableD, font=("Arial", 12), bg ="#93cfbc", border=2,relief="sunken" )
        descripcionCabecera.grid(row=1, column=1,padx=10, pady=10, sticky="nsew")

        # Crear el contenedos para las facturas
        Facturas = tk.Frame(self, bg="#33a8d6",relief="raised", border=2)
        Facturas.columnconfigure(0, weight=1)
        Facturas.grid(row=1, column=1,padx=10, pady=10, sticky="nsew")

        # Crear el contenedorpara  la lista de productos de la factura
        Productos = tk.Frame(self, bg="#338dd6",relief="raised",  border=2)
        Productos.columnconfigure(0, weight=1)
        Productos.grid(row=2, column=1,padx=10, pady=10, sticky="nsew")
        Productos.grid_remove()

        # --- Facturas 
        textoFactura = "Seleccione el cliente que correponde a la factura\npara devolver el producto"
        descripcionFactura = tk.Label(Facturas, text=textoFactura,font=("Arial", 12, "bold"),border=1,relief="sunken")
        descripcionFactura.grid(row=0, padx=10, pady=10, sticky="nsew")
        seleccionarFactura = tk.StringVar(value='Seleccionar Factura')
        Devoluciones.listaFacturas = []
        for factura in Factura.getListaFacturas():
            cliente = factura.getCliente()
            if cliente not in Devoluciones.listaFacturas:
                Devoluciones.listaFacturas.append(cliente)
        desplegableFactura = ttk.Combobox(Facturas,values= Devoluciones.listaFacturas, textvariable=seleccionarFactura, state='readonly', width=30)
        desplegableFactura.grid(row=1, padx=10, pady= 10, sticky="nsew")
        desplegableFactura.bind("<<ComboboxSelected>>", opcionFactura) #llamado a la funcion para mostrar los productos
        
        # --- Productos
        descripcionProducto = tk.Label(Productos, text="Seleccione el producto a devolver",font=("Arial", 12, "bold"), border=1,relief="sunken")
        descripcionProducto.grid(row=0, padx=10, pady= 10, sticky="nsew")
        seleccionarProducto = tk.StringVar(value='Seleccionar producto')
        desplegableProducto = ttk.Combobox(Productos,values= Devoluciones.listaProductos, textvariable=seleccionarProducto, state='readonly', width=30)
        desplegableProducto.grid(row=1, padx=10, pady= 10, sticky="nsew")
        desplegableProducto.bind("<<ComboboxSelected>>", opcionProducto)


        boton = tk.Button(self, text= "Realizar\nDevolución", width=20, height=4, bg="#1c71b8", font=("Franklin Gothic", 14, "bold"), fg="#ffffff",border=2,relief="raised",
                          command= devolverProducto)
        boton.grid(row=3, column=1)
        boton.grid_remove()


       