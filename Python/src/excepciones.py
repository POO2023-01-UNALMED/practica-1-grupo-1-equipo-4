from tkinter import messagebox

class ErrorAplicacion(Exception):
    def __init__(self, msg):
        self._excepcion = "Manejo de errores de la Aplicacion: " + msg
        super().__init__(self._excepcion)

    def mostrarMensaje(self,titulo):
        messagebox.showerror(titulo,self._excepcion)

class ExceptionC1(ErrorAplicacion):
    def __init__(self, msg):
        self._excepcion = msg
        super().__init__(self._excepcion)

class ExceptionC2(ErrorAplicacion):
    def __init__(self, msg): 
        self._excepcion = "Excepcion C2 " +  msg
        super().__init__(self._excepcion)

#Primera rama
class Abastecer0productos(ExceptionC1):
    def __init__(self):
        super().__init__("No es posible hacer un abastecimiento de 0 productos")

class Letras(ExceptionC1):
    def __init__(self):
        super().__init__("No se pueden poner caracteres que no son numeros en el apartado de cantidad")
        
class MayorA(ExceptionC1):
    def __init__(self):
        super().__init__("La cantidad de productos que intenta enviar es superior a la permitida en esa categoria")

class FaltaUno(ExceptionC1):
    def __init__(self):
        super().__init__("Falta seleccionar uno de los campos para el abastecimiento")


#Segunda rama
class NoTrabajadores(ExceptionC2): #Inventada3
    def __init__(self):
        super().__init__("No hay pagos pendientes para este tipo de trabajadores")
        self.mostrarMensaje("No es posible el pago")

class ExceptionInventada4(ExceptionC2):
    def __init__(self):
        super().__init__("ExceptionInventada4")

class ExceptionSugerida2(ExceptionC2):
    def __init__(self):
        super().__init__("ExceptionSugerida2")


class ExceptionFechasFueraDeRango(Exception):

    def __init__(self):

        super().__init__()

class ExceptionFecha1MayorQueFecha2(Exception):

    def __init__(self):

        super().__init__()

