from tkinter import messagebox

class ErrorAplicacion(Exception):
    def __init__(self, msg):
        self._excepcion = "Manejo de errores de la Aplicacion: " + msg
        super().__init__(self._excepcion)

    def mostrarMensaje(self):
        messagebox.showerror(self._excepcion)

class ExceptionC1(ErrorAplicacion):
    def __init__(self, msg):
        self._excepcion = "ExceptionC1" + msg
        super().__init__(self._excepcion)

class ExceptionC2(ErrorAplicacion):
    def __init__(self, msg):
        self._excepcion = "ExceptionC2" + msg
        super().__init__(self._excepcion)

#Primera rama
class ExceptionInventada1(ExceptionC1):
    def __init__(self):
        super().__init__("ExceptionInventada1")

class ExceptionInventada2(ExceptionC1):
    def __init__(self):
        super().__init__("ExceptionInventada2")

class ExceptionSugerida1(ExceptionC1):
    def __init__(self):
        super().__init__("ExceptionSugerida1")


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
