package gestorAplicacion.produccion;

import gestorAplicacion.gestion.Cliente;
import gestorAplicacion.gestion.CuentaBancaria;
import gestorAplicacion.gestion.Financiero;
import gestorAplicacion.gestion.Vendedor;
import gestorAplicacion.gestion.Factura;
import gestorAplicacion.gestion.Moda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tienda implements Financiero, Moda, Serializable {

    // Atributos
    private String nombre;
    private Vendedor vendedor;
    private CuentaBancaria cuentaBancaria;
    private ArrayList<Producto> listaProductos;
    private Map<Producto, Integer> listaCantidadProductos;
    private static int numTiendas = 0;
    private Map<String, Integer> cantidadPorCategoria = new HashMap<String, Integer>() {{
        put("aseo", (int) (Math.random() * (30 - 10 + 1) + 10));
        put("consumible", (int) (Math.random() * (30 - 10 + 1) + 10));
        put("construccion", (int) (Math.random() * (30 - 10 + 1) + 10));
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
    public String mostrarProductos() {
        String str = "";
        for (int i = 0; i < listaProductos.size(); i++) {
            str += "\n" + (i + 1) + listaProductos.get(i).toString() + "\n";
        }
        return str;
    }

    // mostrar productos abastecer :)))
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
    /*Metodo para contar la capacidad de una tienda y contar el tipo de productos que tiene cada tienda */
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

    // mostrar el producto que va a ser enviado
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
        for (Map.Entry<Producto, Integer> entrada : listaCantidadProductos.entrySet()) {
            cadena += "\n" + indice + ". " + entrada.getKey().getNombre() + ": " + entrada.getValue() + " ";
            indice++;
        }

        return cadena;
    }


    public void elegirTransporte(Producto producto) {
        for (int i = 0; i < TipoTransporte.values().length; i++) {
            if (TipoTransporte.values()[i].getCapacidadMax() <= producto.getPeso()) {
                TipoTransporte.values()[i].toString();
            }
        }
    }

    public Factura enviarPedido(ArrayList<Producto> listaProductosPedidos, Transporte transporte, Cliente cliente, int dia) {
        // Resto 1 unidad de las cantidades de los productos, pues se envio
        // ------listaCantidadProductos.put(producto,
        // listaCantidadProductos.get(producto)-1);
        for(int i=0; i<listaProductosPedidos.size(); i++){
            listaProductos.remove(listaProductosPedidos.get(i));
        }
        // Añado la suma de trabajo a los trabajadores
        // Al vendedor
        this.getVendedor().setTrabajo(this.getVendedor().getTrabajo() + listaProductosPedidos.size());
        // Al conductor
        transporte.getConductor().setTrabajo(transporte.getConductor().getTrabajo() + 1);
        // Al operario
        Fabrica.getOperario().setTrabajo(Fabrica.getOperario().getTrabajo() + 1);

        for(int i=0; i<listaProductosPedidos.size(); i++){
            cliente.getProductos().add(listaProductosPedidos.get(i));
        }


        Factura factura = new Factura(this, cliente, transporte, listaProductosPedidos, dia, "Las descripciones y cantidades de los materiales suministrados en esta factura se basan en nuestra mejor información y creencia.");
        return factura;
    }

   // devuelve el producto en base a la factura que se le pase de la funcionalidad
    // devoluciones
    public Cliente devolverProducto(Factura factura, Producto producto) {

        productosDevueltos.add(producto); // se duevuelve el producto

        return factura.getCliente();
    }

    public void descargarProducto(Transporte transporte, int fecha) {
        while (transporte.getListaDeProductos().size() > 0) {
            listaProductos.add(transporte.getListaDeProductos().remove(0));
        }
        transporte.getConductor().setTrabajo(transporte.getConductor().getTrabajo() + 1);
        vendedor.setTrabajo(vendedor.getTrabajo() + 1);
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