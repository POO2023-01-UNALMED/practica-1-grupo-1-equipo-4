package gestorAplicacion.gestion;
import gestorAplicacion.produccion.Transporte;
public class Conductor extends Persona {
	private Transporte transporte;
	public Conductor(String nombre, int edad, int cedula, CuentaBancaria cuentaBancaria,int salario, Boolean trabajo, Transporte transporte) {
		super(nombre, edad, cedula, cuentaBancaria,salario, trabajo);
		this.transporte=transporte;
	}
	public Transporte getTransporte() {
		return transporte;
	}
	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}
	

}
