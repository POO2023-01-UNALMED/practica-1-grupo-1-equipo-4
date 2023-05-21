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

                System.out.println("ERROR: HA OCURRIDO UN ERROR EN LA SERIALIZACIÓN");
                e.printStackTrace();

            }
        }


        public static void guardarFacturas(){

            serializar(Load.facturas,
             "src/baseDatos/temp/facturas.txt");

            }

        public static void guardarTiendas(){

            serializar(Load.tiendas, "src/baseDatos/temp/tiendas.txt");

        }

        public static void guardarFabrica(){

            serializar(Load.fabrica, "src/baseDatos/temp/fabrica.txt");
        }

        public static void guardarCatalogo(){
            serializar(Load.catalogo, "src/baseDatos/temp/catalogo.txt");
        }

        public static void guardarClientes(){
            serializar(Load.clientes, "src/baseDatos/temp/clientes.txt");
        }

         public static void guardarVendedores(){
            serializar(Load.vendedores, "src/baseDatos/temp/vendedores.txt");
         }

         public static void guardarTransporte(){
             serializar(Load.transporteAbastecer, "src/baseDatos/temp/transporte.txt");
         }

         public static void guardarConductor(){
            serializar(Load.conductor, "src/baseDatos/temp/conductor.txt");
         }
         //por si acaso NO BORRAR O explota el programa
        //  public static void guardarMetas(){

        //     serializar(Load.metas,
        //      "src/baseDatos/temp/meta.txt");

        //     }

        public static void main(String args[]){

            System.out.println(Load.catalogo);

        }

       
}
