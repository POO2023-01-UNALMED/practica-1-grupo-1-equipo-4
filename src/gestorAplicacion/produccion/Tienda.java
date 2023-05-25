/* Autores: Joan Sebastian Salazar Montoya, Monica Sofia Restrepo León, 
Luis Alejandro Varela Ojeda, Maria Fernanda Calle Agudelo, Jaider Castañeda Villa
 * FUNCIONALIDAD DE LA CLASE: La clase Tienda desempeña un papel fundamental como intermediaria en el proceso de venta de productos. 
 * Es el punto central desde donde se envían los productos a los clientes, lo que la convierte en un elemento crucial para el funcionamiento 
 * de todas las operaciones. Como tal, la Tienda está estrechamente vinculada con todas las funcionalidades relacionadas, ya que actúa como 
 * el vínculo entre el cliente y la empresa.
 */
package gestorAplicacion.produccion;
import gestorAplicacion.gestion.Cliente;
import gestorAplicacion.gestion.CuentaBancaria;
import gestorAplicacion.gestion.Vendedor;
import gestorAplicacion.gestion.Factura;
import gestorAplicacion.gestion.Moda;
import gestorAplicacion.gestion.Operario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Tienda implements  Moda, Serializable {

    private static final long serialVersionUID = 3809459L;    

    // Atributos
    private String nombre;
    private Vendedor vendedor;
    private CuentaBancaria cuentaBancaria;
    private ArrayList<Producto> listaProductos;
    private Map<Producto, Integer> listaCantidadProductos;
    private static int numTiendas = 0;
    private Map<String, Integer> cantidadPorCategoria = new HashMap<String, Integer>() {{
        put("aseo", (int) (Math.random() * (200 - 100 + 1) + 100));
        put("consumible", (int) (Math.random() * (200 - 100 + 1) + 100));
        put("construccion", (int) (Math.random() * (200 - 100 + 1) + 100));
    }};;

    private Map<String, Integer> productosPorCategoria;
    private ArrayList<Producto> productosDevueltos = new ArrayList<Producto>();


    // Constructor
    public Tienda(String nombre, Vendedor vendedor, CuentaBancaria cuentaBancaria) {
        this.nombre = nombre;
        this.vendedor = vendedor;
        this.cuentaBancaria = cuentaBancaria;
        this.listaCantidadProductos = new HashMap<Producto, Integer>();
        productosPorCategoria = new HashMap<String, Integer>();
        numTiendas++;
    }

    public Tienda() {

    }



    // Métodos

    /*
     * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Enviar Pedido
     * 
     * RECIBE: No recibe argumentos
     * DEVUELVE: String con los productos disponibles de la tienda
     * 
     * DESCRIPCIÓN: recorre la lista de productos disponibles de la tienda para
     * ser enviados y los añade a un String 
     */

    public String mostrarProductos() {
        String str = "";
        for (int i = 0; i < listaProductos.size(); i++) {
            str += "\n" + (i + 1) + listaProductos.get(i).toString() + "\n";
        }
        return str;
    }

    /*
     * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Abastecer
     * 
     * RECIBE: 
     * No recibe ningun argumento
     * 
     * DEVUELVE:
     * Devuelve un String con los productos de la tienda y su cantidad.
     * 
     * DESCRIPCIÓN:
     * Este método permite visualizar los productos que tiene una tienda y la cantidad que hay por cada uno.
     */
    

    public String cantidadProductos() {
        listaCantidadProductos = new HashMap<Producto, Integer>();
        String cadena = "    ";
        /* Ciclo para agregar los valores al diccionario y hacer el conteo */
        for (int i = 0; i < listaProductos.size(); i++) {

            if (listaCantidadProductos.containsKey(listaProductos.get(i))) {
                listaCantidadProductos.put(listaProductos.get(i),listaCantidadProductos.get(listaProductos.get(i)) + 1);
            } else {
                listaCantidadProductos.put(listaProductos.get(i), 1);
            }
        }
        /* Bucle for each para generar la cadena con la cantidad de cada producto */
        for (Map.Entry<Producto, Integer> entrada : listaCantidadProductos.entrySet()) {
            cadena += "\n     " + entrada.getKey().getNombre() + ": " + entrada.getValue() + " ";
        }

        return cadena;
    }


    /*
     * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Abastecer
     * 
     * RECIBE: 
     * No recibe ningun argumento
     * 
     * DEVUELVE:
     * Devuelve un String con cantidades que tiene y su maximo con el formato categoria cantidad/maximo
     * 
     * DESCRIPCIÓN:
     * Este método permite visualizar la cantidad de productos por categoria
     *  que tiene una tienda y ademas tambien la cantidad maxima que puede 
       tener por categoria esa tienda
     */

    public String productosPorCategoria(){
        String cadena = "";
        productosPorCategoria.put("aseo",0);
        productosPorCategoria.put("consumible",0);
        productosPorCategoria.put("construccion",0);
        for(Producto producto:listaProductos){
            if(productosPorCategoria.containsKey(producto.getCategoria())){
                productosPorCategoria.put(producto.getCategoria(),productosPorCategoria.get(producto.getCategoria())+1);
            }
        }
        cadena += "Aseo " + productosPorCategoria.get("aseo")+"/"+cantidadPorCategoria.get("aseo") +"  ";
        cadena += "Consumible " + productosPorCategoria.get("consumible")+"/"+cantidadPorCategoria.get("consumible")+"  ";
        cadena += "Construccion " + productosPorCategoria.get("construccion")+"/"+cantidadPorCategoria.get("construccion")+"  ";
        return cadena;
    } 


        /*
     * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: EnviarPedido
     * 
     * RECIBE: 
     * No recibe ningun argumento
     * 
     * DEVUELVE:
     * String cadena de texto que contiene la cantidad de productos en una lista de ventas.
     * 
     * DESCRIPCIÓN:
     * Dentro del método, se crea un diccionario (HashMap) llamado "listaCantidadProductos" 
     * para almacenar la cantidad de cada producto. Luego, se recorre una lista de productos 
     * y se actualiza el diccionario con el conteo de cada producto. Al final,
     * se genera una cadena que muestra el índice, el nombre del producto y su cantidad, y se retorna dicha cadena.
     * Esta cadena se vé en consola y es con la que el 
     * usuario elige su producto. 
     */

    public String cantidadProductosVentas() {
        listaCantidadProductos = new HashMap<Producto, Integer>();
        String cadena = "    ";
        int indice = 1;
        /* Ciclo para agregar los valores al diccionario y hacer el conteo */
        for (int i = 0; i < listaProductos.size(); i++) {
            if (listaCantidadProductos.containsKey(listaProductos.get(i))) {
                listaCantidadProductos.put(listaProductos.get(i),
                        listaCantidadProductos.get(listaProductos.get(i)) + 1);
            } else {
                listaCantidadProductos.put(listaProductos.get(i), 1);
            }
        }
        /* Bucle for each para generar la cadena con la cantidad de cada producto */
        for(Producto producto:listaProductos){

            if (!cadena.contains(producto.getNombre())){              
                cadena+="\n" + indice + ". " + producto.getNombre() + ": " + listaCantidadProductos.get(producto) + " ";
                indice++;
            }
        }
        return cadena;
    }


    /*
    * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Abastecer, EnviarPedido
    * 
    * RECIBE:
    * No recibe ningun argumento
    * 
    * DEVUELVE:
    * Devuelve un String con las tiendas y los productos que tiene con su
    * respectiva cantidad
    * 
    * DESCRIPCIÓN:
    * sirve para actualizar
    * la cantidad de un productos en la lista de productos y en el HashMap
    * listaCantidadProductos.
    * muestra en tiempo real que el producto ha
    * *sido seleccionado y no está disponible para otros
    * como en EnviarPedido se llama cada vez que se selecciona un producto, en
    * consola va bajando el número
    * de productos disponibles cada vez que selecciones uno.
    * 
    * Primero comprueba si el producto está en la lista de productos
    * listaProductos usando el método contains.
    * Si el producto no está en la lista, no hace nada.
    * Si el producto está en la lista de productos,
    * lo elimina de la lista utilizando remove.
    * Luego, comprueba si la cantidad de producto en el HashMap
    * listaCantidadProductos es mayor que 1.
    * Si la cantidad de producto en el HashMap listaCantidadProductos es igual a
    * Si cumple, reduce la cantidad en 1
    * 1,
    * elimina el producto del HashMap porque ya no quedan más unidades
    * disponibles.
    * 
    * 
    */

    public void venderProducto(Producto producto) {

        if (listaProductos.contains(producto)) {
        
            listaProductos.remove(producto);

            if (listaCantidadProductos.get(producto) > 1) {
                listaCantidadProductos.put(producto, listaCantidadProductos.get(producto) - 1);
                
            } else {
                listaCantidadProductos.remove(producto);
            }
        }
    }


    //Verificar si este método si se usa
    public void elegirTransporte(Producto producto) {
        for (int i = 0; i < TipoTransporte.values().length; i++) {
            if (TipoTransporte.values()[i].getCapacidadMax() <= producto.getPeso()) {
                TipoTransporte.values()[i].toString();
            }
        }
    }


    /*
     * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Enviar Pedido
     * 
     * RECIBE: 
     * lista de productos que se pidieron (ArrayList con objetos de tipo
     * Producto), el transporte que se eligio (objeto tipo transporte),
     * el cliente al que se le enviará el pedido (objeto tipo Cliente) y el dia 
     * del mes del envio (entero).
     * 
     * DEVUELVE: 
     * la factura correspondiente al envio realizado (objeto tipo Factura).
     * 
     * DESCRIPCIÓN: 
     * elimina las cantidades de productos pedidos de las listas
     * de la tienda, suma el respectivo trabajo a las personas involucradas (vendedor,
     * operario y conductor), añade los productos pedidos a la lista del cliente y 
     * genera la factura asociada al envío.
     */
    
    public Factura enviarPedido(ArrayList<Producto> listaProductosPedidos, Transporte transporte, Cliente cliente, int dia, Operario operario) {
        // Resto 1 unidad de las cantidades de los productos, pues se envio

        // Añado la suma de trabajo a los trabajadores

        // Al vendedor
        this.getVendedor().setTrabajo(this.getVendedor().getTrabajo() + 1);
        this.getVendedor().setIndiceMeta(this.getVendedor().getIndiceMeta()+listaProductosPedidos.size() );
        
        // Al conductor
        transporte.getConductor().setTrabajo(transporte.getConductor().getTrabajo() + 1);
        for(int i=0; i<listaProductosPedidos.size(); i++){
            transporte.getConductor().setIndiceMeta(transporte.getConductor().getIndiceMeta()+listaProductosPedidos.get(i).getPeso());
        }

        // Al operario
        operario.setTrabajo(operario.getTrabajo() + 1);
        operario.setIndiceMeta(operario.getIndiceMeta() + listaProductosPedidos.size());

        for(int i=0; i<listaProductosPedidos.size(); i++){
            cliente.getProductos().add(listaProductosPedidos.get(i));
        }

        //Creo la factura
        Factura factura = new Factura(this, cliente, transporte, listaProductosPedidos,
         dia, "Las descripciones y cantidades de los materiales suministrados en esta factura se basan en nuestra mejor información y creencia.", operario);
        return factura;
    }


    /*
     * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Devoluciones
     * 
     * RECIBE: 
     * objeto de tipo Factura y uno de tipo Producto.
     * 
     * DEVUELVE: 
     * un objeto de tipo CLiente.
     * 
     * DESCRIPCIÓN: 
     * devuelve el producto seleccionado 
     * a una lista de la tienda donde se almacenan las devoluciones
     * y por ultimo retorna el cliente al que se le hizo la devolución.
     */

    public Cliente devolverProducto(Factura factura, Producto producto) {

        productosDevueltos.add(producto); // se duevuelve el producto

        return factura.getCliente();
    }


    /*
     * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Abastecer
     * 
     * RECIBE: 
     * transporte: Transporte que lleva los productos.
     * 
     * DEVUELVE: 
     * 
     * DESCRIPCIÓN:
     * Este método envia los poductos del transporte a la tienda.
     */

    public void descargarProducto(Transporte transporte) {
        while (transporte.getListaDeProductos().size() > 0) {
            listaProductos.add(transporte.getListaDeProductos().remove(0));
        }
        transporte.getConductor().setTrabajo(transporte.getConductor().getTrabajo() + 1);
    }

    // Get and Set
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
    public Map<String, Integer> getProductosPorCategoria(){
        return productosPorCategoria;
    }
    public Map<String, Integer> getCantidadPorCategoria(){
        return cantidadPorCategoria;
    }

    public Map<Producto, Integer> getListaCantidadProductos() {
        return this.listaCantidadProductos;
    }

    public void setListaCantidadProductos(Map<Producto, Integer> listaCantidadProductos) {
        this.listaCantidadProductos = listaCantidadProductos;
    }

    public static int getNumTiendas() {
        return numTiendas;
    }

    public ArrayList<Producto> getProductosDevueltos() {
        return productosDevueltos;
    }

    public void setProductosDevueltos(ArrayList<Producto> productosDevueltos) {
        this.productosDevueltos = productosDevueltos;
    }
}
