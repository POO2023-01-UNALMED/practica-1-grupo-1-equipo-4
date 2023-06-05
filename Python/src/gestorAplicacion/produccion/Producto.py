# Autores: Joan Sebastian Salazar Montoya, Monica Sofia Restrepo León, 
# Luis Alejandro Varela Ojeda, Maria Fernanda Calle Agudelo, Jaider Castañeda Villa
# FUNCIONALIDAD DE LA CLASE: clase que representa el producto que se genera en la 
# fábrica y se vende en las tiendas.

import pickle

class Producto:
    numProductos = 0
    listaProductos = []

    def __init__(self, nombre, descripcion, valor, peso, tamano, costoDeProduccion, categoria):
        self.nombre = nombre
        self.descripcion = descripcion
        self.valor = valor
        self.peso = peso
        self.tamano = tamano
        self.costoDeProduccion = costoDeProduccion
        self.categoria = categoria.lower()
        Producto.numProductos += 1
        Producto.listaProductos.append(self)
        self.devuelto = False

    def __init__(self, nombre, valor, peso, tamano, categoria):
        self(nombre, "Sin descripción", valor, peso, tamano, 10.0, categoria)

    # Métodos
    def __str__(self):
        return "\nNombre: " + self.nombre + "\n" \
               + "Descripción: " + self.descripcion + "\n" \
               + "Valor: " + str(self.valor) + "\n" \
               + "Peso: " + str(self.peso) + "\n" \
               + "Tamaño: " + str(self.tamano) + "\n" \
               + "Costo de produccion: " + str(self.costoDeProduccion) + "\n"
    
    # Getters and Setters
    
    def getNombre(self):
        return self.nombre
    
    def setNombre(self, nombre):
        self.nombre = nombre

    def isDevuelto(self):
        return self.devuelto
    
    def setDevuelto(self, devuelto):
        self.devuelto = devuelto

    def getDescripcion(self):
        return self.descripcion

    def setDescripcion(self, descripcion):
        self.descripcion = descripcion

    def getValor(self):
        return self.valor

    def setValor(self, valor):
        self.valor = valor

    def getPeso(self):
        return self.peso

    def setPeso(self, peso):
        self.peso = peso

    def getTamano(self):
        return self.tamano

    def setTamano(self, tamano):
        self.tamano = tamano

    def getCostoDeProduccion(self):
        return self.costoDeProduccion

    def setCostoDeProduccion(self, costoDeProduccion):
        self.costoDeProduccion = costoDeProduccion

    def getCategoria(self):
        return self.categoria
    
    def setCategoria(self, categoria):
        self.categoria = categoria

    @staticmethod
    def getNumProductos():
        return Producto.numProductos

    @staticmethod
    def setListaProductos(listaproductos):
        Producto.listaProductos = listaproductos

    @staticmethod
    def getListaProductos():
        return Producto.listaProductos