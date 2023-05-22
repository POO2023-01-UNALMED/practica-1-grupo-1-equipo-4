/*Hereda de Persona, hay uno por tienda y sus desempseño está directamente ligada a esa tienda  */
package gestorAplicacion.gestion;
import java.util.ArrayList;
import java.util.List;


import gestorAplicacion.produccion.Tienda;


public class Vendedor extends Persona {
	/*-------------------Atributos-------------------------*/
	
	private static ArrayList<Meta> metasVendedor = new ArrayList<Meta>(List.of(new Meta("Fácil",3,10000),
																			   new Meta("Dificil",10,50000)));
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
