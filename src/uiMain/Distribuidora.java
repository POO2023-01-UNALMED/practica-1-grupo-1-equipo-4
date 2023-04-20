package uiMain;

import gestorAplicacion.gestion.*;

import java.util.Scanner;

public class Distribuidora {
    static Scanner sc = new Scanner(System.in);

	static{
		/* 
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
        
            //empleados de la fabrica:
            
            //cuentas para los empleados:
            CuentaBancaria cuentaOperario1 = new CuentaBancaria(55555, 100000);
            CuentaBancaria cuentaOperario2 = new CuentaBancaria(66666, 100000);
            CuentaBancaria cuentaOperario3 = new CuentaBancaria(77777, 100000);
        
            ArrayList<Operario> nomina = new ArrayList<Operario>();
            Operario operario1 = new Operario("operador1",20,55555,cuentaOperario1,Fabrica, 0);//cada oeprador tiene cien mil *hay que sacar cuentas*
            Operario operario2 = new Operario("operador2",21,66666,cuentaOperario2,Fabrica, 0); //para ese atriubuto fabrica primero hay que crear una frabica para asignarselo
            Operario operario3 = new Operario("operador3",22,77777,cuentaOperario3,Fabrica, 0);
            //se agg a la nomina
            nomina.add(operario1);
            nomina.add(operario2);
            nomina.add(operario3);
        
            //tiendas disponibles

            //se crean los empleados para las tiendas: (uno para cada una)
            //cuentas para los empleados de la tienda:
            CuentaBancaria cuentaVendedor1 = new CuentaBancaria(55555, 100000); //cada vendedor tiene cien mil *hay que sacar cuentas*
            CuentaBancaria cuentaVendedor2 = new CuentaBancaria(66666, 100000);
            CuentaBancaria cuentaVendedor3 = new CuentaBancaria(77777, 100000);
            //vendedores
            Vendedor vendedor1 = new Vendedor("vendedor1",20,55555,cuentaVendedor1,Fabrica, 0);
            Vendedor vendedor2 = new Vendedor("vendedor2",21,66666,cuentaVendedor2,Fabrica, 0);
            Vendedor vendedor3 = new Vendedor("vendedor3",22,77777,cuentaVendedor3,Fabrica, 0);

            //tiendas
            ArrayList<Tienda> tiendas = new ArrayList<Tienda>();
            Tienda tienda1 = new Tienda("tienda1",vendedor1,cuentaVendedor1); //eso atributo de la cuenta del vendedor hay que cambiarlo ya que 
            Tienda tienda2 = new Tienda("tienda2",vendedor2,cuentaVendedor2); //cambiamos de opinion y ahora sera una solo cuenta para todas las tiendas.
            Tienda tienda3 = new Tienda("tienda3",vendedor3,cuentaVendedor3);
        
            tiendas.add(tienda1);
            tiendas.add(tienda2);
            tiendas.add(tienda3);

            //se le asigna la tienda a cada vendedor:
            vendedor1.setTienda(tienda1);
            vendedor2.setTienda(tienda2);
            vendedor3.setTienda(tienda3);
        //cuenta bancaria para la fabrica: // **la cuenta de la fabrica y de las tiendas deben ser las mismas **
        CuentaBancaria cuentaFabrica = new CuentaBancaria(00000, 1000000); //saldo = un millon

		*/   
	}
	public static void main(String[] args) {
        int opcion;

		do{
            System.out.println("\n\nMenú principal Distribuidora SAS");
			System.out.println("1. Enviar pedido");
			System.out.println("2. Pagar a trabajadores");
			System.out.println("3. Abastecer tiendas");
			System.out.println("4. Gestionar devoluciones");
            System.out.println("5. Mostrar estadísticas");
            System.out.println("6. Salir");

			System.out.print("Ingrese el número de la opción que desea utilizar: ");

            opcion = sc.nextInt();

            switch(opcion){
                case 1:
                    gestionarPedido();
                    break;
                case 2:
                    pagarATrabajadores();
                    break;
                case 3:
                    abastecerTiendas();
                    break;
                case 4:
                    gestionarDevoluciones();
                    break;
                case 5:
                    mostrarEstadisticas();
                    break;
                case 6:
                    System.out.println("Gracias por visitarnos");
                    break;
                default:
                    System.out.println("Digitó una opción incorrecta");
                    
            }
        }while(opcion != 6);
	
	}

    public static void gestionarPedido(){
    }

    public static void pagarATrabajadores(){
    }

    public static void abastecerTiendas(){
    }

    public static void gestionarDevoluciones(){
    }

    public static void mostrarEstadisticas (){
    }


}

