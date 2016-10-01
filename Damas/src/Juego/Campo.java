package Juego;
import Piezas.*;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

/*
    El campo, es una clase la de la cual se va a basar el tabler, 
    posee la pieza, las coordenadas, el color de fondo y el boton.
*/

public class Campo {
    
    private Pieza pieza; //variable utiliza para almacenar la pieza que entra por parametro
    private int x,y; //coordenadas en el tablero de cada pieza
    private char colorFondo; //define el color de fondo del espacio en el tablero
    private JButton boton; //boton comodin para tener el icono de la pieza que entra por parametro
    

    public Campo(Pieza p, int x, int y, char col) {
        pieza = p; 
        this.x = x; this.y = y; 
        colorFondo = col; 
        
        boton=new JButton(p.getIcono());
        boton.setBorder(new LineBorder(Color.WHITE, 1));
    }
    
    

    public Pieza getPieza() {
        return pieza;
    }

    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
        pieza.setFondo(colorFondo);
        this.boton.setIcon(pieza.getIcono());
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getColor() {
        return colorFondo;
    }

    public void setColor(char color) {
        this.colorFondo = color;
    }

    public JButton getBoton() {
        return boton;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
    }
    
    
    
}
