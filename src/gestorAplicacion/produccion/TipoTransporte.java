package gestorAplicacion.produccion;

public class TipoTransporte extends Transporte {
    
    //Atributos
    String nombre;
    int velocidadPromedio;

    //constructor que recibe todos los parametros teniendo en cuenta la herencia de Transporte

    public TipoTransporte(String matricula, TipoTransporte tipo, Double capacidad, int costo, String nombre,
    int velocidadPromedio) {
    super(matricula, tipo, capacidad, costo); //los atributos del papá
    //Sus propios atributos
    this.nombre = nombre;
    this.velocidadPromedio = velocidadPromedio;
    }


    //métodos 
    //setters y getters 

    //para nombre
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //para velocidadPromedio
    public int getVelocidadPromedio() {
        return velocidadPromedio;
    }
    public void setVelocidadPromedio(int velocidadPromedio) {
        this.velocidadPromedio = velocidadPromedio;
    }

    
}
