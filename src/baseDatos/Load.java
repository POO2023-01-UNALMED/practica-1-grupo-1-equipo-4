package baseDatos;

import java.util.ArrayList;
import java.util.Arrays;

import gestorAplicacion.gestion.*;
import gestorAplicacion.produccion.*;

public class Load {

    public static Fabrica fabrica;
    public static ArrayList<Factura> facturas;
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static ArrayList<Producto> productos;
    public static Transporte transporteAbastecer;
    public static ArrayList<Producto> catalogo = new ArrayList<>();
    public static ArrayList<Tienda> tiendas = new ArrayList<>();
    public static ArrayList<Vendedor> vendedores = new ArrayList<>();
    public static Conductor conductor;
    

    static{
		//NOTA: Toca arreglar los constructores y unas cosas pa ver donde va a ir eso aaaaaaaaaaaaaaaaaaaaaaaa

            //productos disponibles en la fabrica:

            
            //Producto(String nombre, String descripcion, Double valor, Double peso, Double tamano, Double costoDeProduccion);
           /*   Producto producto1 = new Producto("Cemento Portland","Cemento de uso general en construcción", 100, 50, 24000,30,"construccion");
            Producto producto2 = new Producto("Grafeno","Material compuesto por átomos de carbono en una estructura de red hexagonal", 500000, 1, 100,1000,"construccion");
            Producto producto3 = new Producto("Ladrillo"," Bloque utilizado en paredes y estructuras", 1, 2.5, 10374,0.25,"construccion");
            Producto producto4 = new Producto("Bloque de Hormigón","Bloque sólido utilizado en paredes y estructuras", 100, 675, 200000,20,"aseo");
            Producto producto5 = new Producto("Hojas de Acero","acero enrejado utilizado en refuerzos estructurales", 75, 60, 10000,15,"construccion");
            Producto producto6 = new Producto("Adhesivo","Adhesivo multiusos", 20, 0.3, 20000,5,"construccion");
            Producto producto7 = new Producto("Calcita","Mineral de carbonato utilizado como componente en el concreto y la cal", 3090, 271, 20,10,"consumible");
            Producto producto8 = new Producto("Cuarzo","Mineral utilizado como componente en el concreto y la fabricación de vidrio", 30000, 265, 20,1000,"construccion");
            Producto producto9 = new Producto("Marmol","Roca metamórfica utilizada para la decoración y acabado de interiores", 20345, 3000000, 20,1000,"construccion");
            Producto producto10 = new Producto("Granito","Roca ígnea utilizada en encimeras, pisos y paredes", 10000, 27800, 20,750,"construccion");

            catalogo.add(producto1);
            catalogo.add(producto2);
            catalogo.add(producto3);
            catalogo.add(producto4);
            catalogo.add(producto5);
            catalogo.add(producto6);
            catalogo.add(producto7);
            catalogo.add(producto8);
            catalogo.add(producto9);
            catalogo.add(producto10);*/
            try{
               catalogo = Deserializador.cargarCatalogo();
               System.out.println("Catalogo cargado");
               }catch(Exception e){
       
                   e.printStackTrace();
                   System.out.println("HA OCURRIDO UN ERROR EN LA DESERIALIZACIÓN DE FACTURAS");
               }

           try{
               clientes = Deserializador.cargarClientes();
               System.out.println("Clientes cargados");
               }catch(Exception e){
          
                    e.printStackTrace();
                    System.out.println("HA OCURRIDO UN ERROR EN LA DESERIALIZACIÓN DE CLIENTES");
               }
     
               try{
                    vendedores = Deserializador.cargarVendedores();
                    System.out.println("Vendedores cargados");
                    }catch(Exception e){
               
                         e.printStackTrace();
                         System.out.println("HA OCURRIDO UN ERROR EN LA DESERIALIZACIÓN DE VENDEDORES");
                    }

               try{
                    tiendas = Deserializador.cargarTiendas();
                    System.out.println("Tiendas cargadas");
                    }catch(Exception e){
               
                         e.printStackTrace();
                         System.out.println("HA OCURRIDO UN ERROR EN LA DESERIALIZACIÓN DE TIENDAS");
                    }
        

            //Cuenta de la empresa:
            CuentaBancaria cuentaEmpresa = new CuentaBancaria(9999999, 1000000000);
            //cuentas para los empleados:
            CuentaBancaria cuentaOperario1 = new CuentaBancaria(55555, 100000);
            //CuentaBancaria cuentaOperario2 = new CuentaBancaria(66666, 100000););

            //Operarios
            //ArrayList<Operario> listaOperarios = new ArrayList<Operario>();
            Operario operario1 = new Operario("operador1",20,55555,cuentaOperario1,null);//cada oeprador tiene cien mil *hay que sacar cuentas*
            //Operario operario2 = new Operario("operador2",21,66666,cuentaOperario2,0, null); //para ese atriubuto fabrica primero hay que crear una frabica para asignarselo
            //Operario operario3 = new Operario("operador3",22,77777,cuentaOperario3,0, null);
            //se agg a la nomina
            //listaOperarios.add(operario1);
            //listaOperarios.add(operario2);
            //listaOperarios.add(operario3);

            //tiendas disponibles

            //se crean los empleados para las tiendas: (uno para cada una)
            //cuentas para los empleados de la tienda:
           /*   CuentaBancaria cuentaVendedor1 = new CuentaBancaria(55555, 100000); //cada vendedor tiene cien mil *hay que sacar cuentas*
            CuentaBancaria cuentaVendedor2 = new CuentaBancaria(66666, 100000);
            CuentaBancaria cuentaVendedor3 = new CuentaBancaria(77777, 100000);
            //vendedores
            vendedores.add( new Vendedor("vendedor1",20,55555,cuentaVendedor1,null));
            vendedores.add( new Vendedor("vendedor2",21,66666,cuentaVendedor2,null));
            vendedores.add(  new Vendedor("vendedor3",22,77777,cuentaVendedor3,null));*/
            
            //tiendas
           /* Tienda tienda1 = new Tienda("Hefesto Construcciones",vendedores.get(0),cuentaEmpresa); //eso atributo de la cuenta del vendedor hay que cambiarlo ya que 
            Tienda tienda2 = new Tienda("Vitruvio Edificios",vendedores.get(1),cuentaEmpresa); //cambiamos de opinion y ahora sera una solo cuenta para todas las tiendas.
            Tienda tienda3 = new Tienda("Zaha Hadid Arquitectura ",vendedores.get(2),cuentaEmpresa);
            //agregar productos a tiendas
            tienda1.setListaProductos(new ArrayList<>(Arrays.asList(catalogo.get(0),catalogo.get(1),catalogo.get(2))));
            tienda2.setListaProductos(new ArrayList<>(Arrays.asList(catalogo.get(3),catalogo.get(4),catalogo.get(5))));
            tienda3.setListaProductos(new ArrayList<>(Arrays.asList(catalogo.get(6),catalogo.get(7),catalogo.get(8))));
            
            tiendas.add(tienda1);
            tiendas.add(tienda2);
            tiendas.add(tienda3);*/

            //se le asigna la tienda a cada vendedor:
           

            
            //cuenta bancaria para la fabrica: // **la cuenta de la fabrica y de las tiendas deben ser las mismas **
            fabrica = new Fabrica(catalogo, tiendas, cuentaEmpresa);
            fabrica.setOperario(operario1);

            fabrica.getOperario().setFabrica(fabrica);

            //operario2.setFabrica(fabrica);

            //operario3.setFabrica(fabrica);

            //conductores
            conductor = new Conductor("joseito", 17, 12345, vendedores.get(2).getCuentaBancaria(),null);
            conductor.setFabrica(fabrica);
            //Conductor conductor1 = new Conductor("felipe", 17, 12345, cuentaVendedor2,null);
            //Conductor conductor2 = new Conductor("Alejandro", 17, 12345, cuentaVendedor2,null);

            //Transporte para abastecer
            transporteAbastecer = new Transporte(TipoTransporte.CAMION, TipoTransporte.CAMION.getCapacidadMax(),TipoTransporte.CAMION.getCapacidadMax(),conductor);
            conductor.setTransporte(transporteAbastecer);
            
            // Crear objetos de Cliente
        //    ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        /*      CuentaBancaria cuenta1 = new CuentaBancaria(11111, 5000000);
            Cliente cliente1 =       new Cliente("Juan Pérez", "Calle 123", cuenta1);
            CuentaBancaria cuenta2 = new CuentaBancaria(22222, 100000);
            Cliente cliente2 =       new Cliente("María García", "Avenida 456", cuenta2);
            CuentaBancaria cuenta3 = new CuentaBancaria(33333,20000);
            Cliente cliente3 =       new Cliente("Pedro Gómez", "Carrera 789", cuenta3);

            // Agregar los objetos de Cliente a la lista de clientes
            clientes.add(cliente1);
            clientes.add(cliente2);
            clientes.add(cliente3);*/
            //inicializar el map de los productos

            vendedores.get(0).setTienda(tiendas.get(0));
            vendedores.get(1).setTienda(tiendas.get(1));
            vendedores.get(2).setTienda(tiendas.get(2));

            tiendas.get(0).cantidadProductosVentas();
            tiendas.get(1).cantidadProductosVentas();
            tiendas.get(2).cantidadProductosVentas();
            //FACTURAS DE PRUEBA:
      
	}

     public static void main(String args[]){

          Serializador.guardarCatalogo();
          Serializador.guardarClientes();
          Serializador.guardarTiendas();
          Serializador.guardarVendedores();
          Serializador.guardarFabrica();

          System.out.println(clientes);


     }
    
}
