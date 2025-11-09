package proyecto_david_octubre;
import java.time.LocalDate;


public class Venta {
    String id;
    LocalDate fecha;
    double monto;
    Producto producto;
    int cantidad;
    
    public Venta(){
        id ="";
        fecha = null;
        monto =0;
        producto = null;
        cantidad= 0;
    }
    
    public void registrar_venta(String id, LocalDate fecha, double monto, Producto producto, int cantidad ){
        this.id = id;
        this.fecha = fecha;
        this.monto = monto;
        this.producto = producto;
        this.cantidad = cantidad;
    }
}
