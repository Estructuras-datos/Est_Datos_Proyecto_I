package Movimientos;

import Juego.Campo;
import Juego.Matriz;
import Piezas.Vacio;

public class MovimientoReina extends Movimiento {
    
    private boolean estaComiendo = false;
    
    public MovimientoReina() {
    }
    
    @Override
    public boolean Move_From_To(Campo from, Campo to, Matriz m, boolean comeObligado){

        if (to.getPieza() instanceof Vacio) { //verificar que el campo este vacio primero       

            if (to.getX() == from.getX() - 1 && !comeObligado) { //si es el caso que se desplaza hacia adelante 
                if (to.getY() == from.getY() - 1 || to.getY() == from.getY() + 1) { //verificar que se desplaya a un campo valido
                    this.estaComiendo = false;
                    return true;
                }
            } else if (to.getX() == from.getX() + 1 && !comeObligado) {//si es el caso que se desplaza hacia atras
                if (to.getY() == from.getY() - 1 || to.getY() == from.getY() + 1) { //verificar que se desplaya a un campo valido
                    this.estaComiendo = false;
                    return true;
                }
            } else if (from.getPieza().getColor() == 'b') { //si la reina es blanca y va a comer
                if (to.getX() == from.getX() - 2) {
                    if (to.getY() == from.getY() - 2) {
                        Campo auxIzq = m.getCampo(from.getX() - 1, from.getY() - 1);
                        if (!(auxIzq.getPieza() instanceof Vacio) && auxIzq.getPieza().getColor() == 'n') {
                            auxIzq.setPieza(new Vacio('n'));
                            m.restaNegras();
                            this.estaComiendo = true;
                            return true;
                        }
                    } else if (to.getY() == from.getY() + 2) {
                        Campo auxDer = m.getCampo(from.getX() - 1, from.getY() + 1);
                        if (!(auxDer.getPieza() instanceof Vacio) && auxDer.getPieza().getColor() == 'n') {
                            auxDer.setPieza(new Vacio('n'));
                            m.restaNegras();
                            this.estaComiendo = true;
                            return true;
                        }
                    }
                }
                else if (to.getX() == from.getX() + 2) {
                    if (to.getY() == from.getY() - 2) {
                        Campo auxIzq = m.getCampo(from.getX() + 1, from.getY() - 1);
                        if (!(auxIzq.getPieza() instanceof Vacio) && auxIzq.getPieza().getColor() == 'n') {
                            auxIzq.setPieza(new Vacio('n'));
                            m.restaNegras();
                            this.estaComiendo = true;
                            return true;
                        }
                    } else if (to.getY() == from.getY() + 2) {
                        Campo auxDer = m.getCampo(from.getX() + 1, from.getY() + 1);
                        if (!(auxDer.getPieza() instanceof Vacio) && auxDer.getPieza().getColor() == 'n') {
                            auxDer.setPieza(new Vacio('n'));
                            m.restaNegras();
                            this.estaComiendo = true;
                            return true;
                        }
                    }
                }

            } else if (from.getPieza().getColor() == 'n') { //verifica si la reina es negra
                if (to.getX() == from.getX() + 2) {//si es el caso de que va a comer
                    if (to.getY() == from.getY() - 2) {
                        Campo auxIzq = m.getCampo(from.getX() + 1, from.getY() - 1);
                        if (!(auxIzq.getPieza() instanceof Vacio) && auxIzq.getPieza().getColor() == 'b') {
                            auxIzq.setPieza(new Vacio('n'));
                            m.restaBlancas();
                            this.estaComiendo = true;
                            return true;
                        }
                    } else if (to.getY() == from.getY() + 2) {
                        Campo auxDer = m.getCampo(from.getX() + 1, from.getY() + 1);
                        if (!(auxDer.getPieza() instanceof Vacio) && auxDer.getPieza().getColor() == 'b') {
                            auxDer.setPieza(new Vacio('n'));
                            m.restaBlancas();
                            this.estaComiendo = true;
                            return true;
                        }
                    }

                }
                else if (to.getX() == from.getX() - 2) {//si es el caso de que va a comer
                    if (to.getY() == from.getY() - 2) {
                        Campo auxIzq = m.getCampo(from.getX() - 1, from.getY() - 1);
                        if (!(auxIzq.getPieza() instanceof Vacio) && auxIzq.getPieza().getColor() == 'b') {
                            auxIzq.setPieza(new Vacio('n'));
                            m.restaBlancas();
                            this.estaComiendo = true;
                            return true;
                        }
                    } else if (to.getY() == from.getY() + 2) {
                        Campo auxDer = m.getCampo(from.getX() - 1, from.getY() + 1);
                        if (!(auxDer.getPieza() instanceof Vacio) && auxDer.getPieza().getColor() == 'b') {
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
        if(from.getX() == 0){//si es el caso de que la ficha se encuentra en el extremo superior
            if(from.getY() == 1){
                Campo auxIzq = m.getCampo(from.getX()+1, from.getY()+1);
                Campo sig = m.getCampo(from.getX()+2, from.getY()+2);
                if(!( auxIzq.getPieza() instanceof Vacio) && auxIzq.getPieza().getColor() != from.getPieza().getColor()
                        && (sig.getPieza() instanceof Vacio)){
                    return true;
                }
            }else if(from.getY() == 7){
                Campo auxDer = m.getCampo(from.getX()+1, from.getY()-1);
                Campo sig = m.getCampo(from.getX()+2, from.getY()-2);
                if(!( auxDer.getPieza() instanceof Vacio) && auxDer.getPieza().getColor() != from.getPieza().getColor()
                        && (sig.getPieza() instanceof Vacio)){
                    return true;
                }
            }else{
                Campo auxIzq = m.getCampo(from.getX()+1, from.getY()+1);
                Campo sigIzq = m.getCampo(from.getX()+2, from.getY()+2);
                Campo auxDer = m.getCampo(from.getX()+1, from.getY()-1);
                Campo sigDer = m.getCampo(from.getX()+2, from.getY()-2);
                if((!( auxIzq.getPieza() instanceof Vacio) && auxIzq.getPieza().getColor() != from.getPieza().getColor() && (sigIzq.getPieza() instanceof Vacio))
                        || (!( auxDer.getPieza() instanceof Vacio) && auxDer.getPieza().getColor() != from.getPieza().getColor() && (sigDer.getPieza() instanceof Vacio))){
                    return true;
                }
            } 
        }else if(from.getX() == 1){//si es el caso de que la ficha se encuentra en el extremo superior
            if(from.getY() == 0){
                Campo auxIzq = m.getCampo(from.getX()+1, from.getY()+1);
                Campo sig = m.getCampo(from.getX()+2, from.getY()+2);
                if(!( auxIzq.getPieza() instanceof Vacio) && auxIzq.getPieza().getColor() != from.getPieza().getColor()
                        && (sig.getPieza() instanceof Vacio)){
                    return true;
                }
            }else if(from.getY() == 6){
                Campo auxDer = m.getCampo(from.getX()+1, from.getY()-1);
                Campo sig = m.getCampo(from.getX()+2, from.getY()-2);
                if(!( auxDer.getPieza() instanceof Vacio) && auxDer.getPieza().getColor() != from.getPieza().getColor()
                        && (sig.getPieza() instanceof Vacio)){
                    return true;
                }
            }else{
                Campo auxIzq = m.getCampo(from.getX()+1, from.getY()+1);
                Campo sigIzq = m.getCampo(from.getX()+2, from.getY()+2);
                Campo auxDer = m.getCampo(from.getX()+1, from.getY()-1);
                Campo sigDer = m.getCampo(from.getX()+2, from.getY()-2);
                if((!( auxIzq.getPieza() instanceof Vacio) && auxIzq.getPieza().getColor() != from.getPieza().getColor() && (sigIzq.getPieza() instanceof Vacio))
                        || (!( auxDer.getPieza() instanceof Vacio) && auxDer.getPieza().getColor() != from.getPieza().getColor() && (sigDer.getPieza() instanceof Vacio))){
                    return true;
                }
            }
        }else if(from.getX() == 7){//si es el caso de que la ficha se encuentra en el extremo inferior
            if(from.getY() == 0){
                Campo auxDer = m.getCampo(from.getX()-1, from.getY()+1);
                Campo sig = m.getCampo(from.getX()-2, from.getY()+2);
                if(!( auxDer.getPieza() instanceof Vacio) && auxDer.getPieza().getColor() != from.getPieza().getColor()
                        && (sig.getPieza() instanceof Vacio)){
                    return true;
                }
            }else if(from.getY() == 6){
                Campo auxIzq = m.getCampo(from.getX()-1, from.getY()-1);
                Campo sig = m.getCampo(from.getX()-2, from.getY()-2);
                if(!( auxIzq.getPieza() instanceof Vacio) && auxIzq.getPieza().getColor() != from.getPieza().getColor()
                        && (sig.getPieza() instanceof Vacio)){
                    return true;
                }
            }else{
                Campo auxIzq = m.getCampo(from.getX()-1, from.getY()-1);
                Campo sigIzq = m.getCampo(from.getX()-2, from.getY()-2);
                Campo auxDer = m.getCampo(from.getX()-1, from.getY()+1);
                Campo sigDer = m.getCampo(from.getX()-2, from.getY()+2);
                if((!( auxIzq.getPieza() instanceof Vacio) && auxIzq.getPieza().getColor() != from.getPieza().getColor() && (sigIzq.getPieza() instanceof Vacio))
                        || (!( auxDer.getPieza() instanceof Vacio) && auxDer.getPieza().getColor() != from.getPieza().getColor() && (sigDer.getPieza() instanceof Vacio))){
                    return true;
                }
            }
        }else if(from.getX() == 6){
            if(from.getY() == 1){
                Campo auxDer = m.getCampo(from.getX()-1, from.getY()+1);
                Campo sig = m.getCampo(from.getX()-2, from.getY()+2);
                if(!( auxDer.getPieza() instanceof Vacio) && auxDer.getPieza().getColor() != from.getPieza().getColor()
                        && (sig.getPieza() instanceof Vacio)){
                    return true;
                }
            }else if(from.getY() == 7){
                Campo auxIzq = m.getCampo(from.getX()-1, from.getY()-1);
                Campo sig = m.getCampo(from.getX()-2, from.getY()-2);
                if(!( auxIzq.getPieza() instanceof Vacio) && auxIzq.getPieza().getColor() != from.getPieza().getColor()
                        && (sig.getPieza() instanceof Vacio)){
                    return true;
                }
            }else{
                Campo auxIzq = m.getCampo(from.getX()-1, from.getY()-1);
                Campo sigIzq = m.getCampo(from.getX()-2, from.getY()-2);
                Campo auxDer = m.getCampo(from.getX()-1, from.getY()+1);
                Campo sigDer = m.getCampo(from.getX()-2, from.getY()+2);
                if((!( auxIzq.getPieza() instanceof Vacio) && auxIzq.getPieza().getColor() != from.getPieza().getColor() && (sigIzq.getPieza() instanceof Vacio))
                        || (!( auxDer.getPieza() instanceof Vacio) && auxDer.getPieza().getColor() != from.getPieza().getColor() && (sigDer.getPieza() instanceof Vacio))){
                    return true;
                }
            }
        }else if(from.getX() == 2){// las demas filas con sus extremos
            if(from.getY() == 1){
                Campo auxDerAdelan = m.getCampo(from.getX()+1, from.getY()+1);
                Campo sigAdelan = m.getCampo(from.getX()+2, from.getY()+2);
                Campo auxDerAtras = m.getCampo(from.getX()-1, from.getY()+1);
                Campo sigAtras = m.getCampo(from.getX()-2, from.getY()+2);
                if((!( auxDerAdelan.getPieza() instanceof Vacio) && auxDerAdelan.getPieza().getColor() != from.getPieza().getColor()
                        && (sigAdelan.getPieza() instanceof Vacio)) 
                    || (!( auxDerAtras.getPieza() instanceof Vacio) && auxDerAtras.getPieza().getColor() != from.getPieza().getColor()
                        && (sigAtras.getPieza() instanceof Vacio))){
                    return true;
                }
            }else if(from.getY() == 7){
                Campo auxIzqAdelan = m.getCampo(from.getX()+1, from.getY()-1);
                Campo sigAdelan = m.getCampo(from.getX()+2, from.getY()-2);
                Campo auxIzqAtras = m.getCampo(from.getX()-1, from.getY()-1);
                Campo sigAtras = m.getCampo(from.getX()-2, from.getY()-2);
                if((!( auxIzqAdelan.getPieza() instanceof Vacio) && auxIzqAdelan.getPieza().getColor() != from.getPieza().getColor()
                        && (sigAdelan.getPieza() instanceof Vacio)) 
                    || (!( auxIzqAtras.getPieza() instanceof Vacio) && auxIzqAtras.getPieza().getColor() != from.getPieza().getColor()
                        && (sigAtras.getPieza() instanceof Vacio))){
                    return true;
                }
            }else{
                Campo auxIzqAdelan = m.getCampo(from.getX()+1, from.getY()-1);
                Campo sigIzqAdelan = m.getCampo(from.getX()+2, from.getY()-2);
                Campo auxIzqAtras = m.getCampo(from.getX()-1, from.getY()-1);
                Campo sigIzqAtras = m.getCampo(from.getX()-2, from.getY()-2);
                Campo auxDerAdelan = m.getCampo(from.getX()+1, from.getY()+1);
                Campo sigDerAdelan = m.getCampo(from.getX()+2, from.getY()+2);
                Campo auxDerAtras = m.getCampo(from.getX()-1, from.getY()+1);
                Campo sigDerAtras = m.getCampo(from.getX()-2, from.getY()+2);
                if((!( auxIzqAdelan.getPieza() instanceof Vacio) && auxIzqAdelan.getPieza().getColor() != from.getPieza().getColor() && (sigIzqAdelan.getPieza() instanceof Vacio))
                    || (!( auxIzqAtras.getPieza() instanceof Vacio) && auxIzqAtras.getPieza().getColor() != from.getPieza().getColor() && (sigIzqAtras.getPieza() instanceof Vacio))
                    || (!( auxDerAdelan.getPieza() instanceof Vacio) && auxDerAdelan.getPieza().getColor() != from.getPieza().getColor() && (sigDerAdelan.getPieza() instanceof Vacio))
                    || (!( auxDerAtras.getPieza() instanceof Vacio) && auxDerAtras.getPieza().getColor() != from.getPieza().getColor() && (sigDerAtras.getPieza() instanceof Vacio))){
                    return true;
                }
            }
        }else if(from.getX() == 3){
            if(from.getY() == 0){
                Campo auxDerAdelan = m.getCampo(from.getX()+1, from.getY()+1);
                Campo sigAdelan = m.getCampo(from.getX()+2, from.getY()+2);
                Campo auxDerAtras = m.getCampo(from.getX()-1, from.getY()+1);
                Campo sigAtras = m.getCampo(from.getX()-2, from.getY()+2);
                if((!( auxDerAdelan.getPieza() instanceof Vacio) && auxDerAdelan.getPieza().getColor() != from.getPieza().getColor()
                        && (sigAdelan.getPieza() instanceof Vacio)) 
                    || (!( auxDerAtras.getPieza() instanceof Vacio) && auxDerAtras.getPieza().getColor() != from.getPieza().getColor()
                        && (sigAtras.getPieza() instanceof Vacio))){
                    return true;
                }
            }else if(from.getY() == 6){
                Campo auxIzqAdelan = m.getCampo(from.getX()+1, from.getY()-1);
                Campo sigAdelan = m.getCampo(from.getX()+2, from.getY()-2);
                Campo auxIzqAtras = m.getCampo(from.getX()-1, from.getY()-1);
                Campo sigAtras = m.getCampo(from.getX()-2, from.getY()-2);
                if((!( auxIzqAdelan.getPieza() instanceof Vacio) && auxIzqAdelan.getPieza().getColor() != from.getPieza().getColor()
                        && (sigAdelan.getPieza() instanceof Vacio)) 
                    || (!( auxIzqAtras.getPieza() instanceof Vacio) && auxIzqAtras.getPieza().getColor() != from.getPieza().getColor()
                        && (sigAtras.getPieza() instanceof Vacio))){
                    return true;
                }
            }else{
                Campo auxIzqAdelan = m.getCampo(from.getX()+1, from.getY()-1);
                Campo sigIzqAdelan = m.getCampo(from.getX()+2, from.getY()-2);
                Campo auxIzqAtras = m.getCampo(from.getX()-1, from.getY()-1);
                Campo sigIzqAtras = m.getCampo(from.getX()-2, from.getY()-2);
                Campo auxDerAdelan = m.getCampo(from.getX()+1, from.getY()+1);
                Campo sigDerAdelan = m.getCampo(from.getX()+2, from.getY()+2);
                Campo auxDerAtras = m.getCampo(from.getX()-1, from.getY()+1);
                Campo sigDerAtras = m.getCampo(from.getX()-2, from.getY()+2);
                if((!( auxIzqAdelan.getPieza() instanceof Vacio) && auxIzqAdelan.getPieza().getColor() != from.getPieza().getColor() && (sigIzqAdelan.getPieza() instanceof Vacio))
                    || (!( auxIzqAtras.getPieza() instanceof Vacio) && auxIzqAtras.getPieza().getColor() != from.getPieza().getColor() && (sigIzqAtras.getPieza() instanceof Vacio))
                    || (!( auxDerAdelan.getPieza() instanceof Vacio) && auxDerAdelan.getPieza().getColor() != from.getPieza().getColor() && (sigDerAdelan.getPieza() instanceof Vacio))
                    || (!( auxDerAtras.getPieza() instanceof Vacio) && auxDerAtras.getPieza().getColor() != from.getPieza().getColor() && (sigDerAtras.getPieza() instanceof Vacio))){
                    return true;
                }
            }
        }else if(from.getX() == 4){
            if(from.getY() == 1){
                Campo auxDerAdelan = m.getCampo(from.getX()+1, from.getY()+1);
                Campo sigAdelan = m.getCampo(from.getX()+2, from.getY()+2);
                Campo auxDerAtras = m.getCampo(from.getX()-1, from.getY()+1);
                Campo sigAtras = m.getCampo(from.getX()-2, from.getY()+2);
                if((!( auxDerAdelan.getPieza() instanceof Vacio) && auxDerAdelan.getPieza().getColor() != from.getPieza().getColor()
                        && (sigAdelan.getPieza() instanceof Vacio)) 
                    || (!( auxDerAtras.getPieza() instanceof Vacio) && auxDerAtras.getPieza().getColor() != from.getPieza().getColor()
                        && (sigAtras.getPieza() instanceof Vacio))){
                    return true;
                }
            }else if(from.getY() == 7){
                Campo auxIzqAdelan = m.getCampo(from.getX()+1, from.getY()-1);
                Campo sigAdelan = m.getCampo(from.getX()+2, from.getY()-2);
                Campo auxIzqAtras = m.getCampo(from.getX()-1, from.getY()-1);
                Campo sigAtras = m.getCampo(from.getX()-2, from.getY()-2);
                if((!( auxIzqAdelan.getPieza() instanceof Vacio) && auxIzqAdelan.getPieza().getColor() != from.getPieza().getColor()
                        && (sigAdelan.getPieza() instanceof Vacio)) 
                    || (!( auxIzqAtras.getPieza() instanceof Vacio) && auxIzqAtras.getPieza().getColor() != from.getPieza().getColor()
                        && (sigAtras.getPieza() instanceof Vacio))){
                    return true;
                }
            }else{
                Campo auxIzqAdelan = m.getCampo(from.getX()+1, from.getY()-1);
                Campo sigIzqAdelan = m.getCampo(from.getX()+2, from.getY()-2);
                Campo auxIzqAtras = m.getCampo(from.getX()-1, from.getY()-1);
                Campo sigIzqAtras = m.getCampo(from.getX()-2, from.getY()-2);
                Campo auxDerAdelan = m.getCampo(from.getX()+1, from.getY()+1);
                Campo sigDerAdelan = m.getCampo(from.getX()+2, from.getY()+2);
                Campo auxDerAtras = m.getCampo(from.getX()-1, from.getY()+1);
                Campo sigDerAtras = m.getCampo(from.getX()-2, from.getY()+2);
                if((!( auxIzqAdelan.getPieza() instanceof Vacio) && auxIzqAdelan.getPieza().getColor() != from.getPieza().getColor() && (sigIzqAdelan.getPieza() instanceof Vacio))
                    || (!( auxIzqAtras.getPieza() instanceof Vacio) && auxIzqAtras.getPieza().getColor() != from.getPieza().getColor() && (sigIzqAtras.getPieza() instanceof Vacio))
                    || (!( auxDerAdelan.getPieza() instanceof Vacio) && auxDerAdelan.getPieza().getColor() != from.getPieza().getColor() && (sigDerAdelan.getPieza() instanceof Vacio))
                    || (!( auxDerAtras.getPieza() instanceof Vacio) && auxDerAtras.getPieza().getColor() != from.getPieza().getColor() && (sigDerAtras.getPieza() instanceof Vacio))){
                    return true;
                }
            }
        }else if(from.getX() == 5){
            if(from.getY() == 0){
                Campo auxDerAdelan = m.getCampo(from.getX()+1, from.getY()+1);
                Campo sigAdelan = m.getCampo(from.getX()+2, from.getY()+2);
                Campo auxDerAtras = m.getCampo(from.getX()-1, from.getY()+1);
                Campo sigAtras = m.getCampo(from.getX()-2, from.getY()+2);
                if((!( auxDerAdelan.getPieza() instanceof Vacio) && auxDerAdelan.getPieza().getColor() != from.getPieza().getColor()
                        && (sigAdelan.getPieza() instanceof Vacio)) 
                    || (!( auxDerAtras.getPieza() instanceof Vacio) && auxDerAtras.getPieza().getColor() != from.getPieza().getColor()
                        && (sigAtras.getPieza() instanceof Vacio))){
                    return true;
                }
            }else if(from.getY() == 6){
                Campo auxIzqAdelan = m.getCampo(from.getX()+1, from.getY()-1);
                Campo sigAdelan = m.getCampo(from.getX()+2, from.getY()-2);
                Campo auxIzqAtras = m.getCampo(from.getX()-1, from.getY()-1);
                Campo sigAtras = m.getCampo(from.getX()-2, from.getY()-2);
                if((!( auxIzqAdelan.getPieza() instanceof Vacio) && auxIzqAdelan.getPieza().getColor() != from.getPieza().getColor()
                        && (sigAdelan.getPieza() instanceof Vacio)) 
                    || (!( auxIzqAtras.getPieza() instanceof Vacio) && auxIzqAtras.getPieza().getColor() != from.getPieza().getColor()
                        && (sigAtras.getPieza() instanceof Vacio))){
                    return true;
                }
            }else{
                Campo auxIzqAdelan = m.getCampo(from.getX()+1, from.getY()-1);
                Campo sigIzqAdelan = m.getCampo(from.getX()+2, from.getY()-2);
                Campo auxIzqAtras = m.getCampo(from.getX()-1, from.getY()-1);
                Campo sigIzqAtras = m.getCampo(from.getX()-2, from.getY()-2);
                Campo auxDerAdelan = m.getCampo(from.getX()+1, from.getY()+1);
                Campo sigDerAdelan = m.getCampo(from.getX()+2, from.getY()+2);
                Campo auxDerAtras = m.getCampo(from.getX()-1, from.getY()+1);
                Campo sigDerAtras = m.getCampo(from.getX()-2, from.getY()+2);
                if((!( auxIzqAdelan.getPieza() instanceof Vacio) && auxIzqAdelan.getPieza().getColor() != from.getPieza().getColor() && (sigIzqAdelan.getPieza() instanceof Vacio))
                    || (!( auxIzqAtras.getPieza() instanceof Vacio) && auxIzqAtras.getPieza().getColor() != from.getPieza().getColor() && (sigIzqAtras.getPieza() instanceof Vacio))
                    || (!( auxDerAdelan.getPieza() instanceof Vacio) && auxDerAdelan.getPieza().getColor() != from.getPieza().getColor() && (sigDerAdelan.getPieza() instanceof Vacio))
                    || (!( auxDerAtras.getPieza() instanceof Vacio) && auxDerAtras.getPieza().getColor() != from.getPieza().getColor() && (sigDerAtras.getPieza() instanceof Vacio))){
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
