package gestorAplicacion.produccion;
import gestorAplicacion.gestion.CuentaBancaria;
import gestorAplicacion.gestion.Operario;
import gestorAplicacion.gestion.Persona;
import gestorAplicacion.gestion.Factura;

import java.io.Serializable;
import java.util.ArrayList;

public class Fabrica implements Serializable{

    private static final long serialVersionUID = 123123L;    

    private static Operario operario;
    private ArrayList<Producto> listaProductos;
    private ArrayList<Tienda> listaTienda;
    private CuentaBancaria cuentaBancaria;


    // ------------- constructor -------------
    public Fabrica(ArrayList<Producto> listaProductos, ArrayList<Tienda> listaTienda,CuentaBancaria cuentaBancaria) {
        this.listaProductos = listaProductos;
        this.listaTienda = listaTienda;
        this.cuentaBancaria = cuentaBancaria;
    }

    public Fabrica(){}
    //----------- Getters and Setters ----------------

    public static Operario getOperario() {
        return operario;
    }

    public static void setOperario(Operario operario) {
        Fabrica.operario = operario;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public ArrayList<Tienda> getListaTienda() {
        return listaTienda;
    }

    public void setListaTienda(ArrayList<Tienda> listaTienda) {
        this.listaTienda = listaTienda;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    //toString para saber que imprimir cuando se llame al objeto Fabrica     
    @Override   
    public String toString() {
        return "La mejor fabrica del mundo";
    }
    

    // -------------- Metodos ------------------
    
    /*
     * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Abastecer
     * 
     * RECIBE:
     * No recibe ningun argumento 
     * DEVUELVE:
     * Devuelve un String con los productos que tiene la fabrica para abastecer.
     * DESCRIPCIÓN:
     * Este método permite visualizar los productos disponibles que tiene una fabrica.
     */
    public String mostrarProductos(){
		String textoProducto="\nINDICE-PRODUCTO-PESO-PRECIO-CATEGORIA\n";
		int indice = 1;
		//se recorre la lista para obtener cada nombre de las tiendas disponibles:
		for(Producto producto:listaProductos) {
			textoProducto += indice+". "+producto.getNombre()+" - "+producto.getPeso()+" - "+producto.getCostoDeProduccion()+" - "+producto.getCategoria()+"\n"; //se almacenan todos lo nombres de los productos en un string
			indice++;
		}
		return textoProducto;
	}
    /*
     * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Abastecer
     * 
     * RECIBE: 
     * No recibe ningun argumento
     * 
     * DEVUELVE:
     * Devuelve un String con las tiendas y los productos que tiene con su respectiva cantidad
     * 
     * DESCRIPCIÓN:
     * Este método permite visualizar las tiendas que pertenecen a la fabrica y los productos que tiene dentro.
     */
	public String mostrarTiendas() {
		String textoTiendas="";
		int indice = 1;
		//se recorre la lista para obtener cada nombre de las tiendas disponibles:
		for(Tienda tienda:listaTienda) {
			textoTiendas += indice+". "+tienda.getNombre()+"-PRODUCTOS: "+tienda.cantidadProductos() + "\n"; //se almacenan todos lo nombres de las tiendas en un string
			indice++;
            if(indice==listaTienda.size());
            textoTiendas+="\n";
		}
		return textoTiendas;
	}
    // se selecciona la tienda en base a la opcion digitada por pantalla
    public Tienda seleccionarTienda(int opcion) {
		
        Tienda tiendaSeleccionada = listaTienda.get(opcion-1);

		return tiendaSeleccionada;
	}

    /*
     * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Devoluciones
     * 
     * RECIBE: objeto de tipo Producto.
     * DEVUELVE: un double llamado total, que es el valor del producto devuelto.
     * 
     * DESCRIPCIÓN: obtiene el valor total del producto, 
     * realiza el descuento de ese monto en la cuenta bancaria del administrador 
     * y retorna el valor del producto.
     */
    public double descontarDineroCuentaAdmin(Producto productoDevuelto){
        double total = productoDevuelto.getValor();
        CuentaBancaria cuentaAdmin = getCuentaBancaria();
        cuentaAdmin.descontarFondos(total); 
        return total;
    }
    /*
     * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Abastecer
     * 
     * RECIBE: 
     * cantidad: La cantidad n de productos que se va a generar.
     * producto: El producto que se va a generar.
     * 
     * DEVUELVE:
     * Devuelve una lista con los productos.
     * 
     * DESCRIPCIÓN:
     * Genera una lista de n cantidad de un mismo producto
     */
    public ArrayList<Producto> cantidadProductos(int cantidad, Producto producto){
        ArrayList<Producto> listaAbastecer = new ArrayList<>();
        for(int i=0;i<cantidad;i++){
            listaAbastecer.add(producto);
        }
        return listaAbastecer;
    }    
    

    /*
     * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Pago a trabajadores
     * 
     * RECIBE: Lista de facturas de los envios que se han realizado (ArrayList con 
     * objetos de tipo Factura) y un número que se asocia al tipo de trabajador
     * al que se le desea pagar (entero)
     * DEVUELVE: Lista de trabajadores que han trabajado y no se les ha pagado por dicho
     * trabajo (ArrayList con objetos de tipo Persona)
     * 
     * DESCRIPCIÓN: verifica en las facturas cúales son los trabajadores que han realizado
     * envios, además se verifica si su trabajo es mayor a 0, pues se le pudo haber pagado
     * anteriormente
     */
    public static ArrayList<Persona> busquedaTrabajo(ArrayList<Factura> listaFacturas,int tipo){
        ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
        for (Factura factura: listaFacturas){
            if(tipo==1){
                if (Fabrica.getOperario().getTrabajo()>0 && !listaPersonas.contains(Fabrica.getOperario())){
                    listaPersonas.add(Fabrica.getOperario());
                }
            }else if(tipo==2){
                if (!listaPersonas.contains(factura.getTransporte().getConductor()) && factura.getTransporte().getConductor().getTrabajo()>0 ){
                    listaPersonas.add(factura.getTransporte().getConductor());
                }
                    
            }else if(tipo==3){
                if (!listaPersonas.contains(factura.getTienda().getVendedor()) && factura.getTienda().getVendedor().getTrabajo()>0){
                    listaPersonas.add(factura.getTienda().getVendedor());
                }
            }
        }
        return listaPersonas;
        
    }


    /*
     * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Pago a trabajadores
     * 
     * RECIBE: Lista de trabajadores que han trabajado y no se les ha pagado por dicho
     * trabajo (ArrayList con objetos de tipo Persona). 
     * DEVUELVE: texto conformado por las descripciones de cada trabajador de la lista,
     * la cual depende del tipo de trabajador que se escogio a pagar (String).
     * 
     * DESCRIPCIÓN: recorre la lista de trabajadores y los añade a un String.
     */
    public static String mostrarPersonas(ArrayList<Persona> listaTrabajadores){
        String texto = "";
        int indice = 1;

        for (Persona i: listaTrabajadores) {
            texto += "\n" + "Trabajador "+ indice + i.toString();  //Uso de ligadura dinámica
            indice++;               
        }

        return texto;
    }
}
