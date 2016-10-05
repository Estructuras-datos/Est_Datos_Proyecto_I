package Movimientos;

import Juego.Campo;
import Juego.Matriz;
import Piezas.Ficha;
import Piezas.Vacio;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class MovimientoFicha extends Movimiento{

   
    
    public MovimientoFicha(){
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
