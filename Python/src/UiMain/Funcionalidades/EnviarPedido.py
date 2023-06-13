import tkinter as tk
from tkinter import ttk,Frame

# ventanaEnvio = tk.Tk()
# ventanaEnvio.title("Envío de pedidos")
# ventanaEnvio.geometry("900x800")

class EnviarPedido(Frame):
    def __init__(self, window):
        super().__init__(window)

        #----------------TITULO
        frameCabecera = tk.Frame(self)
        frameCabecera.grid(row=0, column=0, columnspan=4,padx=5, pady=5)
        titulo = tk.Label(frameCabecera, text='Envío de Pedidos', font=("Arial", 15))
        titulo.pack()

        #Descripción
        textoDescripcion = """Aquí podrá seleccionar el cliente, productos a enviar, tipo de 
        transporte y descuentos aplicables al pedido. Todo lo necesario para gestionar los pedidos de la empresa """
        descripcion = tk.Label(frameCabecera, text=textoDescripcion,font=("Arial", 10))
        descripcion.pack()    



                # ------Eventos---------
            # def opcionCliente(evento):
            #     opc = desplegableTipos.get()
