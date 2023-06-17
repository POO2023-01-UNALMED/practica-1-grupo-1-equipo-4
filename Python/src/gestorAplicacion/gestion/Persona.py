# /*  Autores: Joan Sebastian Salazar Montoya, Monica Sofia Restrepo León, 
# Luis Alejandro Varela Ojeda, Maria Fernanda Calle Agudelo, Jaider Castañeda Villa
#  * FUNCIONALIDAD DE LA CLASE: clase abstracta que proporciona atributos y métodos 
#  * comunes para la creación de los distintos tipos de trabajadores de la empresa.
#  */

class Persona:
    #/*-------------------Atributos-------------------------*/
    personasTotales = 0
    listaPersonas = []
    SALARIO=1000
    #/*-------------------Constructores-------------------------*/
    def __init__(self, nombre, edad, cedula, cuentaBancaria):
        self._nombre = nombre
        self._edad = edad
        self._cedula = cedula
        self._cuentaBancaria = cuentaBancaria
        self._trabajo = 0
        self._indiceMeta = 0
        self._verificadorMetasCumplidas = [False, False]
        Persona.listaPersonas.append(self)
    #/*------------------- Metodos -------------------------*/
    def recibirSueldo(self, total):
        self._cuentaBancaria.descontarFondos(total)
        self.getCuentaBancaria().anadirFondos(total)

    def __str__(self):
        return (
            "\nNombre: " + self.getNombre() + "\n"
            + "Edad: " + str(self.getEdad()) + "\n"
            + "Cedula: " + str(self.getCedula()) + "\n"
        )
    
    #/*-------------------Getters y setters-------------------------*/
    def getNombre(self):
        return self._nombre

    def setNombre(self, nombre):
        self._nombre = nombre

    def getEdad(self):
        return self._edad

    def setEdad(self, edad):
        self._edad = edad

    def getCedula(self):
        return self._cedula

    def setCedula(self, cedula):
        self._cedula = cedula

    def getCuentaBancaria(self):
        return self._cuentaBancaria

    def setCuentaBancaria(self, cuentaBancaria):
        self._cuentaBancaria = cuentaBancaria

    @classmethod
    def getSalario(cls):
        return cls.SALARIO

    def getTrabajo(self):
        return self._trabajo

    def setTrabajo(self, trabajo):
        self._trabajo = trabajo

    def getIndiceMeta(self):
        return self._indiceMeta

    def setIndiceMeta(self, indiceMeta):
        self._indiceMeta = indiceMeta

    def getVerificadorMetasCumplidas(self):
        return self._verificadorMetasCumplidas

    def setVerificadorMetasCumplidas(self, verificadorMetasCumplidas):
        self._verificadorMetasCumplidas = verificadorMetasCumplidas

    @classmethod
    def getPersonasTotales(cls):
        return cls.personasTotales

    @classmethod
    def getListaPersonas(cls):
        return cls.listaPersonas
