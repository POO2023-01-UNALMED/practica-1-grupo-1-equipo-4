from enum import Enum



class Transporte:
    def __init__(self, tipo, capacidad, costo, conductor):
        self._tipoTransporte = tipo
        self._capacidad = capacidad 
        self._costo = costo
        self._conductor = conductor
        self._listaTransportes = []
        self._tienda = None
        self._listaDeProductos = []


    def abastecer_producto(self, tienda, listaDeProductos):
        self._tienda = tienda
        self._listaDeProductos = listaDeProductos

# def mostrar_tipo_transporte():
#     tipo_transportes = [tipo.name for tipo in TipoTransporte]
#     for tipo in tipo_transportes:
#         print(tipo)

    def tipoTransporte(self, tipoTransporte):
        texto_tipoTransporte = f"Tipo de transporte: {tipoTransporte.value}, Precio: {tipoTransporte.precio_envio}, Capacidad máxima: {tipoTransporte.capacidad_max}"
        return texto_tipoTransporte

    @classmethod
    def enviar_gratis(transporteSeleccionado):
       transporteSeleccionado.tipo.precio_envio = 0
       return transporteSeleccionado

    def recordar_precio_transporte(self):
        self._precioOriginalTransporte = self._tipo.precio_envio

    def reestablecer_precio_trans(self):
        self._tipo.precio_envio = self._precioOriginalTransporte

    def get_precio_original_transporte(self):
        return self._precioOriginalTransporte

    def get_nombre(self):
        return self._tipo.name

    def get_tipoTransporte(self):
        return self._tipo

    def set_tipoTransporte(self, tipo):
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

    def get_listaDeProductos(self):
        return self._listaDeProductos

    def set_listaDeProductos(self, listaDeProductos):
        self._listaDeProductos = listaDeProductos

    def get_lista_transportes(self):
        return self._listaTransportes

    def set_lista_transportes(self, lista_transportes):
        self._listaTransportes = lista_transportes 
        