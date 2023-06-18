import pickle
from gestorAplicacion.gestion.Operario import Operario
from gestorAplicacion.gestion.Vendedor import Vendedor
from gestorAplicacion.produccion.Fabrica import Fabrica
from gestorAplicacion.produccion.Producto import Producto
from gestorAplicacion.produccion.Tienda import Tienda
from gestorAplicacion.gestion.Factura import Factura
from gestorAplicacion.gestion.Cliente import Cliente
from gestorAplicacion.gestion.Conductor import Conductor
from gestorAplicacion.produccion.Transporte import Transporte

class Deserializador:

    @classmethod
    def deserializar():

        #Fábrica
        pickleFileFabrica = open("src/baseDatos/temp/pickleFileFabrica.pkl","rb")
        pcsFabrica = pickle.load(pickleFileFabrica)
        Fabrica.setListaFabricas(pcsFabrica)
        pickleFileFabrica.close()

        #Tiendas
        pickleFileTienda = open("src/baseDatos/temp/pickleFileTienda.pkl","rb")
        pcsTienda = pickle.load(pickleFileTienda)
        Tienda.setListaTiendas(pcsTienda)
        pickleFileTienda.close()

        #Productos
        pickleFileProducto = open("src/baseDatos/temp/pickleFileProducto.pkl","rb")
        pcsProducto = pickle.load(pickleFileProducto)
        Producto.setListaProductos(pcsProducto)
        pickleFileProducto.close()

        #Facturas
        pickleFileFactura = open("src/baseDatos/temp/pickleFileFactura.pkl","rb")
        pcsFactura = pickle.load(pickleFileFactura)
        Factura.setListaFacturas(pcsFactura)
        pickleFileFactura.close()

        #Clientes
        pickleFileCliente = open("src/baseDatos/temp/pickleFileCliente.pkl","rb")
        pcsCliente = pickle.load(pickleFileCliente)
        Cliente.setListaClientes(pcsCliente)
        pickleFileCliente.close()

        #Vendedores
        pickleFileVendedor = open("src/baseDatos/temp/pickleFileVendedor.pkl","rb")
        pcsVendedor = pickle.load(pickleFileVendedor)
        Vendedor.setListaVendedores(pcsVendedor)
        pickleFileVendedor.close()

        #Conductores
        pickleFileConductor = open("src/baseDatos/temp/pickleFileConductor.pkl","rb")
        pcsConductor = pickle.load(pickleFileConductor)
        Conductor.setListaConductores(pcsConductor)
        pickleFileConductor.close()

        #Operarios
        pickleFileOperario = open("src/baseDatos/temp/pickleFileOperario.pkl","rb")
        pcsOperario = pickle.load(pickleFileOperario)
        Operario.setListaOperarios(pcsOperario)
        pickleFileOperario.close()

        #Transportes
        pickleFileTransporte = open("src/baseDatos/temp/pickleFileTransporte.pkl","rb")
        pcsTransporte = pickle.load(pickleFileTransporte)
        Transporte.setListaTransportes(pcsTransporte)
        pickleFileTransporte.close()    