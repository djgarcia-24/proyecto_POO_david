
package proyecto_david_octubre;


public class Vendedor extends Usuario{
    @Override
    public void mostrar_datos(){
        super.mostrar_datos();
    }
    
    @Override
    public void leer_datos(){
        tipo = "vendedor";
        super.leer_datos();
        super.mostrar_datos();
    }
    @Override
    public void menu(){
        System.out.println("Bienvenido "+nombre+":) !");
        System.out.println("\nMenu de vendedor :");
    }
}
