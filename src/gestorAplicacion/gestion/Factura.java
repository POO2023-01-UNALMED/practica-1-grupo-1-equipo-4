package gestorAplicacion.gestion;
import java.util.ArrayList;

import gestorAplicacion.produccion.*;

public class Factura {
    
    private Tienda tienda;
    private Cliente cliente;
    private Transporte transporte;
    private Producto producto;
    private String fecha;
    private String disclaimer;
    private int id;
    private double total;
    private static int facturasCreadas;
    private ArrayList<Factura> listaFacturas;

    // Constructor
    public Factura(Tienda tienda, Cliente cliente, Transporte transporte, Producto producto, String fecha, String disclaimer) {
        this.tienda = tienda;
        this.cliente = cliente;
        this.transporte = transporte;
        this.producto = producto;
        this.fecha = fecha;
        this.disclaimer = disclaimer;
        
        this.total = calcularTotal();
        this.listaFacturas = new ArrayList<>();

        this.id = ++facturasCreadas;
    }

    private double calcularTarifaEnvio(){

        double precioEnvio = transporte.getTipo().precioEnvio;

        return producto.getPeso() * producto.getTamano() + precioEnvio;

    }

    public double calcularTotal(){

        return producto.getValor() + calcularTarifaEnvio();
    }

    public void generarFactura(){

        listaFacturas.add(this);
        
    }

    public String toString(){

        double tarifaEnvio = calcularTarifaEnvio();
        String tipo = transporte.getTipo().name();

        return "Descripcion del producto: " + producto.getDescripcion() + "\n"
        +      "Precio del producto: "      + producto.getValor()       + "\n"
        +      "Tipo de transporte: "       + tipo                      + "\n"
        +      "Tarifa de envio: "          + tarifaEnvio               + "\n"
        +      "Total a pagar: "            + total;  

    }

    // Getters
    public Tienda getTienda() {
        return tienda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public Producto getProducto() {
        return producto;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public int getId() {
        return id;
    }

    public double getTotal() {
        return total;
    }

    public static int getFacturasCreadas() {
        return facturasCreadas;
    }
    
    public ArrayList<Factura> getListaFacturas() {
        return listaFacturas;
    }
    

    // Setters
    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setListaFacturas(ArrayList<Factura> listaFacturas) {
        this.listaFacturas = listaFacturas;
    }

  
}
