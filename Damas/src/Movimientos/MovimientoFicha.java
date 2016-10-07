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
        
        if(from.getPieza().getColor() == 'b'){
            if(to.getPieza() instanceof Vacio && to.getPieza().getFondo() == 'n'){ //verificar que el campo este vacio primero              
                if(to.getX() == from.getX()-1){ //si es el caso que se desplaza hacia adelante 
                    if(to.getY() == from.getY()-1 || to.getY() == from.getY()+1){ //verificar que se desplaya a un campo valido
                        return true;
                    }
                }else if(to.getX() == from.getX()-2){//si es el caso de que va a comer
                    if(to.getY() == from.getY()-2 || to.getY() == from.getY()+2){//verificar que sea un campo valido
                        Campo auxIzq = m.getCampo(from.getX()-1, from.getY()-1);
                        Campo auxDer = m.getCampo(from.getX()-1, from.getY()+1);
                        if((!( auxIzq.getPieza() instanceof Vacio && auxIzq.getPieza().getFondo() == 'n') && auxIzq.getPieza().getColor() == 'n')
                                || (!( auxDer.getPieza() instanceof Vacio && auxDer.getPieza().getFondo() == 'n') && auxDer.getPieza().getColor() == 'n')){ //verificar que haya una ficha para comer
                            return true;
                        }
                    }
                }
            }
        } else if(from.getPieza().getColor() == 'n'){
            if(to.getPieza() instanceof Vacio && to.getPieza().getFondo() == 'n'){ //verificar que el campo este vacio primero              
                if(to.getX() == from.getX()+1){ //si es el caso que se desplaza hacia adelante 
                    if(to.getY() == from.getY()-1 || to.getY() == from.getY()+1){ //verificar que se desplaya a un campo valido
                        return true;
                    }
                }else if(to.getX() == from.getX()+2){//si es el caso de que va a comer
                    if(to.getY() == from.getY()-2 || to.getY() == from.getY()+2){//verificar que sea un campo valido
                        Campo auxIzq = m.getCampo(from.getX()+1, from.getY()-1);
                        Campo auxDer = m.getCampo(from.getX()+1, from.getY()+1);
                        if((!( auxIzq.getPieza() instanceof Vacio && auxIzq.getPieza().getFondo() == 'n') && auxIzq.getPieza().getColor() == 'b')
                                || (!( auxDer.getPieza() instanceof Vacio && auxDer.getPieza().getFondo() == 'n') && auxDer.getPieza().getColor() == 'b')){ //verificar que haya una ficha para comer
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }     
    
    
}
