package uiMain;

import java.util.*;

import gestorAplicacion.Nombrable;
import gestorAplicacion.gestion.CuentaBancaria;
import gestorAplicacion.gestion.Vendedor;
import gestorAplicacion.produccion.*;

// Solo es

public class TestMenu {

    public static void main(String[] args) {
        
        ArrayList<Nombrable> tiendas = new ArrayList<Nombrable>();

        for(int i = 0; i < 10; i++)
            tiendas.add(new Tienda("Tienda" + i, 
                        new Vendedor(), 
                        new CuentaBancaria(i*1000, i * 123)));

        Menu menu1 = new Menu("Ingrese tienda", tiendas);

        Tienda tiendaEscogida = (Tienda) tiendas.get(menu1.iniciar());

        System.out.println("\nTienda escogida: ");
        System.out.println(tiendaEscogida.toString());

    }

}
