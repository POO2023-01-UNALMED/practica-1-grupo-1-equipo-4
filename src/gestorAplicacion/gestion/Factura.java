package gestorAplicacion.gestion;
import java.util.*;

import gestorAplicacion.produccion.*;

public class Factura {
    
    private Tienda tienda;
    private Cliente cliente;
    private Transporte transporte;
    private Producto producto;
    private int fecha;
    private String disclaimer;
    private int id;
    private double total;
    private static int facturasCreadas;
    private ArrayList<Factura> listaFacturas = new ArrayList<Factura>();

    // Constructor
    public Factura(Tienda tienda, Cliente cliente, Transporte transporte, Producto producto, int fecha, String disclaimer) {
        this.tienda = tienda;
        this.cliente = cliente;
        this.transporte = transporte;
        this.producto = producto;
        this.fecha = fecha;
        this.disclaimer = disclaimer;
        
        this.total = calcularTotal();
        listaFacturas.add(this);

        this.id = ++facturasCreadas;
    }

    private double calcularTarifaEnvio(){

        double precioEnvio = transporte.getTipo().precioEnvio;

        return producto.getPeso() * producto.getTamano() + precioEnvio;

    }

    public double calcularTotal(){

        return producto.getValor() + calcularTarifaEnvio();
    }

    public ArrayList<Factura> getFacturasEntreFechas(int fecha1, int fecha2){

            ArrayList<Factura> facturasEntreFechas= new ArrayList<Factura>();
            

            for(Factura factura: this.listaFacturas){
                if(factura.fecha >= fecha1 && factura.fecha <= fecha2)
                    facturasEntreFechas.add(factura); 
            }

            return facturasEntreFechas;
    }

    public ArrayList<Integer> getListaFechas(int fecha1, int fecha2){

        ArrayList<Integer> listaFechas = new ArrayList<Integer>();
        

        for(Factura factura: this.listaFacturas){
            if(factura.fecha >= fecha1 && factura.fecha <= fecha2 && !listaFechas.contains(factura.fecha))
                listaFechas.add(factura.fecha);
        }

        return listaFechas;
}

    public HashMap<Integer, Double> gananciasDiscretas(ArrayList<Integer> fechas){

        int fecha1 = fechas.get(0);
        int fecha2 = fechas.get(fechas.size() - 1);

        ArrayList<Factura> facturas = getFacturasEntreFechas(fecha1, fecha2); 

        HashMap<Integer, Double> dictGananciasDiscretas = new HashMap<Integer, Double>();

        for(int fecha: fechas)
            dictGananciasDiscretas.put(fecha, 0.0);

        for(int fecha: dictGananciasDiscretas.keySet()){

            for(Factura factura: facturas){

                if(factura.fecha == fecha){

                    double valorAnterior = dictGananciasDiscretas.get(fecha);

                    dictGananciasDiscretas.put(fecha, valorAnterior + factura.getTotal());
                }
            }
        } 

        return dictGananciasDiscretas;

    }


    public HashMap<Integer, Double> gananciasDiscretas(int fecha1, int fecha2){

        ArrayList<Integer> fechas = getListaFechas(fecha1, fecha2);

        return gananciasDiscretas(fechas);

    }

public double gananciasTotales(int fecha1, int fecha2){

    HashMap<Integer, Double> dictGananciasDiscretas = gananciasDiscretas(fecha1, fecha2);

    return gananciasTotales(dictGananciasDiscretas);

}

public double gananciasTotales(HashMap<Integer, Double> dictGananciasDiscretas){

    double suma = 0;

    for(int fecha: dictGananciasDiscretas.keySet()){
        suma += dictGananciasDiscretas.get(fecha);
    }

    return suma;

}

public double promedioPorDia(double gananciasTotales, int numFechas){

    return gananciasTotales / numFechas;

} 

public double promedioPorDia(int fecha1, int fecha2){

    Double gananciasTotales = gananciasTotales(fecha1, fecha2);

    int numFechas = gananciasDiscretas(fecha1, fecha2).size();

    return promedioPorDia(gananciasTotales, numFechas);

}

public HashMap<Integer, Double> aumentoPorcentual(HashMap<Integer, Double> dictGananciasDiscretas){

    ArrayList<Integer> fechas = new ArrayList<Integer>(dictGananciasDiscretas.keySet());

    Collections.sort(fechas);

    HashMap<Integer, Double> dictAumentoPorcentual = new HashMap<Integer, Double>();

    for(int i = 1; i < fechas.size(); i++){

        double valorActual = dictGananciasDiscretas.get(fechas.get(i));
        double valorAnterior = dictGananciasDiscretas.get(fechas.get(i - 1));

        double porcentaje = ((valorActual - valorAnterior) / valorAnterior) * 100;

        dictAumentoPorcentual.put(fechas.get(i), porcentaje);
    }
   
    return dictAumentoPorcentual;

}

public HashMap<Integer, Double> aumentoPorcentual(int fecha1, int fecha2){

    HashMap<Integer, Double> dictGananciasDiscretas = gananciasDiscretas(fecha1, fecha2);

    return aumentoPorcentual(dictGananciasDiscretas);

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

    public int getFecha() {
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

    public void setFecha(int fecha) {
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
