package gestorAplicacion.gestion;

import java.io.Serializable;
import java.util.ArrayList;

import gestorAplicacion.produccion.Producto; 


public class Cliente implements Moda, Serializable{

	/*-------------------Atributos-------------------------*/
	

	private String nombre;
	private String direccion;
	private CuentaBancaria cuentaBancaria;
	private ArrayList<Producto> productos = new ArrayList<Producto>();
	static private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	
	
	/*-------------------Constructores-------------------------*/

	public Cliente(String nombre, String direccion,CuentaBancaria cuentaBancaria) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cuentaBancaria = cuentaBancaria;
        
        listaClientes.add(this);
        
    }
	public Cliente() {}
	
	
	/*-------------------Getters y setters-------------------------*/
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	public CuentaBancaria getCuentaBancaria() {
		return cuentaBancaria;
	}
	public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}
		
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
    
	
	public static ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}
	public static void setListaClientes(ArrayList<Cliente> listaClientes) {
		Cliente.listaClientes = listaClientes;
	}
	/*------------------- Metodos -------------------------*/
	



	public static String mostrarClientes() {
		String cadena="";
		int index = 1;
		/*Se recorre la lista y se retornan todos los elementos pero solo como String*/
		for(Cliente cliente:listaClientes) {
			cadena +=index+". "+cliente+"\n"; /*Se hace uso del metodo toString asi devolvemos el objeto como tal*/
			index++;
		}
		return cadena;
	}
	
	public static Cliente seleccionarCliente(int index) {
		Cliente clienteSeleccionado = null;
		/*El ciclo while en caso de que retorne null debe estar en el main*/
		if(index-1>=0 && index<=listaClientes.size()) {
			index=index-1;
			clienteSeleccionado= listaClientes.remove(index);
		}else {
			return clienteSeleccionado;
		}
		return clienteSeleccionado;
	}
	
	public String toString() {
		return this.getNombre()+" Dir. "+this.getDireccion();
	}

}


