package gestorAplicacion.gestion;
import gestorAplicacion.produccion.*;


public class CuentaBancaria {
    
    private int numeroCuenta;
    private int saldo;
    
    // Constructor
    public CuentaBancaria(int numeroCuenta, int saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public void anadirFondos(double fondos){
        this.saldo += fondos;
    }

    public void descontarFondos(double fondos){

        if(this.saldo - fondos < 0)
            System.out.println("Fondos insuficientes!"); //Esto debería ser una excepción
        else
            this.saldo -= fondos;
        
    }

    public static void anadirFondos(Persona persona, double fondos){
        persona.getCuentaBancaria().anadirFondos(1000);
    }

    public static void anadirFondos(Tienda tienda, double fondos){
        tienda.getCuentaBancaria().anadirFondos(1000);
    }

    public static void descontarFondos(Persona persona, double fondos){
        persona.getCuentaBancaria().descontarFondos(1000);
    }

    public static void descontarFondos(Tienda tienda, double fondos){
        tienda.getCuentaBancaria().descontarFondos(1000);
    }




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
