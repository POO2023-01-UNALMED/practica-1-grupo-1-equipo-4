""" Autores: Joan Sebastian Salazar Montoya, Monica Sofia Restrepo León, 
Luis Alejandro Varela Ojeda, Maria Fernanda Calle Agudelo, Jaider Castañeda Villa
 * FUNCIONALIDAD DE LA CLASE: La clase Fábrica cumple un doble rol fundamental en el sistema. 
 * Por un lado, actúa como una distribuidora hacia las tiendas, suministrando los productos necesarios para su venta. 
 * Por otro lado, funciona como un almacén centralizado que almacena tanto las tiendas como los productos que pueden ser abastecidos a las tiendas, 
 * lo que permite una gestión más sencilla y eficiente del programa en su conjunto. 
 * Esta clase es utilizada por todas las funcionalidades del sistema, excepto Estadísticas.
 """

from   excepciones import ProductoYaExistente
from ..gestion.Operario import Operario
from ..gestion.Persona import Persona
from ..gestion.Factura import Factura
from ..gestion.CuentaBancaria import CuentaBancaria
from ..produccion.Producto import Producto
from ..produccion.Tienda import Tienda
import copy

import pickle

class Fabrica:

    _listaFabricas = []

    #------------- constructor -------------

    def __init__(self, listaProductos, listaTienda, cuentaBancaria, operario):
        self._listaProductos = listaProductos
        self._listaTienda = listaTienda
        self._cuentaBancaria = cuentaBancaria
        self._operario = operario
        Fabrica._listaFabricas.append(self)

    # -------------- Metodos ------------------
    

    #  * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Abastecer
    #  * 
    #  * RECIBE:
    #  * No recibe ningun argumento
    #  *  
    #  * DEVUELVE:
    #  * Devuelve un String con los productos que tiene la fabrica para abastecer.
    #  * 
    #  * DESCRIPCIÓN:
    #  * Este método permite visualizar los productos disponibles que tiene una fabrica.

    def mostrarProductos(self):
        textoProducto = "\nINDICE-PRODUCTO-PESO-PRECIO-CATEGORIA\n"
        indice = 1
        for producto in self._listaProductos:
            textoProducto += f"{indice}. {producto.getNombre()} - {producto.getPeso()} - {producto.getCostoDeProduccion()} - {producto.getCategoria()}\n"
            indice += 1
        return textoProducto

    #  * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Abastecer, EnviarPedido
    #  * 
    #  * RECIBE: 
    #  * No recibe ningun argumento
    #  * 
    #  * DEVUELVE:
    #  * Devuelve un String con las tiendas y los productos que tiene con su respectiva cantidad
    #  * 
    #  * DESCRIPCIÓN:
    #  * Este método permite visualizar las tiendas que pertenecen a la fabrica y los productos que tiene dentro.
    
    def mostrarTiendas(self):
        textoTiendas = ""
        indice = 1
        for tienda in self._listaTienda:
            textoTiendas += f"{indice}. {tienda.getNombre()}-PRODUCTOS: {tienda.cantidadProductos()}\n"
            indice += 1
            if indice == len(self._listaTienda):
                textoTiendas += "\n"
        return textoTiendas
    
    #  * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO:  EnviarPedido
    #  * 
    #  * RECIBE: 
    #  * Double llamado opción
    #  * 
    #  * DEVUELVE:
    #  * Devuelve un objeto de tienda
    #  * esta es la tienda que eligió el administrador para enviar los pedidos
    #  * 
    #  * DESCRIPCIÓN:
    #  * consigue una tienda de la lista de tiendas con un get.
    #  * Por los índices de listas usa el listaTienda.get(opcion-1);
    #  * y lo asigna al objeto tiendaSeleccionada que servirá en la funcionalidad
    
    def seleccionarTienda(self, opcion):
        tiendaSeleccionada = self._listaTienda[opcion-1]
        return tiendaSeleccionada
    
