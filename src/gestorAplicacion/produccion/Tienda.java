package gestorAplicacion.produccion;
import gestorAplicacion.gestion.Cliente;
import gestorAplicacion.gestion.CuentaBancaria;
import gestorAplicacion.gestion.Vendedor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Tienda {

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
        this.listaProductos = new ArrayList<Producto>(); //<--- borrar y todo lo que conlleve con este atributo.
        this.listaCantidadProductos = new HashMap<Producto, Integer>();
        numTiendas++;
    }
   
    //Métodos
    public void mostrarProductos() {
        for (int i=0;i<listaProductos.size();i++) {
            listaProductos.get(i).toString();
        }
    }

    public String generarPedido(Producto producto, Transporte transporte, Cliente cliente){
        if(listaProductos.contains(producto)){ //Cambiar
            if(cliente.getCuentaBancaria().getSaldo()>=producto.getValor()){
                //Pedido pedido = new Pedido(producto,transporte,cliente);
                listaCantidadProductos.put(producto, listaCantidadProductos.get(producto) - 1);
                return "Pedido realizado con exito";
            }else{
                return "Error al realizar el pedido, el cliente no tiene saldo suficiente para comprar el producto";
            }
        }else{
            return "Error al realizar el pedido, el producto que seleccionaste no está disponible";
        }

    }

    @Override
    public String toString() {
        return "Nombre: "              + nombre           + "\n"
        +      "Vendedor: "            + vendedor;
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
