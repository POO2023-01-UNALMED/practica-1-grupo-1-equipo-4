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
        int eleccion;
        Scanner escaner1 = new Scanner(System.in);
        Scanner escaner2 = new Scanner(System.in);
        Boolean interruptor = true;
        Tienda tiendaSeleccionada = null;
        Producto productoSeleccionado;
        while (interruptor) {

            switch(x){
                if (x == 0) {
                    break;
                }
                // Visto en pantalla
                System.out.println("\n");
                System.out.println("Abastecer tiendas - Apartado de tiendas");
                System.out.println("0. Volver al menu anterior");
                System.out.println(UiMenu.fabrica.mostrarTiendas());
                // Seleccionar tienda
                System.out.print("Seleccione la tienda a la que desea enviar: ");
                x = escaner1.nextInt();
                while (interruptor && x != 0) {
                    // Se establece el intervalo en el que estan las tiendas

                    if (x > 0 && x <= UiMenu.fabrica.getListaTienda().size()) {
                        tiendaSeleccionada = UiMenu.fabrica.getListaTienda().get(x - 1);
                        break;} 
                    else {System.out.print("Por favor seleccione una tienda dentro del rango: ");}

                    x = escaner1.nextInt();

                    if (x == 0) {break;}

                }

                System.out.println("\nAbastecer tiendas - Apartado de productos");

                if (x != 0) {
                    System.out.println("0. Regresar al menu anterior");
                    System.out.println(tiendaSeleccionada.mostrarProductos());}

                while (x != 0) {
                    eleccion = escaner2.nextInt();
                    // Se establece el intervalo en el que estan los productos

                    if (x > 0 && x <= tiendaSeleccionada.getListaProductos().size()) {
                        productoSeleccionado = tiendaSeleccionada.getListaProductos().remove(x - 1);
                        break;} 
                    else {System.out.print("Por favor seleccione un producto dentro del rango: ");}

                    if (x == 0) {
                        x = 1;
                        break;
                    }

                }   
            }   

        
        }
    }

}