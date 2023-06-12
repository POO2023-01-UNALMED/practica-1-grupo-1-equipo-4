from Python.src.gestorAplicacion.gestion import Conductor
from Python.src.gestorAplicacion.gestion import Vendedor
from Python.src.gestorAplicacion.gestion import Operario
from Python.src.gestorAplicacion.gestion import Persona


class CuentaBancaria:

    def __init__(self, numeroCuenta, saldo):
        self.numeroCuenta = numeroCuenta
        self.saldo = saldo

    def anadirFondos(self, fondos):
        self.saldo += fondos

    def descontarFondos(self, fondos):
        self.fondos -= fondos

    def devolverDinero(self, total, cliente):
        cuenta = cliente.getCuentaBancaria()
        cuenta.anadirFondos(total)

    @staticmethod
    def calcularPago(persona):
        trabajo = persona.getTrabajo()
        salarioBase = Persona.getSalario()
        total = 0

        if isinstance(persona, Operario):
            total += (salarioBase + 3000) * trabajo
        elif isinstance(persona, Vendedor):
            total += (salarioBase + 5000) * trabajo
        elif isinstance(persona, Conductor):
            total += (salarioBase + 4500) * trabajo

        return total
    
    def getSaldo(self):
        return self._saldo

    def setSaldo(self, saldo):
        self._saldo = saldo

    def getNumeroCuenta(self):
        return self._numeroCuenta

    def setNumeroCuenta(self, numeroCuenta):
        self._numeroCuenta = numeroCuenta

    
