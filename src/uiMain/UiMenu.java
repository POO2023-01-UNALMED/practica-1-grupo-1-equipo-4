package uiMain;

import gestorAplicacion.gestion.*;
import gestorAplicacion.produccion.*;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class UiMenu {
    static Scanner sc = new Scanner(System.in);
    public static Fabrica fabrica;
    public static Transporte transporteAbastecer;
	static{
		//NOTA: Toca arreglar los constructores y unas cosas pa ver donde va a ir eso 

            //productos disponibles en la fabrica:

            ArrayList<Producto> catalogo = new ArrayList<Producto>();
            //Producto(String nombre, String descripcion, Double valor, Double peso, Double tamano, Double costoDeProduccion);
            Producto producto1 = new Producto("producto","descricion vacia", 10000, 5, 20,1);
            Producto producto2 = new Producto("producto","descricion vacia", 10000, 5, 20,1);
            Producto producto3 = new Producto("producto","descricion vacia", 10000, 5, 20,1);
            Producto producto4 = new Producto("producto","descricion vacia", 10000, 5, 20,1);
            Producto producto5 = new Producto("producto","descricion vacia", 10000, 5, 20,1);
            Producto producto6 = new Producto("producto","descricion vacia", 10000, 5, 20,1);
            Producto producto7 = new Producto("producto","descricion vacia", 10000, 5, 20,1);
            Producto producto8 = new Producto("producto","descricion vacia", 10000, 5, 20,1);
            Producto producto9 = new Producto("producto","descricion vacia", 10000, 5, 20,1);
            Producto producto10 = new Producto("producto","descricion vacia", 10000, 5, 20,1);
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
        
            //Cuenta de la empresa:
            CuentaBancaria cuentaEmpresa = new CuentaBancaria(9999999, 1000000000);
            //cuentas para los empleados:
            CuentaBancaria cuentaOperario1 = new CuentaBancaria(55555, 100000);
            CuentaBancaria cuentaOperario2 = new CuentaBancaria(66666, 100000);
            CuentaBancaria cuentaOperario3 = new CuentaBancaria(77777, 100000);

            //Operarios
            ArrayList<Operario> listaOperarios = new ArrayList<Operario>();
            Operario operario1 = new Operario("operador1",20,55555,cuentaOperario1,0, null);//cada oeprador tiene cien mil *hay que sacar cuentas*
            Operario operario2 = new Operario("operador2",21,66666,cuentaOperario2,0, null); //para ese atriubuto fabrica primero hay que crear una frabica para asignarselo
            Operario operario3 = new Operario("operador3",22,77777,cuentaOperario3,0, null);
            //se agg a la nomina
            listaOperarios.add(operario1);
            listaOperarios.add(operario2);
            listaOperarios.add(operario3);

            //tiendas disponibles

            //se crean los empleados para las tiendas: (uno para cada una)
            //cuentas para los empleados de la tienda:
            CuentaBancaria cuentaVendedor1 = new CuentaBancaria(55555, 100000); //cada vendedor tiene cien mil *hay que sacar cuentas*
            CuentaBancaria cuentaVendedor2 = new CuentaBancaria(66666, 100000);
            CuentaBancaria cuentaVendedor3 = new CuentaBancaria(77777, 100000);
            //vendedores
            Vendedor vendedor1 = new Vendedor("vendedor1",20,55555,cuentaVendedor1,0, null);
            Vendedor vendedor2 = new Vendedor("vendedor2",21,66666,cuentaVendedor2,0, null);
            Vendedor vendedor3 = new Vendedor("vendedor3",22,77777,cuentaVendedor3,0, null);
            
            //tiendas
            ArrayList<Tienda> tiendas = new ArrayList<Tienda>();
            Tienda tienda1 = new Tienda("tienda1",vendedor1,cuentaEmpresa); //eso atributo de la cuenta del vendedor hay que cambiarlo ya que 
            Tienda tienda2 = new Tienda("tienda2",vendedor2,cuentaEmpresa); //cambiamos de opinion y ahora sera una solo cuenta para todas las tiendas.
            Tienda tienda3 = new Tienda("tienda3",vendedor3,cuentaEmpresa);
            //agregar productos a tiendas
            tienda1.setListaProductos(new ArrayList<>(Arrays.asList(producto1,producto2,producto3)));
            tienda2.setListaProductos(new ArrayList<>(Arrays.asList(producto4,producto5,producto6)));
            tienda3.setListaProductos(new ArrayList<>(Arrays.asList(producto7,producto8,producto9)));
            
            tiendas.add(tienda1);
            tiendas.add(tienda2);
            tiendas.add(tienda3);
            //cambiar las tiendas de los vendedores
            vendedor1.setTienda(tienda1);
            vendedor2.setTienda(tienda2);
            vendedor3.setTienda(tienda3);

            //se le asigna la tienda a cada vendedor:
            vendedor1.setTienda(tienda1);
            vendedor2.setTienda(tienda2);
            vendedor3.setTienda(tienda3);

            
            //cuenta bancaria para la fabrica: // **la cuenta de la fabrica y de las tiendas deben ser las mismas **
            fabrica = new Fabrica(operario1, catalogo, tiendas, cuentaEmpresa);

            //Cambiar null de los operarios

            operario1.setFabrica(fabrica);
            operario2.setFabrica(fabrica);
            operario3.setFabrica(fabrica);

            //Transporte para abastecer
            transporteAbastecer = new Transporte("kkk555", TipoTransporte.CAMION, TipoTransporte.CAMION.getCapacidadMax(), (int)TipoTransporte.CAMION.getCapacidadMax());
	}
	public static void main(String[] args) {
        int opcion;

		do{
            System.out.println("\nMenú principal Distribuidora SAS\n");
			System.out.println("1. Enviar pedido");
			System.out.println("2. Pagar a trabajadores");
			System.out.println("3. Abastecer tiendas");
			System.out.println("4. Gestionar devoluciones");
            System.out.println("5. Mostrar estadísticas");
            System.out.println("6. Salir\n");

			System.out.print("Ingrese el número de la opción que desea utilizar: ");

            opcion = sc.nextInt();

            switch(opcion){
                case 1:
                    //gestionarPedido();
                    break;
                case 2:
                    UiPagarTrabajadores.pagartrabajadores();
                    break;
                case 3:
                    UiAbastecer.abastecerTiendas();
                    break;
                case 4:
                    //gestionarDevoluciones();
                    break;
                case 5:
                    UiEstadisticas.ingresarFechas();
                    break;
                case 6:
                    System.out.println("Gracias por visitarnos");
                    System.out.println("Vuelva pronto");
                    break;
                default:
                    System.out.println("\nDigitó una opción incorrecta");
                    
            }
        }while(opcion != 6);
	
	}


}

