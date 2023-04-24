package gestorAplicacion.gestion;
import gestorAplicacion.produccion.Fabrica;
public class Operario extends Persona {
	
	/*-------------------Atributos-------------------------*/
	
	
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
	
	
	/*-------------------Getter y setter-------------------------*/
	
	
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
		this.getCuentaBancaria().anadirFondos(total);
	}

	//Falta terminar
	@Override
	public String toString() {
		return "\nNombre: "            + getNombre()            + "\n"
        +      "Edad: "                + getEdad()              + "\n"
        +      "Cedula: "              + getCedula()            + "\n";
		
	}
}
