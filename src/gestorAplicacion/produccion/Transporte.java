package gestorAplicacion.produccion;

public class Transporte {
     //Atributos
     private String matricula;
     private TipoTransporte tipo; 
     private Double capacidad; 
     private int costo;
    
     

        //Constructor que recibe todos los parametros 


    public Transporte(String matricula, TipoTransporte tipo, Double capacidad, int costo) {
        this.matricula = matricula;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.costo = costo;
      
}
        //Métodos 

        //MetodoMostrarTipoTransporte
        //muestra todos los tipos de transporte, su precio y su capacidadMax

        public static void MostrarTipoTransporte(String[] args) {
            TipoTransporte[] tipoTransportes = TipoTransporte.values();
            for (int i = 0; i < tipoTransportes.length; i++) {
                System.out.println(tipoTransportes[i]);
        }
    }
    //metodo para imprimir nombre, precio y capacidad de algún tipo de transporte
    public void imprimirTipoTransporte(TipoTransporte tipoTransporte) {
        System.out.println("Tipo de transporte: " + tipoTransporte.name());
        System.out.println("Precio: " + tipoTransporte.getPrecioEnvio());
        System.out.println("Capacidad máxima: " + tipoTransporte.getCapacidadMax());
    }

     //Getters y setters 


     public String getMatricula(){
        return this.matricula; 
     }

     public void setMatricula(String matricula){
        this.matricula = matricula; 
     }
    //para tipo
     public TipoTransporte getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransporte tipo) {
        this.tipo = tipo;
    }
    //para capacidad
    public Double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Double capacidad) {
        this.capacidad = capacidad;
    }
    //para costo 
    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

}

