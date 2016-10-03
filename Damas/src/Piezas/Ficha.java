
package Piezas;

import javax.swing.ImageIcon;


public class Ficha extends Pieza{
    
   private boolean primerMovimiento; 
   
   //---------------------------------------------------------------------------
   // Metodos
   
    public Ficha(char _color, char _fondo)
    {
        
        super(_color,_fondo);
      
        switch(color){
        
            case 'b':
                switch(fondo){                
                    case 'b':
                        this.icono = new ImageIcon("iconos/peon_blanco2.png");
                        break;
                    case 'n':
                        this.icono = new ImageIcon("iconos/peon_blanco.png");
                        break;
                }
                break;
            
            case 'n':
                switch(fondo){
                    case 'b':
                        this.icono = new ImageIcon("iconos/peon_negro.png");
                        break;
                    case 'n':
                        this.icono = new ImageIcon("iconos/peon_negro2.png");
                        break;
                
                }
                break;
        }
       
        this.primerMovimiento = false;
        
    }

    public void setPrimerMovimiento() {
        if(!this.primerMovimiento)this.primerMovimiento = true;
    }

    public boolean getPrimerMovimiento() {
        return primerMovimiento;
    }

    @Override
    public void setFondo(char _fondo) {
   
        icono = null;
        
        switch(color){
        
            case 'b':
                switch(_fondo){                
                    case 'b':
                        this.icono = new ImageIcon("iconos/peon_blanco2.png");
                        break;
                    case 'n':
                        this.icono = new ImageIcon("iconos/peon_blanco.png");
                        break;
                }
                break;
            
            case 'n':
                switch(_fondo){
                    case 'b':
                        this.icono = new ImageIcon("iconos/peon_negro.png");
                        break;
                    case 'n':
                        this.icono = new ImageIcon("iconos/peon_negro2.png");
                        break;
                
                }
                }
        
    }
    
    
   @Override
    public Pieza hacerCopia() {
        Ficha copia=new Ficha(this.color,this.fondo);
        copia.icono=this.icono;
        copia.primerMovimiento=this.primerMovimiento;
        
        return copia;
    }
    
    //--------------------------------------------------------------------------
    
}
