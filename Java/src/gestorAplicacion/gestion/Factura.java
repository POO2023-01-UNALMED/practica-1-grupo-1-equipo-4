/*Autores: Joan Sebastian Salazar Montoya, Monica Sofia Restrepo León, 
Luis Alejandro Varela Ojeda, Maria Fernanda Calle Agudelo, Jaider Castañeda Villa
 * FUNCIONALIDAD DE LA CLASE: La clase Factura representa una factura de una compra realizada en una tienda virtual.
Contiene información sobre la tienda, el cliente, el transporte, la lista de productos, la fecha de compra y un disclaimer opcional.

La clase ofrece métodos para calcular el total de la factura, obtener una lista de facturas entre dos fechas, obtener la fecha más reciente de todas las facturas,
obtener la moda de un atributo en un rango de fechas y obtener las ganancias totales en un rango de fechas.

También cuenta con métodos auxiliares para calcular la tarifa de envío y obtener una lista de fechas de todas las facturas.

Además, la clase mantiene una lista estática de todas las facturas creadas y asigna un id único a cada factura.
 */

package gestorAplicacion.gestion;
import java.io.Serializable;
import java.util.*;
import java.util.Map.Entry;

import baseDatos.*;
import gestorAplicacion.produccion.*;


public class Factura implements Serializable {
   
    private static final long serialVersionUID = 1L;    

    private Tienda tienda;
    private Cliente cliente;
    private Transporte transporte;
    private ArrayList<Producto> listaProductos = new ArrayList<Producto>();
    private int fecha;
    private String disclaimer;
    private int id;
    private double total;
    private static int facturasCreadas;
    private Operario operario;

    private static ArrayList<Factura> listaFacturas = new ArrayList<Factura>();
    private static HashMap<String, Moda> infoAtributos = new HashMap<String,Moda>();

        
/*Constructor de la clase Factura, el cual crea una nueva instancia de Factura con los parámetros ingresados y
    realiza diferentes operaciones para inicializar los atributos y agregar la factura a la lista de facturas creadas.
*
* ENTRADA: Tienda tienda, Cliente cliente, Transporte transporte, ArrayList<Producto> listaProductos, int fecha, String disclaimer. Representan los diferentes atributos que conforman una factura.
*/
    

    public Factura(Tienda tienda, Cliente cliente, Transporte transporte, ArrayList<Producto> listaProductos,
                     int fecha, String disclaimer, Operario operario) {
        this.tienda = tienda;
        this.cliente = cliente;
        this.transporte = transporte;
        this.listaProductos = listaProductos;
        this.fecha = fecha;
        this.disclaimer = disclaimer;
        this.operario = operario;

        infoAtributos.put("tienda", tienda);
        infoAtributos.put("transporte", transporte);
        infoAtributos.put("cliente", cliente);

        
        this.total = calcularTotal();
        listaFacturas.add(this);

        this.id = ++facturasCreadas;
    }


    public Factura(Tienda tienda, Cliente cliente, Transporte transporte, ArrayList<Producto> listaProductos,
                     int fecha, Operario operario) {
        this(tienda, cliente, transporte, listaProductos, fecha, "SIN DISCLAIMER",operario);
    }



/* Este método permite calcular la tarifa de envío de una factura a partir del tipo de transporte seleccionado.
*
* ENTRADA: No tiene parámetros de entrada.
* SALIDA: Double que representa el precio de la tarifa de envío.
*/

    private double calcularTarifaEnvio(){

        double precioEnvio = transporte.getTipo().precioEnvio;

        return precioEnvio;
    }



/* Este método permite calcular el total de una factura sumando el precio de los productos y la tarifa de envío.
*
* ENTRADA: No tiene parámetros de entrada.
* SALIDA: Double que representa el total de la factura.
*/
    public double calcularTotal(){

        double totalParcial = 0;
        for(int i=0; i<listaProductos.size(); i++){
            double precioProducto = listaProductos.get(i).getValor();
            totalParcial+=precioProducto;
        }

        return totalParcial + calcularTarifaEnvio();
    }



