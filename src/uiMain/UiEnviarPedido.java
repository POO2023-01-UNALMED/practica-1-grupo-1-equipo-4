/*Autores: Joan Sebastian Salazar Montoya, Monica Sofia Restrepo León, 
 *   Luis Alejandro Varela Ojeda, Maria Fernanda Calle Agudelo, Jaider Castañeda Villa
 * 
 * FUNCIONALIDAD DEL MÓDULO: En esta clase se desarrolla la lógica principal de la
 * funcionalidad Enviar Pedido
 * 
 * 
 */

package uiMain;

import gestorAplicacion.gestion.*;
import gestorAplicacion.produccion.*;
import baseDatos.Load;

import java.util.Scanner;

//import javax.xml.crypto.dsig.spec.TransformParameterSpec;

import baseDatos.Load;

import java.util.ArrayList;

public class UiEnviarPedido {

    public static void enviarPedido() { // cambiar el tipo de retorno a factura

        int x = 1; // para manejar el menu
        int eleccion = 1;
        int numProductoSeleccionado = 1;

        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        Boolean interruptor = true;
        Cliente clienteSeleccionado = null;
        Tienda tiendaSeleccionada = null;
        Producto productoSeleccionado = null;
        Transporte transporteSeleccionado = null;
        TipoTransporte tipoTransportes = null;
        int PesoTotalProductos = 0;
        int numEnvioGratis=0;
         ArrayList<Producto> listaProductosPedidos = new ArrayList<Producto>();
        //ArrayList<Producto> listaProductosPedidos = new;
        
        while (interruptor) {

            switch (eleccion) {
                case 0:
                    interruptor = false;
                    System.out.println("Has vuelto al menú anterior");
                    break;
                case 1:
                    // LO QUE se ve en pantalla
                    // System.out.println("Enviar pedido al cliente")
                    System.out.println("\n0. Volver al menu anterior");
                    // Seleccionar cliente
                    System.out.print("\nSeleccione el cliente al que desea enviar: \n");
                    System.out.println(Cliente.mostrarClientes());

                    // Entero seleccionado
                    System.out.print("> ");
                    int numClienteSeleccionado = sc.nextInt();
                    if (numClienteSeleccionado == 0) {
                        eleccion = 0;
                        break;
                    }

                    if (numClienteSeleccionado > Cliente.getListaClientes().size()) {
                        System.out.println("Número de cliente inválido, por favor seleccione un cliente en la lista");
                        eleccion = 1;
                        break;
                    } else {
                        clienteSeleccionado = Cliente.getListaClientes().get(numClienteSeleccionado - 1);
                        System.out.print("Has seleccionado al cliente #" + numClienteSeleccionado + "\nEl cliente es: "
                                + clienteSeleccionado.getNombre());
                        eleccion = 2;
                    }
                case 2: // seleccionar la tienda
                    // Visto en pantalla

                    System.out.println("\n");
                    System.out.println("Su pedido se enviará desde alguna de estas tiendas, por favor seleccione una:");
                    System.out.println("0. Volver al menu principal");
                    System.out.print(Load.fabrica.mostrarTiendas());

                    // Seleccionar tienda
                    System.out.println("Seleccione la tienda desde la que desea enviar: ");

                    // Entero seleccionado
                    System.out.print("> ");
                    int numTiendaSeleccionada = sc.nextInt();
                    if (numTiendaSeleccionada == 0) {
                        eleccion = 0;
                        break;
                    }
                    else if (numTiendaSeleccionada > Load.fabrica.getListaTienda().size() || numTiendaSeleccionada < 0) {
                        System.out.println("Número de tienda inválido, por favor seleccione una tienda en la lista");
                        eleccion = 2;
                        break;
                    } else {
                        tiendaSeleccionada = Load.fabrica.getListaTienda().get(numTiendaSeleccionada - 1);
                        System.out.println("Has seleccionado la tienda: " + numTiendaSeleccionada);
                        eleccion = 3;
                    }
                case 3: // seleccionar el producto
                    System.out.println("¿Cuantos productos deseas comprar de esta tienda? \n Máximo 5 productos por cliente");
                    int cuantos = sc.nextInt();
                    if (cuantos > 5 || cuantos < 0){
                        System.out.println("No es válido, elija un numero menor o igual a 5");
                        eleccion = 3;
                        break;
                    }
                    if (cuantos > tiendaSeleccionada.getListaProductos().size()){
                        System.out.println("***La tienda de la que quieres comprar solo tiene " + tiendaSeleccionada.getListaProductos().size() +
                        ". Entonces te dejaremos comprar " + tiendaSeleccionada.getListaProductos().size() + " productos.");
                        cuantos = tiendaSeleccionada.getListaProductos().size();
                    }
                    if (cuantos <= 5 && cuantos > 0){
                    for (int i = 0; i < cuantos; i++){
                        
                        System.out.println("\nSeleccione el producto que desea enviarle al cliente");

                        System.out.println("0. Regresar al menu principal");
                        System.out.println(tiendaSeleccionada.cantidadProductosVentas());
                        System.out.println("Seleccione el producto que desea enviar: ");
                        System.out.print("> ");
                        numProductoSeleccionado = sc.nextInt();
                        // Se establece el intervalo en el que estan los productos
    
                        if (numProductoSeleccionado == 0) {
                            eleccion = 0;
                            break;
                        }
                        if (numProductoSeleccionado > tiendaSeleccionada.getListaProductos().size() || numProductoSeleccionado < 0) {
                            System.out.println("Número de producto inválido, por favor seleccione un producto en la lista");
                            cuantos++;
                        } else {
                            productoSeleccionado = tiendaSeleccionada.getListaProductos().get(numProductoSeleccionado - 1);
                            System.out.print("Ha seleccionado el producto # " + numProductoSeleccionado + " Nombre del producto: " + productoSeleccionado.getNombre());
                            listaProductosPedidos.add(productoSeleccionado);
                            tiendaSeleccionada.venderProducto(productoSeleccionado);
                            PesoTotalProductos += productoSeleccionado.getPeso();
                            //System.out.println(PesoTotalProductos);
                            eleccion = 4;
                        }

                    }
                    break;
                }

                case 4: // seleccionar tipo de transporte
                    System.out.println("\n\nSeleccione en que medio de transporte quiere enviar este producto");
                    System.out.println("Junto a cada tipo de transporte se encuentra su precio.");
                    System.out.println(
                            "\nAdvertencia: Los tipos de transporte han sido filtrados de manera que solo puede seleccionar los que puedan soportar el peso de su producto."
                            + "\nSu pedido pesa " + PesoTotalProductos + " kilogramos");

                    
                    System.out.println("0. Regresar al menu principal");

                    // TipoTransporte tipoTransportes;
                    ArrayList<TipoTransporte> listaTransFiltrada = new ArrayList<TipoTransporte>();
                    listaTransFiltrada = TipoTransporte.crearTipoTransporteSegunCarga(PesoTotalProductos);
                    // System.out.println(Load.tipoTransportes.mostrarTipoTransporteSegunCarga(productoSeleccionado));
                    System.out.println(TipoTransporte.mostrarTipoTransporteSegunCarga(listaTransFiltrada));
                    System.out.println("Seleccione el número del tipo de transporte: ");
                    System.out.print("> ");
                    int numTransporteSeleccionado = sc.nextInt();
                    
                    if (numTransporteSeleccionado == 0) {
                        eleccion = 0;
                        break;
                    }

                    if (numTransporteSeleccionado > listaTransFiltrada.size() || numTransporteSeleccionado < 0) {
                        System.out
                                .println("Número de transporte inválido, por favor seleccione un producto en la lista");
                        eleccion = 4;
                        break;
                    }
                    else {
                        transporteSeleccionado = TipoTransporte.seleccionarTransporte(listaTransFiltrada,
                                numTransporteSeleccionado);
                        System.out.print("Ha seleccionado el transporte #" + (numTransporteSeleccionado)
                                + "\nEl pedido se enviará por " + transporteSeleccionado.getTipo().getNombre());
                        System.out.println("\nDesea aplicar envío gratis?\n 1. Si   2. No");
                        System.out.print("> ");
                        transporteSeleccionado.recordarPrecioTransporte();
                        while(true){
                            numEnvioGratis = sc.nextInt();
                            if (numEnvioGratis == 1){
                                
                                Transporte.enviarGratis(transporteSeleccionado);
                                System.out.println("Su tarifa de envío ha bajado de: $" + transporteSeleccionado.getPrecioOriginalTransporte()+ " a $0");
                                break;
                            }else if(numEnvioGratis != 2){
                                System.out.println("Seleccione un numero dentro del rango");
                                System.out.print("> ");
                            }else{
                                break;
                            }
                        }
                        

                        eleccion = 5;
                        break;
                    }

                case 5: // retorna factura
                    System.out.println("\nDigite el día del mes entre 1 y 30: ");
                    System.out.print("> ");
                    int dia=1;
                    while(true){
                        dia = sc.nextInt();
                        if (dia >= 1 && dia <=30){
                            break;
                        }else{
                            System.out.println("Seleccione un numero dentro del rango");
                            System.out.print("> ");
                        }
                    }
                    System.out.println("\n************************************\n"+ "Factura generada en la tienda " 
                    +tiendaSeleccionada.getNombre() + "\nA nombre del cliente: " + clienteSeleccionado.getNombre()+"\n" 
                    +tiendaSeleccionada.enviarPedido(new ArrayList<>(listaProductosPedidos),
                            transporteSeleccionado, clienteSeleccionado, dia, Load.fabrica.getOperario())+"\n************************************\n\n\n");
                    
                    if(numEnvioGratis==1){
                        transporteSeleccionado.reestablecerPrecioTrans();}
                    listaProductosPedidos.clear();

                    // Realiza una copia de la listaProductosPedidos
                    PesoTotalProductos = 0;
                    System.out.println("¿Desea hacer otro envio o volver al menu principal? ");
                    System.out.println("0. Volver al menu principal");
                    System.out.println("1. Realizar otro  envio");
                    System.out.print("> ");
                    int opcion = sc2.nextInt();
                    while (true) {
                        if (opcion == 0) {
                            eleccion = 0;
                            interruptor = false;
                            break;
                        } else if (opcion == 1) {
                            eleccion = 1;
                            break;
                        } else {
                            System.out.println(" La opcion que digitó es incorrecta ");
                        }
                    }
                    break;

            }

        }

    }
}
