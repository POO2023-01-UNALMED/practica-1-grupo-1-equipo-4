from tkinter import Menu,Tk,BOTH,Frame
from Ventanas.ventanaDeEntrada import ventanaDeEntrada
class VentanaBase(Tk):
    def __init__(self) :
        super().__init__()
        self.geometry("880x640")
        self.title("Funcionalidades")
    
        #Barra menu superior
        menuBar = Menu()
        menuArchivo = Menu(self)
        menuProcesos = Menu(self)
        menuAyuda = Menu(self)
        
        menuBar.add_cascade(menu = menuArchivo,label='Archivo')
        menuBar.add_cascade(menu = menuProcesos,label = 'Procesos y Consultas')
        menuBar.add_cascade(menu = menuAyuda,label='Ayuda')
        # #submenu de procesos y consultas
        # menuProcesos.add_command(label = "Gestionar Ciudades", command = self.gestionarCiudades)


        frameUso = Frame(self)
        interfazInicio = ventanaDeEntrada(self)
        interfazInicio.pack()

        self['menu'] = menuBar

    # def Abastecer(self):
    #     geC = Abastecer(self)
    #     self.Limpiar(geC)
    
    def Limpiar(self, funcionalidadEnPantalla):
        for frame in self.winfo_children():
            frame.pack_forget()
        funcionalidadEnPantalla.pack(fill=BOTH,expand=True)
    