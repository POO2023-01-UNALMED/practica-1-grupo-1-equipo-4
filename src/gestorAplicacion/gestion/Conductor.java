package gestorAplicacion.gestion;
import gestorAplicacion.produccion.Fabrica;
import gestorAplicacion.produccion.Transporte;
public class Conductor extends Persona {
	private Transporte transporte;
	private Fabrica fabrica;
	/*-------------------Constructores-------------------------*/
	
	
	/*Constructor de la clase conductor que recibe todos los parametros*/
	public Conductor(String nombre, int edad, int cedula, CuentaBancaria cuentaBancaria,int trabajo, Transporte transporte) {
		super(nombre, edad, cedula, cuentaBancaria, trabajo);
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
	
	public Fabrica getFabrica() {
		return fabrica;
	}
	public void setFabrica(Fabrica fabrica) {
		this.fabrica = fabrica;
	}
	/*-------------------Metodos-------------------------*/
    @Override
	public void recibirSueldo() {
		Fabrica.getCuentaBancaria().descontarFondos(super.getSalario()*getTrabajo());
		super.getCuentaBancaria().anadirFondos(1000*getTrabajo());
	}
}
