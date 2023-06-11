from tkinter import Menu,Tk,BOTH,Frame
from Ventanas.ventanaDeEntrada import ventanaDeEntrada
class VentanaBase(Tk):
    def __init__(self) :
        super().__init__()
        self.geometry("700x640")
        self.title("Distribuidora MJLJM")


        #Barra menu superior
        menuBar = Menu()
        menuArchivo = Menu(self)
        menuProcesos = Menu(self)
        menuAyuda = Menu(self)
        #----------Archivo---------
        self.config(menu=menuArchivo)
        menuBar.add_cascade(menu = menuArchivo,label='Archivo')
        menuArchivo.add_command(label='Aplicacion')#command
        menuArchivo.add_command(label='Salir')#command

        #----------Procesos y consultas---------
        self.config(menu=menuProcesos)
        menuBar.add_cascade(menu = menuProcesos,label = 'Procesos y Consultas')
        menuProcesos.add_command(label='Enviar pedido')#command
        menuProcesos.add_command(label='Pagar trabajadores')#command
        menuProcesos.add_command(label='Abastecer tiendas')#command
        menuProcesos.add_command(label='Gestionar devoluciones')#command
        menuProcesos.add_command(label='Mostrar estadísticas')#command

        #----------Ayuda---------
        menuBar.add_command(label='Ayuda')
        # #submenu de procesos y consultas
        # menuProcesos.add_command(label = "Gestionar Ciudades", command = self.gestionarCiudades)


        interfazInicio = ventanaDeEntrada(self)
        interfazInicio.pack()

        self['menu'] = menuBar

    # def Abastecer(self):
    #     geC = Abastecer(self)
    #     self.Limpiar(geC)
    
    def abrir_ventana_principal(self):
        self.destroy()
    
    def Limpiar(self, funcionalidadEnPantalla):
        for frame in self.winfo_children():
            frame.pack_forget()
        funcionalidadEnPantalla.pack(fill=BOTH,expand=True)
    