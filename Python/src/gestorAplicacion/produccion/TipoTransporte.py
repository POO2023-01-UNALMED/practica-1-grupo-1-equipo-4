import random

class TipoTransporte:
    def __init__(self, precioEnvio, capacidadMax, nombre):
        self._precioEnvio = precioEnvio
        self._capacidadMax = capacidadMax
        self._nombre = nombre
    
    def __str__(self):
        return self._nombre
    
    @staticmethod
    def crearTipoTransporteSegunCarga(PesoTotalProductos):
        listaTransFiltrada = []
        for tipoTransporte in TipoTransporte.tiposTransporte:
            if tipoTransporte.capacidadMax >= PesoTotalProductos:
                listaTransFiltrada.append(tipoTransporte)
        return listaTransFiltrada
    
    @staticmethod
    def mostrarTipoTransporteSegunCarga(ListaFiltrada):
        textoTransFiltrado = ""
        indice = 1
        for tipoTransporte in ListaFiltrada:
            textoTransFiltrado += f"{indice}. {tipoTransporte.nombre} ${tipoTransporte.precioEnvio}\n"
            indice += 1
        return textoTransFiltrado
    
    @staticmethod
    def seleccionarTransporte(ListaFiltrada, opcion):
        conductor = random.choice(conductor.listaConductores)
        tipoTransporte = ListaFiltrada[opcion - 1]
        capacidad = tipoTransporte.capacidadMax
        precioEnvio = tipoTransporte.precioEnvio
        transporte = transporte(tipoTransporte, capacidad, precioEnvio, conductor)
        conductor.transporte = transporte
        return transporte

TipoTransporte.tiposTransporte = [
    TipoTransporte(5, 16329, "Camion"),
    TipoTransporte(10, 640000, "Avion"),
    TipoTransporte(3, 500, "Automovil"),
    TipoTransporte(4, 650, "Camioneta"),
    TipoTransporte(1, 35, "Bicicleta"),
    TipoTransporte(1, 20, "Patines"),
    TipoTransporte(15, 33565835, "Barco"),
    TipoTransporte(22, 29000, "Helicoptero"),
    TipoTransporte(33, 30000, "Tren"),
    TipoTransporte(1, 15, "Caminando")
]
