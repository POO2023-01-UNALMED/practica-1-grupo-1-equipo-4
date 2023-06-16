from random import choice
from enum import Enum


class TipoTransporte(Enum):
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


    def crearTipoTransporteSegunCarga(self,PesoTotalProductos):
        listaTransFiltrada = []
        for tipoTransporte in TipoTransporte:
            if tipoTransporte[2] >= PesoTotalProductos:
                listaTransFiltrada.append(tipoTransporte)
        return listaTransFiltrada


    # @staticmethod
    # def mostrar_tipo_transporte_segun_carga(lista_filtrada: List['TipoTransporte']) -> str:
    #     texto_trans_filtrado = ""
    #     for indice, tipo in enumerate(lista_filtrada, start=1):
    #         texto_trans_filtrado += f"{indice}. {tipo[0]} ${tipo[1]}\n"
    #     return texto_trans_filtrado

    # @staticmethod
    # def seleccionar_transporte(lista_filtrada: List['TipoTransporte'], opcion: int) -> 'Transporte':
    #     conductor = choice(Conductor.get_lista_conductores())
    #     tipo = lista_filtrada[opcion - 1]
    #     capacidad = tipo[2]
    #     precio_envio = tipo[1]
    #     transporte = Transporte(tipo[0], capacidad, precio_envio, conductor)
    #     conductor.set_transporte(transporte)
    #     return transporte



if __name__=='__main__':
    kdfjdsjf = TipoTransporte.CAMION.value

    print(kdfjdsjf)