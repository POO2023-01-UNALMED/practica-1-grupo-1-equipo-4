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

        /*
     * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO:  EnviarPedido
     * 
     * RECIBE: 
     * parámetro de tipo int llamado "PesoTotalProductos" 
     * es una suma del peso de los productos seleccionadoss, 
     * con este int nos aseguramos de que el transporte tenga
     *  la capacidad de carga para llevar todos los productos
     * 
     * DEVUELVE:
     * ArrayList de objetos TipoTransporte, del que el usuario elige un 
     * tipo para que le transporte su pedido 
     * 
     * DESCRIPCIÓN:
     * se crea un ArrayList llamado "listaTransFiltrada" para almacenar los tipos de transporte que
     * tienen una capacidad máxima mayor o igual al peso total de los productos. 
     * Se itera a través de los valores del enum TipoTransporte y 
     * se verifica si la capacidad máxima de cada tipo de transporte es suficiente para el peso total. Si es así, 
     * se agrega a la lista filtrada. Se retorna la lista filtrada.
     */

    public static ArrayList<TipoTransporte> crearTipoTransporteSegunCarga(int PesoTotalProductos){
		ArrayList<TipoTransporte> listaTransFiltrada = new ArrayList<TipoTransporte>();
		for(TipoTransporte tipoTransportes : TipoTransporte.values()) {
            if(tipoTransportes.getCapacidadMax() >= PesoTotalProductos){
                listaTransFiltrada.add(tipoTransportes); 
            }
	}
    return listaTransFiltrada;
}
            /*
     * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO:  EnviarPedido
     * 
     * RECIBE: 
     * parámetro de tipo ArrayList<TipoTransporte> llamado "ListaFiltrada"
     * 
     * DEVUELVE:
     * String cadena de texto que representa los tipos de transporte filtrados.
     * 
     * DESCRIPCIÓN:
     * Se inicializa una cadena vacía llamada "textoTransFiltrado" y un índice. 
     * Se itera a través de los elementos de la lista filtrada y se añade el índice, 
     * el nombre de cada tipo de transporte y un salto de línea en la cadena de texto.
     *  Finalmente, se retorna la cadena de texto resultante.
     */

    public static String mostrarTipoTransporteSegunCarga(ArrayList<TipoTransporte> ListaFiltrada){
		String textoTransFiltrado="";
        int indice = 1;
		for(TipoTransporte tipoTransportes : ListaFiltrada) {
			textoTransFiltrado += indice+". "+ tipoTransportes.getNombre()+"\n"; //se almacenan todos lo nombres de las tiendas en un string
			indice++;
        
		}
        return  textoTransFiltrado;
}

        /*
     * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO:  EnviarPedido
     * 
     * RECIBE: 
     * No recibe ningun argumento
     * 
     * DEVUELVE:
     * Devuelve un String con las tiendas y los productos que tiene con su respectiva cantidad
     * 
     * DESCRIPCIÓN:
     * Este método permite visualizar las tiendas que pertenecen a la fabrica y los productos que tiene dentro.
     */




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