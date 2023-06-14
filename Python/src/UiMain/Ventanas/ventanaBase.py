from tkinter import Menu, Tk, BOTH, Frame, messagebox

from ..Funcionalidades.Estadisticas import Estadisticas
from .ventanaDeEntrada import ventanaDeEntrada
from ..Funcionalidades.PagoTrabajadores import PagoTrabajadores
from ..Funcionalidades.Abastecer import Abastecer
from ..Funcionalidades.EnviarPedido import EnviarPedido


class VentanaBase(Tk):
    def __init__(self):
        super().__init__()
        self.geometry("700x640")
        self.title("Distribuidora MJLJM")

        # Barra menu superior
        menuBar = Menu()
        menuArchivo = Menu(self)
        menuProcesos = Menu(self)
        menuAyuda = Menu(self)
        # ----------Archivo---------
        self.config(menu=menuArchivo)
        menuBar.add_cascade(menu=menuArchivo, label='Archivo')
        menuArchivo.add_command(label='Aplicacion', command=self.aplicacion)  # command
        menuArchivo.add_command(label='Salir', command=self.salir)

        # ----------Procesos y consultas---------
        self.config(menu=menuProcesos)
        menuBar.add_cascade(menu=menuProcesos, label='Procesos y Consultas')
        menuProcesos.add_command(label='Enviar pedido')  # command
        menuProcesos.add_command(label='Pagar trabajadores', command=self.pagoTrabajadores)  # command
        menuProcesos.add_command(label='Abastecer tiendas', command=self.Abastecer)  # command
        menuProcesos.add_command(label='Gestionar devoluciones')  # command
        menuProcesos.add_command(label='Mostrar estadísticas', command=self.estadisticas)  # command

        

        menuProcesos.add_command(label='Mostrar estadísticas', command = self.estadisticas)#command

        # ----------Ayuda---------
        menuBar.add_cascade(menu=menuAyuda, label='Ayuda')
        menuAyuda.add_command(label='Acerca de', command=acercaDe)
        # #submenu de procesos y consultas
        # menuProcesos.add_command(label = "Gestionar Ciudades", command = self.gestionarCiudades)

        interfazInicio = ventanaDeEntrada(self)
        interfazInicio.pack()

        self['menu'] = menuBar

    def Abastecer(self):
        geC = Abastecer(self)
        self.Limpiar(geC)

    def pagoTrabajadores(self):
        geC = PagoTrabajadores(self)
        self.Limpiar(geC)

    def enviarPedido(self):
        geC = EnviarPedido(self)
        self.Limpiar(geC)

    def estadisticas(self):
        geC = Estadisticas(self)
        self.Limpiar(geC)

    def abrir_ventana_principal(self):
        self.destroy()

    def Limpiar(self, funcionalidadEnPantalla):
        for frame in self.winfo_children():
            frame.pack_forget()
        funcionalidadEnPantalla.pack(fill=BOTH, expand=True)

    def aplicacion(self):
        info = """Distribuidora JMLMJ SAS es un programa diseñado para llevar el control de una empresa de 
        distribuciones de diferentes tipos de productos, vista desde el punto de un administrador que es el encargado de
         controlar todos los procesos. A continuación una breve descripción de cada parte disponible del programa:

        Enviar Pedidos: Esta es la principal herramienta de la aplicación en donde el administrador podrá realizar 
        envíos desde alguna tienda a diferentes clientes, seleccionar productos y hasta el tipo de transporte que se 
        necesitará.

        Abastecer Tiendas: esta opción permite enviar productos desde una fábrica principal a 3 principales tiendas 
        según el tipo de producto y la capacidad de de cada tienda.

        Pago Trabajadores: Le permite al encargado pagar un sueldo base y bonos a la cuenta dependiendo de las metas 
        logradas a los diferentes trabajadores de la empresa: operarios, vendedores y  conductores.

        Realizar Devoluciones:  Como encargado de manejar la aplicación pueden ocurrir errores al momento de hacer un 
        envió a un cliente, por lo tanto en base a la factura que se genera en un envío puede devolver productos.

        Estadísticas: este apartado permite observar el rendimiento de la empresa para saber que productos abastecer y 
        así poder vender más, desde las ganancias  discretas, totales, promedios y aumento porcentual.  """

        messagebox.showinfo("Aplicación", info)

    def salir(self):
        self.destroy()
        VentanaDeInicio()


def acercaDe():
    messagebox.showinfo("Desarrolladores", "Maria Fernanda Calle Agudelo\nMonica Sofia Restrepo Leon\nJaider "
                                           "Castañeda Villa\nLuis Alejandro Varela Ojeda\nJoan Sebastian Salazar "
                                           "Montoya \n")
