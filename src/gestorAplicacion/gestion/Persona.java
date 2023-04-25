package gestorAplicacion.gestion;

import java.util.ArrayList;

public abstract class Persona implements Financiero {
	/*-------------------Atributos-------------------------*/
	
	
	private String nombre;
	private int edad;
	private int cedula;
	private CuentaBancaria cuentaBancaria;
	private static final int salario=1000;
	private int trabajo;
	private static int personasTotales;
	private static  ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
	
	/*-------------------Constructores-------------------------*/
	
	
	/*Constructor de la clase conductor que recibe todos los parametros*/
	protected Persona(String nombre, int edad, int cedula, CuentaBancaria cuentaBancaria) {
		this.nombre=nombre;
		this.edad=edad;
		this.cedula=cedula;
		this.cuentaBancaria=cuentaBancaria;
		this.trabajo = 0;
		listaPersonas.add(this);
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
		return cuentaBancaria;
	}
	public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;}
	public static int getSalario() {
		return salario;
	}
	//public void setSalario(int salario) {
	//	this.salario = salario;
	//}
	public int getTrabajo() {
		return trabajo;
	}
	public void setTrabajo(int trabajo) {
		this.trabajo = trabajo;
	}
	public static int getPersonasTotales() {
		return personasTotales;
	}
	
	public static ArrayList<Persona> getListaPersonas(){
		return listaPersonas;
	}
	
	/*------------------- Metodos -------------------------*/
	
	public abstract void recibirSueldo(int total);
	
}
