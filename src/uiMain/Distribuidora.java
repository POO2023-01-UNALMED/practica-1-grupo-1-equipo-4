package uiMain;
import gestorAplicacion.gestion.*;
public class Distribuidora {
	public static void main(String[] args) {
		
		CuentaBancaria cuenta1 = new CuentaBancaria(333333,55555555);
		CuentaBancaria cuenta2 = new CuentaBancaria(444444,55555555);
		CuentaBancaria cuenta3 = new CuentaBancaria(555555,55555555);
		CuentaBancaria cuenta4 = new CuentaBancaria(666666,55555555);

		
		
		Cliente cliente1 = new Cliente("Jose","Carrera33","Metafetamina",cuenta1);
		Cliente cliente2 = new Cliente("AA","Carrera33","Metafetamina",cuenta2);
		Cliente cliente3 = new Cliente("BB","Carrera33","Metafetamina",cuenta3);
		Cliente cliente4 = new Cliente("CC","Carrera33","Metafetamina",cuenta4);

		System.out.println(Cliente.mostrarClientes());
		System.out.println(Cliente.seleccionarCliente(1));
	}
}
