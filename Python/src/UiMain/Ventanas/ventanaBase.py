from tkinter import Menu,Tk,BOTH,Frame, messagebox
from Ventanas.ventanaDeEntrada import ventanaDeEntrada
from Funcionalidades.PagoTrabajadores import PagoTrabajadores
from Funcionalidades.Abastecer import Abastecer
from Funcionalidades.EnviarPedido import EnviarPedido

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
        menuProcesos.add_command(label='Pagar trabajadores', command= self.pagoTrabajadores)#command
        menuProcesos.add_command(label='Abastecer tiendas',command=self.Abastecer)#command
        menuProcesos.add_command(label='Gestionar devoluciones')#command
        menuProcesos.add_command(label='Mostrar estadísticas')#command

        #----------Ayuda---------
        menuBar.add_cascade(menu=menuAyuda,label='Ayuda')
        menuAyuda.add_command(label='Acerca de', command=self.acercaDe)
        # #submenu de procesos y consultas
        # menuProcesos.add_command(label = "Gestionar Ciudades", command = self.gestionarCiudades)

        interfazInicio = ventanaDeEntrada(self)
        interfazInicio.pack()

        self['menu'] = menuBar

    # def Abastecer(self):
    #     geC = Abastecer(self)
    #     self.Limpiar(geC)

    def pagoTrabajadores(self):
        geC = PagoTrabajadores(self)
        self.Limpiar(geC)
        
    
    
    def abrir_ventana_principal(self):
        self.destroy()
    
    def Limpiar(self, funcionalidadEnPantalla):
        for frame in self.winfo_children():
            frame.pack_forget()
        funcionalidadEnPantalla.pack(fill=BOTH,expand=True)

    def acercaDe(self):
        messagebox.showinfo("Desarrolladores","Maria Fernanda Calle Agudelo\nMonica Sofia Restrepo Leon\nJaider Catañeda Villa\nLuis Alejandro Varela Ojeda\nJoan Sebastian Salazar Montoya \n")
    