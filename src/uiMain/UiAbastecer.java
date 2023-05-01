package uiMain;

import gestorAplicacion.produccion.*;
import java.util.Scanner;
import java.util.ArrayList;

public class UiAbastecer {
    public static void abastecerTiendas() {

        int x = 1; // Pivote que nos permitira manejar el menu
        int eleccion = 1;
        int escanerInt = 1;

        Scanner escaner1 = new Scanner(System.in);
        Scanner escaner2 = new Scanner(System.in);

        Boolean interruptor = true;
        Tienda tiendaSeleccionada = null;
        Producto productoSeleccionado = null;
        Transporte transporteSeleccionado=null;
        ArrayList<Producto> listaDeProductos;
        while (interruptor) {

            switch (eleccion) {
                case 0: {
                    interruptor = false;
                    break;
                }
                case 1:
                    // Visto en pantalla
                    System.out.println("\n");
                    System.out.println("Abastecer tiendas - Apartado de tiendas");
                    System.out.println("\n0. Volver al menu anterior\n");
                    System.out.print(UiMenu.fabrica.mostrarTiendas());
                    // Seleccionar tienda
                    System.out.print("Seleccione la tienda a la que desea enviar: ");
                    // Entero seleccionado
                    x = escaner1.nextInt();
                    while (interruptor) {
                        // Se establece el intervalo en el que estan las tiendas
                        if (x == 0) {
                            eleccion = 0;
                            break;
                        }

                        if (x > 0 && x <= UiMenu.fabrica.getListaTienda().size()) {
                            tiendaSeleccionada = UiMenu.fabrica.getListaTienda().get(x - 1);
                            eleccion = 2;
                            break;
                        } else if (x != 0) {
                            System.out.print("Por favor seleccione una tienda dentro del rango: ");
                            x = escaner1.nextInt();
                        }
                    }
                    break;
                case 2:
                    System.out.println("\nAbastecer tiendas - Apartado de productos");
                    System.out.print("\nLa capacidad de productos para esta tienda es la siguiente: \n");
                    System.out.println(tiendaSeleccionada.productosPorCategoria());
                    System.out.println("\n0. Regresar al menu anterior");
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
                            productoSeleccionado = UiMenu.fabrica.getListaProductos().get(escanerInt - 1);
                            eleccion = 3;
                            break;
                        } else {
                            System.out.print("Por favor seleccione un producto dentro del rango: ");
                        }
                    }
                    break;

                case 3: // Cantidad de productos
                    System.out.print("\nEscriba la cantidad de productos que desea abastecer: ");
                    int productoEnTiendaPorCategoria = tiendaSeleccionada.getProductosPorCategoria()
                            .get(productoSeleccionado.getCategoria());
                    int productosMaximosEnTiendaPorCategoria = tiendaSeleccionada.getCantidadPorCategoria()
                            .get(productoSeleccionado.getCategoria());
                    while (true) {
                        escanerInt = escaner2.nextInt();
                        if (escanerInt == 0){
                            eleccion =1;
                            break;
                        }
                        else if (escanerInt <= productosMaximosEnTiendaPorCategoria - productoEnTiendaPorCategoria) {
                            eleccion = 4;
                            break;
                        } else {
                            System.out.print("Por favor seleccione una cantidad en el limite de la tienda: ");
                        }
                    }
                    break;

                case 4: // seleccionar tipo de transporte
                    int PesoTotalProductos = escanerInt * ((int) Math.round(productoSeleccionado.getPeso()));
                    System.out.println("\n\nSeleccione en que medio de transporte quiere enviar este producto");
                    System.out.println(
                            "\nAdvertencia: Los tipos de transporte han sido filtrados de manera que solo puede seleccionar los que puedan soportar el peso de su producto.");

                    System.out.println("0. Regresar al menu principal");

                    // TipoTransporte tipoTransportes;
                    ArrayList<TipoTransporte> listaTransFiltrada = new ArrayList<TipoTransporte>();
                    listaTransFiltrada = TipoTransporte.crearTipoTransporteSegunCarga(PesoTotalProductos);
                    // System.out.println(UiMenu.tipoTransportes.mostrarTipoTransporteSegunCarga(productoSeleccionado));
                    System.out.println(TipoTransporte.mostrarTipoTransporteSegunCarga(listaTransFiltrada));
                    System.out.println("Seleccione el número del tipo de transporte: ");
                    System.out.print("> ");
                    while(true){
                    int numTransporteSeleccionado = escaner2.nextInt();
                    if (numTransporteSeleccionado == 0) {
                        eleccion = 0;
                        break;
                    }

                    if (numTransporteSeleccionado > listaTransFiltrada.size()) {
                        System.out
                                .print("Número de transporte inválido, por favor seleccione un producto en la lista \n> ");
                    }

                    else {
                        transporteSeleccionado = TipoTransporte.seleccionarTransporte(listaTransFiltrada,
                                numTransporteSeleccionado);
                        System.out.print("Ha seleccionado el transporte #" + (numTransporteSeleccionado)
                                + "\nLa tienda se abastecera por: " + transporteSeleccionado.getTipo().getNombre());
                        eleccion = 5;
                        break;
                    }}
                    break;
                case 5:

                    listaDeProductos = UiMenu.fabrica.cantidadProductos(escanerInt, productoSeleccionado);
                    // Aqui lo que se hace es meter todo en el camion basicamente luego haremos una
                    // comprobacion de que si sea la tienda a la que se le esta enviando
                    transporteSeleccionado.abastecerProducto(tiendaSeleccionada, listaDeProductos);
                    // Se llega a la tienda y se sacan los productos del transporte pero primero se
                    // comprueba que el transporte si vaya hacia esa tienda
                    if (transporteSeleccionado.getTienda().equals(tiendaSeleccionada) == true) {
                        tiendaSeleccionada.descargarProducto(transporteSeleccionado, 0);
                        System.out
                                .println("El producto fue enviado con exito ahora la tienda tienda tiene \nPRODUCTOS: "
                                        + tiendaSeleccionada.cantidadProductos());
                    } else {
                        System.out.println("El envio no se pudo realizar a esa tienda");
                    }
                    // Ciclo final para ver si sale o se reinicia la funcionalidad
                    System.out.println("\n0.Volver al menu principal" + "\n" + "1. Realizar más abastecimientos");
                    System.out.print("> ");
                    while (true) {
                        escanerInt = escaner2.nextInt();
                        if (escanerInt == 0) {
                            eleccion = 0;
                            break;
                        } else if (escanerInt == 1) {
                            eleccion = 1;
                            break;
                        } else {
                            System.out.println("Seleccione una de las opciones disponibles: ");
                        }
                    }
                    break;
            }

        }

    }

}
