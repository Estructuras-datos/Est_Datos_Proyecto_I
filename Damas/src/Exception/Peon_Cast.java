package Exception;


public class Peon_Cast extends Exception{
/* Clase creada para poder hacer un throw de que el peon ha llegado al
   otro lado del tablero, enviando los datos necesarios para que se
   pueda hacer un casteo a la pieza que el usuario prefiera.
*/
    
     private int x,y;
     private int x_from, y_from;
     private char color, fondo;
     
     public Peon_Cast(int xf, int yf, int x, int y, char color, char fondo){
     
         super("Exepcion causada por el casteo de un peon.");
         this.x =x;
         this.y = y;
         x_from = xf;
         y_from = yf;
         this.color = color;
         this.fondo = fondo;
         
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
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public char getFondo() {
        return fondo;
    }

    public void setFondo(char fondo) {
        this.fondo = fondo;
    }
    
}
