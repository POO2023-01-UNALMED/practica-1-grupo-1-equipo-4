package gestorAplicacion.produccion;

public enum TipoTransporte {
    
    //los tipos de transporte que hay
    CAMION(15000, 16329),
    AVION(30000, 640000),
    AUTOMOVIL(9000,500),
    CAMIONETA(12000, 650), 
    BICICLETA(5000,35),
    PATINES(3000,20),
    BARCO(20000, 33565835),
    HELICOPTERO(70000, 29000),
    TREN(20000,30000),
    CAMINANDO(5000, 15); 



    @Override
    public String toString() {
        return "TipoTransporte{" + "Precio de Envío:" + precioEnvio + ", Capacidad Maxima=" + capacidadMax + '}';
    }
 
    public double getPrecioEnvio() {
        return precioEnvio;
    }

    public double getCapacidadMax() {
        return capacidadMax;
    }

    public double precioEnvio; //dado en pesos
    public double capacidadMax; //dado en kilogramos
    
    private TipoTransporte(double precioEnvio, double capacidadMax) {
        this.precioEnvio = precioEnvio;
        this.capacidadMax = capacidadMax;
    }

}
