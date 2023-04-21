package uiMain;
import gestorAplicacion.gestion.Cliente;
import gestorAplicacion.produccion.Tienda;
import gestorAplicacion.gestion.CuentaBancaria;
import gestorAplicacion.produccion.Fabrica;
import gestorAplicacion.produccion.Transporte;
import gestorAplicacion.produccion.TipoTransporte;
import gestorAplicacion.gestion.Factura;

import uiMain.UiMenu;

import java.util.Scanner;
import java.util.ArrayList;

public class UiEnvio {

    public static Factura Enviar;{

        Boolean Continuar = true;  //Para ayudar a seguir o no el proceso de envío

        while (Continuar= true);{
            Scanner sc = new Scanner(System.in);
            String clientes = Cliente.mostrarClientes();
            System.out.println("Por favor seleccione el cliente al que quiere enviarle el producto:\n");
            System.out.println(clientes);
            int numeroClienteSeleccionado = sc.nextInt();
            System.out.println("Has seleccionado al cliente #" +numeroClienteSeleccionado);
            
            Cliente clienteSeleccionado = Cliente.seleccionarCliente(numeroClienteSeleccionado);
        }

    }

    
}
