package gestorAplicacion.gestion;
import java.util.ArrayList;

import gestorAplicacion.produccion.Fabrica;
import gestorAplicacion.produccion.Transporte;
public class Conductor extends Persona {
	private Transporte transporte;
	private Fabrica fabrica;
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
	/*-------------------Metodos-------------------------*/
    @Override
	public void recibirSueldo(int total) {
		fabrica.getCuentaBancaria().descontarFondos(total);
		super.getCuentaBancaria().anadirFondos(total);
	}


	//Falta terminar
	@Override
	public String toString() {
		return "\nNombre: "            + getNombre()               + "\n"
        +      "Edad: "                + getEdad()                 + "\n"
        +      "Cedula: "              + getCedula()               + "\n"
		+      "Transporte: "          + getTransporte().getTipo() + "\n";
		
	}
}