    /* FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Estádisticas
     * 
     * ENTRADA: Dos enteros fecha1 y fecha2 que corresponden a la fecha de inicio y final (inclusivo) respectivamente
     * SALIDA: ArrayList de objetos de clase Factura, con las facturas que tengan fecha entre fecha1 y fecha2
     * 
     * DESCRIPCIÓN: Permite obtener una lista de facturas entre dos fechas ingresadas por parámetro
     */

    private static ArrayList<Factura> getFacturasEntreFechas(int fecha1, int fecha2){

            ArrayList<Factura> facturasEntreFechas= new ArrayList<Factura>();
            

            for(Factura factura: listaFacturas){
                if(factura.fecha >= fecha1 && factura.fecha <= fecha2)
                    facturasEntreFechas.add(factura); 
            }

            return facturasEntreFechas;
    }

    


/* FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Estadísticas
*
* ENTRADA: ninguna
* SALIDA: ArrayList de enteros, con todas las fechas de las facturas en listaFacturas

DESCRIPCIÓN: Permite obtener una lista de fechas únicas de las facturas existentes en la listaFacturas
*/
    public static ArrayList<Integer> getListaFechas(int fecha1, int fecha2){

        ArrayList<Integer> listaFechas = new ArrayList<Integer>();
        

        for(Factura factura: listaFacturas){
            if(factura.fecha >= fecha1 && factura.fecha <= fecha2 && !listaFechas.contains(factura.fecha))
                listaFechas.add(factura.fecha);
        }

        return listaFechas;
}




/* FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Estadística 
*
* ENTRADA: No tiene parámetros de entrada.
* SALIDA: ArrayList de enteros que contiene todas las fechas presentes en las facturas.

  DESCRIPCIÓN: Este método permite obtener una lista de todas las fechas presentes en las facturas.
*/
    public static ArrayList<Integer> getListaFechas(){

        ArrayList<Integer> listaFechas = new ArrayList<Integer>();
        
        for(Factura factura: listaFacturas){
            if(!listaFechas.contains(factura.fecha))
                listaFechas.add(factura.fecha);
        }

        return listaFechas;
    }



