import tkinter as tk
from Ventanas.ventanaBase import VentanaBase

class VentanaDeInicio(tk.Tk):
    def __init__(self):
        super().__init__()

        self.title("Distribuidora MJLJM")
        self.geometry("1080x720")
        menuArchivo = tk.Menu(self)
        self.config(menu=menuArchivo)
        menu1 = tk.Menu(menuArchivo,activebackground="blue",activeforeground="white")
        menuArchivo.add_cascade(label="Inicio", menu=menu1)
        menu1.add_command(label="Descripcion del sistema")#,command=)
        menu1.add_command(label="Salir",command=self.reset_screen)

        # Configurar y mostrar los widgets iniciales en la ventana

        # Agregar un botón para restablecer la pantalla
        reset_button = tk.Button(self, text="Ventana principal del administrador", command=self.abrir_ventana_principal)
        reset_button.pack()

    def reset_screen(self):
        # Destruir la ventana actual
        #Ubicacion serializidor
        self.destroy()

        # Crear una nueva instancia de la ventana
        #self.__init__()

    def abrir_ventana_principal(self):
        self.destroy()
        VentanaBase()
