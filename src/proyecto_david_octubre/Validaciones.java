

package proyecto_david_octubre;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Validaciones {
    static Scanner scan = new Scanner(System.in);

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
    
    static public boolean  verificar_cuenta_existente(String nombre,  String id, ArrayList<? extends Usuario> lista_usuarios){
        // de crear una cuenta con nombre e id ya existentes, no se creara la cuenta
        for(Usuario u: lista_usuarios){
            if(  u.nombre.equals(nombre) &&  u.id.equals(id) || nombre.isBlank()|| nombre.isEmpty() || id.isBlank() || id.isEmpty()){
                System.out.print("Cuenta ya existe!");
                
                return true;
            }
        }
        
        
        return false;
    }

    static public boolean validar_producto(String nombre, String id){
        for(Producto p: Base_de_datos.productos){
            if(nombre.equals(p.nombre) || id.equals(p.id)){
                System.out.println("\nNo puedes tener dos productos con mismo nombre y/o id!");
                System.out.println("\n Producto "+p.nombre+" y "+p.id+" ya existe");
                return true; 
            }
        }
        
        if(nombre.isEmpty() || nombre.isBlank() || id.isEmpty() || id.isBlank()){
            System.out.println("\nNo puedes tener datos vacios!");
            return true;
        }
        
   
        return false;
    }
    
    
    static public boolean validar_vencimiento(){
        System.out.println("El producto tiene fecha de vencimiento?:");
        
        int respuesta = validar_int("1) si \n0) no", 1, 0 );
        
        if(respuesta == 0){
            return false;
        }
        else if (respuesta == 1){
            return true;
        }
        
        return false;
    } 
    
    static public boolean producto_vencido(Producto p){
        
        for(Entrega e: p.entregas){
        
            // si existe todavia alguna entrega con vencimietno despues de hoy, retornar false
            if(  e.vencimiento.isAfter( LocalDate.now() )){
                return false;
            }
        }
        return true;
    }
    
    static public boolean validar_venta(Producto p, int cantidad){
        if(    producto_vencido(p)  ||     p.cantidad_total<cantidad    ){
            return false;
        }
        
        return true;
    }

    static public double validar_monto( String mensaje, int min){
       double valor = 0 ;
       
       boolean repetir = true;
       do {
           try {
                System.out.println(mensaje);
                valor = scan.nextDouble();
                if (valor < min) {
                    System.out.println("No valido.");
                } else {
                    repetir = false;
                }
            } catch (InputMismatchException error) {
                System.out.println("Error: Debes indicar un numero.");
                scan.nextLine();
            }
        } while(repetir);

      return valor;
    }
        
    
    
    


}
