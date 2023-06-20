from enum import Enum

#from gestorAplicacion.produccion.TipoTransporte import TipoTransporte



class Transporte:

    listaTransportes = []

    def __init__(self, tipo, capacidad, costo, conductor):
        self.tipoTransporte = tipo
        self.capacidad = capacidad 
        self.costo = costo
        self.conductor = conductor
        self.listaTransportes = []
        self.tienda = None
        self.listaDeProductos = []
        self.tipo = tipo,
        self.listaTransportes.append(self)

    def abastecerProducto(self, tienda, listaDeProductos):
        self.tienda = tienda
        self.listaDeProductos = listaDeProductos

    def tipoTransporte(self, tipoTransporte):
        textoTipoTransporte = f"Tipo de transporte: {tipoTransporte.value}, Precio: {tipoTransporte.precio_envio}, Capacidad máxima: {tipoTransporte.capacidad_max}"
        return textoTipoTransporte

    # @classmethod
    # def enviarGratis(cls, transporteSeleccionado):
    #     transporteSeleccionado.tipo.precio_envio = 0
    #     return transporteSeleccionado


    # def recordarPrecioTransporte(self):
    #     self.precioOriginalTransporte = self.tipo.precio_envio

    # def reestablecerPrecioTrans(self):
    #     self.tipo.precio_envio = self.precioOriginalTransporte

    def getPrecioOriginalTransporte(self):
        return self.precioOriginalTransporte

    def getNombre(self):
        return self.tipo.name

    def getTipoTransporte(self):
        return self.tipo

    def setTipoTransporte(self, tipo):
        self.tipo = tipo

    def getCapacidad(self):
        return self.capacidad

    def setCapacidad(self, capacidad):
        self.capacidad = capacidad


    def getCosto(self):
        return self.costo

    def setCosto(self, costo):
        self.costo = costo

    def getConductor(self):
        return self.conductor

    def setConductor(self, conductor):
        self.conductor = conductor

    def getTienda(self):
        return self.tienda

    def setTienda(self, tienda):
        self.tienda = tienda

    def getListaDeProductos(self):
        return self.listaDeProductos

    def setListaDeProductos(self, listaDeProductos):
        self.listaDeProductos = listaDeProductos

    def __str__(self) -> str:
        return self.tipoTransporte.value[0]
    
    @classmethod
    def getListaTransportes(cls):
        return cls.listaTransportes

    @classmethod
    def setListaTransportes(cls, listaTransportes):
         cls.listaTransportes = listaTransportes

if __name__=='__main__':
# Ejemplo de prueba

    resultado2 =Transporte.mostrarTransportes()