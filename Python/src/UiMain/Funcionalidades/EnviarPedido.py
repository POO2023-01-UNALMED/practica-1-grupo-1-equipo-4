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
        
        # Configurar el sistema de gestión de geometría grid
        frameCabecera.columnconfigure(0, weight=1)  # Columna 0 con peso 1
        frameCabecera.rowconfigure(0, weight=1)     # Fila 0 con peso 1

        titulo = tk.Label(frameCabecera, text='Envío de Pedidos', font=("Arial", 15))
        titulo.grid(row=0, column=0, sticky="nsew")  # Centrado vertical y horizontalmente
        
        #Descripción
        textoDescripcion = """Aquí podrá seleccionar el cliente, productos a enviar, tipo de 
        transporte y descuentos aplicables al pedido. Todo lo necesario para gestionar los pedidos de la empresa """
        descripcion = tk.Label(frameCabecera, text=textoDescripcion, font=("Arial", 10))
        descripcion.grid(row=1, column=0, sticky="nsew")  # Centrado vertical y horizontalmente

# # Crear la ventana principal
# ventanaEnvio = tk.Tk()
# ventanaEnvio.title("Envío de pedidos")
# ventanaEnvio.geometry("900x800")

# # Crear la instancia de la clase EnviarPedido
# enviarPedido = EnviarPedido(ventanaEnvio)
# enviarPedido.pack(fill="both", expand=True)

# # Ejecutar el bucle principal de la aplicación
# ventanaEnvio.mainloop()