/* Autores: Joan Sebastian Salazar Montoya, Monica Sofia Restrepo León, 
Luis Alejandro Varela Ojeda, Maria Fernanda Calle Agudelo, Jaider Castañeda Villa
 * FUNCIONALIDAD DE LA CLASE: clase que representa las metas que se le pueden dar a los trabajadores 
 * para recibir incentivos monetarios por el cumplimiento de ciertos objetivos. 
 */

package gestorAplicacion.gestion;
import java.io.Serializable;


public class Meta implements Serializable{

    private String nivelDeDificultad;
    private double indice;
    private double pago;

    //Constructor

    public Meta(String nivelDeDificultad, double indice, double pago) {
        this.nivelDeDificultad = nivelDeDificultad;
        this.indice = indice;
        this.pago = pago;

    }

    //Métodos

    /*
     * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Pago a trabajadores
     * 
     * RECIBE: 
     * El respectivo indice (double) trabajado hasta el momento.
     * 
     * DEVUELVE: 
     * Boolean que representa si la meta fue cumplida o no.
     * 
     * DESCRIPCIÓN: 
     * Este método permite saber si la meta fue o no cumplida.
     */
    public boolean cumpleMeta(double indiceTrabajado){
        if (indiceTrabajado >= indice){
            return true;
        }else{
            return false;
        }
    }

    /*
     * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Pago a trabajadores
     * 
     * RECIBE: 
     * El respectivo indice trabajado hasta el momento.
     * 
     * DEVUELVE: 
     * String con las estadisticas de la meta.
     * 
     * DESCRIPCIÓN:
     * Este método permite obtener el porcentaje cumplido de meta, además del
     * porcentaje faltante y cuando falta para que se cumpla la meta.
     */

    public String porcentajesCumplidos(double indiceTrabajado){
        double porcentajeindice = (indiceTrabajado*100)/indice;
        String texto = "Porcentaje de la meta cumplido: " + porcentajeindice + "%";
        if(porcentajeindice < 100){
            texto += "\nPorcentaje faltante: " + (100-porcentajeindice) + "%";
            texto += "\nCantidad faltante del indice indicado: " + (indice-indiceTrabajado); 
        }
        return texto;
    }


    @Override
    public String toString() {
        return "Nivel de dificultad: "            + nivelDeDificultad + "\n"
        +      "indice requerido: "               + indice            + "\n"
		+ 	   "Bonificación por cumplimiento: "  + pago              + "\n";
    }


    //Gets and sets

    public String getNivelDeDificultad() {
        return this.nivelDeDificultad;
    }

    public void setNivelDeDificultad(String nivelDeDificultad) {
        this.nivelDeDificultad = nivelDeDificultad;
    }

    public double getIndice() {
        return this.indice;
    }

    public void setIndice(double indice) {
        this.indice = indice;
    }

    public double getPago() {
        return this.pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }
  
}