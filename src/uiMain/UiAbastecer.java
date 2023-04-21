package uiMain;

import gestorAplicacion.gestion.*;
import gestorAplicacion.produccion.*;

import java.util.Scanner;
import java.util.Scanner;
import java.util.ArrayList;

import java.util.ArrayList;
import uiMain.UiMenu;

public class UiAbastecer {
    public static void abastecerTiendas() {

        int x = 1; //Pivote que nos permitira manejar el menu
        int eleccion=1;
        int escanerInt=1;

        Scanner escaner1 = new Scanner(System.in);
        Scanner escaner2 = new Scanner(System.in);

        Boolean interruptor = true;
        Tienda tiendaSeleccionada = null;
        Producto productoSeleccionado = null;

        ArrayList<Producto> listaDeProductos;
        while (interruptor) {

            switch(eleccion){
                case 0:
                    interruptor=false;
                    break;
                case 1:
                    // Visto en pantalla

                    System.out.println("\n");
                    System.out.println("Abastecer tiendas - Apartado de tiendas");
                    System.out.println("0. Volver al menu anterior");
                    System.out.println(UiMenu.fabrica.mostrarTiendas());

                    // Seleccionar tienda
                    System.out.print("Seleccione la tienda a la que desea enviar: ");

                    //Entero seleccionado
                    x = escaner1.nextInt();
                    while (interruptor) {
                        // Se establece el intervalo en el que estan las tiendas
                        if (x == 0) {
                            eleccion = 0;
                            break;}

                        if (x > 0 && x <= UiMenu.fabrica.getListaTienda().size()) {
                            tiendaSeleccionada = UiMenu.fabrica.getListaTienda().get(x - 1);
                            eleccion = 2;
                            break;} 
                        else if(x!=0) {System.out.print("Por favor seleccione una tienda dentro del rango: ");
                        x = escaner1.nextInt();}}

                        
                case 2:
                    System.out.println("\nAbastecer tiendas - Apartado de productos");

                    System.out.println("0. Regresar al menu anterior");
                    System.out.println(UiMenu.fabrica.mostrarProductos());
                    System.out.print("Seleccione el producto que desea enviar: ");
                    while (x != 0) {
                        escanerInt = escaner2.nextInt();
                        // Se establece el intervalo en el que estan los productos
                        
                        if (escanerInt == 0) {
                            eleccion = 1;
                            break;
                        }  
                        if (escanerInt > 0 && escanerInt <= UiMenu.fabrica.getListaProductos().size()) {
                            productoSeleccionado = UiMenu.fabrica.getListaProductos().remove(x - 1);
                            eleccion = 3;
                            break;} 
                        else {System.out.print("Por favor seleccione un producto dentro del rango: ");}
                    }

                
            
                case 3:
                    System.out.print("\nEscriba la cantidad de productos que desea abastecer: ");
                    escanerInt = escaner2.nextInt();
                    listaDeProductos = UiMenu.fabrica.cantidadProductos(escanerInt, productoSeleccionado);

                    //Aqui lo que se hace es meter todo en el camion basicamente luego haremos una comprobacion de que si sea la tienda a la que se le esta enviando

                    UiMenu.transporteAbastecer.abastecerProducto(tiendaSeleccionada, listaDeProductos);
                    
                }


            }


    }

}
