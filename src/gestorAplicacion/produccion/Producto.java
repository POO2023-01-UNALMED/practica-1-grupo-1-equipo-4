package gestorAplicacion.produccion;
import gestorAplicacion.gestion.Factura;

public class Producto {
    
    //Atributos
    //private String nombre; agg esto  ByLuis*
    private String descripcion;
    private Double valor;
    private Double peso;
    private Double tamano;
    private Factura factura; // <-- esto hay que borrarlo ByLuis*

    //Constructor *RECUERDE QUE AL AGG EL ATRIBUTO NOMBRE DEBE INCLUIRLO EN EL CONSTRUCTOR Y QUITAR EL DE FACTURA ByLuis* tambien recuerde los setter y getters
    public Producto(String descripcion, Double valor, Double peso, Double tamano, Factura factura) {
        this.descripcion = descripcion;
        this.valor = valor;
        this.peso = peso;
        this.tamano = tamano;
        this.factura = factura;
    }

    //Métodos


    //Get and Set
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getValor() {
        return this.valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getPeso() {
        return this.peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getTamano() {
        return this.tamano;
    }

    public void setTamano(Double tamano) {
        this.tamano = tamano;
    }

    public Factura getFactura() {
        return this.factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }



    
}
