from random import choice
from enum import Enum

from gestorAplicacion.produccion.Transporte import Transporte

from enum import Enum

class TipoTransporte(Enum):

    #NOMBRE = ("Nombre", precioEnvio, CapacidadMax)
    CAMION = ("Camion", 5, 16329)
    AVION = ("Avion", 10, 640000)
    AUTOMOVIL = ("Automovil", 3, 500)
    CAMIONETA = ("Camioneta", 4, 650)
    BICICLETA = ("Bicicleta", 1, 35)
    PATINES = ("Patines", 1, 20)
    BARCO = ("Barco", 15, 33565835)
    HELICOPTERO = ("Helicoptero", 22, 29000)
    TREN = ("Tren", 33, 30000)
    CAMINANDO = ("Caminando", 1, 15)

    @classmethod
    def crearTipoTransporteSegunCarga(cls,PesoTotalProductos):
        listaTransFiltrada = []
        for tipoTransporte in TipoTransporte:
            if tipoTransporte.value[2] >= PesoTotalProductos:
                listaTransFiltrada.append(tipoTransporte)
        return listaTransFiltrada

    def __str__(self):
        return f"TipoTransporte: {self.name}\n Precio: {self.value[1]} \n Capacidad: {self.value[2]}"
    
    @staticmethod
    def mostrarTransportes():
        cadenaTexto = ""
        
        for tipoTransporte in TipoTransporte:
            cadenaTexto+=(tipoTransporte.value[0])
            cadenaTexto+=("\n")
        return cadenaTexto
    
    @staticmethod
    def mostrarTransportesSegunCarga():
        cadenaTexto = ""
        
        for tipoTransporte in TipoTransporte:
            cadenaTexto+=(tipoTransporte.value[0])
            cadenaTexto+=("\n")
        return cadenaTexto
    

    # @staticmethod
    # def seleccionar_transporte(lista_filtrada, opcion):
    #     conductor = choice(conductor.get_lista_conductores())
    #     tipo = lista_filtrada[opcion - 1]
    #     capacidad = tipo[2]
    #     precio_envio = tipo[1]
    #     transporte = transporte(tipo[0], capacidad, precio_envio, conductor)
    #     conductor.set_transporte(transporte)
    #     return transporte



if __name__=='__main__':
# Ejemplo de prueba
    resultado = TipoTransporte.crearTipoTransporteSegunCarga(600)
    print(resultado)

    resultado2 =TipoTransporte.mostrarTransportes()
    print(resultado2)