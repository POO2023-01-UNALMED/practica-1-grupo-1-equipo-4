package uiMain;
import gestorAplicacion.gestion.Cliente;
import gestorAplicacion.gestion.CuentaBancaria;
import gestorAplicacion.gestion.Factura;
import gestorAplicacion.produccion.Fabrica;
import gestorAplicacion.produccion.Tienda;

import java.util.Scanner;
import java.util.ArrayList;

public class UiDevoluciones {

    public static void gestionarDevoluciones(){

        Fabrica fabrica = new Fabrica(); //fabrica de mientras hacemos el serializador*
        Tienda tienda = new Tienda(); //tienda de mientras hacemos el serializador*


        Scanner sc = new Scanner(System.in);
        String facturas = Factura.mostrarFacturas();
        System.out.println("Por favor seleccione el número que le corresponda\n"+
                             "a la factura para realizar la devolucion");
        System.out.println(facturas);
        int op = sc.nextInt();
        Factura factura = Factura.seleccionarFactura(op);

        double total = fabrica.descontarDineroCuentaAdmin(factura);

        Cliente cliente = tienda.devolverProducto(factura);

        cliente.getCuentaBancaria().devolverDinero(total, cliente);
        System.out.println("El producto ha sido devuelto exitosamente");

    }

}
