package gestorAplicacion.produccion;
import gestorAplicacion.gestion.CuentaBancaria;
import java.util.ArrayList;

public class Fabrica {

    private static ArrayList<Operario> listaOperadores;
    private static ArrayList<Producto> listaProductos;
    private static int cantidadProducto;
    private static ArrayList<Tienda> listaTienda;
    private static CuentaBancaria CuentaBancaria;

    //----------metodo estatico para generar el catalogo de prodcutos disponibles y los empleados-------------

    static{ //NOTA: AÚN NO SE SI ESTO VA ACA EN UN METODO ESTATICO O DENTRO DEL CONSTRUCTOR
    //productos disponibles en las fabricas:
    ArrayList<Producto> catalogo = new ArrayList<Producto>();
    Producto producto1 = new Producto("descricion vacia", 10000, 5, 20, null);
    Producto producto2 = new Producto("descricion vacia", 10000, 5, 20, null);
    Producto producto3 = new Producto("descricion vacia", 10000, 5, 20, null);
    Producto producto4 = new Producto("descricion vacia", 10000, 5, 20, null);
    Producto producto5 = new Producto("descricion vacia", 10000, 5, 20, null);
    //se agregan al catalogo
    catalogo.add(producto1);
    catalogo.add(producto2);
    catalogo.add(producto3);
    catalogo.add(producto4);
    catalogo.add(producto5);

    //empleados de la fabrica:
    ArrayList<Operario> nomina = new ArrayList<Operario>();
    Operario operario1 = new operario("no se cuantos parametros lleve la clase operario","","");
    Operario operario2 = new operario("no se cuantos parametros lleve la clase operario","","");
    Operario operario3 = new operario("no se cuantos parametros lleve la clase operario","","");

    nomina.add(operario1);
    nomina.add(operario2);
    nomina.add(operario3);

    //tiendas disponibles
    ArrayList<Tienda> tiendas = new ArrayList<Tienda>();
    Tienda tienda1 = new Tienda("tienda1",Vendedor vendedor,CuentaBancaria cuentaBancaria);
    Tienda tienda2 = new Tienda("tienda2",Vendedor vendedor,CuentaBancaria cuentaBancaria);
    Tienda tienda3 = new Tienda("tienda2",Vendedor vendedor,CuentaBancaria cuentaBancaria);

    tiendas.add(tienda1);
    tiendas.add(tienda2);
    tiendas.add(tienda3);

}
    // ------------- constructor -------------
    public Fabrica(ArrayList<Tienda> listaTienda, CuentaBancaria cuentaBancaria) {
        this.listaTrabajadores = nomina;
        Fabrica.listaProductos = catalogo;
        Fabrica.listaTienda = tiendas;
        CuentaBancaria = cuentaBancaria;
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
    public void mostrarCatalogo(){
        int i = 1;
        for (Producto producto : catalogo) {
            print(i+" "+producto.getNombre());
            i++;
        }
    }

    //Enviar productos a tienda:



    
}
