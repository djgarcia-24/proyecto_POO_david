
package proyecto_david_octubre;


import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;


public class Base_de_datos {
    
    //registro de cada tipo de trabajador
    ArrayList<Vendedor> vendedores;
    ArrayList<EncargadoAlmacen> encargados_de_almacen;
    static ArrayList< Producto > productos;

    Scanner scan = new Scanner(System.in);
    
    static public Producto buscar(String id_producto){
        for(Producto p: productos){
            if(id_producto.equals(p.id)){
                return p;
            }
        }
        return null;
    } 
    
    
    
    public  Base_de_datos(){
        productos = new ArrayList<>();
        vendedores = new ArrayList<>();
        encargados_de_almacen = new ArrayList<>();
    
        //productos precargados
        Producto manguera = new Producto(); 
        Producto abono = new Producto();
        Producto cerco = new Producto();
        
         
        manguera.leer_producto("manguera", "000000", "herramienta", "Marca manguera");
        manguera.leer_entrega_producto( 30, LocalDate.now() ,null );
        
        
        abono.leer_producto("abono", "000001", "agricultura",  "Marca abono" );
        abono.leer_entrega_producto( 30, LocalDate.now(), null);
 
        cerco.leer_producto("cerco", "000002", "ganaderia", "Marca cerco" );
        cerco.leer_entrega_producto( 30,LocalDate.now(),null );
 
        
        productos.add(manguera);
        productos.add(cerco);
        productos.add(abono);
    };

    
    public void crear_cuenta(){
        int opcion;
        do{
          System.out.println("\nMenu Crear cuenta:"); 

          System.out.println("0) Salir"); 
          System.out.println("1) Crear como vendedor ");
          System.out.println("2) Crear como Encargado Almacen ");
          System.out.println("3) Crear como null ");
          System.out.println("4) Crear como null ");
          
            opcion = Validaciones.validar_int("Indica un numero positivo del 0 al 4: ", 4, 0);
        
            switch (opcion) {
                case 0 ->{
                    System.out.println("saliendo...");

                }
                case 1->{
                    Vendedor nuevo_vendedor = new Vendedor();
                    nuevo_vendedor.leer_datos();
                    vendedores.add(nuevo_vendedor);
                    nuevo_vendedor.menu(productos);
                    
                    opcion = 0;
                }
                case 2->{
                    EncargadoAlmacen nuevo_encargado_almacen = new EncargadoAlmacen();
                    nuevo_encargado_almacen.leer_datos();
                    encargados_de_almacen.add(nuevo_encargado_almacen);
                    nuevo_encargado_almacen.menu(productos);
                    opcion = 0;

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
        
        if( vendedores.isEmpty() || encargados_de_almacen.isEmpty() ){
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
                        vendedor_encontrado.menu(productos);
                        return;
                    }
                    return;
                    
                }
                case 2->{
                    EncargadoAlmacen encargado_a_encontrado = buscar(encargados_de_almacen, nombre, id);
                    if( encargado_a_encontrado== null){
                        System.out.println("Credenciales no validas, intente de nuevo");
                    }
                    else{
                        System.out.println("Credenciales aceptadas!");
                        encargado_a_encontrado.menu(productos);
                        return;
                    }
                    return;
                
                
                }
                case 3->{
                }
                case 4->{
                }
            }
        }while(opcion!=0);
    }
}
