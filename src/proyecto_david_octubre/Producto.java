package proyecto_david_octubre;
import java.util.ArrayList;
import java.time.LocalDate;

public class Producto {
    
    public String nombre; 
    public String id;
    public String categoria;
    public int cantidad_total;
    public ArrayList<String> proveedores= new ArrayList<>();
    
    //cada producto tendra un listado de entregas con fecha de vencimiento,  ingreso y numero
    public ArrayList<Entrega> entregras= new ArrayList<>();
    
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
            
    public void leer_entrega_producto( int cantidad_entrega, LocalDate ingreso, LocalDate vencimiento){
        int numero = this.entregras.size()+1;
        Entrega nueva_entrega = new Entrega();
        nueva_entrega.leer_datos(numero, cantidad_entrega, ingreso, vencimiento);
        this.entregras.add(nueva_entrega);
        
        for(Entrega e: this.entregras){
            cantidad_total= e.cantidad_por_entrega+cantidad_total;
        }
    }   
}
