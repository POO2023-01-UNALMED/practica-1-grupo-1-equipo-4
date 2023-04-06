package gestorAplicacion.produccion;

public enum TipoTransporte {
    
    //los tipos de transporte que hay 
    Camion(15000, 500),
    Avion(30000, 10000),
    Carro(10000,600),
    Automovil(9000,400),
    Camioneta(12000, 700), 
    Bicicleta(5000,100),
    Patines(3000,50),
    Barco(20000, 400),
    Caminando(5000, 20); 

    //cuanto vale cada uno 
    private double precioEnvio; //dado en pesos
    private double distanciaMax; //dado en kilometros recorridos en un día

    private TipoTransporte(double precioEnvio, double distanciaMax) {
        precioEnvio = precioEnvio;
        distanciaMax = distanciaMax;
    }


}
