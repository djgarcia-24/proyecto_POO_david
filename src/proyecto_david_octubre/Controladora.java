
package proyecto_david_octubre;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Controladora {
    JFrame ventana;
    JTextField  iniciar_nombre , iniciar_id, crear_nombre, crear_id; 
    Base_de_datos bd = new Base_de_datos();
    
    
    public Controladora(JFrame ventana, JTextField iniciar_nombre ,JTextField iniciar_id ,JTextField crear_id , JTextField crear_nombre){
       this.ventana = ventana;
       this.iniciar_id = iniciar_id;
       this.iniciar_nombre = iniciar_nombre;
       this.crear_id = crear_id;
       this.crear_nombre = crear_nombre;
    }    
     
     
    public void iniciaVentana(JFrame ventana){
       ventana.setLocationRelativeTo(null);
       ventana.setResizable(false); 
    }
    
    public void crear_cuenta(){
       bd.crear_cuenta();
       
    }
    
     

}
