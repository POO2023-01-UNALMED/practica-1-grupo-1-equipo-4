import tkinter as tk
from tkinter import ttk

ventana = tk.Tk()
ventana.geometry("500x500+350+100")
ventana.title("Abastecer")

ventana.columnconfigure(0, weight=4)
ventana.columnconfigure(1, weight=5)
# Crear el marco izquierdo
marco_izquierdo = tk.Frame(ventana, bg="#45ffb8")
marco_izquierdo.columnconfigure(0, weight=1)
marco_izquierdo.grid(row=0, column=0,padx=10, pady=10, sticky="nsew")
# Crear el marco derecho
marco_derecho = tk.Frame(ventana, bg="#4287f5")
marco_derecho.columnconfigure(0, weight=1)
marco_derecho.grid(row=0, column=1,padx=10, pady=10, sticky="nsew")
# Configurar el peso para que los marcos se ajusten al tamaño de la ventana
ventana.rowconfigure(0, weight=2)

# --- lado izquierdo 
descripcion1 = tk.Label(marco_izquierdo, text="Seleccione un cliente")
descripcion1.grid(row=0, padx=10, pady=10, sticky="nsew")
seleccionarCliente = tk.StringVar(value='Seleccionar cliente')
clientes = ["cliente1","cliente2","cliente3","cliente4","cliente5","cliente6","cliente7"]
desplegableCliente = ttk.Combobox(marco_izquierdo,values= clientes, textvariable=seleccionarCliente, state='readonly', width=20)
desplegableCliente.grid(row=1, padx=10, pady= 10, sticky="nw")

# --- lado derecho
descripcion2 = tk.Label(marco_derecho, text="Seleccione un producto")
descripcion2.grid(row=0, padx=10, pady=10, sticky="nsew")
seleccionarProducto = tk.StringVar(value='Seleccionar producto')
productos = ["producto1","producto2","producto3","producto4","producto5","producto6","producto7"]
desplegableProducto = ttk.Combobox(marco_derecho,values= productos, textvariable=seleccionarProducto, state='readonly', width=20)
desplegableProducto.grid(row=1, padx=10, pady= 10, sticky="nw")

ventana.mainloop()