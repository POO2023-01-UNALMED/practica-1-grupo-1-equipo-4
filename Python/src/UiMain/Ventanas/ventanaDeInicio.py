import os
import tkinter as tk
from Ventanas.ventanaBase import VentanaBase

class VentanaDeInicio(tk.Tk):
    def __init__(self):
        super().__init__()

        self.title("Inicio")
        self.geometry("1080x720")
        menuArchivo = tk.Menu(self)
        self.config(menu=menuArchivo)
        menu1 = tk.Menu(menuArchivo,activebackground="blue",activeforeground="white")
        menuArchivo.add_cascade(label="Inicio", menu=menu1)
        menu1.add_command(label="Descripcion del sistema")#,command=)
        menu1.add_command(label="Salir",command=self.reset_screen)

        # Configurar y mostrar los widgets iniciales en la ventana

        # Agregar un botón para restablecer la pantalla



        # --------------- APARTIR DE ACA LUIS HARÁ SU MAGIA PARA NO DAÑAR LO DEMAS --------------
        #eventos de click
        def evento_clic(event):
            marco_derecho.configure(bg="black")

        #  ---------Fotos ----------

        # # Obtener la ruta del directorio actual del script
        # directorio_actual = os.path.dirname(os.path.abspath("Pyhton\\UiMain\\Ventanas\\imagenes\\fotosLuis\\viendoTamano.png"))
        
        # # Construir la ruta relativa al archivo
        # ruta_archivo = os.path.join(directorio_actual, "viendoTamano.png")
        # print(directorio_actual)
        # imagen1 = tk.PhotoImage(file="C:\\Users\\LENOVO\\Downloads\\LuizZz\\wakaPruebaCopia.png") #ruta_archivo

        self.columnconfigure(0, weight=1)
        self.columnconfigure(1, weight=2)
        # Crear el marco izquierdo
        marco_izquierdo = tk.Frame(self, bg="#45ffb8")
        marco_izquierdo.columnconfigure(0, weight=1)
        marco_izquierdo.grid(row=0, column=0,padx=10, pady=10, sticky="nsew")
        # Crear el marco derecho
        marco_derecho = tk.Frame(self, bg="#4287f5")
        marco_derecho.columnconfigure(0, weight=1)
        marco_derecho.grid(row=0, column=1,padx=10, pady=10, sticky="nsew")
        # Configurar el peso para que los marcos se ajusten al tamaño de la ventana
        self.rowconfigure(0, weight=2)

        #todo lo del lado izquierdo

        marco_izquierdo.rowconfigure(0,pad=5, weight=1)
        marco_izquierdo.rowconfigure(1,pad=5, weight=1)
        marco_izquierdo.rowconfigure(2,pad=5, weight=1)

        izquierdo_1 = tk.Frame(marco_izquierdo, bg="#70fa2a") #, width="400", height="100"
        izquierdo_1.rowconfigure(0, weight=1)
        izquierdo_1.columnconfigure(0, weight=1)
        izquierdo_1.grid(row=0, padx=10, pady=10, sticky="nsew")
        #aqui va lo que vaya dentro del frame
        algo = tk.Label(izquierdo_1, text="ayuda esto no es un meme")
        algo.grid(row=0, padx=20, pady=20, sticky="nsew")

        izquierdo_2 = tk.Frame(marco_izquierdo, bg="#e8eb34") #, width="400", height="100"
        izquierdo_2.grid(row=1, padx=10, pady=10, sticky="nsew")
        izquierdo_2.rowconfigure(0, weight=1)
        izquierdo_2.columnconfigure(0, weight=1)
        algo2 = tk.Label(izquierdo_2, text="aqui deben ir algunas imagenes")
        algo2.grid(row=0, padx=20, pady=20, sticky="nsew")


        izquierdo_3 = tk.Frame(marco_izquierdo, bg="#eb8f34") #, width="400", height="100"
        izquierdo_3.grid(row=2, padx=10, pady=10, sticky="nsew")
        izquierdo_3.rowconfigure(0, weight=1)
        izquierdo_3.columnconfigure(0, weight=1)
        reset_button = tk.Button(izquierdo_3, text="Ventana principal del administrador", command=self.abrir_ventana_principal, height=10)
        reset_button.grid(row=0, padx=20, pady=20, sticky="nsew")

        #todo lo del lado derecho

        marco_derecho.rowconfigure(0,pad=5, weight=1)
        marco_derecho.rowconfigure(1,pad=5, weight=1)

        derecho_1 = tk.Frame(marco_derecho, bg="#ba3cf0", width=200, height=100) #, width="400", height="100"
        derecho_1.grid(row=0, padx=10, pady=10, sticky="nsew")
        derecho_1.rowconfigure(0, weight=1)
        derecho_1.columnconfigure(0, weight=1)
        algo3 = tk.Label(derecho_1, text="ayuda esto no es un meme")
        algo3.grid(row=0, padx=20, pady=20, sticky="nsew")

        derecho_2 = tk.Frame(marco_derecho, bg="#f5425a") #, width="400", height="100"
        derecho_2.grid(row=1, padx=10, pady=10, sticky="nsew")
        
        derecho_2.rowconfigure(0, weight=1)
        derecho_2.rowconfigure(1, weight=1)
        derecho_2.columnconfigure(0, weight=1)
        derecho_2.columnconfigure(1, weight=1)
        
        algo4 = tk.Label(derecho_2, text="imagen 1") #image= imagen1
        algo4.grid(row=0,column=0, padx=10, pady=10, sticky="nsew")
        algo5 = tk.Label(derecho_2, text="imagen 2")
        algo5.grid(row=0,column=1, padx=10, pady=10, sticky="nsew")
        algo6 = tk.Label(derecho_2, text="imagen 3")
        algo6.grid(row=1,column=0, padx=10, pady=10, sticky="nsew")
        algo7 = tk.Label(derecho_2, text="imagen 4")
        algo7.grid(row=1,column=1, padx=10, pady=10, sticky="nsew")


        marco_derecho.bind("<Button-1>", evento_clic)
        derecho_1.bind("<Button-1>", evento_clic)
        derecho_2.bind("<Button-1>", evento_clic)
        algo3.bind("<Button-1>", evento_clic)
        algo4.bind("<Button-1>", evento_clic)
        algo5.bind("<Button-1>", evento_clic)
        algo6.bind("<Button-1>", evento_clic)
        algo7.bind("<Button-1>", evento_clic)

        # ---------------      ACÁ TERMINA LA MAGIA DE LUIS             -------------

    


        
    def reset_screen(self):
        # Destruir la ventana actual
        #Ubicacion serializidor
        self.destroy()

        # Crear una nueva instancia de la ventana
        #self.__init__()

    def abrir_ventana_principal(self):
        self.destroy()
        VentanaBase()
