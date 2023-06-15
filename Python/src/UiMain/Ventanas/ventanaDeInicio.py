import tkinter as tk
from .ventanaBase import VentanaBase
from tkinter import messagebox
#from tkinter import ttk

import os
import pathlib
path = os.path.join(pathlib.Path(__file__).parent.absolute())
path = os.path.dirname(path)
from PIL import Image, Image, ImageTk


class VentanaDeInicio(tk.Tk):
    contador = 0
    def __init__(self):
        super().__init__()

        self.title("La mejor empresa del mundo0o0o0 MJLJM")
        self.geometry("1080x720+100+0")
        self.config(bg="#dab5ff")
        menuArchivo = tk.Menu(self)
        self.config(menu=menuArchivo, height=30)
        menu1 = tk.Menu(menuArchivo,activebackground="blue",activeforeground="white")
        menuArchivo.add_cascade(label="Inicio", menu=menu1)
        menu1.add_command(label="Descripcion del sistema", command= self.descripcionDelSistema)
        menu1.add_command(label="Salir",command=self.reset_screen)

        # Configurar y mostrar los widgets iniciales en la ventana

        # Agregar un botón para restablecer la pantalla



        # --------------- APARTIR DE ACA LUIS HARÁ SU MAGIA PARA NO DAÑAR LO DEMAS --------------
        #valores para la descripcion
        
        def click_event(self):
            global  imagen1, imagen2, imagen3,imagen4
            VentanaDeInicio.contador += 1
            VentanaDeInicio.contador %= 5 
            
            
            if VentanaDeInicio.contador == 0:
            #fotos de luis
                imagen1 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosLuis/luis1.png').resize((250,200), Image.ANTIALIAS)) 
                imagen2 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosLuis/luis2.png').resize((250,200), Image.ANTIALIAS)) 
                imagen3 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosLuis/luis3.png').resize((250,200), Image.ANTIALIAS)) 
                imagen4 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosLuis/luis4.png').resize((250,200), Image.ANTIALIAS))
                
            elif VentanaDeInicio.contador == 1:
            #fotos de Mafe
                imagen1 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosMafe/mafe1.png').resize((250,200), Image.ANTIALIAS)) 
                imagen2 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosMafe/mafe2.png').resize((250,200), Image.ANTIALIAS)) 
                imagen3 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosMafe/mafe3.png').resize((250,200), Image.ANTIALIAS)) 
                imagen4 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosMafe/mafe4.png').resize((250,200), Image.ANTIALIAS))
            elif VentanaDeInicio.contador == 2:
            #fotos de Moni
                imagen1 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosMoni/Moni1.png').resize((250,200), Image.ANTIALIAS)) 
                imagen2 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosMoni/Moni2.png').resize((250,200), Image.ANTIALIAS)) 
                imagen3 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosMoni/Moni3.png').resize((250,200), Image.ANTIALIAS)) 
                imagen4 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosMoni/Moni4.png').resize((250,200), Image.ANTIALIAS))
            elif VentanaDeInicio.contador == 3:
            #fotos de Jaider
                imagen1 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosJaider/jaider1.png').resize((250,200), Image.ANTIALIAS)) 
                imagen2 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosJaider/jaider2.png').resize((250,200), Image.ANTIALIAS)) 
                imagen3 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosJaider/jaider3.png').resize((250,200), Image.ANTIALIAS)) 
                imagen4 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosJaider/jaider4.png').resize((250,200), Image.ANTIALIAS))
            elif VentanaDeInicio.contador == 4:
            #fotos de Joan
                imagen1 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosJoan/joan1.png').resize((250,200), Image.ANTIALIAS)) 
                imagen2 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosJoan/joan2.png').resize((250,200), Image.ANTIALIAS)) 
                imagen3 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosJoan/joan3.png').resize((250,200), Image.ANTIALIAS)) 
                imagen4 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosJoan/joan4.png').resize((250,200), Image.ANTIALIAS))
            algo4.configure(image=imagen1)
            algo5.configure(image=imagen2)
            algo6.configure(image=imagen3)
            algo7.configure(image=imagen4)

        VALUES  = [
        {"name": "Luis Alejandro Varela Ojeda", "description":"Amante de la Natacion y Waterpolo", "email":"luvarelao@unal.edu.co"},
        {"name": "Monica Sofia Restrepo León", "description":"Amante de la ciencia de datos", "email":"aluribes@unal.edu.co" },
        {"name":"Maria Fernanda Calle Agudelo", "description":"Trabaja en la vaganciaaaaa", "email":"mcalleag@unal.edu.co"},
        {"name": "Jaider Castañeda Villa", "description":"Amante de la comida", "email":"jualopezra@unal.edu.co" },
        {"name":"Joan Sebastian Salazar Montoya", "description":"Apasionado por la lectura", "email":"jtobonz@unal.edu.co"}
            ]


        #  ---------Fotos ----------
        imagen1 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosLuis/luis1.png').resize((250,200), Image.ANTIALIAS)) 
        imagen2 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosLuis/luis2.png').resize((250,200), Image.ANTIALIAS)) 
        imagen3 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosLuis/luis3.png').resize((250,200), Image.ANTIALIAS)) 
        imagen4 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosLuis/luis4.png').resize((250,200), Image.ANTIALIAS))

        #fotos = [imagen1, imagen2, imagen3, imagen4] 
        self.image_names = [imagen1, imagen2, imagen3, imagen4]
       
        self.columnconfigure(0, weight=4)
        self.columnconfigure(1, weight=5)
        
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
        algo = tk.Label(izquierdo_1, text="bienvenidos a la empresa\n MJLJM")
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
        reset_button = tk.Button(izquierdo_3, text="Ventana principal del administrador",command=self.abrir_ventana_principal,  height=10)
        reset_button.grid(row=0, padx=20, pady=20, sticky="nsew")

        #todo lo del lado derecho

        marco_derecho.rowconfigure(0,pad=5, weight=1)
        marco_derecho.rowconfigure(1,pad=5, weight=1)

        derecho_1 = tk.Frame(marco_derecho, bg="#ba3cf0", width=200, height=100) #, width="400", height="100"
        derecho_1.grid(row=0, padx=10, pady=10, sticky="nsew")
        derecho_1.rowconfigure(0, weight=1)
        derecho_1.columnconfigure(0, weight=1)
        algo3 = tk.Label(derecho_1)
        algo3.grid(row=0, padx=20, pady=20, sticky="nsew")

        algo3.rowconfigure(0, weight=1)
        algo3.rowconfigure(1, weight=1)
        algo3.rowconfigure(2, weight=1)
        algo3.columnconfigure(0, weight=1)
        algo3.columnconfigure(1, weight=1)
        algo3.columnconfigure(2, weight=1)

        #descripcion de los Integrantes
        name = tk.Label(algo3, text="Name: " )
        name.grid(row=0,column=0, sticky="nsew")
        nombre = tk.Label(algo3, text=VALUES[VentanaDeInicio.contador]["name"] )
        nombre.grid(row=0,column=1, sticky="nsew")
        description = tk.Label(algo3, text="Description: " )
        description.grid(row=1,column=0, sticky="nsew")
        descripcion = tk.Label(algo3, text=VALUES[VentanaDeInicio.contador]["description"] )
        descripcion.grid(row=1,column=1, sticky="nsew")
        email = tk.Label(algo3, text="Email: " )
        email.grid(row=2,column=0, sticky="nsew")
        correo = tk.Label(algo3, text= VALUES[VentanaDeInicio.contador]["email"] )
        correo.grid(row=2,column=1, sticky="nsew")

        derecho_2 = tk.Frame(marco_derecho, bg="#f5425a") #, width="400", height="100"
        derecho_2.grid(row=1, padx=10, pady=10, sticky="nsew")
        
        derecho_2.rowconfigure(0, weight=1)
        derecho_2.rowconfigure(1, weight=1)
        derecho_2.columnconfigure(0, weight=1)
        derecho_2.columnconfigure(1, weight=1)
        
        
        algo4 = tk.Label(derecho_2, text="imagen 1", image =  imagen1) #image= imagen1
        algo4.grid(row=0,column=0, padx=10, pady=10, sticky="nsew")
        algo5 = tk.Label(derecho_2, text="imagen 2", image =  imagen2)
        algo5.grid(row=0,column=1, padx=10, pady=10, sticky="nsew")
        algo6 = tk.Label(derecho_2, text="imagen 3", image =  imagen3)
        algo6.grid(row=1,column=0, padx=10, pady=10, sticky="nsew")
        algo7 = tk.Label(derecho_2, text="imagen 4", image =  imagen4)
        algo7.grid(row=1,column=1, padx=10, pady=10, sticky="nsew")

        marco_derecho.bind('<ButtonPress-1>', click_event)
        derecho_1.bind('<ButtonPress-1>', click_event)
        derecho_2.bind('<ButtonPress-1>', click_event)
        algo3.bind('<ButtonPress-1>', click_event)
        algo4.bind('<ButtonPress-1>', click_event)
        algo5.bind('<ButtonPress-1>', click_event)
        algo6.bind('<ButtonPress-1>', click_event)
        algo7.bind('<ButtonPress-1>', click_event)

        # ---------------      ACÁ TERMINA LA MAGIA DE LUIS             -------------

    
    def descripcionDelSistema(self):
            info = """Distribuidora JMLMJ SAS es un programa diseñado para llevar el control de una empresa de distribuciones de diferentes tipos de productos, vista desde el punto de un administrador encargado de controlar todos los procesos. 

            Tiene funcionalidades para:
                - Enviar pedido 
                - Pagarle a los trabajadores
                - Abastecer tiendas 
                - Gestionar devoluciones 
                - Mostar estadísticas 

            Básicamente todo lo necesario para organizar, administrar y atender una empresa distibuidora con éxito. 

              """

            messagebox.showinfo("Aplicación", info)



    # def descripcionDelSistema(self):
    #     geC = descripcionDelSistema(self)
    #     self.Limpiar(geC)
            
    def reset_screen(self):
        # Destruir la ventana actual
        #Ubicacion serializidor
        self.destroy()

        # Crear una nueva instancia de la ventana
        #self.__init__()

    def abrir_ventana_principal(self):
        self.destroy()
        VentanaBase()
