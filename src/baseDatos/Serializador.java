package baseDatos;

import java.io.*;
import java.io.Serializable;

import gestorAplicacion.gestion.Factura;

public class Serializador {
   
        public static void serializar(Serializable objeto, String strArchivo){

            ObjectOutputStream objectOutputStream;
            FileOutputStream fileOutputStream;

            try{
                fileOutputStream
                = new FileOutputStream(strArchivo);
   
                 objectOutputStream 
                = new ObjectOutputStream(fileOutputStream);       
   
            objectOutputStream.writeObject(objeto);
            objectOutputStream.flush();
            objectOutputStream.close();
   
            }catch(IOException e){

                System.out.println("ERROR: HA OCURRIDO UN ERROR EN LA SALIDA");
                e.printStackTrace();

            }
        }


        public static void guardarFacturas(){

            serializar(Factura.getListaFacturas(),
             "src\\baseDatos\\temp\\facturas.txt");

            }

        public static void guardarTiendas(){

        }

        public static void guardar(){

            guardarFacturas();
            guardarTiendas();

        }

        public static void main(String args[]){

            try{
                System.out.println(Deserializador.cargarFacturas());


            }catch(Exception e){
                e.printStackTrace();
            }
        
        }
}
