package Movimientos;

import Juego.Campo;
import Juego.Matriz;
import Piezas.Vacio;

/**
 *
 * @authors Denis Rodriguez, Sergio Vega
 */

public final class MovimientoFicha extends Movimiento{
    
    private boolean estaComiendo = false;
    
    public MovimientoFicha(){
    }

    @Override
    public boolean Move_From_To(Campo from, Campo to, Matriz m, boolean comeObligado){
        if(from.getPieza().getColor() == 'b'){
            if(to.getPieza() instanceof Vacio){ //verificar que el campo este vacio primero              
                if(to.getX() == from.getX()-1 && !comeObligado){ //si es el caso que se desplaza hacia adelante 
                    if(to.getY() == from.getY()-1 || to.getY() == from.getY()+1){ //verificar que se desplaya a un campo valido
                        this.estaComiendo = false;
                        return true;
                    }
                }else if(to.getX() == from.getX()-2){//si es el caso de que va a comer
                    if(to.getY() == from.getY()-2 ){
                        Campo auxIzq = m.getCampo(from.getX()-1, from.getY()-1);
                        if(!( auxIzq.getPieza() instanceof Vacio) && auxIzq.getPieza().getColor() == 'n'){
                            auxIzq.setPieza(new Vacio('n'));
                            m.restaNegras();
                            this.estaComiendo = true;
                            return true;
                        }
                    }else if(to.getY() == from.getY()+2){
                        Campo auxDer = m.getCampo(from.getX()-1, from.getY()+1);
                        if(!( auxDer.getPieza() instanceof Vacio) && auxDer.getPieza().getColor() == 'n'){
                            auxDer.setPieza(new Vacio('n'));
                            m.restaNegras();
                            this.estaComiendo = true;
                            return true;
                        }
                    }
                    

                }
            }
        } else if(from.getPieza().getColor() == 'n'){
            if(to.getPieza() instanceof Vacio){ //verificar que el campo este vacio primero              
                if(to.getX() == from.getX()+1 && !comeObligado){ //si es el caso que se desplaza hacia adelante 
                    if(to.getY() == from.getY()-1 || to.getY() == from.getY()+1){ //verificar que se desplaya a un campo valido
                        this.estaComiendo = false;
                        return true;
                    }
                }else if(to.getX() == from.getX()+2){//si es el caso de que va a comer
                    if(to.getY() == from.getY()-2){
                        Campo auxIzq = m.getCampo(from.getX()+1, from.getY()-1);
                        if(!( auxIzq.getPieza() instanceof Vacio) && auxIzq.getPieza().getColor() == 'b'){
                            auxIzq.setPieza(new Vacio('n'));
                            m.restaBlancas();
                            this.estaComiendo = true;
                            return true;
                        }
                    }else if(to.getY() == from.getY()+2){
                        Campo auxDer = m.getCampo(from.getX()+1, from.getY()+1);
                        if(!( auxDer.getPieza() instanceof Vacio) && auxDer.getPieza().getColor() == 'b'){
                            auxDer.setPieza(new Vacio('n'));
                            m.restaBlancas();
                            this.estaComiendo = true;
                            return true;
                        }
                    }
                    
                }
            }
        }
        return false;
    }     

    @Override
    public boolean puedoComer(Campo from, Matriz m) {
        if(from.getPieza().getColor() == 'b'){
            if(from.getX() == 1 || from.getX() == 0){//si es el caso de que la ficha se encuentra en el extremo superior
                return false;
            }else if(from.getY()== 0 || from.getY()== 1){// el caso de las fichas del extremo izquierdo
                Campo auxDer = m.getCampo(from.getX()-1, from.getY()+1);
                Campo sig = m.getCampo(from.getX()-2, from.getY()+2);
                if(!( auxDer.getPieza() instanceof Vacio) && auxDer.getPieza().getColor() == 'n' 
                        && (sig.getPieza() instanceof Vacio)){
                    return true;
                }
            }else if(from.getY() == 7 || from.getY()== 6){// el caso de las fichas del extremo derecho
                Campo auxIzq = m.getCampo(from.getX()-1, from.getY()-1);
                Campo sig = m.getCampo(from.getX()-2, from.getY()-2);
                if(!( auxIzq.getPieza() instanceof Vacio) && auxIzq.getPieza().getColor() == 'n'
                        && (sig.getPieza() instanceof Vacio)){
                    return true;
                }
            }else{
                Campo auxIzq = m.getCampo(from.getX()-1, from.getY()-1);
                Campo sigIzq = m.getCampo(from.getX()-2, from.getY()-2);
                Campo auxDer = m.getCampo(from.getX()-1, from.getY()+1);
                Campo sigDer = m.getCampo(from.getX()-2, from.getY()+2);
                if((!( auxIzq.getPieza() instanceof Vacio) && auxIzq.getPieza().getColor() == 'n' && (sigIzq.getPieza() instanceof Vacio))
                        || (!( auxDer.getPieza() instanceof Vacio) && auxDer.getPieza().getColor() == 'n' && (sigDer.getPieza() instanceof Vacio))){
                    return true;
                }
            }
        }else if(from.getPieza().getColor() == 'n'){
            if(from.getX() == 6 || from.getX() == 7){//si es el caso de que la ficha se encuentra en el extremo inferior
                return false;
            }else if(from.getY()== 0 || from.getY()== 1){// el caso de las fichas del extremo izquierdo
                Campo auxIzq = m.getCampo(from.getX()+1, from.getY()+1);
                Campo sig = m.getCampo(from.getX()+2, from.getY()+2);
                if(!( auxIzq.getPieza() instanceof Vacio) && auxIzq.getPieza().getColor() == 'b'
                        && (sig.getPieza() instanceof Vacio)){
                    return true;
                }
            }else if(from.getY() == 7 || from.getY()== 6){// el caso de las fichas del extremo derecho
                Campo auxDer = m.getCampo(from.getX()+1, from.getY()-1);
                Campo sig = m.getCampo(from.getX()+2, from.getY()-2);
                if(!( auxDer.getPieza() instanceof Vacio) && auxDer.getPieza().getColor() == 'b'
                        && (sig.getPieza() instanceof Vacio)){
                    return true;
                }
            }else{
                Campo auxIzq = m.getCampo(from.getX()+1, from.getY()+1);
                Campo sigIzq = m.getCampo(from.getX()+2, from.getY()+2);
                Campo auxDer = m.getCampo(from.getX()+1, from.getY()-1);
                Campo sigDer = m.getCampo(from.getX()+2, from.getY()-2);
                if((!( auxIzq.getPieza() instanceof Vacio) && auxIzq.getPieza().getColor() == 'b' && (sigIzq.getPieza() instanceof Vacio))
                        || (!( auxDer.getPieza() instanceof Vacio) && auxDer.getPieza().getColor() == 'b' && (sigDer.getPieza() instanceof Vacio))){
                    return true;
                }
            }
        }
        return false; 
    }

    public boolean estaComiendo() {
        return estaComiendo;
    }
    
}
