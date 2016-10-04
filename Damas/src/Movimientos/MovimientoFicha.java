package Movimientos;

import Juego.Campo;
import Juego.Matriz;
import Piezas.Ficha;
import Exception.Peon_Cast;
import Piezas.Vacio;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class MovimientoFicha extends Movimiento{

    /*
        El movimiento del peon es de las clases de movimiento mas complejas,
        debido a que hay dos casos, los peones de color blanco y los de color
        negro; en esta clase se manejan separados.
    
    */
    
    
    public MovimientoFicha(){
   }

    @Override
    public boolean Move_From_To(Campo from, Campo to, Matriz m) throws Peon_Cast{
       return true;
        
    }

    
    
      
    
}
