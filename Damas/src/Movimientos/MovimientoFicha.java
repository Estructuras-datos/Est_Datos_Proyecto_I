package Movimientos;

import Juego.Campo;
import Juego.Matriz;
import Piezas.Vacio;

public final class MovimientoFicha extends Movimiento{
    
    int fichasNegras;
    int fichasBlancas;
    
    public MovimientoFicha(){
        this.fichasNegras = 12;
        this.fichasBlancas = 12;
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
                    if(to.getY() == from.getY()-2 ){
                        Campo auxIzq = m.getCampo(from.getX()-1, from.getY()-1);
                        if(!( auxIzq.getPieza() instanceof Vacio && auxIzq.getPieza().getFondo() == 'n') && auxIzq.getPieza().getColor() == 'n'){
                            auxIzq.setPieza(new Vacio('n'));
                            this.fichasNegras--;
                            return true;
                        }
                    }else if(to.getY() == from.getY()+2){
                        Campo auxDer = m.getCampo(from.getX()-1, from.getY()+1);
                        if(!( auxDer.getPieza() instanceof Vacio && auxDer.getPieza().getFondo() == 'n') && auxDer.getPieza().getColor() == 'n'){
                            auxDer.setPieza(new Vacio('n'));
                            this.fichasNegras--;
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
                    if(to.getY() == from.getY()-2){
                        Campo auxIzq = m.getCampo(from.getX()+1, from.getY()-1);
                        if(!( auxIzq.getPieza() instanceof Vacio && auxIzq.getPieza().getFondo() == 'n') && auxIzq.getPieza().getColor() == 'b'){
                            auxIzq.setPieza(new Vacio('n'));
                            this.fichasBlancas--;
                            return true;
                        }
                    }else if(to.getY() == from.getY()+2){
                        Campo auxDer = m.getCampo(from.getX()+1, from.getY()+1);
                        if(!( auxDer.getPieza() instanceof Vacio && auxDer.getPieza().getFondo() == 'n') && auxDer.getPieza().getColor() == 'b'){
                            auxDer.setPieza(new Vacio('n'));
                            this.fichasBlancas--;
                            return true;
                        }
                    }
                    
                }
            }
        }
        return false;
    }     
    
    
}
