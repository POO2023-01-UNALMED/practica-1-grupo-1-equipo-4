package uiMain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import gestorAplicacion.gestion.Factura;

public class UiEstadisticas {

    public static int[] ingresarFechas(){

        Scanner sc = new Scanner(System.in);

        int opcion = new Menu("REPORTE", new String[]{"Analizar toda la información", 
                                                    "Ingresar fechas específicas"}).mostrar();
       
        int fechaMin = Factura.fechaMin();
        int fechaMax = Factura.fechaMax();

        switch(opcion){

            case 1:

                return new int[]{fechaMin, fechaMax};

            break;

            case 2:

                System.out.println("\nLa fecha mínima es " + fechaMin + " y la fecha máxima es " + fechaMax);
                System.out.println("Ingrese fecha de inicio: ");

                int fecha1 = Menu.ingresarConLimites(fechaMin, fechaMax);
                int fecha2 = Menu.ingresarConLimites(fecha1, fechaMax);
                
                return new int[]{fecha1, fecha2};

            break;

            default:

                return new int[]{-1, -1}; 

            break;
        }
    }

    public void estadistica(int fecha1, int fecha2){

        String opciones[] = new String[]{"Ganancias Discretas", "Ganancias Totales", 
                "Promedio por día", "Aumento porcentual", "Cambiar fechas"};

        String opcion = new Menu("Ingrese información a obtener", opciones, "Volver al inicio").mostrarReturnString();

       HashMap<Integer, Double> disc =  Factura.gananciasDiscretas(fecha1, fecha2);
        
        switch(opcion){

            case "GANANCIAS DISCRETAS":

                    System.out.println(disc);

                break;

            case "GANANCIAS TOTALES":

                    System.out.println(Factura.gananciasTotales(disc));

                break;

            case "PROMEDIO POR DIA":

                    System.out.println(Factura.promedioPorDia(fecha1, fecha2));

                break;

            case "AUMENTO PORCENTUAL":

                    System.out.println(Factura.aumentoPorcentual(fecha1, fecha2));

                break;

            case "CAMBIAR FECHAS":


                break;

            default:

                return;
            
        }

    }

    
}
