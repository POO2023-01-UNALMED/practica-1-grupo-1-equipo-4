package gestorAplicacion.gestion;
import gestorAplicacion.produccion.Fabrica;
public class Operario extends Persona {
	private Fabrica fabrica;
	public Operario(String nombre, int edad, int cedula, CuentaBancaria cuentaBancaria,int salario, Boolean trabajo,Fabrica fabrica) {
		super(nombre, edad, cedula, cuentaBancaria,salario, trabajo);
		this.fabrica=fabrica;
	}
	public Fabrica getFabrica() {
		return fabrica;
	}
	public void setFabrica(Fabrica fabrica) {
		this.fabrica = fabrica;
	}

	

}
