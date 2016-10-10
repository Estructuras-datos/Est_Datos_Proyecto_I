package Movimientos;
import Juego.Matriz;
import Juego.Campo;

/**
 *
 * @authors Denis Rodriguez, Sergio Vega
 */

public abstract class Movimiento {
        public abstract boolean Move_From_To(Campo from, Campo to, Matriz m);
        public abstract boolean puedoComer(Campo from, Matriz m);
        public abstract boolean estaComiendo();
}
