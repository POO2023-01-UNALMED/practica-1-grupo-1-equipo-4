package gestorAplicacion.gestion;

import gestorAplicacion.produccion.Producto; 


public class Cliente{
	private String nombre;
	private String direccion;
	private CuentaBancaria cuentaBancaria;
	private Producto producto;
	
	
	
	public Cliente(String nombre, String direccion, CuentaBancaria cuentaBancaria) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cuentaBancaria = cuentaBancaria;
    }
	public Cliente() {}
	
	
	  // Getters
	  public String getNombre() {
        return nombre;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }
    
    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }
    

}


