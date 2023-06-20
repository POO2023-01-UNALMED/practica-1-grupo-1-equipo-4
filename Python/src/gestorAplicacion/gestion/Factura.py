import pickle

from excepciones import ExceptionFechasFueraDeRango, ExceptionFecha1MayorQueFecha2
#from excepciones import ExceptionFechasFueraDeRango, ExceptionFecha1MayorQueFecha2
from .Cliente import Cliente

class Factura:
    serialVersionUID = 1
    facturasCreadas = 0
    listaFacturas = []

    def __init__(self, tienda, cliente, transporte, listaProductos, fecha, disclaimer, operario):
        self.tienda = tienda
        self.cliente = cliente
        self.transporte = transporte 
        self.listaProductos = listaProductos
        self.fecha = fecha
        self.disclaimer = disclaimer
        self.operario = operario
        self.infoAtributos = {}

        self.infoAtributos["tienda"] = tienda
        self.infoAtributos["transporte"] = transporte
        self.infoAtributos["cliente"] = cliente

        self.total = self.calcularTotal()
        self.listaFacturas.append(self)

        self.id = Factura.facturasCreadas + 1
        Factura.facturasCreadas += 1

    
    
    # def __str__(self):
    #     FacturaPaImprimir=  (f"Tienda: {tienda}\n Cliente: {cliente}\n Transporte: {transporte}\n Productos: {', '.join(str(producto) for producto in listaProductos)}\n \
    #        Fecha: {fecha}\n Disclaimer: {disclaimer}\n Operario: {operario}\n Total: {total}")
    #     return  FacturaPaImprimir
    
    
    
    
    
    
    
    def calcularTarifaEnvio(self):
        return self.transporte.tipo[0].value[1]

    def calcularTotal(self):
        totalParcial = 0
        for i in range(len(self.listaProductos)):
            precioProducto = self.listaProductos[i].getValor()
            totalParcial += precioProducto

        return totalParcial + self.calcularTarifaEnvio()

    @staticmethod
    def getFacturasEntreFechas(fecha1, fecha2):
        facturasEntreFechas = []
        for factura in Factura.listaFacturas:
            if factura.fecha >= fecha1 and factura.fecha <= fecha2:
                facturasEntreFechas.append(factura)
        return facturasEntreFechas
    
    @staticmethod
    def getListaFechas(fecha1 = "", fecha2 = ""):

        if fecha1 == "" and fecha2 == "":

            listaFechas = []
            for factura in Factura.listaFacturas:
                if factura.fecha not in listaFechas:
                    listaFechas.append(factura.fecha)
            return listaFechas

        listaFechas = []
        for factura in Factura.listaFacturas:
            if factura.fecha >= fecha1 and factura.fecha <= fecha2 and factura.fecha not in listaFechas:
                listaFechas.append(factura.fecha)
        return listaFechas

    """@staticmethod
    def getListaFechas():
        listaFechas = []
        for factura in Factura.listaFacturas:
            if factura.fecha not in listaFechas:
                listaFechas.append(factura.fecha)
        return listaFechas"""
    

    @staticmethod
    def gananciasDiscretas(fecha1, fecha2):

        if(fecha1 < Factura.getFechaMin() or fecha2 > Factura.getFechaMax()):
                raise ExceptionFechasFueraDeRango

        if(fecha1 > fecha2):
            raise ExceptionFecha1MayorQueFecha2

        fechas = Factura.getListaFechas(fecha1, fecha2)
        facturas = Factura.getFacturasEntreFechas(fecha1, fecha2)
        dictGananciasDiscretas = {}

        for fecha in fechas:
            dictGananciasDiscretas[fecha] = 0.0

        for fecha in dictGananciasDiscretas.keys():
            for factura in facturas:
                if factura.fecha == fecha:
                    valorAnterior = dictGananciasDiscretas[fecha]
                    dictGananciasDiscretas[fecha] = valorAnterior + factura.getTotal()

        return dictGananciasDiscretas
    
    """@staticmethod
    def gananciasDiscretas(fechas):
        fecha1 = fechas[0]
        fecha2 = fechas[-1]
        facturas = Factura.getFacturasEntreFechas(fecha1, fecha2)
        dictGananciasDiscretas = {}

        for fecha in fechas:
            dictGananciasDiscretas[fecha] = 0.0

        for fecha in dictGananciasDiscretas.keys():
            for factura in facturas:
                if factura.fecha == fecha:
                    valorAnterior = dictGananciasDiscretas[fecha]
                    dictGananciasDiscretas[fecha] = valorAnterior + factura.getTotal()

        return dictGananciasDiscretas
    """

    @staticmethod
    def gananciasTotales(dictGananciasDiscretas):
        suma = 0
        for fecha in dictGananciasDiscretas.keys():
            suma += dictGananciasDiscretas[fecha]
        return suma

    @staticmethod
    def promedioPorDia(dictGananciasDiscretas):
        return Factura.gananciasTotales(dictGananciasDiscretas) / len(dictGananciasDiscretas)
    

    @staticmethod
    def aumentoPorcentual(dictGananciasDiscretas):
        fechas = list(dictGananciasDiscretas.keys())
        fechas.sort()
        dictAumentoPorcentual = {}

        for i in range(1, len(fechas)):
            valorActual = dictGananciasDiscretas[fechas[i]]
            valorAnterior = dictGananciasDiscretas[fechas[i - 1]]
            porcentaje = ((valorActual - valorAnterior) / valorAnterior) * 100
            dictAumentoPorcentual[fechas[i]] = porcentaje

        return dictAumentoPorcentual
    
    
    @staticmethod
    def moda(fecha1, fecha2, atributo):


        facturas = Factura.getFacturasEntreFechas(fecha1, fecha2)
        objetos = []
        for factura in facturas:
            objetos.append(factura.getAtributos().get(atributo))


        return max(objetos,key=objetos.count)
    

    @staticmethod
    def getFechaMin():
        return min(Factura.getListaFechas())
    
    @staticmethod
    def getFechaMax():
        return max(Factura.getListaFechas())
    

    @staticmethod
    def mostrarFacturas():
        textoFactura = ""
        indice = 1
        for factura in Factura.listaFacturas:
            textoFactura += str(indice) + ". ID: " + str(factura.getId()) + " Cliente: " + factura.getCliente().getNombre() + "\n"
            indice += 1
        return textoFactura
    
    @staticmethod
    def seleccionarFactura(opcion):
        facturaSeleccionada = Factura.listaFacturas[opcion - 1]
        return facturaSeleccionada
    

    @staticmethod
    def mostrarProductosFacturas(productosFactura):
        textoSalida = ""
        indice = 1
        for producto in productosFactura:
            if producto.isDevuelto():
                textoSalida += str(indice) + ". Producto: " + producto.getNombre() + " (Devuelto)" + "\n"
                indice += 1
            else:
                textoSalida += str(indice) + ". Producto: " + producto.getNombre() + "\n"
                indice += 1
        return textoSalida
    



    def getTienda(self):
        return self.tienda

    def getAtributos(self):
        return self.infoAtributos

    def getCliente(self):
        return self.cliente

    def getTransporte(self):
        return self.transporte

    def getlistaProductos(self):
        return self.listaProductos

    def getFecha(self):
        return self.fecha

    def getDisclaimer(self):
        return self.disclaimer

    def getId(self):
        return self.id

    def getTotal(self):
        return self.total

    @staticmethod
    def getFacturasCreadas():
        return Factura.facturasCreadas

    @staticmethod
    def getListaFacturas():
        return Factura.listaFacturas

    @staticmethod
    def getInfoAtributos():
        return Factura.infoAtributos

    def setTienda(self, tienda):
        self.tienda = tienda

    def setCliente(self, cliente):
        self.cliente = cliente

    def setTransporte(self, transporte):
        self.transporte = transporte

    def setListaProductos(self, listaProductos):
        self.listaProductos = listaProductos

    def setFecha(self, fecha):
        self.fecha = fecha

    def setDisclaimer(self, disclaimer):
        self.disclaimer = disclaimer

    def setId(self, id):
        self.id = id

    def setTotal(self, total):
        self.total = total

    @staticmethod
    def setListaFacturas(facturas):
        Factura.listaFacturas = facturas
