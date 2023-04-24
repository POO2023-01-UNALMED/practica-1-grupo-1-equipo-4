package gestorAplicacion.produccion;

import java.util.ArrayList;
import gestorAplicacion.gestion.Moda;


import gestorAplicacion.gestion.Conductor;

public class Transporte implements Moda {
    //Atributos

    private TipoTransporte tipo; 
    private Double capacidad; 
    private double costo;
    private Conductor conductor;
    private ArrayList<TipoTransporte> listaTransportes;
    
     
    //Atributos creados por Jaider
    private Tienda tienda;
    private ArrayList<Producto> listaDeProductos;


        //Constructor que recibe todos los parametros 



    public Transporte(TipoTransporte tipo, Double capacidad, double costo, Conductor conductor) {
        this.conductor = conductor;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.costo = costo;
      
}
        //Métodos 

        //MetodoMostrarTipoTransporte
        //muestra todos los tipos de transporte, su precio y su capacidadMax

        public static void MostrarTipoTransporte(String[] args) {
            TipoTransporte[] tipoTransportes = TipoTransporte.values();
            for (int i = 0; i < tipoTransportes.length; i++) {
                System.out.println(tipoTransportes[i]);
        }

    }
    //metodo para imprimir nombre, precio y capacidad de algún tipo de transporte
    public void imprimirTipoTransporte(TipoTransporte tipoTransporte) {
        System.out.println("Tipo de transporte: " + tipoTransporte.name());
        System.out.println("Precio: " + tipoTransporte.getPrecioEnvio());
        System.out.println("Capacidad máxima: " + tipoTransporte.getCapacidadMax());
    }

     //Getters y setters 

     public String getNombre(){
        return tipo.getNombre();
     }
    //para tipo
     public TipoTransporte getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransporte tipo) {
        this.tipo = tipo;
    }
    //para capacidad
    public Double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Double capacidad) {
        this.capacidad = capacidad;
    }
    //para costo 
    public double getCosto() {
        return costo;
    }

    public void setCosto (double costo) {
        this.costo = costo;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public ArrayList<Producto> getListaDeProductos() {
        return listaDeProductos;
    }

    public void setListaDeProductos(ArrayList<Producto> listaDeProductos) {
        this.listaDeProductos = listaDeProductos;
    }
    public ArrayList<TipoTransporte> getListaTransportes() {
        return listaTransportes;
    }

    public void setListaTransportes(ArrayList<TipoTransporte> listaTransportes) {
        this.listaTransportes = listaTransportes;
    }
    

    // -------------- Metodos ------------------
    public int abastecerProducto(Tienda tienda, ArrayList<Producto> listaDeProductos){
        this.setTienda(tienda);
        this.setListaDeProductos(listaDeProductos);
        int gastos = 0;
        for(Producto producto:listaDeProductos){
            gastos+=producto.getCostoDeProduccion();
        }
        gastos += tipo.getPrecioEnvio();
        return gastos;
    }


}

