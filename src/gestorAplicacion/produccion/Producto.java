package gestorAplicacion.produccion;
import java.util.ArrayList;

public class Producto {
    
    //Atributos
    private String nombre;
    private String descripcion;
    private double valor;
    private double peso;
    private double tamano;
    private double costoDeProduccion;
    private static int numProductos = 0;
    private static ArrayList<Producto> listaProductos = new ArrayList<Producto>();
    private boolean devuelto;

    //Constructor

    public Producto(String nombre, String descripcion, double valor, double peso, double tamano, double costoDeProduccion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valor = valor;
        this.peso = peso;
        this.tamano = tamano;
        this.costoDeProduccion = costoDeProduccion;
        numProductos++;
        listaProductos.add(this);
        this.devuelto = false;
    }
   
    //Métodos
    @Override
    public String toString() {
        return "\nNombre: "              + nombre           + "\n"
        +      "Descripción: "         + descripcion      + "\n"
        +      "Valor: "               + valor            + "\n"
        +      "Peso: "                + peso             + "\n"
        +      "Tamaño: "              + tamano           + "\n"
        +      "Costo de produccion: " + costoDeProduccion+ "\n";
    }


    //Get and Set
    public String getNombre() {
        return this.nombre;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

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

    public Double getCostoDeProduccion() {
        return this.costoDeProduccion;
    }

    public void setCostoDeProduccion(Double costoDeProduccion) {
        this.costoDeProduccion = costoDeProduccion;
    }

    public static int getNumProductos(){
        return numProductos;
    }

    public static ArrayList<Producto> getListaProductos(){
        return listaProductos;
    }

    



    
}
