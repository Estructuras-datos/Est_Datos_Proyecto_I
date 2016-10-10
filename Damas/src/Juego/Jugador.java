
package Juego;

/**
 *
 * @authors Denis Rodriguez, Sergio Vega
 */

public final class Jugador{

    private String num;
    private char id;
    private char color;

        public Jugador(String num, char id, char _color) {
            this.num = num;
            this.id = id;
            color = _color;
        }
        
        public void setNum(String num) {
            this.num = num;
        }

        public String getNum() {
            return num;
        }

        public char getId() {
            return id;
        }
        
        public char getColor(){
             return color;
        }

 }
    
