package gestorAplicacion.gestion;

public class Meta {

    private String nivelDeDificultad;
    private int numProductos;
    private double dineroEsperado;
    private double pago;


    //Constructor

    public Meta(String nivelDeDificultad, int numProductos, double dineroEsperado, double pago) {
        this.nivelDeDificultad = nivelDeDificultad;
        this.numProductos = numProductos;
        this.dineroEsperado = dineroEsperado;
        this.pago = pago;
    }
    
    //Métodos
    public String cumpleMeta(int numProductosTrabajados,double dineroGenerado ){
        String texto = "";
        if (numProductosTrabajados >= numProductos && dineroGenerado >= dineroEsperado){
            texto = "La meta ha sido cumplida exitosamente\n"; 
        }else if(numProductosTrabajados >= numProductos || dineroGenerado >= dineroEsperado){
            texto = "Solo se cumple un item de la meta\n";
        }else{
            texto = "No se cumple ningún aspecto de la meta\n";
        }
        double porcentajeNumProductos = (numProductosTrabajados*100)/numProductos;
        double procentajeDinero = (dineroGenerado*100)/dineroEsperado;
        texto += "Porcentaje de productos requeridos" + porcentajeNumProductos + "\nPorcentaje de dinero requerido" + procentajeDinero;
        return texto;

    }

    //Gets and sets
    public String getNivelDeDificultad() {
        return this.nivelDeDificultad;
    }

    public void setNivelDeDificultad(String nivelDeDificultad) {
        this.nivelDeDificultad = nivelDeDificultad;
    }

    public int getNumProductos() {
        return this.numProductos;
    }

    public void setNumProductos(int numProductos) {
        this.numProductos = numProductos;
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