from tkinter import messagebox

class ErrorAplicacion(Exception):
    def __init__(self, msg):
        self._excepcion = "Manejo de errores de la Aplicacion: " + msg
        super().__init__(self._excepcion)

class ExceptionC1(ErrorAplicacion):
    def __init__(self, msg):
        self._excepcion = "Categoría 1 " + msg
        super().__init__(self._excepcion)

class ExceptionC2(ErrorAplicacion):
    def __init__(self, msg): 
        self._excepcion = "Categoría 2 " +  msg
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

class ProductoYaExistente(ExceptionC1):
    def __init__(self):
        super().__init__("Ya existe un producto con ese nombre en la lista de productos")

class FaltanCamposPorLLenar(ExceptionC1):
    def __init__(self, campos = ""):
        super().__init__("Faltan campos por llenar en el formulario: " + campos)

class SoloNumeros(ExceptionC1):
    def __init__(self):
        super().__init__("En los campos de valor, peso, tamaño y costo de producción solo se pueden ingresar números.")

class Letras2(ExceptionC1):
    def __init__(self):
        super().__init__("Solo se pueden ingresar números enteros")
        
        
class ListIndex(ExceptionC1):
    def __init__(self):
        super().__init__("Seleccione un producto en todas las casillas disponibles")
    




#Segunda rama
class NoTrabajadores(ExceptionC2):
    def __init__(self):
        super().__init__("No hay pagos pendientes para este tipo de trabajadores")

class ExceptionFechasFueraDeRango(ExceptionC2):
    def __init__(self):
        super().__init__("Las fechas deben estar dentro del rango permitido")

class ExceptionFecha1MayorQueFecha2(ExceptionC2):
    def __init__(self):
        super().__init__("La fecha 1 no puede ser mayor a la fecha 2")

class CategoriaNoValida(ExceptionC2):
    def __init__(self):
        super().__init__("Se debe ingresar una categoría entre las permitidas: aseo, consumible y construccion")

