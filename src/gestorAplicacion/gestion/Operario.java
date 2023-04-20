package gestorAplicacion.gestion;
import gestorAplicacion.produccion.Fabrica;
public class Operario extends Persona {
	
	/*-------------------Atributos-------------------------*/
	
	
	private Fabrica fabrica;
	
	
	/*-------------------Constructores-------------------------*/
	
	
	/*Constructor de la clase operario que recibe todos los parametros*/

	public Operario(String nombre, int edad, int cedula, CuentaBancaria cuentaBancaria, int trabajo,Fabrica fabrica) {
		super(nombre, edad, cedula, cuentaBancaria, trabajo);
		this.fabrica=fabrica;
	}
	/*Constructor de la clase operario que no recibe parametros*/
	public Operario() {
	}
	
	
	/*-------------------Getter y setter-------------------------*/
	
	
	public Fabrica getFabrica() {
		return fabrica;
	}
	public void setFabrica(Fabrica fabrica) {
		this.fabrica = fabrica;
	}

	
	/*-------------------Metodos-------------------------*/
    @Override
	public void recibirSueldo() {
		fabrica.getCuentaBancaria().descontarFondos(getSalario()*getTrabajo());
		
		this.getCuentaBancaria().anadirFondos(1000*getTrabajo());
	}
}
