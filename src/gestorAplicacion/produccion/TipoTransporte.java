package gestorAplicacion.produccion;

import java.util.ArrayList;

import gestorAplicacion.gestion.Conductor;

import java.util.Random;

public enum TipoTransporte {
    
    //los tipos de transporte que hay
    CAMION(5, 16329, "Camion"),
    AVION(10, 640000,"Avion"),
    AUTOMOVIL(3,500,"Automovil"),
    CAMIONETA(4, 650,"Camioneta"), 
    BICICLETA(1,35,"Bicicleta"),
    PATINES(1,20,"Patines"),
    BARCO(15, 33565835,"Barco"),
    HELICOPTERO(22, 29000,"Helicoptero"),
    TREN(33,30000,"Tren"),
    CAMINANDO(1, 15,"Caminando"); 



    @Override
    public String toString() {
        return this.getNombre();
    }
 
    public double getPrecioEnvio() {
        return precioEnvio;
    }

    public double getCapacidadMax() {
        return capacidadMax;
    }

    public String getNombre() {
        return Nombre;
    }

    public double precioEnvio; //dado en pesos
    public double capacidadMax; //dado en kilogramos
    public String Nombre;
    
    

    private TipoTransporte(int precioEnvio, double capacidadMax, String nombre) {
        this.precioEnvio = precioEnvio;
        this.capacidadMax = capacidadMax;
        Nombre = nombre;
    }

    public static ArrayList<TipoTransporte> crearTipoTransporteSegunCarga(int PesoTotalProductos){
		ArrayList<TipoTransporte> listaTransFiltrada = new ArrayList<TipoTransporte>();
		for(TipoTransporte tipoTransportes : TipoTransporte.values()) {
            if(tipoTransportes.getCapacidadMax() >= PesoTotalProductos){
                listaTransFiltrada.add(tipoTransportes); 
            }
	}
    return listaTransFiltrada;
}
    

    public static String mostrarTipoTransporteSegunCarga(ArrayList<TipoTransporte> ListaFiltrada){
		String textoTransFiltrado="";
        int indice = 1;
		for(TipoTransporte tipoTransportes : ListaFiltrada) {
			textoTransFiltrado += indice+". "+ tipoTransportes.getNombre()+"\n"; //se almacenan todos lo nombres de las tiendas en un string
			indice++;
        
		}
        return  textoTransFiltrado;
}

    public static Transporte seleccionarTransporte(ArrayList<TipoTransporte> ListaFiltrada,int opcion){
        
        int min = 0; // valor mínimo
        int max = Conductor.getListaConductores().size()-1; // valor máximo

        Random random = new Random();
        System.out.println(max);
        int randomNumber = random.nextInt(max - min + 1) + min; //se genera un nuero aleatorio

        Conductor conductor = Conductor.getListaConductores().get(randomNumber);
        TipoTransporte tipo = ListaFiltrada.get(opcion-1);
        Double capacidad= ListaFiltrada.get(opcion-1).getCapacidadMax();
        Double precioEnvio = ListaFiltrada.get(opcion-1).getPrecioEnvio();

        Transporte transporte = new Transporte(tipo,capacidad,precioEnvio,conductor);
        conductor.setTransporte(transporte);

        return transporte;
    }
}