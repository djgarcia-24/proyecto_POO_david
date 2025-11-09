
package proyecto_david_octubre;

import java.time.LocalDate;
import java.util.ArrayList;


public class Vendedor extends Usuario{
    @Override
    public void mostrar_datos(){
        super.mostrar_datos();
    }
    
    @Override
    public void leer_datos(String nombre, String id){
        tipo = "vendedor";
        super.leer_datos(nombre, id);
        super.mostrar_datos();
    }
    
    
    @Override
    public void menu( ArrayList<Producto >  productos){
        System.out.println("Bienvenido "+nombre+":) !");
        int opcion;
        
        do{
          System.out.println("\nMenu de vendedor: ");
           
          System.out.println("0) Salir ");
          System.out.println("1) Buscar producto por id o nomnre");
          
          System.out.println("2) Buscar producto por categoria");
          System.out.println("3) Registrar venta");
          
          
            opcion = Validaciones.validar_int("Indica un numero positivo del 0 al 3: ", 3, 0);
            
            switch (opcion) {
                case 0->{                    
                    System.out.println("saliendo...");
                    scan.nextLine();
                }
                case 1->{
                    System.out.println("Id o nombre buscar:");
                    String busqueda = scan.nextLine();
                    Producto producto_encontrado = Base_de_datos.buscar_producto(busqueda);
                    
                    
                    if(producto_encontrado == null){
                        System.out.println("No encontrado");
                    }
                    else{
                        System.out.println("\nNombre: "+producto_encontrado.nombre +" Id: "+ producto_encontrado.id+" Categoria: "+producto_encontrado.categoria+" Total:"+producto_encontrado.cantidad_total);
                        producto_encontrado.ordenar_entrega_por_vencimiento();
                    
                        for(Entrega e: producto_encontrado.entregas){
                            System.out.print("  Numero de entrega: "+e.numero+"   Cantidad por entrega: "+e.cantidad_por_entrega+"   Vencimiento"+e.vencimiento +"\n");
                        }
                    }
                }
                case 2->{                    
                    System.out.println("categoria buscar:");
                    String busqueda = scan.nextLine();
                    Base_de_datos.filtrar_productos(busqueda);
                }
                case 3->{
                    Base_de_datos.mostrar_lista_productos(productos);
                    System.out.println("Id o nombre buscar:");
                    
                    String busqueda = scan.nextLine();
                    
                    Producto producto_a_vender = Base_de_datos.buscar_producto(busqueda);
                    
                    if(producto_a_vender == null){
                        System.out.println("Error, no se encontro articulo");
                        continue;
                    }
                    
                    System.out.println("Indique cantidad:");
                    int cantidad = Validaciones.validar_int("Debe ser un numero valido mayor a 1 y menor a 100.000", 100000 ,1);
                    double monto = Validaciones.validar_monto("Introducir monto de la venta: ", 1);
                            
                    if (Validaciones.validar_venta(producto_a_vender, cantidad) ){
                        producto_a_vender.venta(cantidad);
                        System.out.println("venta aceptada");
                        
                        
                        Venta nueva_venta = new Venta();
                        String id_de_venta= Integer.toString(Base_de_datos.ventas.size());
                        nueva_venta.registrar_venta(id_de_venta, LocalDate.now(),monto , producto_a_vender, cantidad);
                        Base_de_datos.ventas.add(nueva_venta);
                        
                        
                        
                    }else{
                        System.out.println("venta rechazada");
                    }
                }
            }
        }while(opcion!=0);
    }
}