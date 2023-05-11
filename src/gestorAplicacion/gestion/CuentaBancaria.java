package gestorAplicacion.gestion;

import java.io.Serializable;

public class CuentaBancaria implements Serializable {
    
    private int numeroCuenta;
    private int saldo;
    
    // Constructor
    public CuentaBancaria(int numeroCuenta, int saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }



/*
Este método permite agregar fondos a la cuenta bancaria del cliente.

ENTRADA:

fondos: cantidad de dinero a agregar a la cuenta.
SALIDA:

Ninguna.
*/

    public void anadirFondos(double fondos){
        saldo+= fondos;
    }


/*
Este método permite descontar una cantidad específica de fondos de la cuenta bancaria.

ENTRADA:

fondos: un double que indica la cantidad de fondos a descontar.
SALIDA: 
*/

    public void descontarFondos(double fondos){
        saldo -= fondos;
    }



/*

Este método actualiza la cuenta bancaria de un cliente, añadiendo los fondos correspondientes al total de la factura devuelta.

ENTRADAS:

total: un valor double que representa el monto total de la factura devuelta.
cliente: un objeto de la clase Cliente que contiene la información de la cuenta bancaria a actualizar.
SALIDA: ninguna (void).

*/
    
    public void devolverDinero(double total, Cliente cliente){
        CuentaBancaria cuenta = cliente.getCuentaBancaria();
        cuenta.anadirFondos(total);
    }


    //Hace parte de pago a trabajadores
    /* 
* Permite calcular el pago total de una persona según su salario base y su cantidad de trabajos realizados.
*
* ENTRADA: Objeto de la clase Persona.
* SALIDA: Un entero que representa el pago total de la persona.
*/

    public static int calcularPago(Persona persona){
        int trabajo = persona.getTrabajo();
        int salarioBase = Persona.getSalario();
        int total = 0;     

        //Diferentes pagos según el salario base para cada uno de los tipos
        if (persona instanceof Operario){
            total =+ (salarioBase + 3000)*trabajo;
        }else if (persona instanceof Vendedor){
            total =+ (salarioBase + 5000)*trabajo;
        }else if(persona instanceof Conductor){
            total =+ (salarioBase + 4500)*trabajo;
        }

        //retornamos el total
        return total;
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
