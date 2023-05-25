package uiMain;

import java.util.ArrayList;
import java.util.Scanner;


public class Menu {


    private String[] opciones;
   // private Mostrable[] opcionesMostrables;
    private int numOpciones;
    private String enunciado;
    private String opcionDefault;

    public Menu(String enunciado, String[] opciones){

        this.opciones = opciones;
        numOpciones = opciones.length;
        this.enunciado = enunciado;
        opcionDefault = "Cancelar";
    }

  /*    public Menu(String enunciado, Mostrable[] opcionesMostrables){

        this.opcionesMostrables = opcionesMostrables;
        numOpciones = opciones.length;
        this.enunciado = enunciado;
        opcionDefault = "Cancelar";
    }*/

    public Menu(String enunciado, String[] opciones, String opcionDefault){

        this.opciones = opciones;
        numOpciones = opciones.length;
        this.enunciado = enunciado;
        this.opcionDefault = opcionDefault;
    }

    public int mostrar(){

        System.out.println(enunciado + "\n");

        //if(opciones != null){
            for(int i = 0; i < numOpciones; i++){
                System.out.println((i + 1) + ". " + opciones[i]);
            }
        /* }else{

            for(int i = 0; i < numOpciones; i++){
                System.out.println((i + 1) + ". " + opcionesMostrables[i].getNombre());
            }
        }*/
        System.out.println("0. " +  opcionDefault);

        Scanner sc = new Scanner(System.in);

        System.out.print("> ");

        int input = sc.nextInt();

        while(input < 0 || input > numOpciones){

            System.out.println("El valor ingresado no es válido. Ingreselo nuevamente por favor.");
            System.out.print("> ");
            input = sc.nextInt();
        }

        return input;

    }

    public String mostrarReturnString(){

        System.out.println(enunciado + "\n");

        for(int i = 0; i < numOpciones; i++){
            System.out.println((i + 1) + ". " + opciones[i]);
        }

        System.out.println("0. Cancelar");

        Scanner sc = new Scanner(System.in);

        System.out.print("> ");

        int input = sc.nextInt();

        while(input < 0 || input > numOpciones){

            System.out.println("El valor ingresado no es válido. Ingreselo nuevamente por favor.");
            System.out.print("> ");
            input = sc.nextInt();
        }

        if(input == 0){
            return "Volver al inicio".toUpperCase();
        }

        return opciones[input - 1].toUpperCase();

    }

    public static int ingresarConLimites(int limite1, int limite2){

        System.out.print("\n> ");

        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();

        while(input < limite1 || input > limite2){

            System.out.println("El valor ingresado no es válido. Inténtelo nuevamente por favor");
            System.out.print("\n> ");
            input = sc.nextInt();
        }

        return input;
    }


}
