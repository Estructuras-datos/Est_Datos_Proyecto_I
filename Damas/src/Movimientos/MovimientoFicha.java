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

    private boolean Move_from_to_White(Campo from, Campo to, Matriz m) throws Peon_Cast {
        int x_from = from.getX(), y_from = from.getY();
        int x_to   = to.getX()  , y_to   = to.getY();
        int RestaX = x_from - x_to, RestaY = y_from - y_to;
        Ficha p = (Ficha)from.getPieza();
        if(RestaX < 0) RestaX *= -1;
        switch(RestaX){
        
            case 0:
                
                /*
                En el case 0, los campos a los que va tienen que estar
                vacios.
                */
                if(!(to.getPieza() instanceof Vacio)) return false;
                
                else if(RestaY == -1)
                {
                    if(!p.getPrimerMovimiento()) p.setPrimerMovimiento();
                    
                    if(to.getY() == 7)
                        throw new Peon_Cast(x_from,y_from,x_to,y_to,p.getColor(),to.getColor());
                    
                    else return true;
                     
                }else if(RestaY == -2){
                    
                    if(m.getCampo(to.getX(),to.getY()-1).getPieza() instanceof Vacio)
                        return (!p.getPrimerMovimiento());
                    else return false;
                                    
                }
                
                else return false;
               
            case 1:
                if(RestaY == -1){ 
                    /*
                    En el case 1, la ficha to, no debe ser vacia.
                    */
                    if(!(to.getPieza() instanceof Vacio)){
                    
                        if(to.getY() == 7)
                            throw new Peon_Cast(x_from,y_from,x_to,y_to,p.getColor(),to.getColor());
                        
                        else return true;
                        
                    }else return false;
                }
                
            default: return false;
        }
    }
    
    private boolean Move_from_to_Black(Campo from, Campo to, Matriz m)throws Peon_Cast{
    
          int x_from = from.getX(), y_from = from.getY();
        int x_to   = to.getX()    , y_to   = to.getY();
                
        int RestaX = x_from - x_to, RestaY = y_from - y_to;
        
        Ficha p = (Ficha)from.getPieza();
   
        if(RestaX < 0) RestaX *= -1;
        
        switch(RestaX){
        
            case 0:
                 /*
                    En el case 0, los campos a los que va tienen que estar 
                    vacios.
                */
                if(!(to.getPieza() instanceof Vacio)) return false;
                
                else if(RestaY == 1)
                {
                    if(!p.getPrimerMovimiento()) p.setPrimerMovimiento();
                    
                    if(to.getY() == 0)
                    throw new Peon_Cast(x_from,y_from,x_to,y_to,p.getColor(),to.getColor());
                    
                    else return true;
                     
                }else if(RestaY == 2){
                    
                    if(m.getCampo(to.getX(),to.getY()+1).getPieza() instanceof Vacio)
                    return (!p.getPrimerMovimiento());
                    
                    else return false;
                
                }
                
                else return false;
            
            case 1:
                /*
                    En el case 1, la ficha to, no debe ser vacia.
                */
                if(RestaY == 1){ 
                    
                    if(!(to.getPieza() instanceof Vacio)){
                    
                        if(to.getY() == 0)
                        throw new Peon_Cast(x_from,y_from,x_to,y_to,p.getColor(),to.getColor()); 
                    
                        else return true;
                        
                    }else return false;
                }
                
            default: return false;
            
        }
        
    }
    
    @Override
    public boolean Move_From_To(Campo from, Campo to, Matriz m) throws Peon_Cast{
    
        if(!this.Verifica_Color_Difrente_Fichas(from.getPieza(), to.getPieza())) return false;
        if(!(from.getPieza() instanceof Ficha)) return false;
        
        
            return (from.getPieza().getColor() == 'b')?
                    Move_from_to_White(from,to,m): Move_from_to_Black(from,to,m);
       
        
    }

    
    
      
    
}
