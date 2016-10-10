
package Piezas;

import javax.swing.ImageIcon;

/**
 *
 * @authors Denis Rodriguez, Sergio Vega
 */

public class Reina extends Pieza{
    
    public Reina(char _color, char _fondo) {
        super(_color, _fondo);
          switch(color){
            case 'b':{
                this.icono = new ImageIcon("iconos/reina_blanco.png");
                }
                break;
            case 'n':{
                this.icono = new ImageIcon("iconos/reina_negro.png");
                }
                break;
        }
    }
    
}
