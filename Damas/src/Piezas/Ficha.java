
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
            case 'b': {
                this.icono = new ImageIcon("iconos/ficha_blanca.png");
                }
                break;
            
            case 'n': {
                this.icono = new ImageIcon("iconos/ficha_negra.png");              
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
        
            case 'b': {
                this.icono = new ImageIcon("iconos/ficha_blanca.png");       
                }
                break;
            
            case 'n':{
                this.icono = new ImageIcon("iconos/ficha_negra.png");
                }
                break;
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
