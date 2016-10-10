
package Piezas;

import javax.swing.ImageIcon;

/**
 *
 * @authors Denis Rodriguez, Sergio Vega
 */

public class Ficha extends Pieza{

    public Ficha(char _color, char _fondo){ //el color de fondo no se usa en las fichas pero si en los espacios vacios para definir cual ocupa listener y cual no
    
        super(_color,_fondo);
        switch(color){
            case 'b': {
                this.icono = new ImageIcon("iconos/ficha_blanca.png");
                }
                break;
            case 'n': {
                this.icono = new ImageIcon("iconos/ficha_negra.png");              
                }
                break;
        }
        
    }
    
}
