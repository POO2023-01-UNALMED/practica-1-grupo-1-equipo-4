package gestorAplicacion.gestion;
import gestorAplicacion.produccion.Tienda;
public class Vendedor extends Persona {
	/*-------------------Atributos-------------------------*/
	
	
	private Tienda tienda;
	
	/*-------------------Constructores-------------------------*/
	
	
	/*Constructor de la clase conductor que recibe todos los parametros*/

	public Vendedor(String nombre, int edad, int cedula, CuentaBancaria cuentaBancaria,Tienda tienda) {
		super(nombre, edad, cedula, cuentaBancaria);
		this.tienda=tienda;
	}
	/*Constructor de la clase vendedor que no recibe parametros*/
	public Vendedor() {

	}
	
	
	/*-------------------Getter y setter-------------------------*/
	
	
	public Tienda getTienda() {
		return tienda;
	}
	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}
	
	
	/*-------------------Metodos-------------------------*/
    @Override
	public void recibirSueldo(int total) {
		tienda.getCuentaBancaria().descontarFondos(total);
		super.getCuentaBancaria().anadirFondos(total);
	}

}
