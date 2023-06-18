# /* Autores: Joan Sebastian Salazar Montoya, Monica Sofia Restrepo León, 
# Luis Alejandro Varela Ojeda, Maria Fernanda Calle Agudelo, Jaider Castañeda Villa
#  * FUNCIONALIDAD DE LA CLASE: clase que hereda de Persona, representa al trabajador 
#  * que realiza la venta en su respectiva tienda. 
#  */
from gestorAplicacion.gestion.Meta import Meta

from .Persona import Persona


class Vendedor(Persona):
    #/*-------------------Atributos-------------------------*/
    metasVendedor = [Meta("Fácil", 2, 1000), Meta("Dificil", 5, 5000)]
    listaVendedores = []

    #/*-------------------Constructores-------------------------*/
    def __init__(self, nombre, edad, cedula, cuentaBancaria, tienda):
        super().__init__(nombre, edad, cedula, cuentaBancaria)
        self.tienda = tienda
        self.listaVendedores.append(self)

    #/*-------------------Metodos-------------------------*/
    #	/*
    #  * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Pago a trabajadores
    #  * 
    #  * RECIBE: 
	#  * Entero que hace referencia al pago que se va a realizar
	#  * 
    #  * DEVUELVE: 
	#  * Nada (vacío)
    #  * 
    #  * DESCRIPCIÓN:método sobrescrito de la clase Persona
    #  */
	# @Override
    def recibirSueldo(self, total):
        self.tienda.getCuentaBancaria().descontarFondos(total)
        super().getCuentaBancaria().anadirFondos(total)

    def __str__(self):
        return "\nNombre: " + self.getNombre() + "\n" \
               + "Edad: " + str(self.getEdad()) + "\n" \
               + "Cedula: " + str(self.getCedula()) + "\n" \
               + "Tienda: " + self.getTienda().getNombre() + "\n"
    #/*-------------------Getter y setter-------------------------*/
    def getTienda(self):
        return self.tienda

    def setTienda(self, tienda):
        self.tienda = tienda

    @classmethod
    def getMetasVendedor(cls):
        return cls.metasVendedor

    @classmethod
    def setMetasVendedor(cls,metasVendedor):
        cls.metasVendedor = metasVendedor

    @classmethod
    def getListaVendedores(cls):
        return cls.listaVendedores

    @classmethod
    def setListaVendedores(cls,listaVendedores):
        cls.listaVendedores = listaVendedores
