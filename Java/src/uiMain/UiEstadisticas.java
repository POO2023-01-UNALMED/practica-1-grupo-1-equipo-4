/*Autores: Joan Sebastian Salazar Montoya, Monica Sofia Restrepo León, 
 *   Luis Alejandro Varela Ojeda, Maria Fernanda Calle Agudelo, Jaider Castañeda Villa
 * 
 * FUNCIONALIDAD DEL MÓDULO: En esta clase se desarrolla la lógica principal de la
 * funcionalidad Mostrar estadísticas
 * 
 */

package uiMain;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import baseDatos.Load;

import gestorAplicacion.gestion.Factura;

public class UiEstadisticas {


    public static void estadistica(){

        int[] fechas = ingresarFechas();

        analisis(fechas[0], fechas[1]);


    }

    public static int[] ingresarFechas(){

        Scanner sc = new Scanner(System.in);

        int opcion = new Menu("REPORTE", new String[]{"Analizar toda la información", 
                                                    "Ingresar fechas específicas"}).mostrar();
       
        int fechaMin = Factura.getFechaMin();
        int fechaMax = Factura.getFechaMax();

        while(opcion != 0){

        switch(opcion){

            case 1:

                return new int[]{fechaMin, fechaMax};

            case 2:

                System.out.println("\nLa fecha mínima es " + fechaMin + " y la fecha máxima es " + fechaMax);

                System.out.println("Ingrese fecha de inicio: ");
                int fecha1 = Menu.ingresarConLimites(fechaMin, fechaMax);

                System.out.println("Ingrese fecha final: ");
                int fecha2 = Menu.ingresarConLimites(fecha1, fechaMax);
                
                return new int[]{fecha1, fecha2};

            case 0:

                return new int[]{-1, -1}; 

            default:

            System.out.println("Ha ingresado un valor no válido. Por favor vuelva a intentarlo");

                break;

        }

        opcion = new Menu("REPORTE", new String[]{"Analizar toda la información", 
                                                    "Ingresar fechas específicas"}).mostrar();
    }

    return new int[]{-1, -1}; 

}

    public static void analisis(int fecha1, int fecha2){

        if(fecha1 == -1 && fecha2 == -1){
            return;
        }

            
        int fechaMin = Factura.getFechaMin();
        int fechaMax = Factura.getFechaMax();


        String opciones[] = new String[]{"Ganancias Discretas", "Ganancias Totales", 
                "Promedio por dia", "Aumento porcentual", "Modas estadisticas", "Cambiar fechas"};

        String opcion = new Menu("Ingrese información a obtener", opciones, "Volver al inicio").mostrarReturnString();

       HashMap<Integer, Double> disc =  Factura.gananciasDiscretas(fecha1, fecha2);
        
        while(opcion!= "Volver al inicio"){

            switch(opcion){

                case "GANANCIAS DISCRETAS":
    
                        desplegarInfo(disc, "GANANCIA", "");
    
                    break;
    
                case "GANANCIAS TOTALES":
    
                        System.out.println("\nLas ganancias totales entre las fechas ingresadas han sido: " + Factura.gananciasTotales(disc));
    
                    break;
    
                case "PROMEDIO POR DIA":
    
                        System.out.println("\nEl promedio por día es: " + Factura.promedioPorDia(disc));
    
                    break;
    
                case "AUMENTO PORCENTUAL":
    
                        desplegarInfo(Factura.aumentoPorcentual(disc), "AUMENTO", "%");
    
                    break;
    
                case "CAMBIAR FECHAS":
    
                    System.out.println("\nLa fecha mínima es " + fechaMin + " y la fecha máxima es " + fechaMax);

                    System.out.println("Ingrese fecha de inicio: ");
                    fecha1 = Menu.ingresarConLimites(fechaMin, fechaMax);

                    System.out.println("Ingrese fecha final: ");
                    fecha2 = Menu.ingresarConLimites(fecha1, fechaMax);

                    disc =  Factura.gananciasDiscretas(fecha1, fecha2);
    
                    break;

                case "MODAS ESTADISTICAS":

                        modas(fecha1, fecha2);

                    break;

                case "VOLVER AL INICIO":

                        return;
    
                default:

                    System.out.println("Ha ingresado un valor no válido. Por favor vuelva a intentarlo");
    
                
            }

            opcion = new Menu("Ingrese información a obtener", opciones, "Volver al inicio").mostrarReturnString();
        }
    }

    public static void modas(int fecha1, int fecha2){

        String opciones[] = new String[]{"Tienda más usada", "Transporte más usado", "Cliente al que más se le ha vendido"};

        int opcion = new Menu("Seleccione moda: ", opciones).mostrar();

        System.out.println("\n");

        while(opcion != 0){

            switch(opcion){

                case 1:

                    System.out.println("La tienda más usada ha sido " 
                    + Factura.moda(fecha1, fecha2, "tienda").getNombre());

                    break;

                case 2:     

                    System.out.println("El transporte más usado ha sido " 
                    + Factura.moda(fecha1, fecha2, "transporte").getNombre());

                    break;

                case 3:

                    System.out.println("El cliente al que más se le ha vendido ha sido " 
                    + Factura.moda(fecha1, fecha2, "cliente").getNombre());

                    break;

                case 0:

                    return;

                default:

                    System.out.println("Ha ingresado un valor no válido. Por favor vuelva a intentarlo");

                break;
            }

            System.out.println("\n");

             opcion = new Menu("Seleccione moda: ", opciones).mostrar();
        }
    }

    public static void desplegarInfo(HashMap <Integer, Double> info, String strData, String posfijo){

        System.out.println("DIA \t " + strData);
    
        for(int i: info.keySet()){
            System.out.println(i + "\t" + info.get(i) + posfijo);
        }
    
    
    }
}
