/*Autores: Joan Sebastian Salazar Montoya, Monica Sofia Restrepo León, 
Luis Alejandro Varela Ojeda, Maria Fernanda Calle Agudelo, Jaider Castañeda Villa
 * FUNCIONALIDAD DE LA CLASE:clase que representa una cuenta bancaria la que se utiliza para 
 * realizar los respectivos pagos y descuentos tanto a los trabajadores y clientes, 
 * como a las cuentas de la fábrica y las tiendas.
 */
package gestorAplicacion.gestion;

import java.io.Serializable;


public class CuentaBancaria implements Serializable {

    private static final long serialVersionUID = 125316253L;    
    
    private int numeroCuenta;
    private int saldo;
    
    // Constructor
    public CuentaBancaria(int numeroCuenta, int saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }
/*


ENTRADA: Doble que representa la cantidad de dinero a agregar a la cuenta.
SALIDA: Ninguna

Este método permite agregar fondos a la cuenta bancaria del cliente.

*/

    public void anadirFondos(double fondos){
        saldo+= fondos;
    }

/*
ENTRADA: un double que indica la cantidad de fondos a descontar.
SALIDA: Ninguna
DESCRIPCIÓN: Este método permite descontar una cantidad específica de fondos de la cuenta bancaria.
*/


    public void descontarFondos(double fondos){
        saldo -= fondos;
    }
    /*
     * FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Devoluciones
     * 
     * RECIBE: 
     * un objeto de tipo Cliente y un double total.
     * 
     * DEVUELVE: 
     * nada, este metodo no retorna cosas solo realiza operaciones.
     * 
     * DESCRIPCIÓN: lo que hace es regresar el dinero a la cuenta del cliente
     * por la devolucion del producto comprado.
     */
    public void devolverDinero(double total, Cliente cliente){
        CuentaBancaria cuenta = cliente.getCuentaBancaria();
        cuenta.anadirFondos(total);
    }

    /* 
* FUNCIONALIDADES EN LAS QUE ESTÁ INVOLUCRADO: Pago a trabajadores
*
* ENTRADA: 
* Objeto de la clase Persona.
* SALIDA: 
* DESCRIPCIÓN: Un entero que representa el pago total de la persona.
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
