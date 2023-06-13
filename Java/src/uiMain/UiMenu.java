/*Autores: Joan Sebastian Salazar Montoya, Monica Sofia Restrepo León, 
 *   Luis Alejandro Varela Ojeda, Maria Fernanda Calle Agudelo, Jaider Castañeda Villa
 * 
 * FUNCIONALIDAD DEL MÓDULO: En esta clase contiene el main del proyecto,
 * despliega el menú y según lo elegido se muestran cada una de las funcionalidades.
 * 
 */
package uiMain;

import gestorAplicacion.gestion.*;
import gestorAplicacion.produccion.*;
import baseDatos.*;

import java.util.Scanner;

import baseDatos.Serializador;

import java.util.ArrayList;
import java.util.Arrays;



public class UiMenu {
    static Scanner sc = new Scanner(System.in);
    
	public static void main(String[] args) {

        Load.cargar();

        int opcion;
        
		do{
            System.out.println("\nMenú principal Distribuidora SAS\n");
			System.out.println("1. Enviar pedido");
			System.out.println("2. Pagar a trabajadores");
			System.out.println("3. Abastecer tiendas");
			System.out.println("4. Gestionar devoluciones");
            System.out.println("5. Mostrar estadísticas");
            System.out.println("6. Salir\n");

			System.out.println("Ingrese el número de la opción que desea utilizar");
            System.out.print("> ");
            opcion = sc.nextInt();

            switch(opcion){
                case 1:
                    UiEnviarPedido.enviarPedido();
                    break;
                case 2:
                    UiPagarTrabajadores.pagartrabajadores();
                    break;
                case 3:
                    UiAbastecer.abastecerTiendas();
                    break;
                case 4:
                    UiDevoluciones.gestionarDevoluciones();
                    break;
                case 5:
                    UiEstadisticas.estadistica();
                    break;
                case 6:

                    Load.guardar();

                    System.out.println("Gracias por visitarnos");
                    System.out.println("Vuelva pronto");

                    break;
                    
                default:
                    System.out.println("\nDigitó una opción incorrecta");
                    
            }
        }while(opcion != 6);
	
	}


}

