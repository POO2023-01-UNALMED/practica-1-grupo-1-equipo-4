/* Autores: Joan Sebastian Salazar Montoya, Monica Sofia Restrepo León, 
Luis Alejandro Varela Ojeda, Maria Fernanda Calle Agudelo, Jaider Castañeda Villa
 * FUNCIONALIDAD DE LA CLASE: clase que hereda de Persona, que representa al trabajador que transporta los envíos en determinado 
 * transporte desde la tienda hasta los clientes o desde la fábrica hasta la tienda en el momento de abastecer.
 * Cada uno está asociado a un transporte.
 */
package gestorAplicacion.gestion;
import java.util.ArrayList;
import java.util.List;

import gestorAplicacion.produccion.Fabrica;
import gestorAplicacion.produccion.Transporte;



public class Conductor extends Persona {

	private Transporte transporte;
	private Fabrica fabrica;
	private static ArrayList<Meta> metasConductor = new ArrayList<Meta>(List.of(new Meta("Fácil",5,2000),
																				new Meta("Dificil",20,10000)));
	private static ArrayList<Conductor> listaConductores = new ArrayList<Conductor>();
	/*-------------------Constructores-------------------------*/
	
	/*Constructor de la clase conductor que recibe todos los parametros*/

	public Conductor(String nombre, int edad, int cedula, CuentaBancaria cuentaBancaria,Transporte transporte) {
		super(nombre, edad, cedula, cuentaBancaria);
		this.transporte=transporte;
		listaConductores.add(this);
	}
	/*Constructor de la clase conductor vacio*/

	public Conductor() {
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
		super.getCuentaBancaria().anadirFondos(total);
	}
	

	@Override
	public String toString() {
		return "\nNombre: "            + getNombre()               + "\n"
        +      "Edad: "                + getEdad()                 + "\n"
        +      "Cedula: "              + getCedula()               + "\n"
		+      "Transporte: "          + getTransporte().getTipo() + "\n";
		
	}
	/*-------------------Getter y setter-------------------------*/

	public Transporte getTransporte() {
		return transporte;
	}

	public static ArrayList<Conductor> getListaConductores() {
		return listaConductores;
	}

	public static void setListaConductores(ArrayList<Conductor> listaConductores) {
		Conductor.listaConductores = listaConductores;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}
	
	public Fabrica getFabrica() {
		return fabrica;
	}

	public void setFabrica(Fabrica fabrica) {
		this.fabrica = fabrica;
	}

	public static ArrayList<Meta> getMetasConductor(){
		return metasConductor;
	}

	public static void setMetasConductor(ArrayList<Meta> metasConductor){
		Conductor.metasConductor = metasConductor;
	}
}
