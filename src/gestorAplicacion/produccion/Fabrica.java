package gestorAplicacion.produccion;
import gestorAplicacion.gestion.CuentaBancaria;
import gestorAplicacion.gestion.Financiero;
import gestorAplicacion.gestion.Operario;
import gestorAplicacion.gestion.Persona;
import gestorAplicacion.gestion.Factura;

import java.io.Serializable;
import java.util.ArrayList;

public class Fabrica implements Financiero, Serializable{

    private static Operario operario;
    private ArrayList<Producto> listaProductos;
    private ArrayList<Tienda> listaTienda;
    private CuentaBancaria cuentaBancaria;


    // ------------- constructor -------------
    public Fabrica(ArrayList<Producto> listaProductos,
            ArrayList<Tienda> listaTienda,CuentaBancaria cuentaBancaria) {
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
    
    //muestra el catalogo en pantalla
    public String mostrarProductos(){
		String textoProducto="";
		int indice = 1;
		//se recorre la lista para obtener cada nombre de las tiendas disponibles:
		for(Producto producto:listaProductos) {
			textoProducto += indice+". "+producto.getNombre()+" - "+producto.getCategoria()+"\n"; //se almacenan todos lo nombres de los productos en un string
			indice++;
		}
		return textoProducto;
	}
    
    //muestra las tiendas en pantalla
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

    //quita el dinero de la cuenta de la fabrica/admin
    public double descontarDineroCuentaAdmin(Factura factura){
        double total = factura.getTotal();
        CuentaBancaria cuentaAdmin = getCuentaBancaria();
        cuentaAdmin.descontarFondos(total); //nota no se si genere un problea que el atributo saldo de cuenta es un entero y se le resta un double
        return total;
    }

    //Devuelve un lista de n productos

    public ArrayList<Producto> cantidadProductos(int cantidad, Producto producto){
        ArrayList<Producto> listaAbastecer = new ArrayList<>();
        for(int i=0;i<cantidad;i++){
            listaAbastecer.add(producto);
        }
        return listaAbastecer;
    }    
    //
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
}
