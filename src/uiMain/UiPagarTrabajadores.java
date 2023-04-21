package uiMain;

import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicacion.gestion.CuentaBancaria;
import gestorAplicacion.gestion.Factura;
import gestorAplicacion.gestion.Persona;
import gestorAplicacion.produccion.Fabrica;

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

        //Método #1 Verifica los trabajadores del tipo que seleccionó
        //que salen en las facturas que han sido creadas
        ArrayList<Persona> listaTrabajadores = Fabrica.busquedaTrabajo(Factura.getListaFacturas(),opcion);
        
        //Imprime la lista que se devolvió anteriormente
        int indice = 1;

        for (Persona i: listaTrabajadores) {
            System.out.print(indice + i.toString() + "/n"); //USO DE LIGADURA DINÁMICA
            indice++;               
        }

        
        //Pide el # del trabajador
        System.out.println("Por favor, ingrese el número del trabajador al cual desea pagarle [1-" + listaTrabajadores.size()+"]: ");
        int opcTrabajador = sc.nextInt();

        if (opcTrabajador <= 0 || opcTrabajador > listaTrabajadores.size()){
            System.out.println("Opción de trabajador incorrecta");

        }else{

            Persona trabajadorEscogido = listaTrabajadores.get(opcTrabajador-1);

            //Método #2
            //Calcula el pago que se le va a dar al trabajador escogido
            int total = CuentaBancaria.calcularPago(trabajadorEscogido);
            
            System.out.println("Al trabajor " + trabajadorEscogido.getNombre() + "Se le pagará " + total);
            
            //Método #3
            //Envia el dinero que calculamos antes a la cuenta del trabajador
            // y se lo resta a la cuenta de la fabrica
            trabajadorEscogido.recibirSueldo(total);
            
            System.out.println("El pago fue realizado con éxito");
        }

        sc.close();

    }
    
}
