package gestorAplicacion.gestion;

import java.util.ArrayList;

import gestorAplicacion.produccion.Producto; 


public class Cliente implements Moda{

	/*-------------------Atributos-------------------------*/
	

	private String nombre;
	private String direccion;
	private CuentaBancaria cuentaBancaria;
	private String productoDeseado;
	private ArrayList<Producto> productos;
	static private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	
	
	/*-------------------Constructores-------------------------*/

	public Cliente(String nombre, String direccion, String productoDeseado,CuentaBancaria cuentaBancaria) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.productoDeseado=productoDeseado;
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
	
	
	public String getProductoDeseado() {
		return productoDeseado;
	}
	public void setProductoDeseado(String productoDeseado) {
		this.productoDeseado = productoDeseado;
	}
	
	
	public ArrayList<Producto> getProducto() {
		return productos;
	}
	public void setProducto(ArrayList<Producto> productos) {
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
		return this.getNombre()+" "+this.getDireccion()+" "+this.getProductoDeseado();
	}

}


