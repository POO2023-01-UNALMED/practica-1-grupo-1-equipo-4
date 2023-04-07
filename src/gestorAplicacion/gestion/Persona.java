package gestorAplicacion.gestion;

public abstract class Persona {
	private String nombre;
	private int edad;
	private int cedula;
	private CuentaBancaria cuentaBancaria;
	private int salario;
	private int trabajo;
	private static int personasTotales;
	
	/*-------------------Constructores-------------------------*/
	
	
	/*Constructor de la clase conductor que recibe todos los parametros*/
	public Persona(String nombre, int edad, int cedula, CuentaBancaria cuentaBancaria,int salario, Boolean trabajo) {
		this.nombre=nombre;
		this.edad=edad;
		this.cedula=cedula;
		this.cuentaBancaria=cuentaBancaria;
		this.salario=salario;
		this.trabajo=trabajo;
		personasTotales = getPersonasTotales() + 1;
	}
	/*Constructor de la clase persona que no recibe ninguna parametros*/
	public Persona() {}
	
	
	/*-------------------Getters y setters-------------------------*/
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	public CuentaBancaria getCuentaBancaria() {
		return nombre;
	}
	public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;}
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	public Boolean getTrabajo() {
		return trabajo;
	}
	public void setTrabajo(Boolean trabajo) {
		this.trabajo = trabajo;
	}
	public static int getPersonasTotales() {
		return personasTotales;
	}
	
	
	/*------------------- Metodos -------------------------*/
}
