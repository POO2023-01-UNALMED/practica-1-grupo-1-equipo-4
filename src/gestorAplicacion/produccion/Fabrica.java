package gestorAplicacion.produccion;
import gestorAplicacion.gestion.CuentaBancaria;
import gestorAplicacion.produccion.Tienda;
import gestorAplicacion.produccion.Producto;
import gestorAplicacion.gestion.Financiero;
import gestorAplicacion.gestion.Operario;
import gestorAplicacion.gestion.Vendedor;

import java.util.ArrayList;

public class Fabrica implements Financiero{

    private static ArrayList<Operario> listaOperadores;
    private static ArrayList<Producto> listaProductos;
    private static int cantidadProducto; //se supone que esta es la cantidad a repartir y va a ser fija, puede quitarse el atributo o no xd (consultar)
    private static ArrayList<Tienda> listaTienda;
    private static CuentaBancaria CuentaBancaria;


    // ------------- constructor -------------
    public Fabrica(ArrayList<Operario> listaOperadores, ArrayList<Producto> listaProductos, int cantidadProducto,
            ArrayList<Tienda> listaTienda,CuentaBancaria cuentaBancaria) {
        Fabrica.listaOperadores = listaOperadores;
        Fabrica.listaProductos = listaProductos;
        Fabrica.cantidadProducto = cantidadProducto;
        Fabrica.listaTienda = listaTienda;
        CuentaBancaria = cuentaBancaria;
    }

    //----------- Getters and Setters ----------------

    public static ArrayList<Operario> getListaOperadores() {
        return listaOperadores;
    }

    public static void setListaOperadores(ArrayList<Operario> listaOperadores) {
        Fabrica.listaOperadores = listaOperadores;
    }

    public static ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public static void setListaProductos(ArrayList<Producto> listaProductos) {
        Fabrica.listaProductos = listaProductos;
    }

    public static int getCantidadProducto() {
        return cantidadProducto;
    }

    public static void setCantidadProducto(int cantidadProducto) {
        Fabrica.cantidadProducto = cantidadProducto;
    }

    public static ArrayList<Tienda> getListaTienda() {
        return listaTienda;
    }

    public static void setListaTienda(ArrayList<Tienda> listaTienda) {
        Fabrica.listaTienda = listaTienda;
    }

    public static CuentaBancaria getCuentaBancaria() {
        return CuentaBancaria;
    }

    public static void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        CuentaBancaria = cuentaBancaria;
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
			textoProducto += indice+". "+producto.getNombre()+"\n"; //se almacenan todos lo nombres de los productos en un string
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
			textoTiendas += indice+". "+tienda.getNombre()+"\n"; //se almacenan todos lo nombres de las tiendas en un string
			indice++;
		}
		return textoTiendas;
	}
    // se selecciona la tienda en base a la opcion digitada por pantalla
    public Tienda seleccionarTienda(int opcion) {
		
        Tienda tiendaSeleccionada = listaTienda.get(opcion);

		return tiendaSeleccionada;
	}
}
