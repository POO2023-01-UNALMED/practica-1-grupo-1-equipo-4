package uiMain;

import java.util.Scanner;

public class Menu {

    /*
     * 
     *  INSTRUCCIONES:
     * 
     *  Digamos que queremos ejecutar el siguiente menu, el cual valide correctamente que se ingrese la opción correcta:
     * 
     *  Ingrese información a obtener
     * 
     *  1. Ganancias discretas
     *  2. Ganancias totales
     *  3. Promedio por día
     *  4. Aumento porcentual
     *  0. Retroceder
     * 
     *  > ... [input del usuario]
     * 
     *  Entonces hacemos lo siguiente:
     * 
     *  int opcion = new Menu("Ingrese información a obtener", new String[]{"Ganancias Discretas", "Ganancias Totales", 
                "Promedio por día", "Aumento porcentual", "Cambiar fechas"}, "Retroceder")

        El primer atributo es el enunciado, el segundo son las opciones, y el tercero es el enunciado de la opción 0 que mata
        el proceso. La línea de código anterior lo que hace es efectivamente empezar el proceso del menu. La opción
        seleccionada (de 1 a n) es la opción escogida por el usuario.
        
        Si quieren puedo hacer para que no necesariamente se pueda "devolver", pero me tienen que decir. 

        El ejemplo anterior está en el método estadística de la clase UiEstadística por si lo quieren checar más a detalle. 
     * 
     * 
     * 
     */

    private String[] opciones;
    private int numOpciones;
    private String enunciado;
    private String opcionDefault;

    public Menu(String enunciado, String[] opciones){

        this.opciones = opciones;
        numOpciones = opciones.length;
        this.enunciado = enunciado;
        opcionDefault = "Cancelar";
    }

    public Menu(String enunciado, String[] opciones, String opcionDefault){

        this.opciones = opciones;
        numOpciones = opciones.length;
        this.enunciado = enunciado;
        this.opcionDefault = opcionDefault;
    }

    public int mostrar(){

        System.out.println(enunciado + "\n");

        for(int i = 0; i < numOpciones; i++){
            System.out.println((i + 1) + ". " + opciones[i]);
        }

        System.out.println("0. " +  opcionDefault);

        Scanner sc = new Scanner(System.in);

        System.out.print("> ");

        int input = sc.nextInt();

        while(input > 0 || input > numOpciones){

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

        while(input > 0 || input > numOpciones){

            System.out.println("El valor ingresado no es válido. Ingreselo nuevamente por favor.");
            System.out.print("> ");
            input = sc.nextInt();
        }

        if(input == 0){
            return "Volver al inicio";
        }

        return opciones[input - 1];

    }

    public static int ingresarConLimites(int limite1, int limite2){

        System.out.print("\n> ");

        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();

        while(input < limite1 || input > limite2){

            System.out.println("El valor ingresado no es válido. Inténtelo nuevamente por favor");
            
            input = sc.nextInt();
        }

        return input;
    }
}
