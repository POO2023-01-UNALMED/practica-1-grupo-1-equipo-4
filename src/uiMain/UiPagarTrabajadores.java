package uiMain;

import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicacion.gestion.Conductor;
import gestorAplicacion.gestion.CuentaBancaria;
import gestorAplicacion.gestion.Factura;
import gestorAplicacion.gestion.Operario;
import gestorAplicacion.gestion.Persona;
import gestorAplicacion.gestion.Vendedor;
import gestorAplicacion.produccion.Tienda;

public class UiPagarTrabajadores {
    
    public static void pagartrabajadores() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Has escogido la opción de pagar a trabajadores");
        System.out.println("¿A qué tipo de trabajador desea pagarle?\n");
        System.out.println("1. Operarios");
        System.out.println("2. Vendedores");
        System.out.println("3. Conductores\n");
        System.out.println("Por favor, digite el número del tipo de trabajador al cual deseas pagar: ");
        
        
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Esta es la lista de operarios que han trabajado"); 
                break;
            case 2:
                System.out.println("Esta es la lista de vendedores que han trabajado");
                break;
            case 3:
                System.out.println("Esta es la lista de conductores que han trabajado");
                break;
            default:
                System.out.println("Digitó una opción incorrecta");
        }

        ArrayList<Persona> listaTrabajadores = Fabrica.busquedaTrabajo(Factura.getListaFacturas());
        
        for (Persona i: listaTrabajadores) {
                i.toString();   //USO DE LIGADURA DINÁMICA
        }

        System.out.println("Por favor, ingrese el nombre del trabajador al cual desea pagarle");
        String nombre = sc.nextLine().toLowerCase();
        Persona trabajador;
        for (Persona i: listaTrabajadores) {
            if (i.getNombre().equals(nombre)){
                trabajador = i;
            }else{
                System.out.println("El nombre que ingresó no corresponde a ningún trabajador");
            }
        }

        int total = CuentaBancaria.calcularPago(trabajador);
        
        System.out.println("Al trabajor " + trabajador.getNombre() + "Se le pagará " + total);
        


        sc.close();

    }
    
}
