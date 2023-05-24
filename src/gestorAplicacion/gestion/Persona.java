/*  Autores: Joan Sebastian Salazar Montoya, Monica Sofia Restrepo León, 
Luis Alejandro Varela Ojeda, Maria Fernanda Calle Agudelo, Jaider Castañeda Villa
 * FUNCIONALIDAD DE LA CLASE: clase abstracta que proporciona atributos y métodos 
 * comunes para la creación de los distintos tipos de trabajadores de la empresa.
 */
package gestorAplicacion.gestion;

import java.io.Serializable;
import java.util.ArrayList;


public abstract class Persona implements Serializable {


	/*-------------------Atributos-------------------------*/

	private static final long serialVersionUID = 12736217L;    
	
	
	private String nombre;
	private int edad;
	private int cedula;
	private CuentaBancaria cuentaBancaria;
	private static final int SALARIO=1000;
	private int trabajo;
	private double indiceMeta;
	private ArrayList<Boolean> verificadorMetasCumplidas = new ArrayList<Boolean>();
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
		this.indiceMeta = 0;
		this.verificadorMetasCumplidas.add(false);
		this.verificadorMetasCumplidas.add(false);
		listaPersonas.add(this);
		

		}


	/*Constructor de la clase persona que no recibe ninguna parametros*/
	public Persona() {}

	/*------------------- Metodos -------------------------*/
	
	public abstract void recibirSueldo(int total);
	
	
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
		return SALARIO;
	}
	

	public int getTrabajo() {
		return trabajo;
	}
	
	public void setTrabajo(int trabajo) {
		this.trabajo = trabajo;
	}

	public double getIndiceMeta(){
		return indiceMeta;
	}

	public void setIndiceMeta(double indiceMeta) {
		this.indiceMeta = indiceMeta;
	}

	public ArrayList<Boolean> getVerificadorMetasCumplidas() {
		return verificadorMetasCumplidas;
	}
	
	public void setVerificadorMetasCumplidas(ArrayList<Boolean> verificadorMetasCumplidas) {
		this.verificadorMetasCumplidas = verificadorMetasCumplidas;
	}

	public static int getPersonasTotales() {
		return personasTotales;
	}
	
	public static ArrayList<Persona> getListaPersonas(){
		return listaPersonas;
	}



	

	
}
