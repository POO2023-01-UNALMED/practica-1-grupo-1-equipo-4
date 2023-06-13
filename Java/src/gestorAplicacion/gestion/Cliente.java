/* Autores: Joan Sebastian Salazar Montoya, Monica Sofia Restrepo León, 
Luis Alejandro Varela Ojeda, Maria Fernanda Calle Agudelo, Jaider Castañeda Villa
 * FUNCIONALIDAD DE LA CLASE: Clase que representa al comprador de productos de la empresa y su motor económico . Se utiliza en todas las funcionalidades 
 * excepto PagarTrabajadores. 
 */
package gestorAplicacion.gestion;
import java.io.Serializable;
import java.util.ArrayList;


import baseDatos.Load;
import gestorAplicacion.produccion.Producto; 


public class Cliente implements Moda, Serializable{

	private static final long serialVersionUID = 123812L;    


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

	
	/*------------------- Metodos -------------------------*/
	
/*
	Método: mostrarClientes
     * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Enviar Pedido
     * 
     * RECIBE: Vacío 
     * DEVUELVE: String, una lista de 
     * 
     * DESCRIPCIÓN:
	 * Crea una variable de tipo String llamada "cadena" y la inicializa como una cadena vacía.
	Crea un entero llamado "index" y lo inicializa en 1.
	Recorre la lista de clientes ("listaClientes") utilizando un for
	En cada iteración del bucle, pone el índice seguido de un punto y un espacio, y luego el objeto "cliente" convertido a String, con la cadena "cadena". 
	El método "toString" se utiliza para obtener una representación en forma de cadena del objeto.
	Incrementa el valor de "index" en 1 en cada iteración.
	Al finalizar, devuelve la cadena "cadena" que contiene la representación en forma de cadena de todos los clientes, numerados consecutivamente.
     */

	public static String mostrarClientes() {
		String cadena="";
		int index = 1;
		/*Se recorre la lista y se retornan todos los elementos pero solo como String*/
		for(Cliente cliente:listaClientes) {
			if (!cadena.contains(cliente.getNombre())){
			cadena +=index+". "+ cliente +"\n"; /*Se hace uso del metodo toString asi devolvemos el objeto como tal*/
			index++;
			}
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

}


