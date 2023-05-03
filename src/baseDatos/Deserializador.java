package baseDatos;

import java.io.ObjectInputStream;
import java.util.ArrayList;
import gestorAplicacion.gestion.*;
import gestorAplicacion.produccion.*;
import java.io.*;

public class Deserializador {


    public static Serializable deserializar(String strArchivo) throws IOException, ClassNotFoundException{

        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;

            fileInputStream
            = new FileInputStream(strArchivo);
           objectInputStream
            = new ObjectInputStream(fileInputStream);
        
            Serializable s = (Serializable) objectInputStream.readObject();
            objectInputStream.close();
      
        return s;
    }

    public static ArrayList<Factura> cargarFacturas() throws IOException, ClassNotFoundException{

        ArrayList<Factura> facturas = (ArrayList<Factura>) deserializar("src\\baseDatos\\temp\\facturas.txt");

        return facturas;
    }

    public static Fabrica cargarFabrica() throws IOException, ClassNotFoundException{

        Fabrica fabrica = (Fabrica) deserializar("src\\baseDatos\\temp\\fabrica.txt");

        return fabrica;
    }

    public static ArrayList<Producto> cargarCatalogo() throws IOException, ClassNotFoundException{

        ArrayList<Producto> catalogo = (ArrayList<Producto>) deserializar("src\\baseDatos\\temp\\catalogo.txt");

        return catalogo;
    }

    public static ArrayList<Cliente> cargarClientes() throws IOException, ClassNotFoundException{

        ArrayList<Cliente> clientes= (ArrayList<Cliente>) deserializar("src\\baseDatos\\temp\\clientes.txt");

        return clientes;
    }

    public static ArrayList<Vendedor> cargarVendedores() throws IOException, ClassNotFoundException{

        ArrayList<Vendedor> vendedores = (ArrayList<Vendedor>) deserializar("src\\baseDatos\\temp\\vendedores.txt");

        return vendedores;
    }

    public static ArrayList<Tienda> cargarTiendas() throws IOException, ClassNotFoundException{

        ArrayList<Tienda> tiendas = (ArrayList<Tienda>) deserializar("src\\baseDatos\\temp\\tiendas.txt");

        return tiendas;
    }

    public static Conductor cargarConductor() throws IOException, ClassNotFoundException{

        Conductor conductor = (Conductor) deserializar("src\\baseDatos\\temp\\tiendas.txt");

        return conductor;
    }





    
}
