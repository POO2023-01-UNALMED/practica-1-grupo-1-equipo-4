package gestorAplicacion.gestion;

public class CuentaBancaria {
    
    private int numeroCuenta;
    private int saldo;
    private Financiero financiero;
    
    // Constructor
    public CuentaBancaria(int numeroCuenta, int saldo, Financiero finanicero) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.financiero = finanicero;
    }

    public void anadirFondos(double fondos){
        financiero
            .getCuentaBancaria()
            .anadirFondos(fondos);
    }

    public void descontarFondos(double fondos){
        financiero
            .getCuentaBancaria()
            .descontarFondos(fondos);
    }
  
    /*Quite esto cuando lo lea, Yo, Jaider le quite el static a estos metodos ya que no tenia 
     * sentido que lo tuviera y cambie los 1000 por la variable fondos*/

   /*  public void anadirFondos(Persona persona, double fondos){
        persona.getCuentaBancaria().anadirFondos(fondos); /*1000 -> fondos
    }

    public void anadirFondos(Tienda tienda, double fondos){
        tienda.getCuentaBancaria().anadirFondos(fondos);
    }

    public void descontarFondos(Persona persona, double fondos){
        persona.getCuentaBancaria().descontarFondos(fondos);
    }

    public void descontarFondos(Tienda tienda, double fondos){
        tienda.getCuentaBancaria().descontarFondos(fondos);
    }
    
    public void anadirFondos(Fabrica fabrica, double fondos){
        Fabrica.getCuentaBancaria().anadirFondos(fondos);
    }

    public void descontarFondos(Fabrica fabrica, double fondos){
        Fabrica.getCuentaBancaria().descontarFondos(fondos);
    } */

    // Getters
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    // Setters
    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
