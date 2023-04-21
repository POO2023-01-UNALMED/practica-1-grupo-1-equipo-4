package uiMain;
import gestorAplicacion.gestion.*;
import gestorAplicacion.produccion.*;


import uiMain.UiMenu;

import java.util.Scanner;
import java.util.ArrayList;

public class UiEnviarPedido {

    public static void enviarPedido(){  //cambiar el tipo de retorno a factura

        int x = 1; //para manejar el menu
        int eleccion=1;
        int numProductoSeleccionado=1;

        Scanner sc = new Scanner(System.in);

        Boolean interruptor = true;
        Cliente clienteSeleccionado = null;
        Tienda TiendaSeleccionada = null;
        Producto productoSeleccionado = null;

        ArrayList<Producto> listaDeProductos;
        while (interruptor) {

            switch(eleccion){
                case 0:
                    interruptor=false;
                    System.out.println("Has vuelto al menú anterior");
                    break;
                case 1:
                    // LO QUE se ve en pantalla
                    //System.out.println("Enviar pedido al cliente");
                    System.out.println("\n0. Volver al menu anterior");
                    // Seleccionar cliente
                    System.out.print("\nSeleccione el cliente al que desea enviar: \n");
                    System.out.println(Cliente.mostrarClientes());
     
                    //Entero seleccionado
                    int numClienteSeleccionado = sc.nextInt();
                    if (numClienteSeleccionado == 0) {
                        eleccion = 0;
                        break;}
    
                    if (numClienteSeleccionado > Cliente.getListaClientes().size()){
                        System.out.println("Número de cliente inválido, por favor seleccione un cliente en la lista");
                        eleccion=1;
                    }
                    else{
                        clienteSeleccionado = Cliente.getListaClientes().get(numClienteSeleccionado-1);
                        System.out.print("Has seleccionado al cliente # " + numClienteSeleccionado +"\nEl cliente es:" + clienteSeleccionado);
                        eleccion = 2;
                    }
                case 2: //seleccionar la tienda 
                // Visto en pantalla

                System.out.println("\n");
                System.out.println("Su pedido se enviará desde alguna de estas tiendas, por favor seleccione una:");
                System.out.println("0. Volver al menu anterior");
                System.out.println(UiMenu.fabrica.mostrarTiendas());

                // Seleccionar tienda
                System.out.print("Seleccione la tienda a la que desea enviar: ");

                //Entero seleccionado
                int numTiendaSeleccionada = sc.nextInt();
                if (x == 0) {
                    eleccion = 0;
                    break;}

                else if (numTiendaSeleccionada > UiMenu.fabrica.getListaTienda().size()) {
                    System.out.println("Número de tienda inválido, por favor seleccione una tienda en la lista");
                    eleccion = 2;
                    break;} 
                else {
                    TiendaSeleccionada = UiMenu.fabrica.getListaTienda().get(numTiendaSeleccionada-1);
                    System.out.println("Has seleccionado la tienda: " + numTiendaSeleccionada);
                    eleccion = 3; 
                }    
                case 3: //seleccionar el producto
                System.out.println("\nSeleccione el producto que desea enviarle al cliente");

                    System.out.println("0. Regresar al menu anterior");
                    System.out.println(UiMenu.fabrica.mostrarProductos());
                    System.out.print("Seleccione el producto que desea enviar: ");
                    while (x != 0) {
                        numProductoSeleccionado = sc.nextInt();
                        // Se establece el intervalo en el que estan los productos
                        
                        if (numProductoSeleccionado == 0) {
                            eleccion = 0;
                            break;
                        }  
                        if (numProductoSeleccionado >  UiMenu.fabrica.getListaProductos().size()) {
                            System.out.println("Número de producto inválido, por favor seleccione un producto en la lista");
                            eleccion = 3;
                            break;} 
                        else {
                        productoSeleccionado=UiMenu.fabrica.getListaProductos().get(numProductoSeleccionado-1);
                        System.out.print("Ha seleccionado el producto # " +numProductoSeleccionado);
                    }
                    }
               case 4: //seleccionar tipo de transporte 

 
            }

    }

    
}
}