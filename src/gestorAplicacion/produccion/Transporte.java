package gestorAplicacion.produccion;

import java.io.Serializable;
import java.util.ArrayList;
import gestorAplicacion.gestion.Moda;


import gestorAplicacion.gestion.Conductor;

public class Transporte implements Moda, Serializable{
    //Atributos   

    private TipoTransporte tipo; 
    private Double capacidad; 
    private double costo;
    private Conductor conductor;
    private ArrayList<TipoTransporte> listaTransportes;
    
    private static final long serialVersionUID = 12387137L; 
     

    double precioOriginalTransporte;
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
    /*
     * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Abastecer
     * 
     * RECIBE: 
     * tienda: Objeto tienda a la cual van a llegar los productos.
     * listaDeProductos: La lista de productos que se van a enviar.
     * 
     * DEVUELVE:
     * Nada.
     * 
     * DESCRIPCIÓN:
     * Este método carga los productos en el transporte y asigna a la tienda a la que va a mandar los productos
     */

    public void abastecerProducto(Tienda tienda, ArrayList<Producto> listaDeProductos){
        this.setTienda(tienda);
        this.setListaDeProductos(listaDeProductos);
    }


        //MetodoMostrarTipoTransporte
        //muestra todos los tipos de transporte, su precio y su capacidadMax

        public static void MostrarTipoTransporte(String[] args) {
            TipoTransporte[] tipoTransportes = TipoTransporte.values();
            for (int i = 0; i < tipoTransportes.length; i++) {
                System.out.println(tipoTransportes[i]);
        }

    }
    //metodo para nombre, precio y capacidad de algún tipo de transporte
    public String TipoTransporte(TipoTransporte tipoTransporte) {
        String TextoTipoTransporte = ("Tipo de transporte: " + tipoTransporte.name() + 
        "Precio: " + tipoTransporte.getPrecioEnvio() + 
        "Capacidad máxima: " + tipoTransporte.getCapacidadMax());

        return TextoTipoTransporte;
    }


      /*
     * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: EnviarPedido
     * 
     * RECIBE: 
     * objeto de transporte
     * 
     * DEVUELVE:
     * objeto de transporte
     * 
     * DESCRIPCIÓN:
     * Le cambia al objeto de transporte el precio de envío a 0
     * Con esto se da envío gratis
     */


    public static Transporte enviarGratis(Transporte transporteSeleccionado, double precioTrans){
        transporteSeleccionado.getTipo().setPrecioEnvio(precioTrans);
        return transporteSeleccionado;

    }


     //Getters y setters 


     //de la interfaz Moda
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
    


}

