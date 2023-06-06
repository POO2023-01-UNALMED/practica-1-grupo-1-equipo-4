# /*  Autores: Joan Sebastian Salazar Montoya, Monica Sofia Restrepo León, 
# Luis Alejandro Varela Ojeda, Maria Fernanda Calle Agudelo, Jaider Castañeda Villa
#  * FUNCIONALIDAD DE LA CLASE: clase abstracta que proporciona atributos y métodos 
#  * comunes para la creación de los distintos tipos de trabajadores de la empresa.
#  */
from gestorAplicacion.gestion.cuenta_bancaria import CuentaBancaria

class Persona:
    #/*-------------------Atributos-------------------------*/
    personasTotales = 0
    listaPersonas = []
    SALARIO=1000
    #/*-------------------Constructores-------------------------*/
    def __init__(self, nombre, edad, cedula, cuentaBancaria):
        self.nombre = nombre
        self.edad = edad
        self.cedula = cedula
        self.cuentaBancaria = cuentaBancaria
        self.trabajo = 0
        self.indiceMeta = 0
        self.verificadorMetasCumplidas = [False, False]
        Persona.listaPersonas.append(self)
    #/*------------------- Metodos -------------------------*/
    def recibirSueldo(self, total):
        self.cuentaBancaria.descontarFondos(total)
        self.getCuentaBancaria().anadirFondos(total)

    def __str__(self):
        return (
            "\nNombre: " + self.getNombre() + "\n"
            + "Edad: " + str(self.getEdad()) + "\n"
            + "Cedula: " + str(self.getCedula()) + "\n"
        )
    
    #/*-------------------Getters y setters-------------------------*/
    def getNombre(self):
        return self.nombre

    def setNombre(self, nombre):
        self.nombre = nombre

    def getEdad(self):
        return self.edad

    def setEdad(self, edad):
        self.edad = edad

    def getCedula(self):
        return self.cedula

    def setCedula(self, cedula):
        self.cedula = cedula

    def getCuentaBancaria(self):
        return self.cuentaBancaria

    def setCuentaBancaria(self, cuentaBancaria):
        self.cuentaBancaria = cuentaBancaria

    @classmethod
    def getSalario(cls):
        return cls.SALARIO

    def getTrabajo(self):
        return self.trabajo

    def setTrabajo(self, trabajo):
        self.trabajo = trabajo

    def getIndiceMeta(self):
        return self.indiceMeta

    def setIndiceMeta(self, indiceMeta):
        self.indiceMeta = indiceMeta

    def getVerificadorMetasCumplidas(self):
        return self.verificadorMetasCumplidas

    def setVerificadorMetasCumplidas(self, verificadorMetasCumplidas):
        self.verificadorMetasCumplidas = verificadorMetasCumplidas

    @classmethod
    def getPersonasTotales(cls):
        return cls.personasTotales

    @classmethod
    def getListaPersonas(cls):
        return cls.listaPersonas
