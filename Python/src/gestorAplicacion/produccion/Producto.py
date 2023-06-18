# Autores: Joan Sebastian Salazar Montoya, Monica Sofia Restrepo León, 
# Luis Alejandro Varela Ojeda, Maria Fernanda Calle Agudelo, Jaider Castañeda Villa
# FUNCIONALIDAD DE LA CLASE: clase que representa el producto que se genera en la 
# fábrica y se vende en las tiendas.

import pickle

class Producto:
    _numProductos = 0
    _listaProductos = []

    def __init__(self, nombre, descripcion, valor, peso, tamano, costoDeProduccion, categoria):
        self._nombre = nombre
        self._descripcion = descripcion
        self._valor = valor
        self._peso = peso
        self._tamano = tamano
        self._costoDeProduccion = costoDeProduccion
        self._categoria = categoria.lower()
        Producto._numProductos += 1
        Producto._listaProductos.append(self)
        self._devuelto = False

    # Métodos
    
    def __str__(self):
        return "Nombre: " + self._nombre + "\n" \
               + "Descripción: " + self._descripcion + "\n" \
               + "Valor: " + str(self._valor) + "\n" \
               + "Peso: " + str(self._peso) + "\n" \
               + "Tamaño: " + str(self._tamano) + "\n" \
               + "Costo de produccion: " + str(self._costoDeProduccion) + "\n"\
               + "Categoria: "+str(self._categoria)
    
    # Getters and Setters
    
    def getNombre(self):
        return self._nombre
    
    def setNombre(self, nombre):
        self._nombre = nombre

    def isDevuelto(self):
        return self._devuelto
    
    def setDevuelto(self, devuelto):
        self._devuelto = devuelto

    def getDescripcion(self):
        return self._descripcion

    def setDescripcion(self, descripcion):
        self._descripcion = descripcion

    def getValor(self):
        return self._valor

    def setValor(self, valor):
        self._valor = valor

    def getPeso(self):
        return self._peso

    def setPeso(self, peso):
        self._peso = peso

    def getTamano(self):
        return self._tamano

    def setTamano(self, tamano):
        self._tamano = tamano

    def getCostoDeProduccion(self):
        return self._costoDeProduccion

    def setCostoDeProduccion(self, costoDeProduccion):
        self._costoDeProduccion = costoDeProduccion

    def getCategoria(self):
        return self._categoria
    
    def setCategoria(self, categoria):
        self._categoria = categoria

    @classmethod
    def getNumProductos(cls):
        return cls._numProductos

    @classmethod
    def setListaProductos(cls,listaProductos):
        cls._listaProductos = listaProductos

    @classmethod
    def getListaProductos(cls):
        return cls._listaProductos