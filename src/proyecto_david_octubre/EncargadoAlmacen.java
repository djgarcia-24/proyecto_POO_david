
package proyecto_david_octubre;

import java.util.ArrayList;


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
          System.out.println("1) Ingresar producto");
          System.out.println("2) Editar producto");
          
          opcion = Validaciones.validar_int("Indica un numero positivo del 0 al 2: ", 2, 0);
            
            switch (opcion) {
                case 0->{                    
                    System.out.println("saliendo...");
                }

                case 1->{
                    mostrar_lista_productos(productos);
                    
                    //verificar si existe
                }
                case 2->{                
                    //hacer funcion buscar para poder editarlo
                }
            }
        }while(opcion!=0);
    }
}