    /*FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Estadística  
*
* ENTRADA: Dos enteros que especifican el rango de fechas para las cuales se quieren conocer las ganancias
* SALIDA: HashMap que asocia cada fecha con su ganancia correspondiente

    DESCRIPCIÓN: Permite obtener un HashMap que contiene las ganancias de cada fecha en el ArrayList ingresado por parámetro
*/

public static HashMap<Integer, Double> gananciasDiscretas(int fecha1, int fecha2){

    ArrayList<Integer> fechas = getListaFechas(fecha1, fecha2);

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

   /*FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Estadística  
*
* ENTRADA: Lista con las fechas entre las cuales se quiere obtener las ganancias discretas
* SALIDA: HashMap que asocia cada fecha con su ganancia correspondiente

    DESCRIPCIÓN: Permite obtener un HashMap que contiene las ganancias de cada fecha en el ArrayList ingresado por parámetro
*/

public static HashMap<Integer, Double> gananciasDiscretas(ArrayList<Integer> fechas){

    
    int fecha1 = Collections.min(fechas);
    int fecha2 = Collections.max(fechas);


    return gananciasDiscretas(fecha1, fecha2);
}




/* FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Estadística  
*
* ENTRADA: Diccionario que relaciona una fecha (entero) con una ganancia (doble).
* SALIDA: Double que representa el total de las ganancias a partir del diccionario de ganancias discretas.

  DESCRIPCIÓN: Este método permite obtener el total de las ganancias a partir de un diccionario que contiene las ganancias por fecha.
*/

public static double gananciasTotales(HashMap<Integer, Double> dictGananciasDiscretas){

    double suma = 0;

    for(int fecha: dictGananciasDiscretas.keySet()){
        suma += dictGananciasDiscretas.get(fecha);
    }

    return suma;

}

/* FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Estadística  
*
* ENTRADA: Diccionario de ganancias discretas.
* SALIDA: Double que representa el promedio de las ganancias por día a partir del diccionario de ganancias discretas.

  DESCRIPCIÓN: Este método permite obtener el promedio de las ganancias por día a partir de un diccionario que contiene las ganancias por fecha.
*/


public static double promedioPorDia(HashMap<Integer, Double> dictGananciasDiscretas){

    return gananciasTotales(dictGananciasDiscretas) / dictGananciasDiscretas.size();

} 

/* FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Estadística  
*
* ENTRADA: Diccionario de ganancias discretas.
* SALIDA: Diccionario con aumentos porcentuales respecto al día anterior

  DESCRIPCIÓN: Este método permite obtener el aumento relativo, en porcentaje, de cada fecha con respecto a la fecha anterior*/

public static HashMap<Integer, Double> aumentoPorcentual(HashMap<Integer, Double> dictGananciasDiscretas){

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


/* FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Estadística  
*
* ENTRADA: Lista de elementos genéricos (List<T>)
* SALIDA: Elemento más común en la lista

  DESCRIPCIÓN:Este método permite obtener el elemento más común dentro de una lista de elementos genéricos. El elemento más común es aquel que aparece con mayor frecuencia en la lista. Si hay varios elementos que cumplen con esa condición, el método devuelve el primero que se encuentra al recorrer la lista.
*/


private static <T> T masComun(List<T> list) {
    Map<T, Integer> map = new HashMap<>();

    for (T t : list) {
        Integer val = map.get(t);
        map.put(t, val == null ? 1 : val + 1);
    }

    Entry<T, Integer> max = null;

    for (Entry<T, Integer> e : map.entrySet()) {
        if (max == null || e.getValue() > max.getValue())
            max = e;
    }

    return max.getKey();
}


/* FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Estadística   
*
* ENTRADA: Dos enteros fecha1 y fecha2 que corresponden a la fecha de inicio y final (inclusivo) respectivamente. Un string atributo que representa el atributo del cual se quiere obtener la moda.
* SALIDA: Objeto Moda que representa el valor más común del atributo entre las facturas del período.

  DESCRIPCIÓN: Este método permite obtener la moda de un atributo específico de las facturas entre dos fechas dadas.
*/

public static Moda moda(int fecha1, int fecha2, String atributo){

    ArrayList<Factura> facturas = Factura.getFacturasEntreFechas(fecha1, fecha2);

    ArrayList<Moda> objetos = new ArrayList<Moda>(); 

    for(Factura factura: facturas){

        objetos.add(factura.getAtributos().get(atributo));
    }

    return Factura.masComun(objetos);
}



/* FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Estadística   
*
* ENTRADA: No tiene parámetros de entrada.
* SALIDA: Entero que representa la fecha más grande de la lista de fechas.

DESCRIPCIÓN: Este método permite obtener la fecha más grande de una lista de fechas.
*/
public static int getFechaMax(){

    return Collections.max(getListaFechas());

}



/* FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Estadística   
*
* ENTRADA: No tiene parámetros de entrada.
* SALIDA: Entero que representa la fecha menor de la lista de fechas.

  DESCRIPCIÓN: Este método permite obtener la fecha menor de una lista de fechas.
*/
public static int getFechaMin(){

    return Collections.min(getListaFechas());

}



//------muestra las faturas que hay en pantalla ------
/*
     * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Devoluciones
     * 
     * RECIBE: Vacío, no tiene parámetro para recibir
     * DEVUELVE: String llamado "textoFactura "
     * 
     * DESCRIPCIÓN:
     * Recorre la lista de facturas de la clase Factura y 
     * va generando un texto que muestra un índice, ID y nombre del 
     * cliente de cada factura en un formato específico
     */
public static String mostrarFacturas(){
    String textoFactura="";
    int indice = 1;
    for(Factura factura:listaFacturas) {
            textoFactura += indice+". "+" Cliente: "+factura.getCliente().getNombre()+"\n"; //se almacenan todos lo ID's de las facturas en un string
            indice++;
  
    }
    return textoFactura;
}
    /*
     * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Devoluciones
     * 
     * RECIBE: int opcion (entero), entra por consola en la funcionalidad
     * DEVUELVE: Objeto de la clase Factura llamado facturaSeleccionada, es el que 
     * elige el usuario
     * 
     * DESCRIPCIÓN: Se obtiene la factura seleccionada de la lista de facturas listaFacturas 
     * utilizando el método get() y pasando el valor de opcion-1.
     *  (Se resta 1 a opcion porque los índices de la lista comienzan desde 0.)
        Se le asigna el nombre facturaSeleccionada.
        Se devuelve facturaSeleccionada.
     */
    public static Factura seleccionarFactura(int opcion) {
		
        Factura facturaSeleccionada = listaFacturas.get(opcion-1);

		return facturaSeleccionada;
	}
    //---muestra los productos que hay en la factura seleccionada---
        /*
     * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Devoluciones
     * 
     * RECIBE: Un Array de objetos de tipo Producos.
     * DEVUELVE: Una cadena de texto que son los prductos que contiene la factura
     * que se ha elegido por pantalla
     * DESCRIPCIÓN: se recorren los objetos de la lista Productos y se va almacenando
     * el nombre con un indice y en caso de que ya se haya devuelto se le agg
     * justo al lado (devuelto) para hacer saber que no se puede devolver el mismo producto
     * mas de 1 vez
     */
    public static String mostrarProductosFacturas(ArrayList<Producto> productosFactura){
        String textoSalida="";
        int indice = 1;
        //se recorre la lista para obtener cada nombre de las facturas disponibles:
        for(Producto producto:productosFactura) {
            if (producto.isDevuelto()){
                textoSalida += indice+". Producto: "+producto.getNombre()+" (Devuelto)"+"\n"; //se almacenan todos lo ID's de las facturas en un string
                indice++;
            }
            else {
                textoSalida += indice+". Producto: "+producto.getNombre()+"\n"; //se almacenan todos lo ID's de las facturas en un string
                indice++;                
            }
        }
        return textoSalida;
    }



    /*
     * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Devoluciones
     * 
     * RECIBE: un entero llamado opcion, es el índice seleccionado por el usuario para elegir un producto a devolver.
     * DEVUELVE: objeto de tipo Producto, que es el producto seleccionado por el usuario para devolver.
     * 
     * DESCRIPCIÓN: verifica si la opción es válida, selecciona el producto correspondiente a esa opción de la lista de productos
     * (con opcion-1 dado a los índices de las listas)
     * devuelve el objeto como resultado. 
     * En caso de que la opción sea 0, en la funcionalidad se devuelve del menú, 
     * en este método se elige un producto predeterminado para que devuelva algo
     * ya que en el siguiente paso se hace la comprobacion de si ese objeto está en
     * la lista o no, esto con el fin de que el programa no tenga un error.
     */
    public Producto seleccionarProcutoDevolver(int opcion) {
        Producto productoSeleccionado = null; 
		if ((0< opcion)&& (opcion<=listaProductos.size())){
        productoSeleccionado = listaProductos.get(opcion-1);
        }
        else{ //esta condicion es solo para que no de error al seleccionar la op 0  del menu para devolverse.
           productoSeleccionado = listaProductos.get(1);
        }
		return productoSeleccionado;
	}



    public String toString(){

        double tarifaEnvio = calcularTarifaEnvio();
        String tipo = transporte.getTipo().name();

        String textoProductos = "";
        for(int i=0; i<listaProductos.size(); i++){
            textoProductos += "Nombre del producto: " + listaProductos.get(i).getNombre()+"\n"+ "Precio del producto: "+ listaProductos.get(i).getValor()+"\n";
        }

        return  textoProductos
        +      "Tipo de transporte: "       + tipo                      + "\n"
        +      "Tarifa de envio: "          + tarifaEnvio               + "\n"
        +      "Total a pagar: "            + total;  

    }


    

/*
 * Los siguientes son los Getters y Setters de los atributos de la clase
 */

    public Tienda getTienda() {
        return tienda;
    }

    public HashMap<String, Moda> getAtributos(){

        return infoAtributos;

    }

    public Cliente getCliente() {
        return cliente;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public ArrayList<Producto> getlistaProductos() {
        return listaProductos;
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
    
    public static ArrayList<Factura> getListaFacturas() {
        return listaFacturas;
    }

    public Operario getOperario() {
        return operario;
    }
    
    public static HashMap<String, Moda> getInfoAtributos(){
        return infoAtributos;
    }
    


    // Setters
    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public static void setInfoAtributos(HashMap<String, Moda> infoAtributos){
        Factura.infoAtributos = infoAtributos;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
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

    public void setOperario(Operario operario) {
        this.operario = operario;
    }

    public static void setListaFacturas(ArrayList<Factura> facturas){
       listaFacturas = facturas;
    }  
}
