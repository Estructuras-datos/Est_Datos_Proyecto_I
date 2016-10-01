
package Piezas;
import javax.swing.ImageIcon;

public class Vacio extends Pieza{
    
    /*
        
        Los campos Vacios los hicimos para cuendo no hay ningun objeto en la
        la matriz, entonces va a ser un campo vacio. 
    
    */
    
    
    public Vacio(char color) {
        
        super('v'/*Vacio*/,color);
                
        if(color == 'n'){
        
             icono = new ImageIcon("iconos/cafe.png");
            
        }else if(color == 'b'){
        
             icono = new ImageIcon("iconos/claro.png");
        }
    }

    @Override
    public void setFondo(char _fondo) {
   
        if(_fondo != fondo){
        
            if(_fondo == 'b'){
   
                icono = null;
                icono = new ImageIcon("iconos/claro.png");
            
            }else if(_fondo == 'n'){
            
                icono = null;
                icono = new ImageIcon("iconos/cafe.png");
            }
            
            this.fondo = _fondo;
            
        }
    }
    
    public Pieza hacerCopia() {
        Vacio copia=new Vacio(this.color);
        copia.icono=this.icono;
        return copia;
    }
    
}
