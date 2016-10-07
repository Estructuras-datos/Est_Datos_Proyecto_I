
package Juego;
import Interfaz.*;
import Movimientos.*;
import Piezas.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.border.LineBorder;

/*
    El juego, es la clase control del juego.

    En esta clase, se maneja el ActionListener que se le asigno a 
    los botones en la clase tablero y se encarga de darle un adecuado 
    uso a las clases del Package Interfaz.  

*/

public class Juego implements ActionListener{

    private Matriz matriz;
    private Tablero tablero;
    private Jugador jugador1, jugador2;
    private boolean turno = false, error = false;
    private boolean flag1 = false, flag2 = false, flag3 = false;
    private Campo campoInicial,campoDestino;
    private int x_blanco = 0,y_blanco = 4,x_negro = 7,y_negro = 4;
    private Movimiento mov;
    
    
    public Juego() {
        nuevoJuego();
     }
    
    
    public final void nuevoJuego(){
        
        jugador1=new Jugador("Jugador 1",false,'b');
        jugador2=new Jugador("Jugador 2",true,'n');
        matriz=new Matriz();
        tablero = new Tablero(matriz,this);
    }

    private char CasteaInt(int i){ //uilizado para imprimir la posicion en la que se encuentra la ficha seleccionada
        if(i == 0) return 'A';
        if(i == 1) return 'B';
        if(i == 2) return 'C';
        if(i == 3) return 'D';
        if(i == 4) return 'E';
        if(i == 5) return 'F';
        if(i == 6) return 'G';
        if(i == 7) return 'H';
        return '!';
    }
    
    private void CambiaDeTurno(){
        turno = !this.turno;
        this.tablero.CambiaTurnoJLabel();
        this.tablero.SetMessage("Elija la ficha a mover");
       
    }
   
    
    /*
        El metodo dependiendo el turno y la ficha seleccionada retorna 
        true o false. Tambien, si es el turno del otro jugador, muestra
        un mensaje diciendo de quien es el turno y que ficha debe moverse.
    */
    private boolean ValidaSeleccion(Campo _from){
    
        if(turno == jugador1.getId())
             if(_from.getPieza().getColor() == jugador1.getColor()){
                 return true;
             }else{
             
                 JOptionPane.showMessageDialog(null,"El turno es del:"+jugador1.getNum()+"\n"+"Debe seleccionar fichas blancas.","Error",JOptionPane.ERROR_MESSAGE);
             }
            
        else if(_from.getPieza().getColor() == jugador2.getColor()){
                 return true;
             }else{
             
                 JOptionPane.showMessageDialog(null,"El turno es del:"+jugador2.getNum()+"\n"+"Debe seleccionar fichas negras.","Error",JOptionPane.ERROR_MESSAGE);
             }
        
        return false;
    }
    
    //--------------------------------------------------------------------------
    /*
        EL siguiente metodo lo que hace es convertir en distintas instancias
        el atributo mov, el cual le peertenece a clase abstracta Movimiento, 
        dependiendo el campo to y la ficha que poseea mov se va a hacer de ese
        movimiento.
        
        Ej. la ficha from, tiene la pieza reina, entonces se inicializa reina
        como Movimiento de Reina, y valida si el movimiento esta correcto
        devolviendo un true o un false; en caso de que sea true, se cambian de
        posicion.
    */
    
    private boolean InicializaMov(){
    
        if(flag1 && flag2){
            if(campoInicial.getPieza() instanceof Ficha)   mov = new MovimientoFicha();
            else if(campoInicial.getPieza() instanceof Reina)  mov = new MovimientoReina();
            else return false;
            return true;
        }
        else return false;
    
    }
    
