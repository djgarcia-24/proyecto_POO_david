
package proyecto_david_octubre;

import java.util.ArrayList;


public class Vendedor extends Usuario{
    @Override
    public void mostrar_datos(){
        super.mostrar_datos();
    }
    
    @Override
    public void leer_datos(){
        tipo = "vendedor";
        super.leer_datos();
        super.mostrar_datos();
    }
    
    
    @Override
    public void menu( ArrayList<Producto >  productos){
        System.out.println("Bienvenido "+nombre+":) !");
        int opcion;
        
        do{
          System.out.println("\nMenu de vendedor: ");
           
          System.out.println("0) Salir ");
          System.out.println("1) Buscar producto");
          System.out.println("2) Registrar venta");
          
          
            opcion = Validaciones.validar_int("Indica un numero positivo del 0 al 2: ", 2, 0);
            
            switch (opcion) {
                case 0->{                    
                    System.out.println("saliendo...");
                }

                case 1->{
                }
                case 2->{                    
                }
                
                
                
                
            }
        }while(opcion!=0);
    
    
    
    }
    
    
    
    
}
