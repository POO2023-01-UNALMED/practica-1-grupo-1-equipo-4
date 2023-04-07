package gestorAplicacion.produccion;
import gestorAplicacion.gestion.CuentaBancaria;
import gestorAplicacion.gestion.Operario;
import gestorAplicacion.gestion.Vendedor;

import java.util.ArrayList;

public class Fabrica {

    private static ArrayList<Operario> listaOperadores;
    private static ArrayList<Producto> listaProductos;
    private static int cantidadProducto;
    private static ArrayList<Tienda> listaTienda;
    private static CuentaBancaria CuentaBancaria;


    // ------------- constructor -------------
    public Fabrica() {

         //NOTA: AÚN NO SE SI ESTO VA ACA O EN UN METODO ESTATICO 

            //productos disponibles en las fabricas:

            ArrayList<Producto> catalogo = new ArrayList<Producto>();
            Producto producto1 = new Producto("descricion vacia", 10000, 5, 20);
            Producto producto2 = new Producto("descricion vacia", 10000, 5, 20);
            Producto producto3 = new Producto("descricion vacia", 10000, 5, 20);
            Producto producto4 = new Producto("descricion vacia", 10000, 5, 20);
            Producto producto5 = new Producto("descricion vacia", 10000, 5, 20);
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
            Operario operario2 = new Operario("operador2",21,66666,cuentaOperario2,Fabrica, 0);
            Operario operario3 = new Operario("operador3",22,77777,cuentaOperario3,Fabrica, 0);
            //se agg a la nomina
            nomina.add(operario1);
            nomina.add(operario2);
            nomina.add(operario3);
        
            //tiendas disponibles

            //se crean los empleados para las tiendas:
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
            Tienda tienda1 = new Tienda("tienda1",vendedor1,cuentaVendedor1);
            Tienda tienda2 = new Tienda("tienda2",vendedor2,cuentaVendedor2);
            Tienda tienda3 = new Tienda("tienda3",vendedor3,cuentaVendedor3);
        
            tiendas.add(tienda1);
            tiendas.add(tienda2);
            tiendas.add(tienda3);

        //cuenta bancaria para la fabrica:
        CuentaBancaria cuentaFabrica = new CuentaBancaria(00000, 1000000); //saldo = un millon

        //asignacion a los atributos de la clase:

        Fabrica.listaOperadores = nomina;
        Fabrica.listaProductos = catalogo;
        Fabrica.listaTienda = tiendas;
        CuentaBancaria = cuentaFabrica;
        cantidadProducto = 10;
    }

    //----------- Getters and Setters ----------------

    public static ArrayList<Operario> getListaOperadores() {
        return listaOperadores;
    }

    public static void setListaOperadores(ArrayList<Operario> listaOperadores) {
        Fabrica.listaOperadores = listaOperadores;
    }

    public static ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public static void setListaProductos(ArrayList<Producto> listaProductos) {
        Fabrica.listaProductos = listaProductos;
    }

    public static int getCantidadProducto() {
        return cantidadProducto;
    }

    public static void setCantidadProducto(int cantidadProducto) {
        Fabrica.cantidadProducto = cantidadProducto;
    }

    public static ArrayList<Tienda> getListaTienda() {
        return listaTienda;
    }

    public static void setListaTienda(ArrayList<Tienda> listaTienda) {
        Fabrica.listaTienda = listaTienda;
    }

    public static CuentaBancaria getCuentaBancaria() {
        return CuentaBancaria;
    }

    public static void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        CuentaBancaria = cuentaBancaria;
    }

    //toString para saber que imprimir cuando se llame al objeto Fabrica        @Override
    public String toString() {
        return "La mejor fabrica del mundo";
    }
    

    // -------------- Metodos ------------------
    
    //muestra el catalogo en pantalla
    public void mostrarProductos(){
        int i = 1;
        for (Producto producto : listaProductos) {
            System.out.println(i+" "+producto.getNombre());
            i++;
        }
    }
    //muestra las tiendas en pantalla
    public void mostrarTiendas(){
        int i = 1;
        for (Tienda tienda : listaTienda) {
            System.out.println(i+" "+tienda.getNombre());
            i++;
        }
    }
    public void PagarOperario(Fabrica fabrica, Operario operario, double monto){
        CuentaBancaria.anadirFondos(operario, monto);
        CuentaBancaria.descontarFondos(fabrica, monto);
    }
    //Enviar productos a tienda:
    //
    public void Enviarproducto(Tienda tienda,Producto producto){
        tienda.setListaCantidadProductos(map<producto,cantidadProducto>()); //aun no se muy bien como hacer esto xd
    }

    
}
