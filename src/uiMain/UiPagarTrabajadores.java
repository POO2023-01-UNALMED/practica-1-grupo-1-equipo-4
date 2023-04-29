package uiMain;

import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicacion.gestion.Conductor;
import gestorAplicacion.gestion.CuentaBancaria;
import gestorAplicacion.gestion.Factura;
import gestorAplicacion.gestion.Meta;
import gestorAplicacion.gestion.Operario;
import gestorAplicacion.gestion.Persona;
import gestorAplicacion.gestion.Vendedor;
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
                        "Vendedores"}, "Volver al menú principal").mostrar();
            
            if (opcion == 0){
                verificador1 = false;
                break;
            } 

            boolean verificador3 = true;
            while(verificador3){
                //Método #1 Verifica los trabajadores del tipo que seleccionó
                //que salen en las facturas que han sido creadas
                ArrayList<Persona> listaTrabajadores = Fabrica.busquedaTrabajo(Factura.getListaFacturas(),opcion);

                if (listaTrabajadores.size()==0){
                    System.out.print("\nLo sentimos, ningun de trabajador de este tipo ha trabajado por el momento\n");
                    verificador3 = false;
                    break;
                }

                ArrayList<Meta> listaMetas;
                switch (opcion) {
                    case 1:
                        System.out.println("\nEsta es la lista de Operarios que han trabajado"); 
                        listaMetas = Operario.getMetasOperario();
                        break;
                    case 2:
                        System.out.println("\nEsta es la lista de Conductores que han trabajado");
                        listaMetas = Conductor.getMetasConductor();
                        break;
                    case 3:
                        System.out.println("\nEsta es la lista de Vendedores que han trabajado");
                        listaMetas = Vendedor.getMetasVendedor();
                        break;
                }

                //Imprime la lista que se devolvió anteriormente
                System.out.println(Fabrica.mostrarPersonas(listaTrabajadores));

                while(verificador2){
                    //Pide el # del trabajador
                    if(listaTrabajadores.size()==1){
                        System.out.println("Por favor, ingrese el número del trabajador al cual desea pagarle [1]: ");

                    }else{
                        System.out.println("Por favor, ingrese el número del trabajador al cual desea pagarle [1-" + listaTrabajadores.size()+"]: ");
                    }
                    System.out.print("> ");
                    int opcTrabajador = sc.nextInt();
    
                    if (opcTrabajador <= 0 || opcTrabajador > listaTrabajadores.size()){
                        System.out.println("Opción de trabajador incorrecta");
    
                    }else{
                        Persona trabajadorEscogido = listaTrabajadores.get(opcTrabajador-1);
    
                        //Método #2
                        //Calcula el pago que se le va a dar al trabajador escogido
                        int total = CuentaBancaria.calcularPago(trabajadorEscogido);
                        
                        System.out.println("\nAl trabajor " + trabajadorEscogido.getNombre() + " se le pagará " + total + " por trabajar " + trabajadorEscogido.getTrabajo() + " veces");
                        
                        
                        System.out.println("\n¿Desea analizar y pagar al trabajador por sus metas cumplidas?\n1.Si\n2.No");
                        
                        boolean verificador4 = true;

                        int valorPorMetas = 0;

                        while(verificador4){
                            System.out.println("\nDigite el número de la opción que desee");
                            System.out.print("> ");
                            int opcMeta = sc.nextInt();

                            switch(opcMeta){
                                case 1:
                                verificador4 = false;
                                break;
                                case 2:
                                System.out.println("El trabajador escogido tiene las siguientes metas");
                                //Falta terminar aquí
                                verificador4 = false;
                                break;
                                default:
                                System.out.println("Opción incorrecta");
                            }
                        }

                        //Método #3
                        //Envia el dinero que calculamos antes a la cuenta del trabajador
                        // y se lo resta a la cuenta de la fabrica
                        trabajadorEscogido.recibirSueldo(total + valorPorMetas);
                        
                        System.out.println("\nEl pago fue realizado con éxito\n");
                        System.out.println("**************************");
                        System.out.println("Comprobante");
                        System.out.println("Pago asociado a los envios realizados " + total);
                        System.out.println("Pago asociado al cumpliento de metas " + valorPorMetas);
                        System.out.println("Total = " + (total+valorPorMetas));
                        System.out.println("**************************");

                        //Asignamos de nuevo 0 al trabajo, para que si se le paga de nuevo,
                        //no se le pague más de una vez por el mismo trabajo
                        trabajadorEscogido.setTrabajo(0);

                        verificador2 = false;
                        break;
                    }
                }
                verificador3 = false;

            }
            
            //Ciclo final para ver si sale o se reinicia la funcionalidad
            System.out.println("\n¿Qué desea hacer?\n1. Pagar a otro trabajador\n0.Volver al menu principal");
            while(true){
                System.out.print("> ");
                opcSalida = sc.nextInt();

                if(opcSalida==1){
                    verificador1=true;
                    break;
                }else if(opcSalida==0){
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
