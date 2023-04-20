package gestorAplicacion.produccion;
import gestorAplicacion.gestion.CuentaBancaria;
import gestorAplicacion.produccion.Tienda;
import gestorAplicacion.produccion.Producto;
import gestorAplicacion.gestion.Financiero;
import gestorAplicacion.gestion.Operario;

import java.util.ArrayList;

public class Fabrica implements Financiero{

<<<<<<< Updated upstream
    private ArrayList<Operario> listaOperadores;
    private ArrayList<Producto> listaProductos;
    private int cantidadProducto; //se supone que esta es la cantidad a repartir y va a ser fija, puede quitarse el atributo o no xd (consultar)
    private ArrayList<Tienda> listaTienda;
    private CuentaBancaria CuentaBancaria;
=======
    private static ArrayList<Operario> listaOperadores;
    private static ArrayList<Producto> listaProductos;
    private static ArrayList<Tienda> listaTienda;
    private static CuentaBancaria CuentaBancaria;
>>>>>>> Stashed changes


    // ------------- constructor -------------
    public Fabrica(ArrayList<Operario> listaOperadores, ArrayList<Producto> listaProductos,
            ArrayList<Tienda> listaTienda,CuentaBancaria cuentaBancaria) {
<<<<<<< Updated upstream
        this.listaOperadores = listaOperadores;
        this.listaProductos = listaProductos;
        this.cantidadProducto = cantidadProducto;
        this.listaTienda = listaTienda;
=======
        Fabrica.listaOperadores = listaOperadores;
        Fabrica.listaProductos = listaProductos;
        Fabrica.listaTienda = listaTienda;
>>>>>>> Stashed changes
        CuentaBancaria = cuentaBancaria;
    }

    public Fabrica(){}
    //----------- Getters and Setters ----------------

    public ArrayList<Operario> getListaOperadores() {
        return listaOperadores;
    }

    public void setListaOperadores(ArrayList<Operario> listaOperadores) {
        this.listaOperadores = listaOperadores;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

<<<<<<< Updated upstream
    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public ArrayList<Tienda> getListaTienda() {
=======
    public static ArrayList<Tienda> getListaTienda() {
>>>>>>> Stashed changes
        return listaTienda;
    }

    public void setListaTienda(ArrayList<Tienda> listaTienda) {
        this.listaTienda = listaTienda;
    }

    public CuentaBancaria getCuentaBancaria() {
        return CuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
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
