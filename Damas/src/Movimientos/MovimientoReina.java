package Movimientos;

import Juego.Campo;
import Juego.Matriz;
import Piezas.Vacio;

public class MovimientoReina extends Movimiento {

    public MovimientoReina() {
    }
    
    
    @Override
    public boolean Move_From_To(Campo from, Campo to, Matriz m){

        if (to.getPieza() instanceof Vacio) { //verificar que el campo este vacio primero       

            if (to.getX() == from.getX() - 1) { //si es el caso que se desplaza hacia adelante 
                if (to.getY() == from.getY() - 1 || to.getY() == from.getY() + 1) { //verificar que se desplaya a un campo valido
                    return true;
                }
            } else if (to.getX() == from.getX() + 1) {//si es el caso que se desplaza hacia atras
                if (to.getY() == from.getY() - 1 || to.getY() == from.getY() + 1) { //verificar que se desplaya a un campo valido
                    return true;
                }
            } else if (from.getPieza().getColor() == 'b') { //si la reina es blanca y va a comer
                if (to.getX() == from.getX() - 2) {
                    if (to.getY() == from.getY() - 2) {
                        Campo auxIzq = m.getCampo(from.getX() - 1, from.getY() - 1);
                        if (!(auxIzq.getPieza() instanceof Vacio) && auxIzq.getPieza().getColor() == 'n') {
                            auxIzq.setPieza(new Vacio('n'));
                            m.restaNegras();
                            return true;
                        }
                    } else if (to.getY() == from.getY() + 2) {
                        Campo auxDer = m.getCampo(from.getX() - 1, from.getY() + 1);
                        if (!(auxDer.getPieza() instanceof Vacio) && auxDer.getPieza().getColor() == 'n') {
                            auxDer.setPieza(new Vacio('n'));
                            m.restaNegras();
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
                            return true;
                        }
                    } else if (to.getY() == from.getY() + 2) {
                        Campo auxDer = m.getCampo(from.getX() + 1, from.getY() + 1);
                        if (!(auxDer.getPieza() instanceof Vacio) && auxDer.getPieza().getColor() == 'n') {
                            auxDer.setPieza(new Vacio('n'));
                            m.restaNegras();
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
                            return true;
                        }
                    } else if (to.getY() == from.getY() + 2) {
                        Campo auxDer = m.getCampo(from.getX() + 1, from.getY() + 1);
                        if (!(auxDer.getPieza() instanceof Vacio) && auxDer.getPieza().getColor() == 'b') {
                            auxDer.setPieza(new Vacio('n'));
                            m.restaBlancas();
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
                            return true;
                        }
                    } else if (to.getY() == from.getY() + 2) {
                        Campo auxDer = m.getCampo(from.getX() - 1, from.getY() + 1);
                        if (!(auxDer.getPieza() instanceof Vacio) && auxDer.getPieza().getColor() == 'b') {
                            auxDer.setPieza(new Vacio('n'));
                            m.restaBlancas();
                            return true;
                        }
                    }

                }
            }

        }


        
        return false;
    }

    @Override
    public boolean puedoComer(Campo from, Campo to, Matriz m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
