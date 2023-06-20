# Autores: Joan Sebastian Salazar Montoya, Monica Sofia Restrepo León, 
# Luis Alejandro Varela Ojeda, Maria Fernanda Calle Agudelo, Jaider Castañeda Villa
# FUNCIONALIDAD DE LA CLASE: Clase que representa al comprador de productos de la empresa y su motor económico . Se utiliza en todas las funcionalidades 
# excepto PagarTrabajadores. 

import pickle

class Cliente:
    #/*-------------------Atributos-------------------------*/
    
    _lista_clientes=[]

    #-------------------Constructores-------------------------*/
    def __init__(self, nombre, direccion, cuenta_bancaria):
        self._nombre = nombre
        self._direccion = direccion
        self._cuenta_bancaria = cuenta_bancaria
        self._productos = []
        Cliente._lista_clientes.append(self)

    #/*------------------- Metodos -------------------------*/
    
    # Método: mostrarClientes
    # FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Enviar Pedido
    #      
    # RECIBE: Vacío 
    # DEVUELVE: String, una lista de 
    #    
    # DESCRIPCIÓN:
    # Crea una variable de tipo String llamada "cadena" y la inicializa como una cadena vacía.
    # Crea un entero llamado "index" y lo inicializa en 1.
    # Recorre la lista de clientes ("listaClientes") utilizando un for
    # En cada iteración del bucle, pone el índice seguido de un punto y un espacio, y luego el objeto "cliente" convertido a String, con la cadena "cadena". 
    # El método "toString" se utiliza para obtener una representación en forma de cadena del objeto.
    # Incrementa el valor de "index" en 1 en cada iteración.
    # Al finalizar, devuelve la cadena "cadena" que contiene la representación en forma de cadena de todos los clientes, numerados consecutivamente.
    
    @staticmethod
    def mostrarClientes():
        cadena = ""
        index = 1
        # Se recorre la lista y se retornan todos los elementos como cadena
        for cliente in Cliente._lista_clientes:
            if cliente.nombre not in cadena:
                cadena += f"{index}. {cliente}\n"  # Se hace uso del método __str__() para obtener la representación del objeto
                index += 1
        return cadena

    def seleccionarCliente(index):
        clienteSeleccionado = None
        # El ciclo while en caso de que retorne None debe estar en el main
        if index - 1 >= 0 and index <= len(Cliente._lista_clientes):
            index = index - 1
            clienteSeleccionado = Cliente._lista_clientes.pop(index)
        else:
            return clienteSeleccionado
        return clienteSeleccionado
    
    def __str__(self):
        return f"Cliente: {self._nombre}, Dirección: {self._direccion}"
    
    #/*-------------------Getters y setters-------------------------*/

    def getNombre(self):
        return self._nombre

    def setNombre(self, nombre):
        self._nombre = nombre

    def getDireccion(self):
        return self._direccion

    def setDireccion(self, direccion):
        self._direccion = direccion

    def getCuentaBancaria(self):
        return self._cuenta_bancaria

    def setCuentaBancaria(self, cuenta_bancaria):
        self._cuenta_bancaria = cuenta_bancaria

    def setProductos(self, productos):
        self._productos = productos

    def getProductos(self):
        return self._productos

    @classmethod
    def getListaClientes(cls):
        return cls._lista_clientes

    @classmethod
    def setListaClientes(cls,lista_clientes):
        cls._lista_clientes = lista_clientes

