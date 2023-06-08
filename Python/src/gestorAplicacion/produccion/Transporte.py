from enum import Enum


class TipoTransporte(Enum):
    AVION = "Avion"
    BARCO = "Barco"
    CAMION = "Camion"


class Transporte:
    def __init__(self, tipo, capacidad, costo, conductor):
        self._tipo = tipo
        self._capacidad = capacidad
        self._costo = costo
        self._conductor = conductor
        self._listaTransportes = []
        self._precioOriginalTransporte = None
        self._tienda = None
        self._listaDeProductos = []

    def abastecer_producto(self, tienda, lista_de_productos):
        self._tienda = tienda
        self._listaDeProductos = lista_de_productos

    @staticmethod
    def mostrar_tipo_transporte():
        for tipo in TipoTransporte:
            print(tipo.value)

    def tipo_transporte(self, tipo_transporte):
        texto_tipo_transporte = f"Tipo de transporte: {tipo_transporte.value}, Precio: {tipo_transporte.precio_envio}, Capacidad máxima: {tipo_transporte.capacidad_max}"
        return texto_tipo_transporte

    @staticmethod
    def enviar_gratis(transporte_seleccionado):
        transporte_seleccionado.tipo.precio_envio = 0
        return transporte_seleccionado

    def recordar_precio_transporte(self):
        self._precioOriginalTransporte = self._tipo.precio_envio

    def reestablecer_precio_trans(self):
        self._tipo.precio_envio = self._precioOriginalTransporte

    def get_precio_original_transporte(self):
        return self._precioOriginalTransporte

    def get_nombre(self):
        return self._tipo.name

    def get_tipo(self):
        return self._tipo

    def set_tipo(self, tipo):
        self._tipo = tipo

    def get_capacidad(self):
        return self._capacidad

    def set_capacidad(self, capacidad):
        self._capacidad = capacidad

    def get_costo(self):
        return self._costo

    def set_costo(self, costo):
        self._costo = costo

    def get_conductor(self):
        return self._conductor

    def set_conductor(self, conductor):
        self._conductor = conductor

    def get_tienda(self):
        return self._tienda

    def set_tienda(self, tienda):
        self._tienda = tienda

    def get_lista_de_productos(self):
        return self._listaDeProductos

    def set_lista_de_productos(self, lista_de_productos):
        self._listaDeProductos = lista_de_productos

    def get_lista_transportes(self):
        return self._listaTransportes

    def set_lista_transportes(self, lista_transportes):
        self._listaTransportes = lista_transportes
