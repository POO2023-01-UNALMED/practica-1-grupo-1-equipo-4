package uiMain;

import gestorAplicacion.gestion.*;
import gestorAplicacion.produccion.*;

import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Thread;

import uiMain.UiMenu;

public class UiDevoluciones {

    public static void gestionarDevoluciones(){

        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        boolean condicion = true;
        boolean condicion2 = true;
        int eleccion = 1;
    
        while (condicion){

            switch (eleccion) {

                case 0:
                    condicion = false;
                    break;
                case 1:

                    while(condicion2){
                    String facturas = Factura.mostrarFacturas(); //se almacenan las facturas en un string
                    System.out.println("Por favor seleccione el número que le corresponda\n"+
                                        "a la factura para realizar la devolucion\n");
                    System.out.println("0. Volver al menu principal");
                    System.out.println(facturas); //se muestran las facturas en pantalla
                    int op = sc.nextInt(); // se pide la opcion al admin

                    if (op == 0){
                        eleccion = 0;
                        condicion = false;
                        break;
                    }
                    else if ((op >0) && (op <= Factura.getListaFacturas().size())){

                        Factura factura = Factura.seleccionarFactura(op);
                        System.out.println("Seleccionó la factura con la opcion número: "+ op);

                        //temporizador para que se vea mas real la eliminacion.
                        try {
                            Thread.sleep(1000); // Espera 1 segundo
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("⌛🕗 Realizando devolución ... Por favor espere 🕔⌛");
                        try {
                            Thread.sleep(2000); // Espera 2 segundos
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        double total = UiMenu.fabrica.descontarDineroCuentaAdmin(factura);
            
                        Cliente cliente = factura.getTienda().devolverProducto(factura);
            
                        cliente.getCuentaBancaria().devolverDinero(total, cliente);
                        cliente.setProducto(null);
                        System.out.println("✅ El producto ha sido devuelto exitosamente ✅");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        eleccion = 2; //para que entre al ultimo caso
                    }    
                    else {
                        System.out.println("❌ La opcion que digitó es incorrecta ❌");}
                    }
                    break;

                case 2:

                    System.out.println("¿Desea hacer otra devolucion o volver al menu principal?\n");
                    System.out.println("0. Volver al menu principal");
                    System.out.println("1. Realizar otra devolución");

                    int opcion =  sc2.nextInt();
                    while(true){
                        if (opcion == 0){
                            eleccion = 0;
                            condicion = false;
                            break;
                        }
                        else if(opcion ==1){
                            eleccion = 1;
                            break;
                        }
                        else{
                            System.out.println("❌ La opcion que digitó es incorrecta ❌");
                        }
                    }
                    break;
                
            }
        }

    }

}
