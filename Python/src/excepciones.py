from tkinter import messagebox

class ErrorAplicacion(Exception):
    def __init__(self, msg):
        self._excepcion = "Manejo de errores de la Aplicacion: " + msg
        super().__init__(self._excepcion)

    def mostrarMensaje(self):
        messagebox.showerror(self._excepcion)

class ExceptionC1(ErrorAplicacion):
    def __init__(self, msg):
        self._excepcion = msg
        super().__init__(self._excepcion)

class ExceptionC2(ErrorAplicacion):
    def __init__(self, msg):
        self._excepcion = "ExceptionC1" +  msg
        super().__init__(self._excepcion)

#Primera rama
class Abastecer0productos(ExceptionC1):
    def __init__(self):
        super().__init__("No es posible hacer un abastecimiento de 0 productos")
        messagebox.showerror("0 Productos",self._excepcion)


class Letras(ExceptionC1):
    def __init__(self):
        super().__init__("No se pueden poner caracteres que no son numeros en el apartado de cantidad")
        messagebox.showerror("Letras",self._excepcion)

class MayorA(ExceptionC1):
    def __init__(self):
        super().__init__("La cantidad de productos que intenta enviar es superior a la permitida en esa categoria")
        messagebox.showerror("Superar lo permitido",self._excepcion)


#Segunda rama
class ExceptionInventada3(ExceptionC2):
    def __init__(self):
        super().__init__("ExceptionInventada3")

class ExceptionInventada4(ExceptionC2):
    def __init__(self):
        super().__init__("ExceptionInventada4")

class ExceptionSugerida2(ExceptionC2):
    def __init__(self):
        super().__init__("ExceptionSugerida2")
