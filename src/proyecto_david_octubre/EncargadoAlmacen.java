
package proyecto_david_octubre;

import java.util.ArrayList;

public class EncargadoAlmacen extends Usuario{
    @Override
    public void mostrar_datos(){
        super.mostrar_datos();
    }
    
    @Override
    public void leer_datos(){
        tipo = "encargado almacen";
        super.leer_datos();
        super.mostrar_datos();
    }
    
    private void mostrar_lista_productos(ArrayList<  ArrayList<Producto >> colecciones_de_productos){
        for (ArrayList<Producto> coleccion : colecciones_de_productos) {
            //imprimir primero el nombre, id  y de los productos de la coleccion
            
            System.out.println(coleccion.get(0).nombre);
            
            System.out.println(coleccion.get(0).id);
            
            System.out.println(coleccion.get(0).categoria);
            
            
            //falta cantidad total
            for (Producto p : coleccion) {
                
                //imprimir la fecha de vencimiento de cada lote
                System.out.println(p.fecha_vencimiento);        
            }
        }
        
    
    }
    
    @Override
    public void menu(ArrayList<  ArrayList<Producto > >  colecciones_de_productos){
        System.out.println("Bienvenido "+nombre+":) !");
        int opcion;
        
        do{
          System.out.println("\nMenu de encargado de almacen: ");
           
          System.out.println("0) Salir ");
          System.out.println("1) Ingresar producto");
          System.out.println("2) Editar producto");
          
          opcion = Validaciones.validar_int("Indica un numero positivo del 0 al 2: ", 2, 0);
            
            switch (opcion) {
                case 0->{                    
                    System.out.println("saliendo...");
                }

                case 1->{
                    //verificar si existe
                    
                    
                    
                }
                case 2->{                
                    //hacer funcion buscar para poder editarlo
                }
                
                
                
                
            }
        }while(opcion!=0);
    
    
    
    }
    
    
}
