import tkinter as tk
from tkinter import ttk, Frame, DISABLED,Entry
import sys
sys.path.append('../')  # Retrocede un nivel al directorio padre
#import Objetos as prueba

class Devoluciones(Frame):
    def __init__(self, window):
        #print(prueba.Fabrica)
        super().__init__(window)

        #----  Funciones ----
        def opcionFactura(event):
            print("aksjdbkajsbdkjasbdkanskjaskf")
            Productos.grid()
        
        def opcionProducto(event):
            boton.grid()

        #-----------Divisiones filas y columnas--------
        self.config(bg="#b6fce6")
        for i in range(12):
            self.rowconfigure(i, weight=1)
        for j in range(3):
            self.columnconfigure(j, weight=1)

        Cabecera = tk.Frame(self, bg="#bee4ed")
        for k in range(3):
            Cabecera.columnconfigure(k, weight=1)
        Cabecera.rowconfigure(0, weight=1)
        Cabecera.rowconfigure(1, weight=1)
        Cabecera.grid(row=0, column=1,padx=5, pady=5, sticky="nsew")
        tituloCabecera = tk.Label(Cabecera, text='Gestionar Devoluciones', font=("Arial", 15), fg="#fc035e" , bg ="#fa6b05", relief="raised", border=2 )
        tituloCabecera.grid(row=0, column=1,padx=10, pady=10, sticky="nsew")
        variableD = "probando"
        descripcionCabecera = tk.Label(Cabecera, text=variableD, font=("Arial", 15), bg ="#bee4ed", border=2,relief="sunken" )
        descripcionCabecera.grid(row=1, column=1,padx=10, pady=10, sticky="nsew")
        # Crear el contenedos para las facturas
        Facturas = tk.Frame(self, bg="#de6ac7",relief="raised", border=2)
        Facturas.columnconfigure(0, weight=1)
        Facturas.grid(row=2, column=1,padx=10, pady=10, sticky="nsew")

        # Crear el contenedorpara  la lista de productos de la factura
        Productos = tk.Frame(self, bg="#c96ade",relief="raised",  border=2)
        Productos.columnconfigure(0, weight=1)
        Productos.grid(row=3, column=1,padx=10, pady=10, sticky="nsew")
        Productos.grid_remove()

        # --- Facturas 
        descripcionFactura = tk.Label(Facturas, text="Seleccione la factura pa devolver el producto")
        descripcionFactura.grid(row=0, padx=10, pady=10, sticky="nsew")
        seleccionarFactura = tk.StringVar(value='Seleccionar Factura')
        ListaFacturas = ["factura1","factura2","factura3","factura4","factura5","factura6","Factura7"]
        desplegableFactura = ttk.Combobox(Facturas,values= ListaFacturas, textvariable=seleccionarFactura, state='readonly', width=30)
        desplegableFactura.grid(row=1, padx=10, pady= 10, sticky="nsew")
        desplegableFactura.bind("<<ComboboxSelected>>", opcionFactura) #llamado a la funcion para mostrar los productos
        
        # --- Productos
        descripcionProducto = tk.Label(Productos, text="Seleccione un producto")
        descripcionProducto.grid(row=0, padx=10, pady= 10, sticky="nsew")

        seleccionarProducto = tk.StringVar(value='Seleccionar producto')
        ListaProductos = ["producto1","producto2","producto3","producto4","producto5","producto6","producto7"]
        desplegableProducto = ttk.Combobox(Productos,values= ListaProductos, textvariable=seleccionarProducto, state='readonly', width=30)
        desplegableProducto.grid(row=1, padx=10, pady= 10, sticky="nsew")
        desplegableProducto.bind("<<ComboboxSelected>>", opcionProducto)


        boton = tk.Button(self, text= "Realizar\nDevolcion", width=20, height=4, bg="#a6e4ff", font=("Franklin Gothic", 10, "bold"))
        boton.grid(row=4, column=1)
        boton.grid_remove()


       