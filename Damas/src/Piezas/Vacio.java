
package Piezas;
import javax.swing.ImageIcon;

public class Vacio extends Pieza{
    
    /*
        
        Espacio vacio en el tablero
    
    */
    
    
    public Vacio(char color) {
        
        super('v',color);
                
        if(color == 'n'){
        
             icono = new ImageIcon("iconos/cafe.png");
            
        }else if(color == 'b'){
        
             icono = new ImageIcon("iconos/claro.png");
        }
    }

    
}
