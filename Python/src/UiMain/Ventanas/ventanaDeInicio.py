import tkinter as tk
from .ventanaBase import VentanaBase
from tkinter import messagebox
import os
import pathlib
path = os.path.join(pathlib.Path(__file__).parent.absolute())
path = os.path.dirname(path)
from PIL import Image, Image, ImageTk
#from tkinter import ttk
import sys
sys.path.append('../') 
from baseDatos.Deserializador import Deserializador


class VentanaDeInicio(tk.Tk):
    contador = 0
    contador2 = 0
    def __init__(self):
        super().__init__()

        self.title("La mejor empresa del mundo JMLMJ")
        self.geometry("1080x720+100+0")
        self.config(bg="#b6fce6")
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
                imagen1 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosMoni/moni2.png').resize((250,200), Image.ANTIALIAS)) 
                imagen2 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosMoni/moni3.png').resize((250,200), Image.ANTIALIAS)) 
                imagen3 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosMoni/moni4.png').resize((250,200), Image.ANTIALIAS)) 
                imagen4 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosMoni/moni1.png').resize((250,200), Image.ANTIALIAS))
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
            nombre.configure(text= VALUES[VentanaDeInicio.contador]["name"]) 
            descripcion.configure(text=VALUES[VentanaDeInicio.contador]["description"]) 
            correo.configure(text=VALUES[VentanaDeInicio.contador]["email"]) 
        
        def mouse_entra(event):
            # Acciones a realizar cuando el mouse entra en el widget
            global imagenSistema1
            VentanaDeInicio.contador2 += 1
            VentanaDeInicio.contador2 %= 5 
            if VentanaDeInicio.contador2 == 0:
                imagenSistema1 =ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosSistema/sistema1.png').resize((300,250), Image.ANTIALIAS))
            elif VentanaDeInicio.contador2 == 1:
                imagenSistema1 =ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosSistema/sistema2.png').resize((300,250), Image.ANTIALIAS))
            elif VentanaDeInicio.contador2 == 2:
                imagenSistema1 =ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosSistema/sistema3.png').resize((300,250), Image.ANTIALIAS))
            elif VentanaDeInicio.contador2 == 3:
                imagenSistema1 =ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosSistema/sistema4.png').resize((300,250), Image.ANTIALIAS))
            elif VentanaDeInicio.contador2 == 4:
                imagenSistema1 =ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosSistema/sistema5.png').resize((300,250), Image.ANTIALIAS))
            # elif VentanaDeInicio.contador2 == 5:
            #     imagenSistema1 =ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosSistema/sistema6.png').resize((300,250), Image.ANTIALIAS))
            # elif VentanaDeInicio.contador2 == 6:
            #     imagenSistema1 =ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosSistema/sistema7.png').resize((300,250), Image.ANTIALIAS))
            algo2.configure(image=imagenSistema1)

        VALUES  = [
        {"name": "Luis Alejandro Varela Ojeda", "description":"Amante de la Natacion y Waterpolo", "email":"luvarelao@unal.edu.co"},
        {"name":"Maria Fernanda Calle Agudelo", "description":"Apasionada por el baloncesto", "email":"mcalleag@unal.edu.co"},
        {"name": "Monica Sofia Restrepo León", "description":"Me gusta el morado, los caballos y la tecnología", "email":"morestrepol@unal.edu.co" },
        {"name": "Jaider Castañeda Villa", "description":"Entusiasta de la programacion", "email":"jcastanedavi@unal.edu.co" },
        {"name":"Joan Sebastian Salazar Montoya", "description":"Amo la música y las matemáticas", "email":"josalazarmo@unal.edu.co"}
            ]


        #  ---------Fotos ----------
        imagen1 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosLuis/luis1.png').resize((250,200), Image.ANTIALIAS)) 
        imagen2 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosLuis/luis2.png').resize((250,200), Image.ANTIALIAS)) 
        imagen3 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosLuis/luis3.png').resize((250,200), Image.ANTIALIAS)) 
        imagen4 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosLuis/luis4.png').resize((250,200), Image.ANTIALIAS))
        imagenSistema1 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosSistema/sistema1.png').resize((300,250), Image.ANTIALIAS))
        self.image_names = [imagen1, imagen2, imagen3, imagen4, imagenSistema1]
       
        self.columnconfigure(0, weight=4)
        self.columnconfigure(1, weight=5)
        
        # Crear el marco izquierdo
        marco_izquierdo = tk.Frame(self, bg="#33a8d6", relief="raised", border=2)
        marco_izquierdo.columnconfigure(0, weight=1)
        marco_izquierdo.grid(row=0, column=0,padx=10, pady=10, sticky="nsew")
        # Crear el marco derecho
        marco_derecho = tk.Frame(self, bg="#33a8d6", relief="raised", border=2)
        marco_derecho.columnconfigure(0, weight=1)
        marco_derecho.grid(row=0, column=1,padx=10, pady=10, sticky="nsew")
        # Configurar el peso para que los marcos se ajusten al tamaño de la ventana
        self.rowconfigure(0, weight=2)

        #todo lo del lado izquierdo

        marco_izquierdo.rowconfigure(0,pad=5, weight=1)
        marco_izquierdo.rowconfigure(1,pad=5, weight=1)
        marco_izquierdo.rowconfigure(2,pad=5, weight=1)

        izquierdo_1 = tk.Frame(marco_izquierdo, bg="#93cfbc", relief="sunken", border=2) # 70fa2a
        izquierdo_1.rowconfigure(0, weight=1)
        izquierdo_1.columnconfigure(0, weight=1)
        izquierdo_1.grid(row=0, padx=10, pady=10, sticky="nsew")
        #aqui va lo que vaya dentro del frame
        algo = tk.Label(izquierdo_1, text="Bienvenidos a la distribuidora\n JMLMJ", font=("Franklin Gothic", 15, "bold"), bg="#329bfc", relief="raised", border=2)
        algo.grid(row=0, padx=20, pady=20, sticky="nsew")

        izquierdo_2 = tk.Frame(marco_izquierdo, bg="#93cfbc",relief="sunken", border=2) #, width="400", height="100"
        izquierdo_2.grid(row=1, padx=10, pady=10, sticky="nsew")
        izquierdo_2.rowconfigure(0, weight=1)
        izquierdo_2.columnconfigure(0, weight=1)
        algo2 = tk.Label(izquierdo_2 , image= imagenSistema1, bg="#329bfc", relief="raised", border=2 ) #
        algo2.grid(row=0, padx=20, pady=20, sticky="nsew")


        izquierdo_3 = tk.Frame(marco_izquierdo, bg="#93cfbc", relief="sunken", border=2) #, width="400", height="100"
        izquierdo_3.grid(row=2, padx=10, pady=10, sticky="nsew")
        izquierdo_3.rowconfigure(0, weight=1)
        izquierdo_3.columnconfigure(0, weight=1)
        entrar_button = tk.Button(izquierdo_3, text="Ventana principal\ndel administrador",command=self.abrir_ventana_principal,  height=5, width=5, bg="#329bfc", relief="raised", border=2, font=("Franklin Gothic", 15, "bold"))
        entrar_button.grid(row=0, padx=20, pady=20, sticky="nsew")

        #todo lo del lado derecho

        marco_derecho.rowconfigure(0,pad=5, weight=1)
        marco_derecho.rowconfigure(1,pad=5, weight=1)

        derecho_1 = tk.Frame(marco_derecho, bg="#93cfbc", relief="sunken", border=2, width=200, height=100) #, width="400", height="100"
        derecho_1.grid(row=0, padx=10, pady=10, sticky="nsew")
        derecho_1.rowconfigure(0, weight=1)
        derecho_1.rowconfigure(1, weight=1)
        derecho_1.columnconfigure(0, weight=1)
        algo8 = tk.Label(derecho_1, text="Integrantes", font=("Arial", 15, "bold"), bg="#329bfc", relief="raised", border=2)
        algo8.grid(row=0, padx=20, pady=10, sticky="nsew")
        algo3 = tk.Label(derecho_1, bg="#329bfc", relief="raised", border=2)
        algo3.grid(row=1, padx=20, pady=10, sticky="nsew")

        algo3.rowconfigure(0, weight=1)
        algo3.rowconfigure(1, weight=1)
        algo3.rowconfigure(2, weight=1)
        algo3.rowconfigure(3, weight=1)
        algo3.columnconfigure(0, weight=1)
        algo3.columnconfigure(1, weight=1)
        

        #Descripcion de los Integrantes

        name = tk.Label(algo3, text="Nombre: " ,font=("Arial", 12, "bold"), bg="#329bfc", relief="raised", border=2)
        name.grid(row=0,column=0, sticky="nsew")
        nombre = tk.Label(algo3, text=  VALUES[VentanaDeInicio.contador]["name"], bg="#329bfc", relief="raised", border=2, font=("Arial", 8, "bold"))
        nombre.grid(row=0,column=1, sticky="nsew")
        description = tk.Label(algo3, text="Descripcion: ",font=("Arial", 12, "bold") , bg="#329bfc", relief="raised", border=2)
        description.grid(row=1,column=0, sticky="nsew")
        descripcion = tk.Label(algo3, text= VALUES[VentanaDeInicio.contador]["description"] , bg="#329bfc", relief="raised", border=2, font=("Arial", 8, "bold"))
        descripcion.grid(row=1,column=1, sticky="nsew")
        email = tk.Label(algo3, text="Correo: ",font=("Arial", 12, "bold") , bg="#329bfc", relief="raised", border=2,)
        email.grid(row=2,column=0, sticky="nsew")
        correo = tk.Label(algo3, text= VALUES[VentanaDeInicio.contador]["email"] , bg="#329bfc", relief="raised", border=2, font=("Arial", 8, "bold") )
        correo.grid(row=2,column=1, sticky="nsew")
        uni = tk.Label(algo3, text="Universidad: " ,font=("Arial", 12, "bold"), bg="#329bfc", relief="raised", border=2)
        uni.grid(row=3,column=0, sticky="nsew")
        universidad = tk.Label(algo3, text= "Universidad Nacional de Colombia" , bg="#329bfc", relief="raised", border=2, font=("Arial", 8, "bold"))
        universidad.grid(row=3,column=1, sticky="nsew")

        derecho_2 = tk.Frame(marco_derecho, bg="#93cfbc", relief="sunken", border=2) #, width="400", height="100"
        derecho_2.grid(row=1, padx=10, pady=10, sticky="nsew")
        
        derecho_2.rowconfigure(0, weight=1)
        derecho_2.rowconfigure(1, weight=1)
        derecho_2.columnconfigure(0, weight=1)
        derecho_2.columnconfigure(1, weight=1)
        
        
        algo4 = tk.Label(derecho_2, text="imagen 1", image =  imagen1, bg="#329bfc", relief="raised", border=2) #image= imagen1
        algo4.grid(row=0,column=0, padx=10, pady=10, sticky="nsew")
        algo5 = tk.Label(derecho_2, text="imagen 2", image =  imagen2, bg="#329bfc", relief="raised", border=2)
        algo5.grid(row=0,column=1, padx=10, pady=10, sticky="nsew")
        algo6 = tk.Label(derecho_2, text="imagen 3", image =  imagen3, bg="#329bfc", relief="raised", border=2)
        algo6.grid(row=1,column=0, padx=10, pady=10, sticky="nsew")
        algo7 = tk.Label(derecho_2, text="imagen 4", image =  imagen4, bg="#329bfc", relief="raised", border=2)
        algo7.grid(row=1,column=1, padx=10, pady=10, sticky="nsew")

        marco_derecho.bind('<ButtonPress-1>', click_event)
        derecho_1.bind('<ButtonPress-1>', click_event)
        derecho_2.bind('<ButtonPress-1>', click_event)
        algo3.bind('<ButtonPress-1>', click_event)
        algo4.bind('<ButtonPress-1>', click_event)
        algo5.bind('<ButtonPress-1>', click_event)
        algo6.bind('<ButtonPress-1>', click_event)
        algo7.bind('<ButtonPress-1>', click_event)
        algo8.bind('<ButtonPress-1>', click_event)

        # Asociar el evento <Enter> (mouse entra) con la función mouse_entra
        algo2.bind("<Enter>", mouse_entra)

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

            messagebox.showinfo("Descripción del sistema", info)



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
        Deserializador.deserializar()
        VentanaBase()
