package gestorAplicacion.gestion;

public class Meta {

    private String nivelDeDificultad;
    private int indice;
    private double dineroEsperado;
    private double pago;


    //Constructor

    public Meta(String nivelDeDificultad, int indice, double dineroEsperado, double pago) {
        this.nivelDeDificultad = nivelDeDificultad;
        this.indice = indice;
        this.dineroEsperado = dineroEsperado;
        this.pago = pago;
    }
    
    //Métodos
    public String cumpleMeta(int indiceTrabajado,double dineroGenerado ){
        String texto = "";
        if (indiceTrabajado >= indice && dineroGenerado >= dineroEsperado){
            texto = "La meta ha sido cumplida exitosamente\n"; 
        }else if(indiceTrabajado >= indice || dineroGenerado >= dineroEsperado){
            texto = "Solo se cumple un item de la meta\n";
        }else{
            texto = "No se cumple ningún aspecto de la meta\n";
        }
        double porcentajeindice = (indiceTrabajado*100)/indice;
        double procentajeDinero = (dineroGenerado*100)/dineroEsperado;
        texto += "Porcentaje de productos requeridos" + porcentajeindice + "\nPorcentaje de dinero requerido" + procentajeDinero;
        return texto;

    }

    @Override
    public String toString() {
        return "\nNivel de dificultad: "          + nivelDeDificultad + "\n"
        +      "Productos requeridos: "           + indice      + "\n"
        +      "Dinero esperado: "                + dineroEsperado    + "\n"
		+ 	   "Bonificación por cumplimiento: "  + pago               + "\n";
    }

    //Gets and sets
    public String getNivelDeDificultad() {
        return this.nivelDeDificultad;
    }

    public void setNivelDeDificultad(String nivelDeDificultad) {
        this.nivelDeDificultad = nivelDeDificultad;
    }

    public int getIndice() {
        return this.indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public double getDineroEsperado() {
        return this.dineroEsperado;
    }

    public void setDineroEsperado(double dineroEsperado) {
        this.dineroEsperado = dineroEsperado;
    }

    public double getPago() {
        return this.pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }
}