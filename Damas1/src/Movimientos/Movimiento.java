package Movimientos;
import Exception.Enroque;
import Exception.Peon_Cast;
import Juego.Matriz;
import Juego.Campo;
import Piezas.Pieza;
import Piezas.Vacio;

/*

    La clase movimiento es una clase abstracta, la cual es un interfaz
    para las clases de movimento de una ficha. 

    La clase posee un metodo Move_From_To, recibe una coordenada ,una
    ficha y el tablero y devuelve un true si el movimiento se puede 
    realizar o un false de la forma contraria.

    Todos los metodos de move_from_to, de las clases heredadas, deberian usar
    el metodo Verifica_Color_Difrente_Fichas, el cual verifica que pieza de
    llegada, sea distinto jugador o sea un campo vacio; de lo contrario se
    estara realizando un movimiento incorrecto.

*/

public abstract class Movimiento {
    
        protected final boolean Verifica_Color_Difrente_Fichas(Pieza to, Pieza from){
        
            if(to instanceof Vacio) return true;
            else return (to.getColor() != from.getColor());
        }
                
        public abstract boolean Move_From_To(Campo from, Campo to, Matriz m)throws Peon_Cast, Enroque;
    
}
