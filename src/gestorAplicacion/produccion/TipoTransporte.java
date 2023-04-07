package gestorAplicacion.produccion;

public enum TipoTransporte {
    
    //los tipos de transporte que hay
    Camion(15000, 16329),
    Avion(30000, 640000),
    Automovil(9000,500),
    Camioneta(12000, 650), 
    Bicicleta(5000,35),
    Patines(3000,20),
    Barco(20000, 33565835),
    Container(20000, 29000),//cambielo por helicoptero :v ByLuis*
    Caminando(5000, 15); 


    @Override
    public String toString() {
        return "TipoTransporte{" + "Precio de Envío:" + precioEnvio + ", Capacidad Maxima=" + capacidadMax + '}';
    }

    //Borrar todo de aca para abajo ---------------------

    //cuanto vale cada uno 
    public double precioEnvio; //dado en pesos
    public double capacidadMax; //dado en kilogramos
    
    private TipoTransporte(double precioEnvio, double capacidadMax) {
        this.precioEnvio = precioEnvio;
        this.capacidadMax = capacidadMax;
    }

    //Metodo para que muestre los detalles de transporte  **<-- este metodo va en la clase Transporte ByLuis*

}