    //--------------------------------------------------------------------------
    /* 
        Si el metodo selecciona ficha es true, es porque debe hacerse el
        movimiento; el metodo selecciona campos, los cuales se van agregando
        a las variables from y to de esta clase.
    */
    
    
    private boolean SeleccionaFicha(ActionEvent ae){
        if(this.error){
            this.campoInicial.getBoton().setBorder(new LineBorder(Color.WHITE, 1));
            this.campoDestino.getBoton().setBorder(new LineBorder(Color.WHITE, 1));
            if(error) error = !error;
            campoInicial = null;
            campoDestino = null;
        }
        
        Campo aux = null;
        boolean f = true;
        int x = 0;
        int y = 0;
        
        while( f){  //Este while busca la ficha seleccionada, comienza en 0,0 -> 1,0 -> 2,0.... 0,1 -> 1,1... 7,7
            if(ae.getSource() == matriz.getCampo(x, y).getBoton()){
                aux = matriz.getCampo(x, y);
                f = false;
            }
            else if(ae.getSource() == matriz.getCampo(x+1, y).getBoton()){
                aux = matriz.getCampo(x+1, y);
                f = false;
            }
            else if(ae.getSource() == matriz.getCampo(x+2, y).getBoton()){
                aux = matriz.getCampo(x+2, y);
                f = false;
            }
            else if(ae.getSource() == matriz.getCampo(x+3, y).getBoton()){
                aux = matriz.getCampo(x+3, y);  
                f = false;
            }else{
                x += 4 ;
                if(x == 8){
                    y++;
                    x = 0;
                    if(y == 8) return false;
                }
            }
        }
              
        if(!flag1){
            if(aux.getPieza() instanceof Vacio) return false;//si la ficha seleccionada es vacio se cancela la seleccion
            
            else if(!this.ValidaSeleccion(aux)){
                campoInicial = null;
                this.tablero.SetMessage("Elija la ficha a mover");
            }else{ 
                flag1 = true;
                campoInicial = aux;
                this.tablero.SetMessage("Ficha: "+aux.getPieza().getClass().getSimpleName()
                        +"  [ "+CasteaInt(aux.getX())+(aux.getY()+1)+" ]");
                this.campoInicial.getBoton().setBorder(new LineBorder(Color.YELLOW, 3));  //ficha seleccionada correctamente por lo que se pone el borde en amarillo
            } 
        }else if(!flag2){
            flag2 = true;
            campoDestino = aux;
            this.campoInicial.getBoton().setBorder(new LineBorder(Color.WHITE, 1));
            return true;
        }
        return false;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        boolean f9 = true, f10 = false;
        if(ae.getSource() == tablero.getReiniciar()){
            tablero.dispose();
            Juego j = new Juego();
        }
        else if(ae.getSource() == tablero.getInfo()){
            Reglas r = new Reglas();
        }
        else if(ae.getSource() == tablero.getRetirarse()){
        
            //Jugador _j = new Jugador("",false,'c');
            //JuegoTerminado j = new JuegoTerminado(_j);
            //j.Empate();
            
           //tablero.dispose();
           
        }
        else if(SeleccionaFicha(ae)){
            if(this.InicializaMov()){
                if(campoInicial.getX() == campoDestino.getX() && campoInicial.getY() == campoDestino.getY()){ //si esta seleccionando la misma ficha como destino
                    this.campoInicial.getBoton().setBorder(new LineBorder(Color.WHITE, 1));
                    this.tablero.SetMessage("Eliga la ficha a mover");
                    campoInicial = null;
                    campoDestino = null;
                    f9 = false;
                 }else f10 = true;

                if(f9)
                    if(mov.Move_From_To(campoInicial, campoDestino, this.matriz)){
                        
                        this.reemplazarFichas(campoInicial,campoDestino);
                        this.verificaGane();
                        this.CambiaDeTurno();
                    }else{
                        this.tablero.SetMessage("Movimiento Incorrecto");
                        this.campoInicial.getBoton().setBorder(new LineBorder(Color.RED, 3));
                        this.campoDestino.getBoton().setBorder(new LineBorder(Color.RED, 3));
                        this.error = true;
                    }   
            }
            this.flag1 = false;
            this.flag2 = false;
        }
    }
    
    public void reemplazarFichas(Campo from, Campo to){
        if (from.getPieza().getColor() == 'b' && to.getX() == 0) { //si el destino es el borde del contrario se convierte en reina
            to.setPieza(new Reina('b', 'n'));
            from.setPieza(new Vacio(from.getColor()));
        }
        else if(from.getPieza().getColor() == 'n' && to.getX() == 7){
            to.setPieza(new Reina('n', 'n'));
            from.setPieza(new Vacio(from.getColor()));
        }
        else {
            to.setPieza(from.getPieza());
            from.setPieza(new Vacio(from.getColor()));
        }
    }
    
    public void verificaGane(){
        if (matriz.getContadorNegras() == 0) {
            tablero.dispose();
            JuegoTerminado juegoTer = new JuegoTerminado(this.jugador1);
        } 
        else if (matriz.getContadorBlancas() == 0) {
            tablero.dispose();
            JuegoTerminado juegoTer = new JuegoTerminado(this.jugador2);
        }
    }
    
}
