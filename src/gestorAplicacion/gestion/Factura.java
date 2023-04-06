package gestorAplicacion.gestion;
import gestorAplicacion.produccion.*;

public class Factura {
    
    private Tienda tienda;
    private Transporte transporte;
    private Producto producto;
    private String fecha;
    private String disclaimer;
    private int id;
    private double total;
    private static int facturasCreadas;

    // Constructor
    public Factura(Tienda tienda, Transporte transporte, Producto producto, String fecha, String disclaimer, double total) {
        this.tienda = tienda;
        this.transporte = transporte;
        this.producto = producto;
        this.fecha = fecha;
        this.disclaimer = disclaimer;
        this.total = total;
        this.id = ++facturasCreadas;
    }

    private double calcularTarifaEnvio(){

        double precioEnvio = transporte.getTipo().precioEnvio;

        return producto.getPeso() * producto.getTamano() + precioEnvio;

    }

    public double calcularTotal(){

        return producto.getValor() + calcularTarifaEnvio();
    }

    public String generarFactura(){

        double tarifaEnvio = calcularTarifaEnvio();
        double total = calcularTotal();
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

    public Transporte getTransporte() {
        return transporte;
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

    // Setters
    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
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
}
