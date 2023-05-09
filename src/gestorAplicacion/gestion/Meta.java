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
    public boolean cumpleMeta(double indiceTrabajado,double dineroGenerado ){
        if (indiceTrabajado >= indice){
            return true;
        }else{
            return false;
        }
    }

    public String porcentajesCumplidos(double indiceTrabajado,double dineroGenerado){
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