/* Autores: Joan Sebastian Salazar Montoya, Monica Sofia Restrepo León, 
Luis Alejandro Varela Ojeda, Maria Fernanda Calle Agudelo, Jaider Castañeda Villa
 * FUNCIONALIDAD DE LA CLASE: clase que hereda de Persona, que representa al trabajador 
 * que controla la producción de los productos en las fábricas.
 */
package gestorAplicacion.gestion;
import java.util.ArrayList;
import java.util.List;


import gestorAplicacion.produccion.Fabrica;


public class Operario extends Persona {
	
	/*-------------------Atributos-------------------------*/
	
	private static ArrayList<Meta> metasOperario = new ArrayList<Meta>(List.of(new Meta("Fácil",5,5000),
																				new Meta("Dificil",10,7000)));
	private Fabrica fabrica;
	
	
	/*-------------------Constructores-------------------------*/
	
	
	/*Constructor de la clase operario que recibe todos los parametros*/

	public Operario(String nombre, int edad, int cedula, CuentaBancaria cuentaBancaria,Fabrica fabrica) {
		super(nombre, edad, cedula, cuentaBancaria);
		this.fabrica=fabrica;
	}
	/*Constructor de la clase operario que no recibe parametros*/
	public Operario() {
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
		fabrica.getCuentaBancaria().descontarFondos(total);
		this.getCuentaBancaria().anadirFondos(total);
	}


	@Override
	public String toString() {
		return "\nNombre: "            + getNombre()            + "\n"
        +      "Edad: "                + getEdad()              + "\n"
        +      "Cedula: "              + getCedula()            + "\n"
		+ 	   "Fabrica: "			   + getFabrica()           + "\n";
	}

	
	/*-------------------Getter y setter-------------------------*/
	
	
	public Fabrica getFabrica() {
		return fabrica;
	}
	public void setFabrica(Fabrica fabrica) {
		this.fabrica = fabrica;
	}
	public static ArrayList<Meta> getMetasOperario(){
		return metasOperario;
	}
	public static void setMetasOperario(ArrayList<Meta> metasOperario){
		Operario.metasOperario = metasOperario;
	}
	
}