#      * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Devoluciones
#      * 
#      * RECIBE: 
#      * objeto de tipo Producto.
#      * 
#      * DEVUELVE: 
#      * un double llamado total, que es el valor del producto devuelto.
#      * 
#      * DESCRIPCIÓN: 
#      * obtiene el valor total del producto, 
#      * realiza el descuento de ese monto en la cuenta bancaria del administrador 
#      * y retorna el valor del producto.
    
    def descontarDineroCuentaAdmin(self, productoDevuelto):
        total = productoDevuelto.getValor()
        cuentaAdmin = self._cuentaBancaria
        cuentaAdmin.descontarFondos(total)
        return total
    

    #  * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Abastecer
    #  * 
    #  * RECIBE: 
    #  * cantidad: La cantidad n de productos que se va a generar.
    #  * producto: El producto que se va a generar.
    #  * 
    #  * DEVUELVE:
    #  * Devuelve una lista con los productos.
    #  * 
    #  * DESCRIPCIÓN:
    #  * Genera una lista de n cantidad de un mismo producto
    
    def cantidadProductos(self, cantidad, producto):
        listaAbastecer = []
        for i in range(cantidad):
            listaAbastecer.append(copy.deepcopy(producto))
        return listaAbastecer
    
    #  * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Pago a trabajadores
    #  * 
    #  * RECIBE: 
    #  * Lista de facturas de los envios que se han realizado (ArrayList con 
    #  * objetos de tipo Factura) y un número que se asocia al tipo de trabajador
    #  * al que se le desea pagar (entero)
    #  * 
    #  * DEVUELVE: 
    #  * Lista de trabajadores que han trabajado y no se les ha pagado por dicho
    #  * trabajo (ArrayList con objetos de tipo Persona)
    #  * 
    #  * DESCRIPCIÓN: 
    #  * verifica en las facturas cúales son los trabajadores que han realizado
    #  * envios, además se verifica si su trabajo es mayor a 0, pues se le pudo haber pagado
    #  * anteriormente
    
    @classmethod
    def busquedaTrabajo(cls, listaFacturas, tipo):
        listaPersonas = []
        for factura in listaFacturas:
            if tipo == 1:
                if factura.operario not in listaPersonas and factura.operario.getTrabajo() > 0:
                    listaPersonas.append(factura.operario)
            elif tipo == 2:
                if factura.getTransporte().getConductor() not in listaPersonas and factura.getTransporte().getConductor().getTrabajo() > 0:
                    listaPersonas.append(factura.getTransporte().getConductor())
            elif tipo == 3:
                if factura.getTienda().getVendedor() not in listaPersonas and factura.getTienda().getVendedor().getTrabajo() > 0:
                    listaPersonas.append(factura.getTienda().getVendedor())
        return listaPersonas
    
    #  * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Pago a trabajadores
    #  * 
    #  * RECIBE: 
    #  * Lista de trabajadores que han trabajado y no se les ha pagado por dicho
    #  * trabajo (ArrayList con objetos de tipo Persona). 
    #  * 
    #  * DEVUELVE: 
    #  * texto conformado por las descripciones de cada trabajador de la lista,
    #  * la cual depende del tipo de trabajador que se escogio a pagar (String).
    #  * 
    #  * DESCRIPCIÓN: 
    #  * recorre la lista de trabajadores y los añade a un String.
    
    @classmethod
    def mostrarPersonas(cls,listaTrabajadores):
        texto = ""
        indice = 1
        for trabajador in listaTrabajadores:
            texto += f"\nTrabajador {indice} {trabajador.toString()}"
            indice += 1
        return texto
    
    #----------- Getters and Setters ----------------
    
    
    def getOperario(self):
        return self._operario
    
    def setOperario(self, operario):
        self._operario = operario
    
    def getListaProductos(self):
        return self._listaProductos
    
    def setListaProductos(self, listaProductos):
        self._listaProductos = listaProductos
    
    def getListaTienda(self):
        return self._listaTienda
    
    def setListaTienda(self, listaTienda):
        self._listaTienda = listaTienda
    
    def getCuentaBancaria(self):
        return self._cuentaBancaria
    
    def setCuentaBancaria(self, cuentaBancaria):
        self._cuentaBancaria = cuentaBancaria

    @classmethod
    def setListaFabricas(cls,listaFabricas):
        cls._listaFabricas = listaFabricas

    @classmethod
    def getListaFabricas(cls):
        return cls._listaFabricas    
    
    # toString para saber que imprimir cuando se llame al objeto Fabrica     
    #@Override  
    def __str__(self):
        return "Distribuidora JMLMJ SAS"

    def anadirProducto(self, producto):

        if( producto._nombre in [p._nombre for p in self._listaProductos]):
            
            raise ProductoYaExistente()
        else:
            self._listaProductos.append(producto)


