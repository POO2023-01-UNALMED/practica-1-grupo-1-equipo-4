package gestorAplicacion.gestion;

public class CuentaBancaria {
    
    private int numeroCuenta;
    private int saldo;
    
    // Constructor
    public CuentaBancaria(int numeroCuenta, int saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
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
