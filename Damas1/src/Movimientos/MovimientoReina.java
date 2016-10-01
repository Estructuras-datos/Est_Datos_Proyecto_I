package Movimientos;

import Juego.Campo;
import Juego.Matriz;
import Piezas.Pieza;
import Piezas.Reina;
import Piezas.Vacio;

public class MovimientoReina extends Movimiento {

    public MovimientoReina() {
    }
    
    
    
 //-----------------------------------------------------------------------------------------------
    /*
        Los metodos Calcula_Diagonal_ dependen de:
        Despues de realizar la resta de las coordenadas from y to, se dan los 
        siguientes casos:
            
            - Resta_x y resta_y negativa.
            - Resta_x positiva y resta_t negativa.
            - Resta_x negatica y resta_y positiva.
            - Resta_x y resta_y positivas.
    
        Entran a sus respectivos metodos y realizan un calculo a ver si existe
        una diagonal, y si en el camino, no existe ninguna pieza que interfiera.
    
    */
    
     private boolean Calcula_Diagonal_XNEG_YNEG(int x_from,int y_from,int x_to,int y_to, Matriz m){
    
        
        
        while(true){
        
            x_from++;
            y_from++;
            
            if(x_from > 7 || y_from > 7) return false;
            else if(x_from == x_to && y_from == y_to) return true;
            else if(x_from > x_to || y_from > y_to) return false;
            else if(!this.Campo_Vacio(x_from, y_from, m)) return false;
         
        }
    
    }
    
    private boolean Calcula_Diagonal_XPOS_YNEG(int x_from,int y_from,int x_to,int y_to, Matriz m){
    
        
        
        while(true){
        
            x_from--;
            y_from++;
            
            if(x_from < 0 || y_from > 7) return false;
            else if(x_from == x_to && y_from == y_to) return true;
            else if(x_from < x_to || y_from > y_to) return false;
            else if(!this.Campo_Vacio(x_from, y_from, m)) return false;
         
        }
    
    }
    
    private boolean Calcula_Diagonal_XNEG_YPOS(int x_from,int y_from,int x_to,int y_to, Matriz m){
    
        
        
        while(true){
        
            x_from++;
            y_from--;
            
            if(x_from > 7 || y_from < 0) return false;
            else if(x_from == x_to && y_from == y_to) return true;
            else if(x_from > x_to || y_from < y_to) return false;
            else if(!this.Campo_Vacio(x_from, y_from, m)) return false;
         
        }
    
    }
    
    private boolean Calcula_Diagonal_XPOS_YPOS(int x_from,int y_from,int x_to,int y_to, Matriz m){
    
        
    
        while(true){
        
            x_from--;
            y_from--;
            
            if(x_from < 0 || y_from < 0) return false;
            else if(x_from == x_to && y_from == y_to) return true;
            else if(x_from < x_to || y_from < y_to) return false;
            else if(!this.Campo_Vacio(x_from, y_from, m)) return false;
         
        }
    
    }
    
    //---------------------------------------------------------------------------------------
   
     /*
    
        Los metodos Verifican eje, lo que hacen es lo siguiente:
        Dependiendo la resta, uno de los dos debe dar 0, ese seria el eje const,
        el otro da un numero:
        
            - si es menor a 0, se utiliza el metodo Verifica_Resta_Eje_Menor.
            - si es mayor a 0, se utiliza el metodo Verifica_Resta_Eje_Mayor.
            - si es 0 , es un movimiento invalido, debido a que se quedo en
              la misma posicion.
    
    */
    
    private boolean Verifica_Resta_Eje_MenorX(int EjeConst,int EjeVariable, int ejeTo, Matriz m){
    
        for(int i = EjeVariable+1 ;  i < ejeTo ;i++){
                
                    if(!(m.getCampo(i, EjeConst ).getPieza() instanceof Vacio)  ) return false;
                                    
                }
        return true;
    }
    
    private boolean Verifica_Resta_Eje_MayorX(int EjeConst,int EjeVariable, int EjeTo, Matriz m){
    
        for(int i = EjeVariable-1 ;  i > EjeTo ;i--){
                
                    if(!(m.getCampo(i, EjeConst).getPieza() instanceof Vacio)) return false;
                                    
                }
        
        return true;
    }
    
      private boolean Verifica_Resta_Eje_MenorY(int EjeConst,int EjeVariable, int ejeTo, Matriz m){
    
        for(int i = EjeVariable+1 ;  i < ejeTo ;i++){
                
                    if(!(m.getCampo(EjeConst, i).getPieza() instanceof Vacio)  ) return false;
                                    
                }
        return true;
    }
    
    private boolean Verifica_Resta_Eje_MayorY(int EjeConst,int EjeVariable, int EjeTo, Matriz m){
    
        for(int i = EjeVariable-1 ;  i > EjeTo ;i--){
                
                    if(!(m.getCampo(EjeConst, i).getPieza() instanceof Vacio)) return false;
                                    
                }
        
        return true;
    }
    
    //---------------------------------------------------------------------------------------
    
    private boolean Campo_Vacio(int x, int y, Matriz m){
            Pieza p;
            p = m.getCampo(x, y).getPieza();
            return (p instanceof Vacio);
    }
    
    private boolean Can_Move(Campo from, Campo to, Matriz m){
        
        int x_from = from.getX(), y_from = from.getY();
        int x_to   = to.getX(), y_to   = to.getY();
                
        int RestaX = x_from - x_to, RestaY = y_from - y_to;
        
         if(RestaX == 0 && RestaY != 0){
        
            if(RestaY < 0) if(!Verifica_Resta_Eje_MenorY(x_from,y_from,y_to,m)) return false;
                
            else if(!Verifica_Resta_Eje_MayorY(x_from,y_from,y_to,m)) return false;
            
            return true;
                        
        }else if(RestaX != 0 && RestaY == 0){
        
            if(RestaX < 0) if(!Verifica_Resta_Eje_MenorX(y_from,x_from,x_to,m)) return false;
                
            else if(!Verifica_Resta_Eje_MayorX(y_from,x_from,x_to,m)) return false;
            
            return true;
            
        }
        else if(RestaX < 0 && RestaY < 0 ) 
            return  Calcula_Diagonal_XNEG_YNEG(x_from,y_from,x_to,y_to,m);
        
        else if(RestaX > 0 && RestaY < 0) 
            return Calcula_Diagonal_XPOS_YNEG(x_from, y_from, x_to, y_to, m);
        
        else if(RestaX < 0 && RestaY > 0)
            return Calcula_Diagonal_XNEG_YPOS(x_from, y_from, x_to, y_to, m);
        
        else if(RestaX > 0 && RestaY > 0)
            return Calcula_Diagonal_XPOS_YPOS(x_from, y_from, x_to, y_to, m);
        
       else return false;
    }
    
    
    @Override
    public boolean Move_From_To(Campo from, Campo to, Matriz m){
   
          if(!(from.getPieza() instanceof Reina)) return false;
        
        if(!this.Verifica_Color_Difrente_Fichas(to.getPieza(), from.getPieza()))
            return false;
           
        return Can_Move(from,to,m);
        
    }
        
}
