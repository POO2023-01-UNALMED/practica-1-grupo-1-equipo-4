package gestorAplicacion.gestion;
import gestorAplicacion.produccion.Tienda;
public class Vendedor extends Persona {
	private Tienda tienda;
	public Vendedor(String nombre, int edad, int cedula, CuentaBancaria cuentaBancaria,int salario, Boolean trabajo, Tienda tienda) {
		super(nombre, edad, cedula, cuentaBancaria,salario, trabajo);
		this.tienda=tienda;
	}
	public Tienda getTienda() {
		return tienda;
	}
	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}


}
