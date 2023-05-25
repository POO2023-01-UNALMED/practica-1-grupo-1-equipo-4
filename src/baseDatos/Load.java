package baseDatos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import gestorAplicacion.gestion.*;
import gestorAplicacion.produccion.*;


public class Load {
     public static ArrayList<Producto> catalogo = new ArrayList<Producto>();
     public static ArrayList<Tienda> tiendas = new ArrayList<Tienda>();
     public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
     public static ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
     public static ArrayList<Factura> facturas = new ArrayList<Factura>();
    public static ArrayList<Conductor> conductores = new ArrayList<Conductor>();

    public static HashMap<String, Moda> infoAtributos = new HashMap<String,Moda>();


     public static Fabrica fabrica;
     public static Transporte transporteAbastecer;


   /*   public static void cargarPorDefecto(){
           //NOTA: Toca arreglar los constructores y unas cosas pa ver donde va a ir eso
 
 
             //productos disponibles en la fabrica:

      
             //Producto(String nombre, String descripcion, Double valor, Double peso, Double tamano, Double costoDeProduccion);
             Producto producto1 = new Producto("Ladrillo"," Bloque utilizado en paredes y estructuras", 1, 2.5, 10374,0.25,"construccion");
             Producto producto2 = new Producto("Lámpara LED", "Bombilla LED de bajo consumo energético", 80, 0.2, 500, 50, "construccion");
             Producto producto3 = new Producto("Adhesivo","Adhesivo multiusos", 20, 0.3, 20000,5,"construccion");
             Producto producto4 = new Producto("Cemento", "Material utilizado para la construcción", 200, 40, 8000, 10, "construccion");
             Producto producto5 = new Producto("Marmol","Roca metamórfica utilizada para la decoración y acabado de interiores", 20345, 3000000, 20,1000,"construccion");
             Producto producto6 = new Producto("Pintura blanca", "Pintura acrílica de color blanco", 50, 1.5, 10000, 30, "construccion");
             Producto producto7 = new Producto("Granito","Roca ígnea utilizada en encimeras, pisos y paredes", 10000, 27800, 20,750,"construccion");
             
             Producto producto8 = new Producto("Sandwich de pollo","Sandwich de pollo", 8, 0.2, 1,3,"consumible");
             Producto producto9 = new Producto("Hojas de Te","hojas de té verde", 6, 0.02, 1,15,"consumible");
             Producto producto10 = new Producto("Carne de res","Carne de res de vacas del llano", 15, 1, 1,7,"consumible");
             Producto producto11 = new Producto("Jamon","Jamón de cerdo", 9, 0.03, 1,4,"consumible");
             Producto producto12 = new Producto("Carne de cerdo","Cerdo de criadero", 12, 1, 1,3,"consumible");
             Producto producto13 = new Producto("Galletitas","Galletitas hechas con amor", 5, 0.006, 1,2,"consumible");
             Producto producto14 = new Producto("Pastel de cumpleaños","Pastel de cumpleaños de vainilla", 20, 2, 2,7,"consumible");
             
             Producto producto15 = new Producto("LimpiaMax","Limpiador multiusos", 8, 1, 1,2,"aseo");
             Producto producto16 = new Producto("Lavadora","Máquina para lavar ropa", 800, 70, 1,200,"aseo");
             Producto producto17 = new Producto("Jabon","Producto de limpieza", 5, 1, 1,1,"aseo");
             Producto producto18 = new Producto("Papel higiénico", "Rollos de papel suave y absorbente", 8, 1, 1, 2, "aseo");
             Producto producto19 = new Producto("Detergente", "Detergente líquido para lavadora", 15, 1.2, 1, 2, "aseo");
             Producto producto20 = new Producto("Cepillo de dientes", "Cepillo de cerdas suaves para la higiene bucal", 4, 1, 1, 1, "aseo");
             Producto producto21 = new Producto("Bolsas de basura", "Bolsas resistentes para desechar la basura", 3, 0.5, 1, 1, "aseo");
             Producto producto22 = new Producto("Jabón líquido", "Jabón líquido para manos", 5, 3, 1, 1, "aseo");

             //se agregan al catalogo
             catalogo.add(producto1);
             catalogo.add(producto2);
             catalogo.add(producto3);
             catalogo.add(producto4);
             catalogo.add(producto5);
             catalogo.add(producto6);
             catalogo.add(producto7);
             catalogo.add(producto8);
             catalogo.add(producto9);
             catalogo.add(producto10);
             catalogo.add(producto11);
             catalogo.add(producto12);
             catalogo.add(producto13);
             catalogo.add(producto14);
             catalogo.add(producto15);
             catalogo.add(producto16);
             catalogo.add(producto17);
             catalogo.add(producto18);
             catalogo.add(producto19);
             catalogo.add(producto20);
             catalogo.add(producto21);
             catalogo.add(producto22);
         
             //Cuenta de la empresa:
             CuentaBancaria cuentaEmpresa = new CuentaBancaria(9999999, 1000000000);
             //cuentas para los empleados:
             CuentaBancaria cuentaOperario1 = new CuentaBancaria(55555, 100000);

             //Operarios
             Operario operario1 = new Operario("Jaime",20,97890,cuentaOperario1,null);//cada oeprador tiene cien mil *hay que sacar cuentas*

             //tiendas disponibles
 
             //se crean los empleados para las tiendas: (uno para cada una)
             //cuentas para los empleados de la tienda:

             CuentaBancaria cuentaVendedor1 = new CuentaBancaria(56932, 100); //cada vendedor tiene cien mil *hay que sacar cuentas*
             CuentaBancaria cuentaVendedor2 = new CuentaBancaria(45728, 200);
             CuentaBancaria cuentaVendedor3 = new CuentaBancaria(95687, 200);


             //vendedores

             Vendedor vendedor1 = new Vendedor("Maria Beatriz",20,57793,cuentaVendedor1,null);
             Vendedor vendedor2 = new Vendedor("Adriana Alexia Putellas",21,89235,cuentaVendedor2,null);
             Vendedor vendedor3 = new Vendedor("Lionel Andres Messi",22,14720,cuentaVendedor3,null);
             
             //tiendas

             ArrayList<Tienda> tiendas = new ArrayList<Tienda>();
             Tienda tienda1 = new Tienda("Hefesto Construcciones",vendedor1,cuentaEmpresa); //eso atributo de la cuenta del vendedor hay que cambiarlo ya que 
             Tienda tienda2 = new Tienda("Consumibles de la Abuela Tata",vendedor2,cuentaEmpresa); //cambiamos de opinion y ahora sera una solo cuenta para todas las tiendas.
             Tienda tienda3 = new Tienda("Miss Músculo Aseo",vendedor3,cuentaEmpresa);
             //agregar productos a tiendas
             tienda1.setListaProductos(new ArrayList<>(Arrays.asList(producto1,producto2,producto3,producto4,producto5,producto6,producto7)));
             tienda2.setListaProductos(new ArrayList<>(Arrays.asList(producto8,producto9,producto10,producto11,producto12,producto13,producto14)));
             tienda3.setListaProductos(new ArrayList<>(Arrays.asList(producto15,producto16,producto17,producto18,producto19,producto20,producto21,producto22)));
             
             for(int i=0;i<3;i++){
              tienda1.getListaProductos().add(producto1);
              tienda1.getListaProductos().add(producto2);
              tienda1.getListaProductos().add(producto3);
              tienda1.getListaProductos().add(producto4);
              tienda1.getListaProductos().add(producto5);
              tienda1.getListaProductos().add(producto6);
              tienda1.getListaProductos().add(producto7);

              tienda2.getListaProductos().add(producto8);
              tienda2.getListaProductos().add(producto9);
              tienda2.getListaProductos().add(producto10);
              tienda2.getListaProductos().add(producto11);
              tienda2.getListaProductos().add(producto12);
              tienda2.getListaProductos().add(producto13);
              tienda2.getListaProductos().add(producto14);

              tienda3.getListaProductos().add(producto15);
              tienda3.getListaProductos().add(producto16);
              tienda3.getListaProductos().add(producto17);
              tienda3.getListaProductos().add(producto18);
              tienda3.getListaProductos().add(producto19);
              tienda3.getListaProductos().add(producto20);
              tienda3.getListaProductos().add(producto21);
              tienda3.getListaProductos().add(producto22);
             }
             tiendas.add(tienda1);
             tiendas.add(tienda2);
             tiendas.add(tienda3);
 

             //se le asigna la tienda a cada vendedor:
             vendedor1.setTienda(tienda1);
             vendedor2.setTienda(tienda2);
             vendedor3.setTienda(tienda3);
 
             
             //cuenta bancaria para la fabrica: // **la cuenta de la fabrica y de las tiendas deben ser las mismas **
             fabrica = new Fabrica(catalogo, tiendas, cuentaEmpresa,operario1);
             operario1.setFabrica(fabrica);
             //operario2.setFabrica(fabrica);
             //operario3.setFabrica(fabrica);
 
             //Cuentas Conductores
             CuentaBancaria cuentaConductor1 = new CuentaBancaria(646541231, 100); //cada vendedor tiene cien mil *hay que sacar cuentas*
             CuentaBancaria cuentaConductor2 = new CuentaBancaria(13213544, 100); //cada vendedor tiene cien mil *hay que sacar cuentas*
             CuentaBancaria cuentaConductor3 = new CuentaBancaria(1321354, 100); //cada vendedor tiene cien mil *hay que sacar cuentas*
             //conductores
             Conductor conductor1 = new Conductor("Pablo Ramirez", 45, 544764513, cuentaConductor1,null);
             Conductor conductor2 = new Conductor("Hernando Cruz", 50, 645541321, cuentaConductor2,null);
             Conductor conductor3 = new Conductor("Mario Casas", 25, 13216531, cuentaConductor3,null);
             conductor1.setFabrica(fabrica);
             conductor2.setFabrica(fabrica);
             conductor3.setFabrica(fabrica);
 
             //Transporte para abastecer
             transporteAbastecer = new Transporte(TipoTransporte.CAMION, TipoTransporte.CAMION.getCapacidadMax(),TipoTransporte.CAMION.getCapacidadMax(),conductor1);
             conductor1.setTransporte(transporteAbastecer);
             
             // Crear objetos de Cliente
             
             CuentaBancaria cuentaCliente1 = new CuentaBancaria(11111, 5000000);
             Cliente cliente1 = new Cliente("Juan Pérez", "Calle 123", cuentaCliente1);
             CuentaBancaria cuentaCliente2 = new CuentaBancaria(22222, 200);
             Cliente cliente2 = new Cliente("María García", "Avenida 456", cuentaCliente2);
             CuentaBancaria cuentaCliente3 = new CuentaBancaria(33333,20000);
             Cliente cliente3 = new Cliente("Pedro Gómez", "Carrera 789", cuentaCliente3);
             CuentaBancaria cuentaCliente4 = new CuentaBancaria(44444,20000);
             Cliente cliente4 = new Cliente("Luis Gómez", "Carrera 789", cuentaCliente4);
             CuentaBancaria cuentaCliente5 = new CuentaBancaria(55555,20000);
             Cliente cliente5 = new Cliente("Josesito Gómez", "Carrera 789", cuentaCliente5);
             CuentaBancaria cuentaCliente6 = new CuentaBancaria(66666,30000);
             Cliente cliente6 = new Cliente("Julián Araña Alvarez", "Carrera 101", cuentaCliente6);
             CuentaBancaria cuentaCliente7 = new CuentaBancaria(77777,70000);
             Cliente cliente7 = new Cliente("Emiliano Dibu Martinez", "Carrera 23", cuentaCliente7);
             CuentaBancaria cuentaCliente8 = new CuentaBancaria(88888,211000);
             Cliente cliente8 = new Cliente("Diego Armando Maradona", "Carrera 10", cuentaCliente8);

             
             // Agregar los objetos de Cliente a la lista de clientes
             clientes.add(cliente1);
             clientes.add(cliente2);
             clientes.add(cliente3);
             clientes.add(cliente4);
             clientes.add(cliente5);
             clientes.add(cliente6);
             clientes.add(cliente7);
             clientes.add(cliente8);

             vendedores.add(vendedor1);
             vendedores.add(vendedor2);
             vendedores.add(vendedor3);

             conductores.add(conductor1);
             conductores.add(conductor2);
             conductores.add(conductor3);
 
             //inicializar el map de los productos
             tienda1.cantidadProductosVentas();
             tienda2.cantidadProductosVentas();
             tienda3.cantidadProductosVentas();
        }*/
    
