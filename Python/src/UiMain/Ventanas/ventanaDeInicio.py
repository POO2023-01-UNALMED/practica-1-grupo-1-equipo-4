import tkinter as tk
from .ventanaBase import VentanaBase
from tkinter import messagebox

import os
import pathlib
path = os.path.join(pathlib.Path(__file__).parent.absolute())
path = os.path.dirname(path)
from PIL import Image, Image, ImageTk

class VentanaDeInicio(tk.Tk):
    def __init__(self):
        super().__init__()

        self.title("La mejor empresa del mundo0o0o0 MJLJM")
        self.geometry("1080x720+0+0")
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

        python_imagen1 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosLuis/luis1.png').resize((300,225), Image.ANTIALIAS)) 
        python_imagen2 = ImageTk.PhotoImage(Image.open(path+'/Ventanas/imagenes/fotosLuis/luis2.png').resize((300,225), Image.ANTIALIAS)) 
        
        #eventos de click
        def evento_clic(event):
            marco_derecho.configure(bg="black")

        #  ---------Fotos ----------

        #robando cosas (aún debe adaptarlas)

        #def cambiarInfoDesarrolladores(self, e=None):
            """ Funcion encargada de cambiar la infomacion y las imagenes de los desarroladors '
            cuando se da click en la información"""

            #self._numeroInicio == 0
            # Como solo son 3 desarroladores para se repita en ciclo
            #self._numeroInicio %= 5

            #nuevos_valores = self.VALUES[self._numeroInicio]

            # Se cambian los label con los datos del respectivo desarrollador
            # self._nombre.config(text= nuevos_valores["name"])
            # self._descripcioncita.config(text=nuevos_valores["description"])
            # self._correo.config(text=nuevos_valores["email"])

            # Condicionales para configurar las 4 imagenes de cada desarrollador
            #if self._numeroInicio == 0 :
            #python_imagen1 = ImageTk.PhotoImage(Image.open(path+'/imagenes/fotosLuis/foto1.png').resize((300,225), Image.ANTIALIAS))
            #self.imagen1.image = python_imagen1
            #self.imagen1.configure(image = python_imagen1)

                # python_imagen2 = ImageTk.PhotoImage(Image.open(path+'/imagenes/fotosLuis/hina2.jpg').resize((300,225), Image.ANTIALIAS))
                # self.imagen2.image = python_imagen2
                # self.imagen2.configure(image = python_imagen2)

                # python_imagen3 = ImageTk.PhotoImage(Image.open(path+'/imagenes/fotosLuis/hina3.jpg').resize((300,225), Image.ANTIALIAS))
                # self.imagen3.image = python_imagen3
                # self.imagen3.configure(image = python_imagen3)

                # python_imagen4 = ImageTk.PhotoImage(Image.open(path+'/imagenes/fotosLuis/hina4.jpg').resize((300,225), Image.ANTIALIAS))
                # self.imagen4.image = python_imagen4
                # self.imagen4.configure(image = python_imagen4)

            # elif self._numeroInicio == 1:
            #     python_imagen1 = ImageTk.PhotoImage(Image.open(path+'/imagenes/fotos_ale/ale1.jpeg').resize((300,225), Image.ANTIALIAS))
            #     self.imagen1.image = python_imagen1
            #     self.imagen1.configure(image = python_imagen1)

            #     python_imagen2 = ImageTk.PhotoImage(Image.open(path+'/imagenes/fotos_ale/ale2.jpeg').resize((300,225), Image.ANTIALIAS))
            #     self.imagen2.image = python_imagen2
            #     self.imagen2.configure(image = python_imagen2)

            #     python_imagen3 = ImageTk.PhotoImage(Image.open(path+'/imagenes/fotos_ale/ale3.jpeg').resize((300,225), Image.ANTIALIAS))
            #     self.imagen3.image = python_imagen3
            #     self.imagen3.configure(image = python_imagen3)

            #     python_imagen4 = ImageTk.PhotoImage(Image.open(path+'/imagenes/fotos_ale/ale4.jpeg').resize((300,225), Image.ANTIALIAS))
            #     self.imagen4.image = python_imagen4
            #     self.imagen4.configure(image = python_imagen4)

            # elif self._numeroInicio == 2:
            #     python_imagen1 = ImageTk.PhotoImage(Image.open(path+'/imagenes/fotos_anna/anna1.jpeg').resize((300,225), Image.ANTIALIAS))
            #     self.imagen1.image = python_imagen1
            #     self.imagen1.configure(image = python_imagen1)

            #     python_imagen2 = ImageTk.PhotoImage(Image.open(path+'/imagenes/fotos_anna/anna2.jpeg').resize((300,225), Image.ANTIALIAS))
            #     self.imagen2.image = python_imagen2
            #     self.imagen2.configure(image = python_imagen2)

            #     python_imagen3 = ImageTk.PhotoImage(Image.open(path+'/imagenes/fotos_anna/anna3.jpeg').resize((300,225), Image.ANTIALIAS))
            #     self.imagen3.image = python_imagen3
            #     self.imagen3.configure(image = python_imagen3)

            #     python_imagen4 = ImageTk.PhotoImage(Image.open(path+'/imagenes/fotos_anna/anna4.jpeg').resize((300,225), Image.ANTIALIAS))
            #     self.imagen4.image = python_imagen4
            #     self.imagen4.configure(image = python_imagen4)
                
            # elif self._numeroInicio == 3:
            #     python_imagen1 = ImageTk.PhotoImage(Image.open(path+'/imagenes/fotos_felo/felo1.jpeg').resize((300,225), Image.ANTIALIAS))
            #     self.imagen1.image = python_imagen1
            #     self.imagen1.configure(image = python_imagen1)

            #     python_imagen2 = ImageTk.PhotoImage(Image.open(path+'/imagenes/fotos_felo/felo2.jpeg').resize((300,225), Image.ANTIALIAS))
            #     self.imagen2.image = python_imagen2
            #     self.imagen2.configure(image = python_imagen2)

            #     python_imagen3 = ImageTk.PhotoImage(Image.open(path+'/imagenes/fotos_felo/felo3.jpeg').resize((300,225), Image.ANTIALIAS))
            #     self.imagen3.image = python_imagen3
            #     self.imagen3.configure(image = python_imagen3)

            #     python_imagen4 = ImageTk.PhotoImage(Image.open(path+'/imagenes/fotos_felo/felo4.jpeg').resize((300,225), Image.ANTIALIAS))
            #     self.imagen4.image = python_imagen4
            #     self.imagen4.configure(image = python_imagen4)
                
            # elif self._numeroInicio == 4:
            #     python_imagen1 = ImageTk.PhotoImage(Image.open(path+'/imagenes/fotos_juanjo/juanjo1.jpeg').resize((300,225), Image.ANTIALIAS))
            #     self.imagen1.image = python_imagen1
            #     self.imagen1.configure(image = python_imagen1)

            #     python_imagen2 = ImageTk.PhotoImage(Image.open(path+'/imagenes/fotos_juanjo/juanjo2.jpeg').resize((300,225), Image.ANTIALIAS))
            #     self.imagen2.image = python_imagen2
            #     self.imagen2.configure(image = python_imagen2)

            #     python_imagen3 = ImageTk.PhotoImage(Image.open(path+'/imagenes/fotos_juanjo/juanjo3.jpeg').resize((300,225), Image.ANTIALIAS))
            #     self.imagen3.image = python_imagen3
            #     self.imagen3.configure(image = python_imagen3)

            #     python_imagen4 = ImageTk.PhotoImage(Image.open(path+'/imagenes/fotos_juanjo/juanjo4.jpeg').resize((300,225), Image.ANTIALIAS))
            #     self.imagen4.image = python_imagen4
            #     self.imagen4.configure(image = python_imagen4)

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
        
        algo4 = tk.Label(derecho_2,image= python_imagen1) #image= imagen1
        algo4.grid(row=0,column=0, padx=10, pady=10, sticky="nsew")
        algo5 = tk.Label(derecho_2, text="imagen 2", image = python_imagen2)
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
