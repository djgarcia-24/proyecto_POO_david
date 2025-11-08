
package proyecto_david_octubre;

import java.util.ArrayList;
import java.time.LocalDate;


public class EncargadoAlmacen extends Usuario{
    @Override
    public void mostrar_datos(){
        super.mostrar_datos();
    }
    
    @Override
    public void leer_datos(String nombre , String id){
        tipo = "encargado almacen";
        super.leer_datos(nombre, id );
        super.mostrar_datos();
    }
    
    
    
    private void editar_nombre(Producto producto){
         System.out.println("\nIndique nuevo nombre: ");
        
        producto.nombre =    scan.nextLine();
    }
    
    private void editar_categoria(Producto producto){
        
         System.out.println("\nIndique nueva categoria: ");
        
        producto.categoria =  scan.nextLine();
    }
    
    
    
    
    @Override
    public void menu(ArrayList<Producto >  productos){
        System.out.println("Bienvenido "+nombre+":) !");
        int opcion;
        
        do{
          System.out.println("\nMenu de encargado de almacen: ");
           
          System.out.println("0) Salir ");
          System.out.println("1) Ingresar producto nuevo");
          System.out.println("2) Editar producto");
          System.out.println("3) Registrar entrega de producto existente");

          opcion = Validaciones.validar_int("Indica un numero positivo del 0 al 3: ", 3, 0);
            
            switch (opcion) {
                case 0->{                    
                    System.out.println("saliendo...");
                }

                case 1->{
                    
                    Producto nuevo_producto = new Producto();
                    
                    
                    System.out.println("Indique nombre del producto: ");
                    String nombre = scan.nextLine();
                    System.out.println("Indique id del producto: ");
                    String id = scan.nextLine();
                    System.out.println("Indique categoria del producto: ");
                    String categoria = scan.nextLine();
                    System.out.println("Indique proveedor del producto: ");
                    String proveedor = scan.nextLine();
                    
                    nuevo_producto.leer_producto(nombre, id, categoria, proveedor);
                
                    
                    System.out.println("Indique cantidad del producto: ");
                    int cantidad_de_entrega = scan.nextInt();
                    
                    LocalDate ingreso= Validaciones.validarFecha("Indicar fecha de ingreso formato aaaa-mm-dd: ", "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$");
                    LocalDate vencimiento = Validaciones.validarFecha("Indicar fecha de vencimiento formato aaaa-mm-dd: ", "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$");
                    
                    nuevo_producto.leer_entrega_producto(cantidad_de_entrega, ingreso, vencimiento);
                    
                    productos.add(nuevo_producto);
                    Base_de_datos.mostrar_lista_productos(productos);
                }
                case 2->{ 
                    Base_de_datos.mostrar_lista_productos(productos);
                    System.out.println("Indique id del producto a editar: ");
                    Producto producto_a_editar = Base_de_datos.buscar_producto(scan.nextLine() );
                    System.out.println("Producto a editar: \n"+"Nombre: "+producto_a_editar.nombre+" Categoria: "+producto_a_editar.categoria);
                    
                    editar_nombre(producto_a_editar);
                    editar_categoria(producto_a_editar);
                    //funcion editar, no habra menu pq se trabajara en gui
                    //tendra la opcion de editar categoria y/o nombre
                
                    Base_de_datos.mostrar_lista_productos(productos);
                    
                }
                case 3->{
                    Base_de_datos.mostrar_lista_productos(productos);
                    System.out.println("Indique id del producto: ");
                    
                    Producto producto_a_editar = Base_de_datos.buscar_producto( scan.nextLine() );
                    
                    System.out.println("Producto: \n"+"Nombre: "+producto_a_editar.nombre+"Categoria: "+producto_a_editar.categoria);
                    
                    LocalDate fecha_entrega =  Validaciones.validarFecha("Indicar fecha de entrega formato aaaa-mm-dd: ", "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$");
                    
                    LocalDate fecha_vencimiento =  Validaciones.validarFecha("Indicar fecha de vencimiento formato aaaa-mm-dd: ", "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$");
                    
                    int numero =  Validaciones.validar_int("Indicar numero de existencias", 1000, 1);
                     
                    
                    producto_a_editar.leer_entrega_producto(numero, fecha_entrega, fecha_vencimiento);
                    
                    
                    Base_de_datos.mostrar_lista_productos(productos);
                    
                }
            }
        }while(opcion!=0);
    }
}
