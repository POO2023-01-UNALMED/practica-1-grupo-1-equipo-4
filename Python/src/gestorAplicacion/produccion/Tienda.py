# Autores: Joan Sebastian Salazar Montoya, Monica Sofia Restrepo León, 
# Luis Alejandro Varela Ojeda, Maria Fernanda Calle Agudelo, Jaider Castañeda Villa
# FUNCIONALIDAD DE LA CLASE: La clase Tienda desempeña un papel fundamental como intermediaria en el proceso de venta de productos. 
# Es el punto central desde donde se envían los productos a los clientes, lo que la convierte en un elemento crucial para el funcionamiento 
# de todas las operaciones. Como tal, la Tienda está estrechamente vinculada con todas las funcionalidades relacionadas, ya que actúa como 
# el vínculo entre el cliente y la empresa.

from gestorAplicacion.gestion.Cliente import Cliente
from gestorAplicacion.gestion.Vendedor import Vendedor
from gestorAplicacion.gestion.Factura import Factura  
from gestorAplicacion.gestion.Moda import Moda
from gestorAplicacion.gestion.Operario import Operario
import pickle
import random
import copy

class Tienda(Moda):
    
    _listaTiendas= []
    _numTiendas = 0

    def __init__(self, nombre, vendedor, cuentaBancaria):
        self._nombre = nombre
        self._vendedor = vendedor
        self._cuentaBancaria = cuentaBancaria
        self._listaProductos = []
        self._listaCantidadProductos = [{}]
        self._productosPorCategoria = {}
        self._productosDevueltos = []
        Tienda._numTiendas += 1
        Tienda._listaTiendas.append(self)
        self._cantidadPorCategoria = {
            "aseo": random.randint(100, 200),
            "consumible": random.randint(100, 200),
            "construccion": random.randint(100, 200)
        }

    # Métodos

    # FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Enviar Pedido
    # 
    # RECIBE: No recibe argumentos
    # DEVUELVE: String con los productos disponibles de la tienda
    # 
    # DESCRIPCIÓN: recorre la lista de productos disponibles de la tienda para
    # ser enviados y los añade a un String 

    def mostrarProductos(self):
        str = ""
        for i, producto in enumerate(self._listaProductos):
            str += f"\n{i + 1}" + str(producto) + "\n"
        return str
    
    # FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Abastecer
    # 
    # RECIBE: 
    # No recibe ningun argumento
    # 
    # DEVUELVE:
    # Devuelve un String con los productos de la tienda y su cantidad.
    # 
    # DESCRIPCIÓN:
    # Este método permite visualizar los productos que tiene una tienda y la cantidad que hay por cada uno.
    
    def cantidadProductos(self):
        self._listaCantidadProductos = {}
        cadena = "\n"
            
        # Ciclo para agregar los valores al diccionario y hacer el conteo
        for producto in self._listaProductos:
            if producto.getNombre() in self._listaCantidadProductos:
                self._listaCantidadProductos[producto.getNombre()] += 1
            else:
                self._listaCantidadProductos[producto.getNombre()] = 1

        # Bucle for para generar la cadena con la cantidad de cada producto
        for producto, cantidad in self._listaCantidadProductos.items():
            cadena += f"{producto}: {cantidad} \n"

        return cadena

    # FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Abastecer
    # 
    # RECIBE: 
    # No recibe ningun argumento
    # 
    # DEVUELVE:
    # Devuelve un String con cantidades que tiene y su maximo con el formato categoria cantidad/maximo
    # 
    # DESCRIPCIÓN:
    # Este método permite visualizar la cantidad de productos por categoria
    # que tiene una tienda y ademas tambien la cantidad maxima que puede 
    # tener por categoria esa tienda
     
    def productosPorCategoria(self):
        cadena = ""
        self._productosPorCategoria = {
            "aseo": 0,
            "consumible": 0,
            "construccion": 0
        }
        for producto in self._listaProductos:
            categoria = producto.getCategoria()
            if categoria in self._productosPorCategoria:
                self._productosPorCategoria[categoria] += 1

        cadena += "Aseo " + str(self._productosPorCategoria["aseo"]) + "/" + str(self._cantidadPorCategoria["aseo"]) + "  "
        cadena += "Consumible " + str(self._productosPorCategoria["consumible"]) + "/" + str(self._cantidadPorCategoria["consumible"]) + "  "
        cadena += "Construccion " + str(self._productosPorCategoria["construccion"]) + "/" + str(self._cantidadPorCategoria["construccion"]) + "  "
        return cadena

    # FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: EnviarPedido
    # 
    # RECIBE: 
    # No recibe ningun argumento
    # 
    # DEVUELVE:
    # String cadena de texto que contiene la cantidad de productos en una lista de ventas.
    # 
    # DESCRIPCIÓN:
    # Dentro del método, se crea un diccionario (HashMap) llamado "listaCantidadProductos" 
    # para almacenar la cantidad de cada producto. Luego, se recorre una lista de productos 
    # y se actualiza el diccionario con el conteo de cada producto. Al final,
    # se genera una cadena que muestra el índice, el nombre del producto y su cantidad, y se retorna dicha cadena.
    # Esta cadena se vé en consola y es con la que el 
    # usuario elige su producto.

    def cantidadProductosVentas(self):
        self._listaCantidadProductos = {}
        cadena = "    "
        indice = 1
        
        # Ciclo para agregar los valores al diccionario y hacer el conteo
        for producto in self._listaProductos:
            if producto in self._listaCantidadProductos:
                self._listaCantidadProductos[producto] += 1
            else:
                self._listaCantidadProductos[producto] = 1
        
        # Bucle for para generar la cadena con la cantidad de cada producto
        for producto in self._listaProductos:
            if producto.getNombre() not in cadena:
                cadena += f"\n{indice}. {producto.getNombre()}: {self._listaCantidadProductos[producto]} "
                indice += 1
        
        return cadena
    
    # FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Abastecer, EnviarPedido
    # 
    # RECIBE:
    # No recibe ningun argumento
    # 
    # DEVUELVE:
    # Devuelve un String con las tiendas y los productos que tiene con su
    # respectiva cantidad
    # 
    # DESCRIPCIÓN:
    # sirve para actualizar la cantidad de un productos en la lista de productos 
    # y en el diccionario listaCantidadProductos. Muestra en tiempo real que el producto ha
    # sido seleccionado y no está disponible para otros como en EnviarPedido 
    # se llama cada vez que se selecciona un producto, en consola va bajando el número
    # de productos disponibles cada vez que selecciones uno.
    
    def venderProducto(self, producto):
        for productos in self._listaProductos:
            if producto.getNombre() == productos.getNombre():
                self._listaProductos.remove(productos)
                break


    # FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Enviar Pedido
    # 
    # RECIBE: 
    # lista de productos que se pidieron (ArrayList con objetos de tipo
    # Producto), el transporte que se eligio (objeto tipo transporte),
    # el cliente al que se le enviará el pedido (objeto tipo Cliente) y el dia 
    # del mes del envio (entero).
    # 
    # DEVUELVE: 
    # la factura correspondiente al envio realizado (objeto tipo Factura).
    # 
    # DESCRIPCIÓN: 
    # elimina las cantidades de productos pedidos de las listas
    # de la tienda, suma el respectivo trabajo a las personas involucradas (vendedor,
    # operario y conductor), añade los productos pedidos a la lista del cliente y 
    # genera la factura asociada al envío.

    def enviarPedido(self,listaProductosPedidos, transporte, cliente, dia, operario):
        # Resto 1 unidad de las cantidades de los productos, pues se envió
        # for producto in listaProductosPedidos:
        #     if producto in self._listaCantidadProductos and self._listaCantidadProductos[producto] > 1:
        #         self._listaCantidadProductos[producto] -= 1
        #     else:
        #         del self._listaCantidadProductos[producto]

        # Añado la suma de trabajo a los trabajadores

        # Al vendedor
        self._vendedor.setTrabajo(self._vendedor.getTrabajo()+1)
        self._vendedor.setIndiceMeta(self._vendedor.getIndiceMeta() + len(listaProductosPedidos))

        # Al conductor
        transporte.getConductor().setTrabajo(transporte.getConductor().getTrabajo() + 1)
        for producto in listaProductosPedidos:
            transporte.getConductor().setIndiceMeta(transporte.getConductor().getIndiceMeta() + producto.getPeso())

        # Al operario
        operario.setTrabajo(operario.getTrabajo()+1)
        operario.setIndiceMeta(operario.getIndiceMeta() + len(listaProductosPedidos))

        # Agrego los productos al cliente
   
        if (cliente.getProductos() == None):
            cliente.setProductos([])
            
        listaProvicional = cliente.getProductos()

        for producto in listaProductosPedidos:
           listaProvicional.append(copy.deepcopy(producto))

        cliente.setProductos(listaProvicional) 

        # Creo la factura
        factura = Factura(self, cliente, transporte, listaProductosPedidos, int(dia), "Las descripciones y cantidades de los materiales suministrados en esta factura se basan en nuestra mejor información y creencia.", operario)
        return factura

    # FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Devoluciones
    # 
    # RECIBE: 
    # objeto de tipo Factura y uno de tipo Producto.
    # 
    # DEVUELVE: 
    # un objeto de tipo CLiente.
    # 
    # DESCRIPCIÓN: 
    # devuelve el producto seleccionado 
    # a una lista de la tienda donde se almacenan las devoluciones
    # y por ultimo retorna el cliente al que se le hizo la devolución.

    def devolverProducto(self, factura, producto):
        self._productosDevueltos.append(producto)  # se devuelve el producto
        return factura.getCliente()
    
    # FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Abastecer
    # 
    # RECIBE: 
    # transporte: Transporte que lleva los productos.
    # 
    # DEVUELVE: Jaider ponga que se devuelve
    # 
    # DESCRIPCIÓN:
    # Este método envia los poductos del transporte a la tienda.

    def descargarProducto(self, transporte):
        while len(transporte.getListaDeProductos()) > 0:
            self._listaProductos.append(transporte.getListaDeProductos().pop(0))
        transporte.getConductor().setTrabajo(transporte.getConductor().getTrabajo() + 1)

    # Getters and Setters

    def getNombre(self):
        return self._nombre

    def setNombre(self, nombre):
        self._nombre = nombre

    def getVendedor(self):
        return self._vendedor

    def setVendedor(self, vendedor):
        self._vendedor = vendedor

    def getCuentaBancaria(self):
        return self._cuentaBancaria

    def setCuentaBancaria(self, cuentaBancaria):
        self._cuentaBancaria = cuentaBancaria

    def getListaProductos(self):
        return self._listaProductos

    def setListaProductos(self, listaProductos):
        self._listaProductos = listaProductos

    def getProductosPorCategoria(self):
        return self._productosPorCategoria

    def getCantidadPorCategoria(self):
        return self._cantidadPorCategoria

    def getListaCantidadProductos(self):
        return self._listaCantidadProductos

    def setListaCantidadProductos(self, listaCantidadProductos):
        self._listaCantidadProductos = listaCantidadProductos

    def getProductosDevueltos(self):
        return self._productosDevueltos

    def setProductosDevueltos(self, productosDevueltos):
        self._productosDevueltos = productosDevueltos

    @classmethod
    def get_num_tiendas(cls):
        return cls._numTiendas
    
    @classmethod
    def setListaTiendas(cls,listaTiendas):
        cls._listaTiendas = listaTiendas

    @classmethod
    def getListaTiendas(cls):
        return cls._listaTiendas
    
    def __str__(self) -> str:
        return self._nombre