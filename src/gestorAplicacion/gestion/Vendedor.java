/* Autores: Joan Sebastian Salazar Montoya, Monica Sofia Restrepo León, 
Luis Alejandro Varela Ojeda, Maria Fernanda Calle Agudelo, Jaider Castañeda Villa
 * FUNCIONALIDAD DE LA CLASE: clase que hereda de Persona, representa al trabajador 
 * que realiza la venta en su respectiva tienda. 
 */
package gestorAplicacion.gestion;
import java.util.ArrayList;
import java.util.List;


import gestorAplicacion.produccion.Tienda;


public class Vendedor extends Persona {
	/*-------------------Atributos-------------------------*/
	
	private static ArrayList<Meta> metasVendedor = new ArrayList<Meta>(List.of(new Meta("Fácil",2,1000),
																			   new Meta("Dificil",5,5000)));
	private Tienda tienda;
	
	/*-------------------Constructores-------------------------*/
	

	
	/*Constructor de la clase conductor que recibe todos los parametros*/

	public Vendedor(String nombre, int edad, int cedula, CuentaBancaria cuentaBancaria,Tienda tienda) {
		super(nombre, edad, cedula, cuentaBancaria);
		this.tienda=tienda;
	}
	
	
	/*Constructor de la clase vendedor que no recibe parametros*/
	public Vendedor() {

	}
	

	/*-------------------Metodos-------------------------*/


	/*
     * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Pago a trabajadores
     * 
     * RECIBE: 
	 * Entero que hace referencia al pago que se va a realizar
	 * 
     * DEVUELVE: 
	 * Nada (vacío)
     * 
     * DESCRIPCIÓN:método sobrescrito de la clase Persona
     */
	@Override
	public void recibirSueldo(int total) {
		tienda.getCuentaBancaria().descontarFondos(total);
		super.getCuentaBancaria().anadirFondos(total);
	}

	//Falta terminar
	@Override
	public String toString() {
		return "\nNombre: "            + getNombre()              + "\n"
		+      "Edad: "                + getEdad()                + "\n"
		+      "Cedula: "              + getCedula()              + "\n"
		+      "Tienda: "              + getTienda().getNombre()  + "\n";
		
	}
	

	/*-------------------Getter y setter-------------------------*/
	
	
	public Tienda getTienda() {
		return tienda;
	}
	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}
	public static ArrayList<Meta> getMetasVendedor(){
		return metasVendedor;
	}
	public static void setMetasVendedor(ArrayList<Meta> metasVendedor){
		Vendedor.metasVendedor = metasVendedor;
	}
	

}
