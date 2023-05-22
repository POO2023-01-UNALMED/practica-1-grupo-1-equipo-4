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
     //public static ArrayList<Meta> metas = new ArrayList<Meta>();

     static Scanner sc = new Scanner(System.in);

     public static Conductor conductor1;
     public static Fabrica fabrica;
     public static Transporte transporteAbastecer;


      public static void cargarPorDefecto(){
           //NOTA: Toca arreglar los constructores y unas cosas pa ver donde va a ir eso
 
 
             //productos disponibles en la fabrica:
 
             ArrayList<Producto> catalogo = new ArrayList<Producto>();
             ArrayList<Producto> catalogo2 = new ArrayList<Producto>();
      
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

             catalogo2.add(producto1);
             catalogo2.add(producto2);
            
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
             

             tiendas.add(tienda1);
             tiendas.add(tienda2);
             tiendas.add(tienda3);
 

             //se le asigna la tienda a cada vendedor:
             vendedor1.setTienda(tienda1);
             vendedor2.setTienda(tienda2);
             vendedor3.setTienda(tienda3);
 

             //-----------BORRAAAAAAAAAAAAARR
            //  //Metas
            //  Meta metaVendedores1 = new Meta("Fácil",3,10000);
            //  Meta metaVendedores2 = new Meta("Dificil",10,50000);
            //  Vendedor.getMetasVendedor().add(metaVendedores1);
            //  Vendedor.getMetasVendedor().add(metaVendedores2);
            //  Meta metaConductores1 = new Meta("Fácil",10,10000);
            //  Meta metaConductores2 = new Meta("Dificil",10,10000);
            //  Conductor.getMetasConductor().add(metaConductores1);
            //  Conductor.getMetasConductor().add(metaConductores2);
            //  Meta metaOperarios1 = new Meta("Fácil",10,10000);
            //  Meta metaOperarios2 = new Meta("Dificil",10,10000);
            //  Operario.getMetasOperario().add(metaOperarios1);
            //  Operario.getMetasOperario().add(metaOperarios2);
 
            //  //Guardar metas
            // metas.add(metaConductores1);
            // metas.add(metaConductores2);
            // metas.add(metaVendedores1);
            // metas.add(metaVendedores2);
            // metas.add(metaOperarios1);
            // metas.add(metaOperarios2);
             
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
             conductor1 = new Conductor("Pablo Ramirez", 45, 544764513, cuentaConductor1,null);
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
            facturas.add(new Factura(tienda3, cliente3, transporteAbastecer, catalogo2, 1, "hola",operario1));
            facturas.add(new Factura(tienda3, cliente2, transporteAbastecer, catalogo2, 2, "hola",operario1));
            facturas.add(new Factura(tienda3, cliente1, transporteAbastecer, catalogo, 2, "hola",operario1));
            facturas.add( new Factura(tienda3, cliente2, transporteAbastecer, catalogo, 4, "hola",operario1));
            facturas.add( new Factura(tienda3, cliente3, transporteAbastecer, catalogo, 5, "hola",operario1));
            facturas.add( new Factura(tienda3, cliente1, transporteAbastecer, catalogo, 6, "hola",operario1));
            facturas.add(new Factura(tienda3, cliente1, transporteAbastecer, catalogo, 6, "hola",operario1));

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
      //Serializador.guardarMetas();
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
       conductor1 = Deserializador.cargaConductor();
       //metas = Deserializador.cargarMeta();



       Factura.setListaFacturas(facturas);
       Cliente.setListaClientes(clientes);

       

       Producto.setListaProductos(catalogo);
       Conductor.getListaConductores().add( conductor1);

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
