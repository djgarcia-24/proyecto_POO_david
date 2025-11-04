
package proyecto_david_octubre;
import java.time.LocalDate;

public class Entrega {
    public int numero;
    public int cantidad_por_entrega;
    public LocalDate ingreso;
    public LocalDate vencimiento;
    
    
    public void leer_datos(int numero, int cantidad_entrega, LocalDate ingreso, LocalDate vencimiento){
        this.numero = numero;
        this.cantidad_por_entrega = cantidad_entrega;
        this.ingreso = ingreso;
        this.vencimiento = vencimiento;
    }
}
