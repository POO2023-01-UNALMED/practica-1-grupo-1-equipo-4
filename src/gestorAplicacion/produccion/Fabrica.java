package gestorAplicacion.produccion;
import gestorAplicacion.gestion.CuentaBancaria;
import java.util.ArrayList;

public class Fabrica {

    private ArrayList<Trabajador> listaTrabajadores;
    private ArrayList<Producto> listaProductos;
    private static int cantidadProducto;
    private ArrayList<Tienda> listaTienda;
    private CuentaBancaria CuentaBancaria;


    // ------------- constructor -------------
    public Fabrica(ArrayList<Trabajador> listaTrabajadores, ArrayList<Producto> listaProductos,
            ArrayList<Tienda> listaTienda, gestorAplicacion.produccion.CuentaBancaria cuentaBancaria) {
        this.listaTrabajadores = listaTrabajadores;
        this.listaProductos = listaProductos;
        this.listaTienda = listaTienda;
        CuentaBancaria = cuentaBancaria;
    }

    //----------- Getters and Setters ----------------

    public ArrayList<Trabajador> getListaTrabajadores() {
        return listaTrabajadores;
    }

    public void setListaTrabajadores(ArrayList<Trabajador> listaTrabajadores) {
        this.listaTrabajadores = listaTrabajadores;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public ArrayList<Tienda> getListaTienda() {
        return listaTienda;
    }

    public void setListaTienda(ArrayList<Tienda> listaTienda) {
        this.listaTienda = listaTienda;
    }

    public CuentaBancaria getCuentaBancaria() {
        return CuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        CuentaBancaria = cuentaBancaria;
    }

    public static int getCantidadProducto() {
        return cantidadProducto;
    }

    public static void setCantidadProducto(int cantidadProducto) {
        Fabrica.cantidadProducto = cantidadProducto;
    }

    //toString para saber que imprimir cuando se llame al objeto Fabrica
    @Override
    public String toString() {
        return "La mejor fabrica del mundo";
    }

    // -------------- Metodos ------------------
    
    

    
}
