import pickle
from ..gestorAplicacion.gestion.Operario import Operario
from ..gestorAplicacion.gestion.Vendedor import Vendedor
from ..gestorAplicacion.produccion.Fabrica import Fabrica
from ..gestorAplicacion.produccion.Producto import Producto
from ..gestorAplicacion.produccion.Tienda import Tienda
from ..gestorAplicacion.gestion.Factura import Factura
from ..gestorAplicacion.gestion.Cliente import Cliente
from ..gestorAplicacion.gestion.Conductor import Conductor
from ..gestorAplicacion.produccion.Transporte import Transporte

class Serializador:

    @classmethod
    def serializar():

        #Fábrica
        pickleFileFabrica = open("src/baseDatos/temp/pickleFileFabrica.pkl","wb")
        pickle.dump(Fabrica.getListaFabricas(),pickleFileFabrica)
        pickleFileFabrica.close()

        #Tiendas
        pickleFileTienda = open("src/baseDatos/temp/pickleFileTienda.pkl","wb")
        pickle.dump(Tienda.getListaTiendas(),pickleFileTienda)
        pickleFileTienda.close()

        #Productos
        pickleFileProducto = open("src/baseDatos/temp/pickleFileProducto.pkl","wb")
        pickle.dump(Producto.getListaProductos(),pickleFileProducto)
        pickleFileProducto.close()

        #Facturas
        pickleFileFactura = open("src/baseDatos/temp/pickleFileFactura.pkl","wb")
        pickle.dump(Factura.getListaFacturas(),pickleFileFactura)
        pickleFileFactura.close()

        #Clientes
        pickleFileCliente = open("src/baseDatos/temp/pickleFileCliente.pkl","wb")
        pickle.dump(Cliente.getListaClientes(),pickleFileCliente)
        pickleFileCliente.close()

        #Vendedores
        pickleFileVendedor = open("src/baseDatos/temp/pickleFileVendedor.pkl","wb")
        pickle.dump(Vendedor.getListaVendedores(),pickleFileVendedor)
        pickleFileVendedor.close()

        #Conductores
        pickleFileConductor = open("src/baseDatos/temp/pickleFileConductor.pkl","wb")
        pickle.dump(Conductor.getListaConductores(),pickleFileConductor)
        pickleFileConductor.close()

        #Operarios
        pickleFileOperario = open("src/baseDatos/temp/pickleFileOperario.pkl","wb")
        pickle.dump(Operario.getListaOperarios(),pickleFileOperario)
        pickleFileOperario.close()

        #Transportes
        pickleFileTransporte = open("src/baseDatos/temp/pickleFileTransporte.pkl","wb")
        pickle.dump(Transporte.getListaTransportes(),pickleFileTransporte)
        pickleFileTransporte.close()