    public static void guardar(){

      facturas = Factura.getListaFacturas();
      clientes = Cliente.getListaClientes();
      catalogo = Producto.getListaProductos();
      conductores = Conductor.getListaConductores();
      infoAtributos = Factura.getInfoAtributos();

      Serializador.guardarTiendas();
      Serializador.guardarCatalogo();
      Serializador.guardarFabrica();
      Serializador.guardarFacturas();
      Serializador.guardarTransporte();
      Serializador.guardarVendedores();
      Serializador.guardarClientes();
      Serializador.guardarConductores();
      Serializador.guardarAtributos();

    }

    public static void cargar(){

      try{

       tiendas =  Deserializador.cargarTiendas();
       catalogo = Deserializador.cargarCatalogo();
       fabrica = Deserializador.cargarFabrica();
       clientes = Deserializador.cargarClientes();
       transporteAbastecer = Deserializador.cargarTransporte();
       vendedores =  Deserializador.cargarVendedores();
       facturas =  Deserializador.cargarFacturas();
       conductores = Deserializador.cargaConductores();
       infoAtributos = Deserializador.cargaAtributos();

       Factura.setListaFacturas(facturas);
       Cliente.setListaClientes(clientes);
       Producto.setListaProductos(catalogo);
       Conductor.setListaConductores(conductores);
       Factura.setInfoAtributos(infoAtributos);

      }catch(Exception e){
        System.out.println("Ha ocurrido un error en la deserialización");
        e.printStackTrace();
      }
    }

    public static void main(String[] args){


	}
}
