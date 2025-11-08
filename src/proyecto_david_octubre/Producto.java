package proyecto_david_octubre;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;

public class Producto {
    
    public String nombre; 
    public String id;
    public String categoria;
    public int cantidad_total;
    public ArrayList<String> proveedores= new ArrayList<>();
    
    //cada producto tendra un listado de entregas con fecha de vencimiento,  ingreso y numero
    public ArrayList<Entrega> entregas= new ArrayList<>();
    
    public void producto(){
        nombre = categoria = id="";
        cantidad_total =0 ;
    }
    
    public void leer_producto(String nombre, String id, String categoria, String proveedor){
        this.nombre = nombre;
        this.id = id;
        this.categoria = categoria;
        proveedores.add(proveedor);
    };
    
    // se podran ordenar las entregas almacenas en el producto por fecha de vencimiento y por fecha de ingreso 
    public void ordenar_entrega_por_vencimiento(){
        if (entregas == null || entregas.size() < 2){
            return;
        }
        
        boolean swap;
        
        LocalDate fecha_1;  
        LocalDate fecha_2; 
        
        for(int i=0 ; i< entregas.size()-1;i++ ){
            swap= false;

            for(int j =0 ; j< entregas.size()-1-i ; j++ ){
                fecha_1= entregas.get(j).vencimiento;
                fecha_2= entregas.get(j+1).vencimiento;
                
                if( fecha_1.isAfter(fecha_2)){
                    Collections.swap(entregas, j, j + 1); 
                    swap=true;
                }
                
            }               
            if(!swap) break;

        }
    }

    public void leer_entrega_producto( int cantidad_entrega, LocalDate ingreso, LocalDate vencimiento){
        int numero = this.entregas.size()+1;
        Entrega nueva_entrega = new Entrega();
        nueva_entrega.leer_datos(numero, cantidad_entrega, ingreso, vencimiento);
        this.entregas.add(nueva_entrega);
        //suma sera igual a todas las entregas sumadas sin importar el numero anterior total 
        // se asignara cant total a ese num
        
        cantidad_total=0;
        for(Entrega e: this.entregas){
            
            cantidad_total= e.cantidad_por_entrega+cantidad_total;
            
        }
    }   

    public void venta(int cantidad_vendida){
        cantidad_total = cantidad_total -cantidad_vendida;
    }


}
