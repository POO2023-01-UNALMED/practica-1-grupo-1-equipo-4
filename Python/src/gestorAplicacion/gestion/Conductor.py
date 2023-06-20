# /* Autores: Joan Sebastian Salazar Montoya, Monica Sofia Restrepo León, 
# Luis Alejandro Varela Ojeda, Maria Fernanda Calle Agudelo, Jaider Castañeda Villa
#  * FUNCIONALIDAD DE LA CLASE: clase que hereda de Persona, que representa al trabajador que transporta los envíos en determinado 
#  * transporte desde la tienda hasta los clientes o desde la fábrica hasta la tienda en el momento de abastecer.
#  * Cada uno está asociado a un transporte.
#  */
from gestorAplicacion.produccion.Transporte import Transporte
from gestorAplicacion.gestion.Meta import Meta
from gestorAplicacion.gestion.Persona import Persona


class Conductor(Persona):
    metasConductor = [
        Meta("Fácil", 5, 2000),
        Meta("Dificil", 20, 10000)
    ]
    listaConductores = []
    #/*-------------------Constructor-------------------------*/

    def __init__(self, nombre, edad, cedula, cuentaBancaria, transporte):
        super().__init__(nombre, edad, cedula, cuentaBancaria)
        self.transporte = transporte
        self.listaConductores.append(self)

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
    
    #@ override
    def recibirSueldo(self, total):
        self.fabrica.getCuentaBancaria().descontarFondos(total)
        super().getCuentaBancaria().anadirFondos(total)

    def __str__(self):
        return "\nNombre: " + self.getNombre() + "\n" \
               + "Edad: " + str(self.getEdad()) + "\n" \
               + "Cedula: " + str(self.getCedula()) + "\n"
          
            
    
    #	/*-------------------Getter y setter-------------------------*/
    def getTransporte(self):
        return self.transporte

    def setTransporte(self, transporte):
        self.transporte = transporte

    def getFabrica(self):
        return self.fabrica

    def setFabrica(self, fabrica):
        self.fabrica = fabrica

    @classmethod
    def getMetasConductor(cls):
        return cls.metasConductor

    @classmethod
    def setMetasConductor(cls,metasConductor):
        cls.metasConductor = metasConductor
    
    @classmethod
    def getListaConductores(cls):
        return cls.listaConductores

    @classmethod
    def setListaConductores(cls,listaConductores):
        cls.listaConductores = listaConductores