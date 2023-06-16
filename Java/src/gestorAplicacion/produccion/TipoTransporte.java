/* Autores: Joan Sebastian Salazar Montoya, Monica Sofia Restrepo León, 
Luis Alejandro Varela Ojeda, Maria Fernanda Calle Agudelo, Jaider Castañeda Villa
 * FUNCIONALIDAD DEL ENUMERADO: enumerado que establece el conjunto de valores constantes 
 * disponibles para los tipos de transportes en los que se pueden transportar los productos.
 */
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


    //Atributos
    public double precioEnvio; //dado en pesos
    public double capacidadMax; //dado en kilogramos
    public String Nombre;


    //Metodos
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
			textoTransFiltrado += indice+". "+ tipoTransportes.getNombre()+ " $" +tipoTransportes.getPrecioEnvio() +"\n"; //se almacenan todos lo nombres de las tiendas en un string
			indice++;
        
		}
        return  textoTransFiltrado;
}

        /*
     * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO:  EnviarPedido
     * 
     * 
     * RECIBE: 
     * recibe dos parámetros, 
     * primero un ArrayList de objetos TipoTransporte llamado "ListaFiltrada" 
     * segundo un entero llamado "opcion". 
     * 
     * 
     * DEVUELVE:
     * un objeto de la clase Transporte. 
     * 
     * 
     * DESCRIPCIÓN:
     * Se establecen los valores mínimo y máximo para generar un número aleatorio. 
     * Luego, se genera un número aleatorio dentro de ese rango. 
     * Se obtiene un conductor aleatorio de la lista de conductores 
     * y se obtienen los detalles del tipo de transporte seleccionado según la opción. 
     * A partir de estos valores, se crea un objeto Transporte. 
     * Se establece el transporte al conductor y se retorna el objeto Transporte creado.
     */


    public static Transporte seleccionarTransporte(ArrayList<TipoTransporte> ListaFiltrada,int opcion){
        
        int min = 0; // valor mínimo
        int max = Conductor.getListaConductores().size()-1; // valor máximo

        Random random = new Random();
        int randomNumber = random.nextInt(max - min + 1) + min; //se genera un nuero aleatorio

        Conductor conductor = Conductor.getListaConductores().get(randomNumber);
        TipoTransporte tipo = ListaFiltrada.get(opcion-1);
        Double capacidad= ListaFiltrada.get(opcion-1).getCapacidadMax();
        Double precioEnvio = ListaFiltrada.get(opcion-1).getPrecioEnvio();

        Transporte transporte = new Transporte(tipo,capacidad,precioEnvio,conductor);
        conductor.setTransporte(transporte);

        return transporte;
    }


    //Getter y setter
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

    public void setPrecioEnvio(double precioEnvio) {
        this.precioEnvio = precioEnvio;
    }
}