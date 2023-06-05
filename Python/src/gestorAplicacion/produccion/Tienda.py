# Autores: Joan Sebastian Salazar Montoya, Monica Sofia Restrepo León, 
# Luis Alejandro Varela Ojeda, Maria Fernanda Calle Agudelo, Jaider Castañeda Villa
# FUNCIONALIDAD DE LA CLASE: La clase Tienda desempeña un papel fundamental como intermediaria en el proceso de venta de productos. 
# Es el punto central desde donde se envían los productos a los clientes, lo que la convierte en un elemento crucial para el funcionamiento 
# de todas las operaciones. Como tal, la Tienda está estrechamente vinculada con todas las funcionalidades relacionadas, ya que actúa como 
# el vínculo entre el cliente y la empresa.

from gestorAplicacion.gestion import Cliente, CuentaBancaria, Vendedor, Factura, Moda, Operario
import pickle
import random

class Tienda(Moda):
    
    numTiendas = 0

    def __init__(self, nombre, vendedor, cuentaBancaria):
        self.nombre = nombre
        self.vendedor = vendedor
        self.cuentaBancaria = cuentaBancaria
        self.listaProductos = []
        self.listaCantidadProductos = {}
        self.productosPorCategoria = {}
        self.productosDevueltos = []
        Tienda.numTiendas += 1
        self.cantidadPorCategoria = {
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
        for i, producto in enumerate(self.listaProductos):
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
        self.listaCantidadProductos = {}
        cadena = "    "
            
        # Ciclo para agregar los valores al diccionario y hacer el conteo
        for producto in self.listaProductos:
            if producto in self.listaCantidadProductos:
                self.listaCantidadProductos[producto] += 1
            else:
                self.listaCantidadProductos[producto] = 1

        # Bucle for para generar la cadena con la cantidad de cada producto
        for producto, cantidad in self.listaCantidadProductos.items():
            cadena += f"\n     {producto.nombre}: {cantidad} "

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
        self.productosPorCategoria = {
            "aseo": 0,
            "consumible": 0,
            "construccion": 0
        }
        for producto in self.listaProductos:
            categoria = producto.categoria
            if categoria in self.productosPorCategoria:
                self.productosPorCategoria[categoria] += 1

        cadena += "Aseo " + str(self.productosPorCategoria["aseo"]) + "/" + str(self.cantidadPorCategoria["aseo"]) + "  "
        cadena += "Consumible " + str(self.productosPorCategoria["consumible"]) + "/" + str(self.cantidadPorCategoria["consumible"]) + "  "
        cadena += "Construccion " + str(self.productosPorCategoria["construccion"]) + "/" + str(self.cantidadPorCategoria["construccion"]) + "  "
        return cadena


     

