package Juego;
import Piezas.*;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

/**
 *
 * @authors Denis Rodriguez, Sergio Vega
 */

public class Campo {
    
    private Pieza pieza; //variable utiliza para almacenar la pieza que entra por parametro
    private int x,y; //coordenadas en el tablero de cada ficha
    private char colorFondo; //define el color de fondo del espacio en el tablero, principalmente utilizado para dejar los espacios blancos sin listener
    private JButton boton; //boton comodin para tener el icono de la pieza que entra por parametro
    private boolean vacioBlanco=false;

    public Campo(Pieza p, int x, int y, char col) {
        pieza = p; 
        if(p.getColor()=='v' && p.getFondo()=='b')
            vacioBlanco=true;
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

    public boolean isVacioBlanco() {
        return vacioBlanco;
    }
    
}
