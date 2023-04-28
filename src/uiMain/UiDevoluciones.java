package uiMain;

import gestorAplicacion.gestion.*;
import gestorAplicacion.produccion.*;
import java.util.Scanner;
import java.lang.Thread;

public class UiDevoluciones {

    public static void gestionarDevoluciones() {

        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Factura facturaSeleccionada = null;
        Producto productoSeleccionado = null;
        boolean condicion = true;
        boolean condicion2 = true;
        boolean condicion3 = true;
        int eleccion = 1;

        while (condicion) {

            switch (eleccion) {

                case 0:
                    condicion = false;
                    break;
                case 1:

                    while (condicion2) {
                        String facturas = Factura.mostrarFacturas(); // se almacenan las facturas en un string
                        System.out.println("\nPor favor seleccione el número que le corresponda\n" +
                                "a la factura para realizar la devolucion\n");
                        System.out.println("0. Volver al menu principal");
                        System.out.println(facturas); // se muestran las facturas en pantalla

                        System.out.println("Digite su opcion: ");
                        System.out.print("> ");
                        int op = sc.nextInt(); // se pide la opcion al admin
                        System.out.println("");

                        if (op == 0) {
                            eleccion = 0;
                            condicion2 =false;
                            condicion3 =false;
                            break;
                        } 
                        else if ((op > 0) && (op <= Factura.getListaFacturas().size())) {

                            facturaSeleccionada = Factura.seleccionarFactura(op);
                            System.out.println("Seleccionó la factura con la opcion número: " + op);
                            eleccion = 2;
                            break;
                        }
                        else {
                            System.out.println("¡ATENCION! La opcion que digitó es incorrecta");
                        }

                    }

                case 2:
                    while (condicion2) {
                    // se almacenan os productos de la factura seleccionada en un string
                        String producosDeFactura = Factura.mostrarProductosFacturas(facturaSeleccionada.getlistaProductos()); 

                        System.out.println("\nPor favor seleccione el número que le corresponda\n" +
                                        "a el producto para realizar la devolucion\n");
                        System.out.println("0. Volver al menu principal");
                        System.out.println(producosDeFactura); // se muestran los productos de la factura en pantalla

                        System.out.println("Digite su opcion: ");
                        System.out.print("> ");
                        int op2 = sc.nextInt(); // se pide la opcion al admin
                        System.out.println("");

                        // ciclo para saber si en la factura ya estan todos los prodcutos devueltos
                        int contadorDevoluciones = 0;
                        for (Producto producto : facturaSeleccionada.getlistaProductos()) {
                            if (producto.isDevuelto()) {
                                contadorDevoluciones++;
                            }
                        }
                        productoSeleccionado = facturaSeleccionada.seleccionarProcutoDevolver(op2);
                        if (op2 == 0) {
                            eleccion = 0;
                            condicion2 = false;
                            condicion3 =false;
                            break;
                        }

                        else if (contadorDevoluciones >= facturaSeleccionada.getlistaProductos().size()){
                            System.out.println("En la factura que seleccionó ya se han devuelto todos los productos\n"+
                                                "Por favor digite el Número de otra factura");
                        }

                        else if ((op2 > 0) && (op2 <= facturaSeleccionada.getlistaProductos().size())
                                && (!productoSeleccionado.isDevuelto())) {

                            Boolean devolver = true;
                            productoSeleccionado.setDevuelto(devolver);
                            System.out.println("Seleccionó el producto con la opcion número: " + op2);

                            // temporizador para que se vea mas real la eliminacion.
                            try {
                                Thread.sleep(500); // Espera 1 segundo
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("... Realizando devolución ... Por favor espere ...");
                            try {
                                Thread.sleep(1500); // Espera 1,5 segundos
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            double total = UiMenu.fabrica.descontarDineroCuentaAdmin(facturaSeleccionada);

                            Cliente cliente = facturaSeleccionada.getTienda()
                                    .devolverProducto(facturaSeleccionada, productoSeleccionado);

                            cliente.getCuentaBancaria().devolverDinero(total, cliente);
                            cliente.getProductos().remove(productoSeleccionado);
                            System.out.println("¡¡ El producto ha sido devuelto exitosamente !!\n");
                            try {
                                Thread.sleep(750);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            
                            eleccion = 3; // para que entre al ultimo caso
                            break;
                        }
                        else {
                            System.out.println("¡ATENCION! La opcion que digitó es incorrecta o el producto ya ha sido devuelto");
                        }
                    }

                case 3:

                    while (condicion3) {
                        System.out.println("¿Desea hacer otra devolucion o volver al menu principal?\n");
                        System.out.println("0. Volver al menu principal");
                        System.out.println("1. Realizar otra devolución");
    
                        System.out.print("> ");
                        int opcion = sc2.nextInt();
                        if (opcion == 0) {
                            eleccion = 0;
                            condicion = false;
                            break;
                        } else if (opcion == 1) {
                            eleccion = 1;
                            break;
                        } else {
                            System.out.println("¡ATENCION! La opcion que digitó es incorrecta ");
                        }
                    }
                    break;

            }
        }

    }

}
