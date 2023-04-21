package uiMain;
import gestorAplicacion.gestion.Factura;
import gestorAplicacion.produccion.Fabrica;;
import java.util.Scanner;
import java.util.ArrayList;

public class UiDevoluciones {

    public static void gestionarDevoluciones(){

        Fabrica fabrica = new Fabrica(); //fabrica de mientras hacemos el serializador*

        Scanner sc = new Scanner(System.in);
        String facturas = Factura.mostrarFacturas();
        System.out.println("Por favor seleccione el número que le corresponda\n"+
                             "a la factura para realizar la devolucion");
        System.out.println(facturas);
        int op = sc.nextInt();
        Factura factura = Factura.seleccionarFactura(op);

        double total = fabrica.descontarDineroCuentaAdmin(factura);

        
    }

}
