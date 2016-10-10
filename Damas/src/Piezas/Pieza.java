
package Piezas;

import javax.swing.ImageIcon;

/**
 *
 * @authors Denis Rodriguez, Sergio Vega
 */

public abstract class Pieza {
/*
    - int x, y: coordenadas.
    - char color: b = blancas, n = negro, v = vacio; otro argumento dara error.
    - char fondo: b = blanco, n = negro; otro argumento dara error.
*/
    
    protected ImageIcon icono;
    protected char color, fondo;
    
    public Pieza(char _color, char _fondo)
           throws IllegalArgumentException
    {
        if(_color == 'b' || _color == 'n'  || _color == 'v')  {color = _color; /*v = vacio.*/}
        else throw new IllegalArgumentException(" Error en el Argumento Creando Ficha");
        if(_fondo == 'b' || _fondo == 'n') {fondo = _fondo;}
        else throw new IllegalArgumentException(" Error en el Argumento Creando Ficha");
    }
    
    public final ImageIcon getIcono() {
        return icono;
    }

    public final  char getFondo(){
        return fondo;
    }
    
    public final  char getColor() {
        return color;
    }
    
}
