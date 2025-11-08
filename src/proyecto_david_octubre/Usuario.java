
package proyecto_david_octubre;

import java.util.ArrayList;
import java.util.Scanner;



public abstract class Usuario {
    String id;
    String nombre;
    String tipo;
    Scanner scan = new Scanner(System.in);
    
    

    public abstract void menu(ArrayList<Producto >  productos);
    
    
    public void leer_datos(String nombre, String id){
        this.nombre = nombre;
        this.id = id;
    }
    
    public void mostrar_datos(){   
        System.out.println("ID: "+id);
        System.out.println("Nombre: "+nombre);
        System.out.println("Tipo de usuario: "+tipo);
    }       
    
    
}
