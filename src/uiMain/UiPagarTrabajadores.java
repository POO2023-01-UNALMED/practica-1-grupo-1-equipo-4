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
        System.out.println("\nHas escogido la opción pagar a trabajadores");

        boolean verificador1 = true;

        while(verificador1){
            int opcSalida;
            boolean verificador2 = true;

            int opcion = new Menu("\n¿A qué tipo de trabajador desea pagarle?", new String[]{"Operarios", "Conductores", 
                        "Vendedores"}, "Retroceder").mostrar();
            
            if (opcion == 0){
                verificador1 = false;
                break;
            } 
            
            switch (opcion) {
                case 1:
                    System.out.println("\nEsta es la lista de operarios que han trabajado\n"); 
                    break;
                case 2:
                    System.out.println("\nEsta es la lista de conductores que han trabajado\n");
                    break;
                case 3:
                    System.out.println("\nEsta es la lista de vendedores que han trabajado\n");
                    break;
            }

            //Método #1 Verifica los trabajadores del tipo que seleccionó
            //que salen en las facturas que han sido creadas
            //System.out.println("El error está acá");
            //System.out.println(Factura.getListaFacturas());
            ArrayList<Persona> listaTrabajadores = Fabrica.busquedaTrabajo(Factura.getListaFacturas(),opcion);
            
            //Imprime la lista que se devolvió anteriormente
            int indice = 1;

            for (Persona i: listaTrabajadores) {
                System.out.print("Trabajador "+indice + i.toString() + "\n"); //USO DE LIGADURA DINÁMICA
                indice++;               
            }

            while(verificador2){
                //Pide el # del trabajador
                System.out.println("Por favor, ingrese el número del trabajador al cual desea pagarle [1-" + listaTrabajadores.size()+"]: ");
                System.out.print("> ");
                int opcTrabajador = sc.nextInt();

                if (opcTrabajador <= 0 || opcTrabajador > listaTrabajadores.size()){
                    System.out.println("Opción de trabajador incorrecta");

                }else{
                    Persona trabajadorEscogido = listaTrabajadores.get(opcTrabajador-1);

                    //Método #2
                    //Calcula el pago que se le va a dar al trabajador escogido
                    int total = CuentaBancaria.calcularPago(trabajadorEscogido);
                    
                    System.out.println("\nAl trabajor " + trabajadorEscogido.getNombre() + " se le pagará " + total);
                    
                    //Método #3
                    //Envia el dinero que calculamos antes a la cuenta del trabajador
                    // y se lo resta a la cuenta de la fabrica
                    trabajadorEscogido.recibirSueldo(total);
                    
                    System.out.println("\nEl pago fue realizado con éxito");
                    verificador2 = false;
                    break;
                }

            }

            //Ciclo final para ver si sale o se reinicia la funcionalidad
            System.out.println("\n¿Qué desea hacer?\n1. Realizar mas envios\n2.Volver al menu principal");
            while(true){
                System.out.print("> ");
                opcSalida = sc.nextInt();

                if(opcSalida==1){
                    verificador1=true;
                    break;
                }else if(opcSalida==2){
                    verificador1=false;
                    break;
                }else{
                    System.out.println("Seleccione una de las opciones disponibles: ");
                }
            }


        }
        //sc.close();
    }    
    
}
