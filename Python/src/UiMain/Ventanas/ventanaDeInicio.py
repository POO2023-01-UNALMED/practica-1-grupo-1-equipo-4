import tkinter as tk
from Ventanas.ventanaBase import VentanaBase

class VentanaDeInicio(tk.Tk):
    def __init__(self):
        super().__init__()

        self.title("Ejemplo de Menú")
        self.geometry("1080x720")
        menuBar = tk.Menu(self)
        self.config(menu=menuBar)
        menu1 = tk.Menu(menuBar,activebackground="blue",activeforeground="white")
        menuBar.add_cascade(label="Archivo", menu=menu1)
        menu1.add_command(label="Abrir")
        self.texto = tk.Label(self,text="Presione un Menu",font=("Arial",10))
        self.texto.pack(anchor="w")
        menu2 = tk.Menu(menuBar,activebackground="blue",activeforeground="white")

        menu2.add_command(label="Opcion1",command= self.opcion1)
        menu2.add_command(label="Opcion2",command= self.opcion2)
        menu1.add_cascade(label="Salir", menu=menu2)

        # Configurar y mostrar los widgets iniciales en la ventana
        # ...

        # Agregar un botón para restablecer la pantalla
        reset_button = tk.Button(self, text="Ventana principal del administrador", command=self.abrir_ventana_principal)
        reset_button.pack()

    def reset_screen(self):
        # Destruir la ventana actual
        self.destroy()

        # Crear una nueva instancia de la ventana
        self.__init__()

    def opcion1(self):
        self.config(bg="blue")
        self.texto.config(text="Click en Menu Opcion 1",bg="blue")
        
    def opcion2(self):
        self.config(bg="red")
        self.texto.config(text="Click en Menu Opcion 2",bg="red")

    def abrir_ventana_principal(self):
        self.destroy()
        VentanaBase()
