
package proyecto_david_octubre;

import java.util.Scanner;

public class Proyecto_david_octubre {

    public static void main(String[] args) {
        int opcion;
        Base_de_datos bd = new Base_de_datos();
        bd.Base_de_datos();
        
        Scanner scan = new Scanner(System.in);
        
        do{
          System.out.println("\nMenu Principal: ");
          System.out.println("0) Salir"); 
          System.out.println("1) Crear cuenta");
          System.out.println("2) Iniciar Sesion");
          
            opcion = Validaciones.validar_int("Indica un numero positivo del 0 al 2: ", 2, 0);
        
            switch (opcion) {
                case 0->{
                    System.out.println("saliendo...");
                }

                case 1->{
                    bd.crear_cuenta();
                }
                case 2->{
                    bd.iniciar_sesion();
                    
                }
            }
        }while(opcion!=0);
    }
}
