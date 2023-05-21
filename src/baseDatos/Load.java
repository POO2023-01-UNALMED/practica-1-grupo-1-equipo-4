package baseDatos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import gestorAplicacion.gestion.*;
import gestorAplicacion.produccion.*;

import java.util.Scanner;


import java.util.ArrayList;
import java.util.Arrays;


public class Load {
     public static ArrayList<Producto> catalogo = new ArrayList<Producto>();
     public static ArrayList<Tienda> tiendas = new ArrayList<Tienda>();
     public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
     public static ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
     public static ArrayList<Factura> facturas = new ArrayList<Factura>();

     static Scanner sc = new Scanner(System.in);

     public static Conductor conductor;
     public static Fabrica fabrica;
     public static Transporte transporteAbastecer;

      public static void cargarPorDefecto(){
           //NOTA: Toca arreglar los constructores y unas cosas pa ver donde va a ir eso
 
 
             //productos disponibles en la fabrica:
 
             ArrayList<Producto> catalogo = new ArrayList<Producto>();
             //Producto(String nombre, String descripcion, Double valor, Double peso, Double tamano, Double costoDeProduccion);
             Producto producto1 = new Producto("LimpiaMax","Limpiador multiusos", 100, 50, 24000,30,"aseo");
             Producto producto2 = new Producto("Sandwich de pollo","Sandwich de pollo", 5, 0.7, 100,1000,"consumible");
             Producto producto3 = new Producto("Ladrillo"," Bloque utilizado en paredes y estructuras", 1, 2.5, 10374,0.25,"construccion");
             Producto producto4 = new Producto("Lavadora","Máquina para lavar ropa", 100, 675, 200000,20,"aseo");
             Producto producto5 = new Producto("Hojas de Te","hojas de té verde", 75, 60, 10000,15,"consumible");
             Producto producto6 = new Producto("Adhesivo","Adhesivo multiusos", 20, 0.3, 20000,5,"construccion");
             Producto producto7 = new Producto("Jabon","Producto de limpieza", 3090, 271, 20,10,"aseo");
             Producto producto8 = new Producto("Carne de res","Carne de res de vacas del llano", 30000, 265, 20,1000,"consumible");
             Producto producto9 = new Producto("Marmol","Roca metamórfica utilizada para la decoración y acabado de interiores", 20345, 3000000, 20,1000,"construccion");
             Producto producto10 = new Producto("Granito","Roca ígnea utilizada en encimeras, pisos y paredes", 10000, 27800, 20,750,"construccion");
             Producto producto11 = new Producto("Jamon","Jamón de cerdo", 3, 27800, 20,750,"consumible");
             Producto producto12 = new Producto("Carne de cerdo","Cerdo de criadero", 10, 27800, 20,750,"consumible");
             Producto producto13 = new Producto("Papel higiénico", "Rollos de papel suave y absorbente", 8, 1, 5000, 2, "aseo");
             Producto producto14 = new Producto("Pintura blanca", "Pintura acrílica de color blanco", 50, 1.5, 10000, 30, "construccion");
             Producto producto15 = new Producto("Detergente", "Detergente líquido para lavadora", 150, 1.2, 500, 20, "aseo");
             Producto producto16 = new Producto("Cemento", "Material utilizado para la construcción", 200, 40, 8000, 10, "construccion");
             Producto producto17 = new Producto("Cepillo de dientes", "Cepillo de cerdas suaves para la higiene bucal", 25, 0.1, 100, 5, "aseo");
             Producto producto18 = new Producto("Bolsas de basura", "Bolsas resistentes para desechar la basura", 15, 0.5, 200, 3, "aseo");
             Producto producto19 = new Producto("Lámpara LED", "Bombilla LED de bajo consumo energético", 80, 0.2, 500, 50, "construccion");
             Producto producto20 = new Producto("Jabón líquido", "Jabón líquido para manos", 30, 0.5, 1000, 8, "aseo");


            
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
         
             //Cuenta de la empresa:
             CuentaBancaria cuentaEmpresa = new CuentaBancaria(9999999, 1000000000);
             //cuentas para los empleados:
             CuentaBancaria cuentaOperario1 = new CuentaBancaria(55555, 100000);
             //CuentaBancaria cuentaOperario2 = new CuentaBancaria(66666, 100000);
             //CuentaBancaria cuentaOperario3 = new CuentaBancaria(77777, 100000);
 
             //Operarios
             //ArrayList<Operario> listaOperarios = new ArrayList<Operario>();
             Operario operario1 = new Operario("Jaime",20,97890,cuentaOperario1,null);//cada oeprador tiene cien mil *hay que sacar cuentas*
             //Operario operario2 = new Operario("operador2",21,66666,cuentaOperario2,0, null); //para ese atriubuto fabrica primero hay que crear una frabica para asignarselo
             //Operario operario3 = new Operario("operador3",22,77777,cuentaOperario3,0, null);
             //se agg a la nomina
             //listaOperarios.add(operario1);
             //listaOperarios.add(operario2);
             //listaOperarios.add(operario3);
 
             //tiendas disponibles
 
             //se crean los empleados para las tiendas: (uno para cada una)
             //cuentas para los empleados de la tienda:
             CuentaBancaria cuentaVendedor1 = new CuentaBancaria(56932, 100); //cada vendedor tiene cien mil *hay que sacar cuentas*
             CuentaBancaria cuentaVendedor2 = new CuentaBancaria(45728, 200);
             CuentaBancaria cuentaVendedor3 = new CuentaBancaria(95687, 200);
             //vendedores
             Vendedor vendedor1 = new Vendedor("Maria Beatriz",20,57793,cuentaVendedor1,null);
             Vendedor vendedor2 = new Vendedor("Adriana",21,89235,cuentaVendedor2,null);
             Vendedor vendedor3 = new Vendedor("Lionel Andres",22,14720,cuentaVendedor3,null);
             
             //tiendas
             ArrayList<Tienda> tiendas = new ArrayList<Tienda>();
             Tienda tienda1 = new Tienda("Hefesto Construcciones",vendedor1,cuentaEmpresa); //eso atributo de la cuenta del vendedor hay que cambiarlo ya que 
             Tienda tienda2 = new Tienda("Vitruvio Edificios",vendedor2,cuentaEmpresa); //cambiamos de opinion y ahora sera una solo cuenta para todas las tiendas.
             Tienda tienda3 = new Tienda("Zaha Hadid Arquitectura ",vendedor3,cuentaEmpresa);
             //agregar productos a tiendas
             tienda1.setListaProductos(new ArrayList<>(Arrays.asList(producto1,producto2,producto3)));
             tienda2.setListaProductos(new ArrayList<>(Arrays.asList(producto4,producto5,producto6)));
             tienda3.setListaProductos(new ArrayList<>(Arrays.asList(producto7,producto8,producto9,producto10, producto11)));
             
             tiendas.add(tienda1);
             tiendas.add(tienda2);
             tiendas.add(tienda3);
 
             //se le asigna la tienda a cada vendedor:
             vendedor1.setTienda(tienda1);
             vendedor2.setTienda(tienda2);
             vendedor3.setTienda(tienda3);
 
             
             //Metas
             Meta metaVendedores1 = new Meta("Fácil",3,10000);
             Meta metaVendedores2 = new Meta("Dificil",10,50000);
             Vendedor.getMetasVendedor().add(metaVendedores1);
             Vendedor.getMetasVendedor().add(metaVendedores2);
             Meta metaConductores1 = new Meta("Fácil",10,10000);
             Meta metaConductores2 = new Meta("Dificil",10,10000);
             Conductor.getMetasConductor().add(metaConductores1);
             Conductor.getMetasConductor().add(metaConductores2);
             Meta metaOperarios1 = new Meta("Fácil",10,10000);
             Meta metaOperarios2 = new Meta("Dificil",10,10000);
             Operario.getMetasOperario().add(metaOperarios1);
             Operario.getMetasOperario().add(metaOperarios2);
 
             
             //cuenta bancaria para la fabrica: // **la cuenta de la fabrica y de las tiendas deben ser las mismas **
             fabrica = new Fabrica(catalogo, tiendas, cuentaEmpresa,operario1);
             operario1.setFabrica(fabrica);
             //operario2.setFabrica(fabrica);
             //operario3.setFabrica(fabrica);
 
             //conductores
             conductor = new Conductor("joseito", 17, 12345, cuentaVendedor3,null);
             conductor.setFabrica(fabrica);
             //Conductor conductor1 = new Conductor("felipe", 17, 12345, cuentaVendedor2,null);
             //Conductor conductor2 = new Conductor("Alejandro", 17, 12345, cuentaVendedor2,null);
 
             //Transporte para abastecer
             transporteAbastecer = new Transporte(TipoTransporte.CAMION, TipoTransporte.CAMION.getCapacidadMax(),TipoTransporte.CAMION.getCapacidadMax(),conductor);
             conductor.setTransporte(transporteAbastecer);
             
             // Crear objetos de Cliente
             CuentaBancaria cuenta1 = new CuentaBancaria(11111, 5000000);
             Cliente cliente1 = new Cliente("Juan Pérez", "Calle 123", cuenta1);
             CuentaBancaria cuenta2 = new CuentaBancaria(22222, 200);
             Cliente cliente2 = new Cliente("María García", "Avenida 456", cuenta2);
             CuentaBancaria cuenta3 = new CuentaBancaria(33333,20000);
             Cliente cliente3 = new Cliente("Pedro Gómez", "Carrera 789", cuenta3);
 
             // Agregar los objetos de Cliente a la lista de clientes
             clientes.add(cliente1);
             clientes.add(cliente2);
             clientes.add(cliente3);

             vendedores.add(vendedor1);
             vendedores.add(vendedor2);
             vendedores.add(vendedor3);
 
             //inicializar el map de los productos
             tienda1.cantidadProductosVentas();
             tienda2.cantidadProductosVentas();
             tienda3.cantidadProductosVentas();


             //FACTURAS DE PRUEBA:
         facturas.add(new Factura(tienda3, cliente3, transporteAbastecer, catalogo, 1, "hola",operario1));
         facturas.add(new Factura(tienda3, cliente3, transporteAbastecer, catalogo, 2, "hola",operario1));
         facturas.add(new Factura(tienda3, cliente3, transporteAbastecer, catalogo, 2, "hola",operario1));
         facturas.add( new Factura(tienda3, cliente3, transporteAbastecer, catalogo, 4, "hola",operario1));
         facturas.add( new Factura(tienda3, cliente3, transporteAbastecer, catalogo, 5, "hola",operario1));
         facturas.add( new Factura(tienda3, cliente3, transporteAbastecer, catalogo, 6, "hola",operario1));
         facturas.add(new Factura(tienda3, cliente3, transporteAbastecer, catalogo, 6, "hola",operario1));

        }
      

    



    public static void guardar(){

      Serializador.guardarTiendas();
      Serializador.guardarCatalogo();
      Serializador.guardarFabrica();
      Serializador.guardarFacturas();
      Serializador.guardarTransporte();
      Serializador.guardarVendedores();
      Serializador.guardarClientes();
      Serializador.guardarConductor();
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
       conductor = Deserializador.cargaConductor();



       Factura.setListaFacturas(facturas);
       Cliente.setListaClientes(clientes);

       

       Producto.setListaProductos(catalogo);
       Conductor.getListaConductores().add( conductor);

       System.out.println(fabrica);



      }catch(Exception e){
        System.out.println("Ha ocurrido un error en la deserialización");
       // e.printStackTrace();
      }

 

    }

    public static void main(String[] args){

    Load.cargar();

    System.out.println(Cliente.getListaClientes());

	}

}
