
package proyecto_david_octubre;
import java.util.Scanner;

import java.util.ArrayList;


public class Base_de_datos {
    ArrayList<Vendedor> vendedores;
    ArrayList<Producto> productos;

    
    Scanner scan = new Scanner(System.in);
    
    
    public void Base_de_datos(){
        vendedores = new ArrayList<>();
    };

    
    public void crear_cuenta(){
        int opcion;
        do{
          System.out.println("\nMenu Crear cuenta:"); 

          System.out.println("0) Salir"); 
          System.out.println("1) Crear como vendedor ");
          System.out.println("2) Crear como null ");
          System.out.println("3) Crear como null ");
          System.out.println("4) Crear como null ");
          
            opcion = Validaciones.validar_int("Indica un numero positivo del 0 al 4: ", 4, 0);
        
            switch (opcion) {
                case 0 ->{}
                case 1->{
                    Vendedor nuevo_vendedor = new Vendedor();
                    nuevo_vendedor.leer_datos();
                    vendedores.add(nuevo_vendedor);
                    nuevo_vendedor.menu();
                    
                    opcion = 0;
                }
                case 2->{
                }
                case 3->{
                }
                case 4->{
                }
                default -> System.out.println("Opción no válida. Por favor, elige 1, 2 ,3 ,4 o 0");
            }
        }while(opcion!=0);
    }
    
    private <Rol_generico extends Usuario> Rol_generico buscar(ArrayList<Rol_generico> lista, String nombre, String id){
        for (Rol_generico r : lista) {
            if (r.nombre.equals(nombre) && r.id.equals(id)){
                return r;
            }
        }
        return null;
    }
    
    public void iniciar_sesion(){
        int opcion;
        
        if( vendedores.isEmpty() ){
            System.out.println("\nNo existe ninguna cuenta en el sistema");
            
            return;
        }
    
        do{
            System.out.println("\nIntroducir nombre de la cuenta: ");
            String nombre =  scan.nextLine();
            System.out.println("Introducir contraseña de la cuenta: ");
            String id =  scan.nextLine();
            
            System.out.println("Seleccionar tipo de cuenta a acceder: ");
            System.out.println("0) volver ");
            System.out.println("1) Vendedor ");
            System.out.println("2) Encargado ");
            System.out.println("3) null ");
            System.out.println("4) null ");
            
            opcion= Validaciones.validar_int("Indica un numero positivo del 0 al 4: ", 4, 0);
            
            
            switch (opcion) {
                case 1->{
                    
                    Vendedor vendedor_encontrado = buscar(vendedores, nombre, id);
                    if( vendedor_encontrado== null){
                        System.out.println("Credenciales no validas, intente de nuevo");
                    }
                    else{
                        System.out.println("Credenciales aceptadas!");
                        vendedor_encontrado.menu();
                        return;
                    }
                    return;
                    
                }
                case 2->{
                }
                case 3->{
                }
                case 4->{
                }
            }
        }while(opcion!=0);
    }
}
