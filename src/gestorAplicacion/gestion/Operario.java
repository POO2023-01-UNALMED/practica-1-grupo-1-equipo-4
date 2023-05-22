/*El operario es el que trabaja en la fábrica */
package gestorAplicacion.gestion;
import java.util.ArrayList;
import java.util.List;


import gestorAplicacion.produccion.Fabrica;


public class Operario extends Persona {
	
	/*-------------------Atributos-------------------------*/
	
	private static ArrayList<Meta> metasOperario = new ArrayList<Meta>(List.of(new Meta("Fácil",10,10000),
																				new Meta("Dificil",10,10000)));
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
