package uiMain;

import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicacion.gestion.CuentaBancaria;
import gestorAplicacion.gestion.Factura;
import gestorAplicacion.gestion.Persona;
import gestorAplicacion.produccion.Fabrica;

public class UiPagarTrabajadores {

    public static void pagartrabajadores() {

        System.out.println("\nHas escogido la opción pagar a trabajadores");

        boolean verificador1 = true;

        while(verificador1){

            Scanner sc = new Scanner(System.in);
            int opcSalida;
            boolean verificador2 = true;

            int opcion = new Menu("¿A qué tipo de trabajador desea pagarle?", new String[]{"Operarios", "Vendedores", 
                        "Conductores"}, "Retroceder").mostrar();
            
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


            while(verificador2){
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
                    verificador2 = false;
                    break;
                }

            }

            //Ciclo final para ver si sale o se reinicia la funcionalidad
            System.out.println("1. Realizar mas envios"+"\n"+"2.Volver al menu principal");
            while(true){
                opcSalida = sc.nextInt();
                if(opcSalida==1){
                    verificador1=true;
                    break;
                }else if(opcSalida==2){
                    verificador2=false;
                    break;
                }else{
                    System.out.println("Seleccione una de las opciones disponibles: ");
                }
            }
            sc.close();

        }
        

    }    
    
}
