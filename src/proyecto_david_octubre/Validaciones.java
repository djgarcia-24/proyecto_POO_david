
package proyecto_david_octubre;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validaciones {
    static Scanner scan = new Scanner(System.in);

    //a
    static public int validar_int(String mensaje, int max,int min){
       int valor = 0 ;
       
       boolean repetir = true;
       do {
            try {
                System.out.println(mensaje);
                valor = scan.nextInt();
                if (valor < min || valor >max) {
                    System.out.println("No valido.");
                } else {
                    repetir = false;
                }
            } catch (InputMismatchException error) {
                System.out.println("Error: Debes indicar un numero entero.");
                scan.nextLine();
            }
        } while(repetir);

      return valor;
    }
    
    static public String validar_string( String mensaje, String regex){
        String cadena;
        boolean continuar = true;
       
       do {
            System.out.print(mensaje);
            cadena = scan.nextLine();
            if (cadena.matches(regex)) {
                continuar = false;
             } 
            else {
                System.out.println("No valido.");
            }
       }  while(continuar);
        return cadena;
    }
}
