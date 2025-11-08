
package proyecto_david_octubre;


import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;


public class Base_de_datos {
    
    //registro de cada tipo de trabajador
    static ArrayList<Vendedor> vendedores;
    static ArrayList<EncargadoAlmacen> encargados_de_almacen;
    
    static ArrayList< Producto > productos;
    ArrayList<String> ventas;
    
    Scanner scan = new Scanner(System.in);
    
    
    public  Base_de_datos(){
        productos = new ArrayList<>();
        vendedores = new ArrayList<>();
        encargados_de_almacen = new ArrayList<>();
        ventas = new ArrayList();
        //productos precargados
        Producto manguera = new Producto(); 
        Producto abono = new Producto();
        Producto cerco = new Producto();
        Producto semillas = new Producto();
         
        manguera.leer_producto("manguera", "000000", "herramienta", "Marca manguera");
        manguera.leer_entrega_producto( 30, LocalDate.now() ,null );
        
        
        abono.leer_producto("abono", "000001", "agricultura",  "Marca abono" );
        abono.leer_entrega_producto( 30, LocalDate.now(), LocalDate.parse("2026-01-01"));
        abono.leer_entrega_producto( 30, LocalDate.now(), LocalDate.parse("2029-12-01"));
        abono.leer_entrega_producto( 30, LocalDate.now(), LocalDate.parse("2025-01-01"));
 
        semillas.leer_producto("semillas", "000009", "agricultura",  "Marca semillas" );
        semillas.leer_entrega_producto( 600, LocalDate.now(), LocalDate.parse("2030-01-01"));
        semillas.leer_entrega_producto( 500, LocalDate.now(), LocalDate.parse("2040-12-01"));
        
        
        
        cerco.leer_producto("cerco", "000002", "ganaderia", "Marca cerco" );
        cerco.leer_entrega_producto( 30,LocalDate.now(),null );
 
        
        productos.add(manguera);
        productos.add(cerco);
        productos.add(abono);
        productos.add(semillas);
    };
    
    
    static public Producto buscar_producto(String dato_producto){
        for(Producto p: productos){
            if(dato_producto.equals(p.id) || dato_producto.equals(p.nombre) ){
                return p;
            }
        }
        
        
        return null;
    } 
    
    static public void mostrar_lista_productos(ArrayList<Producto> productos){
        if(productos.isEmpty()){
            return; 
        }
        System.out.println("\n Lista completa de productos: \n");
        for (Producto p : productos) {
       
            System.out.println("\nNombre: "+p.nombre +" Id: "+ p.id+" Categoria: "+p.categoria+" Total:"+p.cantidad_total);
            for ( Entrega e : p.entregas) {
                System.out.print("  Numero de entrega: "+e.numero+"   Cantidad por entrega: "+e.cantidad_por_entrega+"Ingreso: "+e.ingreso+"   Vencimiento"+e.vencimiento +"\n");
            }
        }
    }
    
    static public void filtrar_productos(String categoria){
        ArrayList< Producto > productos_encontrados= new ArrayList();
        
        for(Producto p: productos){
            if(categoria.equals(p.categoria)){
                p.ordenar_entrega_por_vencimiento();
                productos_encontrados.add(p);
            }
        }
        
        System.out.println("\nProductos de categoria "+categoria+":");

        mostrar_lista_productos(productos_encontrados);
    } 
            
    private Usuario buscar_empleado(ArrayList<? extends Usuario> lista_vendedores, ArrayList<? extends Usuario> lista_encargados_a, String nombre, String id){
        for (Usuario u : lista_vendedores) {
            if (u.nombre.equals(nombre) && u.id.equals(id)){
                return u;
            }
        }
        
        for (Usuario  u: lista_encargados_a) {
            if (u.nombre.equals(nombre) && u.id.equals(id)){
                return u;
            }
        }
        
        return null;
    }
    
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
            String nombre;
            String id;
            switch (opcion) {
                case 0 ->{
                    System.out.println("saliendo...");

                }
                case 1->{
                   // si no existe el usuario, se crea la cuenta, de lo contrario, mostrar un error
                    do{
                        System.out.print("Introduzca el nombre que tendra su cuenta, no debe tener mismo nombre ni id que otra cuenta: ");
                        nombre = scan.nextLine();
                        System.out.print("Introduzca el ID que tendra su cuenta: ");
                        id = scan.nextLine();
                    }while(Validaciones.verificar_cuenta_existente(nombre, id, vendedores) );
                    Vendedor nuevo_vendedor = new Vendedor();
                    nuevo_vendedor.leer_datos(nombre, id );
                    vendedores.add(nuevo_vendedor);
                    nuevo_vendedor.menu(productos);
                    
                    opcion = 0;
                }
                case 2->{
                    do{
                        System.out.print("Introduzca el nombre que tendra su cuenta, no debe tener mismo nombre ni id que otra cuenta: ");
                        nombre = scan.nextLine();
                        System.out.print("Introduzca el ID que tendra su cuenta: ");
                        id = scan.nextLine();
                    }while(Validaciones.verificar_cuenta_existente(nombre, id , encargados_de_almacen));
                    EncargadoAlmacen nuevo_encargado_a = new EncargadoAlmacen();
                    nuevo_encargado_a.leer_datos(nombre, id );
                    encargados_de_almacen.add(nuevo_encargado_a);
                    nuevo_encargado_a.menu(productos);
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
    //añadir parametro de lista, por cada tipo de usuario
 
    
    public void iniciar_sesion(){
        boolean seguir = true;
        
        if( vendedores.isEmpty() && encargados_de_almacen.isEmpty() ){
            System.out.println("\nNo existe ninguna cuenta en el sistema");
            return;
        }
   
        do{
            System.out.println("\nIntroducir nombre de la cuenta: ");
            String nombre =  scan.nextLine();
            System.out.println("Introducir contraseña de la cuenta: ");
            String id =  scan.nextLine();
            
            Usuario cuenta_encontrada = buscar_empleado(vendedores, encargados_de_almacen, nombre, id);
            
            if( cuenta_encontrada == null){
                System.out.println("no encontrado");
            }else{
                cuenta_encontrada.menu(productos);
                seguir = false;
            }
        }while(seguir);
    }
}
