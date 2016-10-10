
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
    private char turno = 'A';
    private boolean error = false;
    private Campo campoInicial,campoDestino;
    private int x_blanco = 0,y_blanco = 4,x_negro = 7,y_negro = 4;
    private Movimiento mov;
    private boolean tengoInicial = false, tengoDestino = false;
    
    public Juego() {
        nuevoJuego();
     }
    
    
    public final void nuevoJuego(){
        jugador1=new Jugador("1",'A','b');
        jugador2=new Jugador("2",'B','n');
        matriz=new Matriz();
        tablero = new Tablero(matriz,this);
    }

    private void cambiaDeTurno(){        
        if(turno == 'A'){
            turno = 'B';
        }else{
            turno = 'A';     
        }
        this.tablero.CambiaTurnoJLabel();
        this.tablero.SetMessage("Elija la ficha a mover");
    }
        
    public boolean seleccionar(ActionEvent ae){
        if(this.error){
            this.campoInicial.getBoton().setBorder(new LineBorder(Color.WHITE, 1));
            this.campoDestino.getBoton().setBorder(new LineBorder(Color.WHITE, 1));
            if(error) error = !error;
            campoInicial = null;
            campoDestino = null;
        }
        Campo actual = this.getFichaPulsada(ae);
        if(!tengoInicial){
            if(actual.getPieza() instanceof Vacio){
                return false;
            }else if(!this.validarSeleccion(actual)){
                campoInicial = null;
                this.tablero.SetMessage("Elija la ficha a mover");
            }else{ 
                campoInicial = actual;
                this.tengoInicial = true;
                this.campoInicial.getBoton().setBorder(new LineBorder(Color.GREEN, 3));  //ficha seleccionada correctamente por lo que se pone el borde en amarillo                this.campoActual = 'D'; //se setea para que la siguienete seleccion sea del destino
            }
        }else if(!tengoDestino){
            campoDestino = actual;
            this.tengoDestino = true;
            this.campoInicial.getBoton().setBorder(new LineBorder(Color.WHITE, 1));
            return true;
        }
        return false;
        
    }
    
    private Campo getFichaPulsada(ActionEvent ae){
        int x = 0;
        int y = 0;
        Campo selected = null;
        boolean seguir = true;
        while(seguir){ //Este while busca la ficha seleccionada, comienza en 0,0 -> 1,0 -> 2,0.... 0,1 -> 1,1... 7,7
            if(y<8){
                if(ae.getSource() == matriz.getCampo(x, y).getBoton()){
                    selected = matriz.getCampo(x, y);
                    seguir = false;
                }else{
                    y++;
                }
            }else{
                if(x<8){
                    x++;
                    y=0;
                }
                
            }
        }
        return selected;
    }
    
    /*
        El metodo dependiendo el turno y la ficha seleccionada retorna 
        true o false. Tambien, si es el turno del otro jugador, muestra
        un mensaje diciendo de quien es el turno y que ficha debe moverse.
    */
    private boolean validarSeleccion(Campo from){
        if(turno == jugador1.getId()){
            if(from.getPieza().getColor() == jugador1.getColor()){
                return true;
            }else{
                JOptionPane.showMessageDialog(null,"El turno es del jugador de fichas blancas.","Error",JOptionPane.ERROR_MESSAGE);
            }
        }else if(turno == jugador2.getId()){
            if(from.getPieza().getColor() == jugador2.getColor()){
                return true;
            }else{
                JOptionPane.showMessageDialog(null,"El turno es del jugador de fichas negras.","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;        
    }
    
    private boolean seguirComiendo(Campo to){
       return  mov.puedoComer(this.campoDestino, to, this.matriz);
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
    
    private boolean inicializaMov(){
        if(this.tengoInicial && this.tengoDestino){
            if(campoInicial.getPieza() instanceof Ficha)   mov = new MovimientoFicha();
            else if(campoInicial.getPieza() instanceof Reina)  mov = new MovimientoReina();
            else return false;
            return true;
        }
        else return false;
    
    }
       
    @Override
    public void actionPerformed(ActionEvent ae) {
        boolean proseguir = true;
        if(ae.getSource() == tablero.getReiniciar()){
            tablero.dispose();
            Juego j = new Juego();
        }
        else if(ae.getSource() == tablero.getInfo()){
            Reglas r = new Reglas();
        }
        else if(ae.getSource() == tablero.getRetirarse()){
            //agregar codigo                   
        }
        else if(this.seleccionar(ae)){
            if(this.inicializaMov()){
                if(campoInicial.getX() == campoDestino.getX() && campoInicial.getY() == campoDestino.getY()){ //si esta seleccionando la misma ficha como destino
                    this.campoInicial.getBoton().setBorder(new LineBorder(Color.WHITE, 1));
                    this.tablero.SetMessage("Eliga la ficha a mover");
                    campoInicial = null;
                    campoDestino = null;
                    proseguir = false;
                }
                else if(proseguir)
                    if(mov.Move_From_To(campoInicial, campoDestino, this.matriz)){
                        this.reemplazarFichas(campoInicial,campoDestino);
                        this.verificaGane();
//                        while(this.seguirComiendo(campoDestino)){
//                            this.tablero.SetMessage("Siga comiendo.");
//                            this.tengoInicial = false;
//                            this.tengoDestino = false;
//                            if(this.seleccionar(ae)){
//                                mov.Move_From_To(campoInicial, campoDestino, this.matriz);
//                            }
//                        }
                        this.cambiaDeTurno();
                    }else{
                        this.tablero.SetMessage("Movimiento Incorrecto");
                        this.campoInicial.getBoton().setBorder(new LineBorder(Color.RED, 3));
                        this.campoDestino.getBoton().setBorder(new LineBorder(Color.RED, 3));
                        this.error = true;
                    }   
            }
            this.tengoInicial = false;
            this.tengoDestino = false;
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
    
} //fin de la clase juego




    //--------------------------------------------------------------------------
    /* 
        Si el metodo selecciona ficha es true, es porque debe hacerse el
        movimiento; el metodo selecciona campos, los cuales se van agregando
        a las variables from y to de esta clase.
    */
    
    
//    private boolean SeleccionaFicha(ActionEvent ae){
//        if(this.error){
//            this.campoInicial.getBoton().setBorder(new LineBorder(Color.WHITE, 1));
//            this.campoDestino.getBoton().setBorder(new LineBorder(Color.WHITE, 1));
//            if(error) error = !error;
//            campoInicial = null;
//            campoDestino = null;
//        }
//        
//        Campo aux = null;
//        boolean f = true;
//        int x = 0;
//        int y = 0;
//        
//        while(f){ //Este while busca la ficha seleccionada, comienza en 0,0 -> 1,0 -> 2,0.... 0,1 -> 1,1... 7,7
//            if(y<8){
//                if(ae.getSource() == matriz.getCampo(x, y).getBoton()){
//                    aux = matriz.getCampo(x, y);
//                    f = false;
//                }else{
//                    y++;
//                }
//            }else{
//                if(x<8){
//                    x++;
//                    y=0;
//                }else{
//                    return false;
//                }
//                
//            }
//        }
//              
//        if(!flag1){
//            if(aux.getPieza() instanceof Vacio) return false;//si la ficha seleccionada es vacio se cancela la seleccion
//            
//            else if(!this.ValidaSeleccion(aux)){
//            
//                campoInicial = null;
//                this.tablero.SetMessage("Elija la ficha a mover");
//            }else{ 
//                flag1 = true;
//                campoInicial = aux;
//                this.tablero.SetMessage("Ficha: "+aux.getPieza().getClass().getSimpleName()
//                        +"  [ "+CasteaInt(aux.getX())+(aux.getY()+1)+" ]");
//                this.campoInicial.getBoton().setBorder(new LineBorder(Color.YELLOW, 3));  //ficha seleccionada correctamente por lo que se pone el borde en amarillo
//            } 
//        }else if(!flag2){
//            flag2 = true;
//            campoDestino = aux;
//            this.campoInicial.getBoton().setBorder(new LineBorder(Color.WHITE, 1));
//            return true;
//        }
//        return false;
//    }