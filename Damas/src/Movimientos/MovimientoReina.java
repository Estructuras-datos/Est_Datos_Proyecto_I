package Movimientos;

import Juego.Campo;
import Juego.Matriz;
import Piezas.Pieza;
import Piezas.Reina;
import Piezas.Vacio;

public class MovimientoReina extends Movimiento {

    public MovimientoReina() {
    }
    
    
    @Override
    public boolean Move_From_To(Campo from, Campo to, Matriz m){
        /*
        Para obtener campos de la lista de listas:
        Iterador it = new Iterador(matriz);
        Iterador it2=new Iterador((Lista)it.getPos(x));
        Campo aux=(Campo)it2.getPos(y); //aux es el campo en la posicion x,y de la matriz
        
        */
        
        return true;
    }
        
}
