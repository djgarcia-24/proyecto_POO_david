

package proyecto_david_octubre;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
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
    
    
    static public LocalDate validarFecha( String mensaje, String regex){
        scan.nextLine();

        
        LocalDate fecha= LocalDate.of(1, 1, 1);
        String cadena;
        
        boolean continuar = true;
        
            do {
                try {
                    System.out.print(mensaje);
                    cadena = scan.nextLine();
                
                    if (cadena.matches(regex)) {
                        continuar = false;
                        fecha = LocalDate.parse(cadena);
                    } 
                else {
                    System.out.println("No valido.");
                }
            } catch (InputMismatchException error) {
                System.out.println("Debes indicar solo numeros.");
                scan.nextLine();
                continuar = false;
            } catch(DateTimeParseException e){
                System.out.println("Debes una poner fecha valida.");
                scan.nextLine();
                continuar = false;
            }
        } while(continuar);
            
            
        return fecha;
    }
    
    static public boolean validar_venta(Producto p, int cantidad){
        
        for(Entrega e: p.entregas){
            // si la fecha de vencimiento de alguna entrega es despues de hoy Y la cantidad no supera la cantidad total de productos, se vendera
            if(    e.vencimiento.isAfter( LocalDate.now() )  &&     p.cantidad_total>= cantidad    ){
                return true;
            }
        }
        return false;
    }

    static public boolean  verificar_cuenta_existente(String nombre,  String id, ArrayList<? extends Usuario> lista_usuarios){
        // de crear una cuenta con nombre e id ya existentes, no se creara la cuenta
        for(Usuario u: lista_usuarios){
            if(  u.nombre.equals(nombre) &&  u.id.equals(id) ){
                System.out.print("Cuenta ya existe!");
                
                return true;
            }
        }
        
        
        return false;
    }
}
