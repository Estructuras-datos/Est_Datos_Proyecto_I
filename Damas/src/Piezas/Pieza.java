
package Piezas;

import javax.swing.ImageIcon;


public abstract class Pieza {
/*
    La pieza es un Interfaz, la cual posee metodos de creaccion, los argumentos
    son:
        
    - int x, y: coordenadas.
    - char color: b = blancas, n = negro, v = vacio; otro argumento dara error.
    - char fondo: b = blanco, n = negro; otro argumento dara error.

    Los atributos char, dependiendo lo que especifiquen, el atributo icono se le
    va a dar una imagen automaticamente.

    El boton es para el interfaz - usuario, el cual va a ser un icono. 

    Cuando se hereda esta clase, hay un metodo abstracto llamado setFondo, lo 
    cual dependiendo el campo donde esta cambia el fondo.

    El color de fondo, de las piezas y sus clases heredadas, las brinda la clase
    campo.
*/
    
//------------------------------------------------------------------------------
// Atributos:
    
    protected ImageIcon icono;
    protected char color, fondo;

    
//------------------------------------------------------------------------------
// Metodos:
    
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
    
//------------------------------------------------------------------------------
}
