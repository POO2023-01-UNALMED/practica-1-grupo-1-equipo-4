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

import os
import pathlib
path = os.path.join(pathlib.Path(__file__).parent.absolute())
path = os.path.dirname(path)

class Serializador:

    @classmethod
    def serializar(cls):

        #Fábrica
        pickleFileFabrica = open(path+"/baseDatos/temp/pickleFileFabrica.pkl","wb")
        pickle.dump(Fabrica.getListaFabricas(),pickleFileFabrica)
        pickleFileFabrica.close()

        #Tiendas
        pickleFileTienda = open(path+"/baseDatos/temp/pickleFileTienda.pkl","wb")
        pickle.dump(Tienda.getListaTiendas(),pickleFileTienda)
        pickleFileTienda.close()

        #Productos
        pickleFileProducto = open(path+"/baseDatos/temp/pickleFileProducto.pkl","wb")
        pickle.dump(Producto.getListaProductos(),pickleFileProducto)
        pickleFileProducto.close()

        #Facturas
        pickleFileFactura = open(path+"/baseDatos/temp/pickleFileFactura.pkl","wb")
        pickle.dump(Factura.getListaFacturas(),pickleFileFactura)
        pickleFileFactura.close()

        #Clientes
        pickleFileCliente = open(path+"/baseDatos/temp/pickleFileCliente.pkl","wb")
        pickle.dump(Cliente.getListaClientes(),pickleFileCliente)
        pickleFileCliente.close()

        #Vendedores
        pickleFileVendedor = open(path+"/baseDatos/temp/pickleFileVendedor.pkl","wb")
        pickle.dump(Vendedor.getListaVendedores(),pickleFileVendedor)
        pickleFileVendedor.close()

        #Conductores
        pickleFileConductor = open(path+"/baseDatos/temp/pickleFileConductor.pkl","wb")
        pickle.dump(Conductor.getListaConductores(),pickleFileConductor)
        pickleFileConductor.close()

        #Operarios
        pickleFileOperario = open(path+"/baseDatos/temp/pickleFileOperario.pkl","wb")
        pickle.dump(Operario.getListaOperarios(),pickleFileOperario)
        pickleFileOperario.close()

        #Transportes
        pickleFileTransporte = open(path+"/baseDatos/temp/pickleFileTransporte.pkl","wb")
        pickle.dump(Transporte.getListaTransportes(),pickleFileTransporte)
        pickleFileTransporte.close()