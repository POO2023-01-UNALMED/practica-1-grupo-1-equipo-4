package baseDatos;

import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;

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
        @SuppressWarnings("unchecked") /*Jaider: Lo puse porque me tiraba que esta operacion no era segura cuando intentaba hacer un .jar*/

        ArrayList<Factura> facturas = (ArrayList<Factura>) deserializar("src/baseDatos/temp/facturas.txt");

        return facturas;
    }


    public static Fabrica cargarFabrica() throws IOException, ClassNotFoundException{

        Fabrica fabrica = (Fabrica) deserializar("src/baseDatos/temp/fabrica.txt");

        return fabrica;
    }


    public static ArrayList<Producto> cargarCatalogo() throws IOException, ClassNotFoundException{

        ArrayList<Producto> catalogo = (ArrayList<Producto>) deserializar("src/baseDatos/temp/catalogo.txt");

        return catalogo;
    }


    public static ArrayList<Cliente> cargarClientes() throws IOException, ClassNotFoundException{

        ArrayList<Cliente> clientes= (ArrayList<Cliente>) deserializar("src/baseDatos/temp/clientes.txt");

        return clientes;
    }


    public static ArrayList<Vendedor> cargarVendedores() throws IOException, ClassNotFoundException{

        ArrayList<Vendedor> vendedores = (ArrayList<Vendedor>) deserializar("src/baseDatos/temp/vendedores.txt");

        return vendedores;
    }


    public static ArrayList<Tienda> cargarTiendas() throws IOException, ClassNotFoundException{

        ArrayList<Tienda> tiendas = (ArrayList<Tienda>) deserializar("src/baseDatos/temp/tiendas.txt");

        return tiendas;
    }


    public static Transporte cargarTransporte() throws IOException, ClassNotFoundException{

        Transporte transporte = (Transporte) deserializar("src/baseDatos/temp/transporte.txt");

        return transporte;
    }


    public static ArrayList<Conductor> cargaConductores() throws IOException, ClassNotFoundException{

        ArrayList<Conductor> conductores = (ArrayList<Conductor>) deserializar("src/baseDatos/temp/conductores.txt");

        return conductores;
    }

    public static HashMap<String, Moda> cargaAtributos() throws IOException, ClassNotFoundException{

        HashMap<String, Moda>  infoAtributos = (HashMap<String, Moda>) deserializar("src/baseDatos/temp/infoAtributos.txt");

        return infoAtributos;

    }

    
}
