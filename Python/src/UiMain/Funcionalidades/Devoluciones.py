""" import tkinter as tk
from tkinter import ttk, Frame, DISABLED,Entry
import sys
sys.path.append('../')  # Retrocede un nivel al directorio padre
#import Objetos as prueba

class Devoluciones(Frame):
    def __init__(self, window):
        #print(prueba.Fabrica)
        super().__init__(window)
        ventana = tk.Tk()
        ventana.geometry("500x500+350+100")
        ventana.title("Abastecer")

        ventana.columnconfigure(0, weight=4)
        ventana.columnconfigure(1, weight=5)
        # Crear el marco izquierdo
        marcoIzquierdo = tk.Frame(ventana, bg="#45ffb8")
        marcoIzquierdo.columnconfigure(0, weight=1)
        marcoIzquierdo.grid(row=0, column=0,padx=10, pady=10, sticky="nsew")
        # Crear el marco derecho
        marcoDerecho = tk.Frame(ventana, bg="#4287f5")
        marcoDerecho.columnconfigure(0, weight=1)
        marcoDerecho.grid(row=0, column=1,padx=10, pady=10, sticky="nsew")
        # Configurar el peso para que los marcos se ajusten al tamaño de la ventana
        ventana.rowconfigure(0, weight=2)

        # --- lado izquierdo 
        descripcion1 = tk.Label(marcoIzquierdo, text="Seleccione un cliente")
        descripcion1.grid(row=0, padx=10, pady=10, sticky="nsew")
        seleccionarCliente = tk.StringVar(value='Seleccionar cliente')
        clientes = ["cliente1","cliente2","cliente3","cliente4","cliente5","cliente6","cliente7"]
        desplegableCliente = ttk.Combobox(marcoIzquierdo,values= clientes, textvariable=seleccionarCliente, state='readonly', width=20)
        desplegableCliente.grid(row=1, padx=10, pady= 10, sticky="nw")

        # --- lado derecho
        descripcion2 = tk.Label(marcoDerecho, text="Seleccione un producto")
        descripcion2.grid(row=0, padx=10, pady=10, sticky="nsew")
        seleccionarProducto = tk.StringVar(value='Seleccionar producto')
        productos = ["producto1","producto2","producto3","producto4","producto5","producto6","producto7"]
        desplegableProducto = ttk.Combobox(marcoDerecho,values= productos, textvariable=seleccionarProducto, state='readonly', width=20)
        desplegableProducto.grid(row=1, padx=10, pady= 10, sticky="nw")
        """