import tkinter as tk
from tkinter import ttk, Frame, DISABLED,Entry
import sys
sys.path.append('../')  # Retrocede un nivel al directorio padre
from gestorAplicacion.gestion.Factura import Factura
from gestorAplicacion.gestion.Cliente import Cliente
from gestorAplicacion.produccion.Producto import Producto 

class Devoluciones(Frame):
    def __init__(self, window):
        #print(prueba.Fabrica)
        super().__init__(window)
        
        #----  Funciones ----
        def opcionFactura(event):
            global listaProductos, clienteElegido
            clienteElegido = desplegableFactura.get()

            for factura in Factura.getListaFacturas():
                if f"{factura.getCliente()}" == clienteElegido:
                    clienteElegido = factura.getCliente()
            
            for producto in clienteElegido.getProductos():
                listaProductos.append(producto.getNombre())
            Productos.grid()
        
        def opcionProducto(event):
            boton.grid()

        #-----------Divisiones filas y columnas--------
        self.config(bg="#b6fce6")
        for i in range(12):
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
        variableD = "probando"
        descripcionCabecera = tk.Label(Cabecera, text=variableD, font=("Arial", 12), bg ="#93cfbc", border=2,relief="sunken" )
        descripcionCabecera.grid(row=1, column=1,padx=10, pady=10, sticky="nsew")

        # Crear el contenedos para las facturas
        Facturas = tk.Frame(self, bg="#33a8d6",relief="raised", border=2)
        Facturas.columnconfigure(0, weight=1)
        Facturas.grid(row=2, column=1,padx=10, pady=10, sticky="nsew")

        # Crear el contenedorpara  la lista de productos de la factura
        Productos = tk.Frame(self, bg="#338dd6",relief="raised",  border=2)
        Productos.columnconfigure(0, weight=1)
        Productos.grid(row=3, column=1,padx=10, pady=10, sticky="nsew")
        Productos.grid_remove()

        # --- Facturas 
        textoFactura = "Seleccione el cliente que correponde a la factura\npara devolver el prducto"
        descripcionFactura = tk.Label(Facturas, text=textoFactura,font=("Arial", 12, "bold"),border=1,relief="sunken")
        descripcionFactura.grid(row=0, padx=10, pady=10, sticky="nsew")
        seleccionarFactura = tk.StringVar(value='Seleccionar Factura')
        listaFacturas = []
        for factura in Factura.getListaFacturas():
            cliente = factura.getCliente()
            listaFacturas.append(cliente)
        desplegableFactura = ttk.Combobox(Facturas,values= listaFacturas, textvariable=seleccionarFactura, state='readonly', width=30)
        desplegableFactura.grid(row=1, padx=10, pady= 10, sticky="nsew")
        desplegableFactura.bind("<<ComboboxSelected>>", opcionFactura) #llamado a la funcion para mostrar los productos
        
        # --- Productos
        descripcionProducto = tk.Label(Productos, text="Seleccione un producto",font=("Arial", 12, "bold"), border=1,relief="sunken")
        descripcionProducto.grid(row=0, padx=10, pady= 10, sticky="nsew")
        seleccionarProducto = tk.StringVar(value='Seleccionar producto')
        listaProductos = []
        desplegableProducto = ttk.Combobox(Productos,values= listaProductos, textvariable=seleccionarProducto, state='readonly', width=30)
        desplegableProducto.grid(row=1, padx=10, pady= 10, sticky="nsew")
        desplegableProducto.bind("<<ComboboxSelected>>", opcionProducto)


        boton = tk.Button(self, text= "Realizar\nDevolución", width=20, height=4, bg="#1c71b8", font=("Franklin Gothic", 14, "bold"),border=2,relief="raised")
        boton.grid(row=4, column=1)
        boton.grid_remove()


       