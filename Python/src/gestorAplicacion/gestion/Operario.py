# /* Autores: Joan Sebastian Salazar Montoya, Monica Sofia Restrepo León, 
# Luis Alejandro Varela Ojeda, Maria Fernanda Calle Agudelo, Jaider Castañeda Villa
#  * FUNCIONALIDAD DE LA CLASE: clase que hereda de Persona, que representa al trabajador 
#  * que controla la producción de los productos en las fábricas.
#  */
from gestorAplicacion.produccion.fabrica import Fabrica
from gestorAplicacion.gestion.meta import Meta
from gestorAplicacion.persona import Persona

#aaa

class Operario(Persona):
    #/*-------------------Atributos-------------------------*/
    metasOperario = [
        Meta("Fácil", 5, 5000),
        Meta("Dificil", 10, 7000)
    ]
    #/*-------------------Constructores-------------------------*/
    def __init__(self, nombre, edad, cedula, cuentaBancaria, fabrica):
        super().__init__(nombre, edad, cedula, cuentaBancaria)
        self.fabrica = fabrica

    #/*-------------------Metodos-------------------------*/
    # 	/*
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
    #override
    def recibirSueldo(self, total):
        self.fabrica.getCuentaBancaria().descontarFondos(total)
        self.getCuentaBancaria().anadirFondos(total)

    def __str__(self):
        return (
            "\nNombre: " + self.getNombre() + "\n"
            + "Edad: " + str(self.getEdad()) + "\n"
            + "Cedula: " + str(self.getCedula()) + "\n"
            + "Fabrica: " + str(self.getFabrica()) + "\n"
        )
    #/*-------------------Getter y setter-------------------------*/
    def getFabrica(self):
        return self.fabrica

    def setFabrica(self, fabrica):
        self.fabrica = fabrica

    @classmethod
    def getMetasOperario(cls):
        return cls.metasOperario

    @classmethod
    def setMetasOperario(cls,metasOperario):
        cls.metasOperario = metasOperario
    