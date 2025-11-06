
package proyecto_david_octubre;

import java.util.ArrayList;
import java.time.LocalDate;


public class EncargadoAlmacen extends Usuario{
    @Override
    public void mostrar_datos(){
        super.mostrar_datos();
    }
    
    @Override
    public void leer_datos(){
        tipo = "encargado almacen";
        super.leer_datos();
        super.mostrar_datos();
    }
    
    
    private void mostrar_lista_productos(ArrayList<Producto> productos){
        if(productos.isEmpty()){
            return; 
        }
        System.out.println("\n Lista completa de productos: ");
        for (Producto p : productos) {
            //imprimir primero el nombre, id  y de los productos de la coleccion
            
            

            System.out.println("Nombre: "+p.nombre +" Id: "+ p.id+" Categoria: "+p.categoria+" Total:"+p.cantidad_total);
            
            for ( Entrega e : p.entregras) {
                //imprimir la fecha de vencimiento de cada coleccion
                
                System.out.println("Numero de entrega : "+e.numero +" Cantidad : "+ e.cantidad_por_entrega+" Fecha de ingreso: "+e.ingreso);
            
                if(e.vencimiento == null){
                    System.out.println("\n");        
                }
                else{
                    System.out.println("Fecha de vencimiento: "+e.vencimiento+"\n");        
                } 
            }
        }
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
                    mostrar_lista_productos(productos);
                }
                case 2->{ 
                    mostrar_lista_productos(productos);
                    System.out.println("Indique id del producto a editar: ");
                    Producto producto_a_editar = Base_de_datos.buscar( scan.nextLine() );
                    
                    System.out.println("Producto a editar: "+producto_a_editar.nombre+producto_a_editar.categoria);
                    
                    
                    
                    

                    //hacer funcion buscar para poder editarlo
                }
                case 3->{
                
                }
            }
        }while(opcion!=0);
    }
}
