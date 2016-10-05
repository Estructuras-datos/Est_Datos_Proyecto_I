
package Juego;

public final class Jugador{

    private String num;
    private boolean id;
    private char color;

        public Jugador(String num, boolean id, char _color) {
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

        public boolean getId() {
            return id;
        }
        
        public char getColor(){
             return color;
        }

 }
    
