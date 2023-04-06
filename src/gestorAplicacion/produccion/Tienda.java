package gestorAplicacion.produccion;
import gestorAplicacion.gestion.CuentaBancaria;
import gestorAplicacion.gestion.Vendedor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Tienda {

    //Atributos
    private String nombre;
    private Vendedor vendedor;
    private CuentaBancaria cuenta;
    private ArrayList<Producto> listaProductos; 
    private Map<Producto, Integer> listaCantidadProductos; 
    
    //Constructor que recibe solo nombre, vendedor y cuenta 
    public Tienda(String nombre,Vendedor vendedor,CuentaBancaria cuenta){
        this.nombre = nombre;
        this.vendedor = vendedor;
        this.cuenta = cuenta;
        this.listaProductos = new ArrayList<Producto>();
        this.listaCantidadProductos = new HashMap<Producto, Integer>();
    }

    //Constructor que recibe todos los parametros
    public Tienda(String nombre, Vendedor vendedor, CuentaBancaria cuenta, ArrayList<Producto> listaProductos, Map<Producto,Integer> listaCantidadProductos) {
        this.nombre = nombre;
        this.vendedor = vendedor;
        this.cuenta = cuenta;
        this.listaProductos = listaProductos;
        this.listaCantidadProductos = listaCantidadProductos;
    }
    
    //Métodos

    
    //Get and Set
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Vendedor getVendedor() {
        return this.vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public CuentaBancaria getCuentaBancaria() {
        return this.cuenta;
    }

    public void setCuenta(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }

    public ArrayList<Producto> getListaProductos() {
        return this.listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Map<Producto,Integer> getListaCantidadProductos() {
        return this.listaCantidadProductos;
    }

    public void setListaCantidadProductos(Map<Producto,Integer> listaCantidadProductos) {
        this.listaCantidadProductos = listaCantidadProductos;
    }

}
