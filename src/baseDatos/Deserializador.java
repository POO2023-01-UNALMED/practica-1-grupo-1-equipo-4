package baseDatos;

import java.io.ObjectInputStream;
import java.util.ArrayList;
import gestorAplicacion.gestion.Factura;
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

        ArrayList<Factura> facturas = (ArrayList<Factura>) deserializar("src\\baseDatos\\temp\\facturas.txt");

        return facturas;
    }
    
}
