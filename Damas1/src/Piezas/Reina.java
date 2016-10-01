
package Piezas;

import javax.swing.ImageIcon;


public class Reina extends Pieza{
    
    public Reina(char _color, char _fondo) {
        super(_color, _fondo);
        
          switch(color){
        
            case 'b':
                switch(fondo){                
                    case 'b':
                        this.icono = new ImageIcon("iconos/reina_blanco.png");
                        break;
                    case 'n':
                        this.icono = new ImageIcon("iconos/reina_blanco2.png");
                        break;
                }
                break;
            
            case 'n':
                switch(fondo){
                    case 'b':
                        this.icono = new ImageIcon("iconos/reina_negro2.png");
                        break;
                    case 'n':
                        this.icono = new ImageIcon("iconos/reina_negro.png");
                        break;
                
                }
                break;
        }
    
    }

    @Override
    public void setFondo(char _fondo) {
     
        icono = null;
        
        switch(color){
        
            case 'b':
                switch(_fondo){                
                    case 'b':
                        this.icono = new ImageIcon("iconos/reina_blanco.png");
                        break;
                    case 'n':
                        this.icono = new ImageIcon("iconos/reina_blanco2.png");
                        break;
                }
                break;
            
            case 'n':
                switch(_fondo){
                    case 'b':
                        this.icono = new ImageIcon("iconos/reina_negro2.png");
                        break;
                    case 'n':
                        this.icono = new ImageIcon("iconos/reina_negro.png");
                        break;
                
                }
                break;
        }
   }
    
    @Override
    public Pieza hacerCopia() {
        Reina copia=new Reina(this.color,this.fondo);
        copia.icono=this.icono;
    
        return copia;
    }
    
}
