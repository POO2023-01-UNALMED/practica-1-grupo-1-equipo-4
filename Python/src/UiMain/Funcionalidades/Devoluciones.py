import tkinter as tk
from tkinter import ttk, Frame, DISABLED,Entry
import sys
sys.path.append('../')  # Retrocede un nivel al directorio padre
#import Objetos as prueba

class Devoluciones(Frame):
    def __init__(self, window):
        #print(prueba.Fabrica)
        super().__init__(window)
            #-----------Divisiones filas y columnas--------
        self.config(bg="#c6bff5")
        for i in range(12):
            self.rowconfigure(i, weight=1)
        for j in range(3):
            self.columnconfigure(j, weight=1)

        Cabecera = tk.Frame(self, relief="raised", bg="#c6bff5")
        for k in range(3):
            Cabecera.columnconfigure(k, weight=1)
        Cabecera.rowconfigure(0,weight=1)
        Cabecera.grid(row=0, column=1,padx=5, pady=5, sticky="nsew")
        titulo = tk.Label(Cabecera, text='Gestionar Devoluciones', font=("Arial", 15), fg="#fc035e" , bg ="#ffffff" )
        titulo.grid(row=0, column=1,padx=10, pady=10, sticky="nsew")
        # Crear el marco izquierdo
        Facturas = tk.Frame(self, bg="#de6ac7",relief="raised")
        Facturas.columnconfigure(0, weight=1)
        Facturas.grid(row=1, column=1,padx=10, pady=10, sticky="nsew")
        # Crear el marco derecho
        Productos = tk.Frame(self, bg="#c96ade",relief="raised")
        Productos.columnconfigure(0, weight=1)
        Productos.grid(row=2, column=1,padx=10, pady=10, sticky="nsew")
        # Configurar el peso para que los marcos se ajusten al tamaño de la ventana


        # --- Facturas 
        descripcionCliente = tk.Label(Facturas, text="Seleccione la factura pa devolver el producto")
        descripcionCliente.grid(row=0, padx=10, pady=10, sticky="nsew")
        seleccionarCliente = tk.StringVar(value='Seleccionar cliente')
        ListaClientes = ["factura1","factura2","factura3","factura4","factura5","factura6","cliente7"]
        desplegableCliente = ttk.Combobox(Facturas,values= ListaClientes, textvariable=seleccionarCliente, state='readonly', width=30)
        desplegableCliente.grid(row=1, padx=10, pady= 10, sticky="nw")

        # --- Productos
        descripcionProducto = tk.Label(Productos, text="Seleccione un producto")
        descripcionProducto.grid(row=0, padx=10, pady=10, sticky="nsew")
        seleccionarProducto = tk.StringVar(value='Seleccionar producto')
        ListaProductos = ["producto1","producto2","producto3","producto4","producto5","producto6","producto7"]
        desplegableProducto = ttk.Combobox(Productos,values= ListaProductos, textvariable=seleccionarProducto, state='readonly', width=30)
        desplegableProducto.grid(row=1, padx=10, pady= 10, sticky="nw")
       