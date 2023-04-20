package gestorAplicacion.produccion;
import gestorAplicacion.gestion.Cliente;
import gestorAplicacion.gestion.CuentaBancaria;
import gestorAplicacion.gestion.Financiero;
import gestorAplicacion.gestion.Vendedor;
import gestorAplicacion.gestion.Factura;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Tienda implements Financiero{

    //Atributos
    private String nombre;
    private Vendedor vendedor;
    private CuentaBancaria cuentaBancaria;
    private ArrayList<Producto> listaProductos; 
    private Map<Producto, Integer> listaCantidadProductos;
    private static int numTiendas=0; 
    
    //Constructor
    public Tienda(String nombre,Vendedor vendedor,CuentaBancaria cuentaBancaria){
        this.nombre = nombre;
        this.vendedor = vendedor;
        this.cuentaBancaria = cuentaBancaria;
        this.listaCantidadProductos = new HashMap<Producto, Integer>();
        numTiendas++;
    }

    public Tienda(){
        
    }
   
    //Métodos
    public void mostrarProductos() {
        for (int i=0;i<listaProductos.size();i++) {
            listaProductos.get(i).toString();
        }
    }

    public void elegirTransporte(Producto producto){
        for(int i=0; i<TipoTransporte.values().length; i++) {
			if (TipoTransporte.values()[i].getCapacidadMax()<=producto.getPeso()){
                TipoTransporte.values()[i].toString();
            }
        }
    }

    public Factura enviarPedido(Producto producto, Transporte transporte, Cliente cliente, int dia){
        listaCantidadProductos.put(producto, listaCantidadProductos.get(producto)-1);
        Factura factura = new Factura(this,cliente,transporte,producto,dia,"DISCLAIMER");
        return factura;
    }

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
        return this.cuentaBancaria;
    }

    public void setCuenta(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
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

    public static int getNumTiendas(){
        return numTiendas;
    }
}
