package gestorAplicacion.gestion;
import gestorAplicacion.produccion.Transporte;
public class Conductor extends Persona {
	private Transporte transporte;
	/*-------------------Constructores-------------------------*/
	
	
	/*Constructor de la clase conductor que recibe todos los parametros*/
	public Conductor(String nombre, int edad, int cedula, CuentaBancaria cuentaBancaria,int salario, int trabajo, Transporte transporte) {
		super(nombre, edad, cedula, cuentaBancaria,salario, trabajo);
		this.transporte=transporte;
	}
	/*Constructor de la clase conductor vacio*/
	public Conductor() {
	}
	
	
	/*-------------------Getter y setter-------------------------*/
	public Transporte getTransporte() {
		return transporte;
	}
	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}
	
	
	/*-------------------Metodos-------------------------*/
	
	public void recibirSueldo() {}
}
