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
        try:
            for tipoTransporte in TipoTransporte:
                CargaTipoTrans = 0
                CargaTipoTrans = tipoTransporte.value[2]
                if CargaTipoTrans >= PesoTotalProductos:
                    listaTransFiltrada.append(tipoTransporte)
        except TypeError:
            pass
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
    
    @classmethod
    def enviarGratis(cls, transporteSeleccionado):
        transporteSeleccionado.tipo.precio_envio = 0
        return transporteSeleccionado

    @classmethod
    def recordarPrecioTransporte(self):
        self.precioOriginalTransporte = self.tipo.precio_envio

    @classmethod
    def reestablecerPrecioTrans(self):
        self.tipo.precio_envio = self.precioOriginalTransporte

