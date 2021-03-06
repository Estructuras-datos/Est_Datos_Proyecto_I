
package Interfaz;

import Model.Iterador;
import Model.Lista;
import Juego.Campo;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;
import Piezas.*;
import Juego.*;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;

/**
 *
 * @authors Denis Rodriguez, Sergio Vega
 */

public class Tablero extends JFrame{

    private JPanel panelJuego,panelPiezas,panelSuperior,panelInferior,panelMS;//paneles en los que se insertaran los componentes visuales del tablero
    private JButton reiniciar, retirarse; //botones para reiniciar o salir de la pantalla del tablero
    private JButton info;
    private boolean _turno = false; //define si es el turno del jugador 1 o del 2, para mostrarlo en el panel inferior
    private JLabel  turno, mensaje; //JLabels utilizados para mostrar mensajes varios, numerosTablero y letrasTablero son utlizados para incluir imagenes en el tablero para identificar el eje x,y
    private Lista<Lista> matriz; //matriz de tipo Campo que contiene las fichas que se imprimen en el tablero
    private ActionListener listener; //listener para poder desarrollarlo en la clase juego en lugar de tablero
     
    public Tablero(Matriz matrz, ActionListener l){
        super("Damas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(590,700);
        setVisible(true);
        Container contenedor = getContentPane();
        setIconImage(new ImageIcon("iconos/icon_damas.png").getImage());
         this.setLocationRelativeTo(null);
        listener=l;
        matriz=matrz.getMatriz();

        // Inicializando Paneles:
        ImageIcon InfoImg = new ImageIcon("iconos/Info.png");
        this.info = new JButton();
        info.setIcon(InfoImg);
        info.setToolTipText("Reglas del Juego");
        info.setBorder(new LineBorder(Color.WHITE, 1));
        info.addActionListener(l);
        panelJuego    = new JPanel(null);
        panelSuperior = new JPanel(new FlowLayout());
        panelSuperior.setBackground(Color.black);
        panelPiezas  = new JPanel(new GridLayout(8,8));
        this.panelMS     = new JPanel(new GridLayout(2,1));
        this.panelMS.setBackground(Color.black);
        this.panelInferior = new JPanel(new BorderLayout(25,20));
        this.panelInferior.setBackground(Color.black);
        panelInferior.add(panelMS, BorderLayout.WEST);
        panelJuego.setBackground(Color.black);
        panelJuego.add(panelSuperior);
        panelJuego.add(panelPiezas);
        panelJuego.add(panelInferior);
        panelJuego.add(info);
        panelSuperior.setBounds(140, 10, 300, 32);
        panelPiezas.setBounds(85, 80, 405, 420);
        panelInferior.setBounds(85, 520, 405, 70);
        info.setBounds(10, 10, 23, 23);

        //Inicializando atributos y agregandolos a los paneles.
        //Panel Superior (Botones salir y reiniciar)
        reiniciar=new JButton("Reiniciar");
        reiniciar.setToolTipText("Reiniciar el juego a su estado inicial");
        this.retirarse = new JButton("Retirarse");
        retirarse.setToolTipText("Retirarse del Juego");
        retirarse.addActionListener(l);
        panelSuperior.add(reiniciar);
        panelSuperior.add(retirarse);
        reiniciar.addActionListener(listener);

        //Panel Tablero
        this.llenarTablero();
        //Panel Inferior (mensajes)
        //Panel MS
        turno  = new JLabel("Turno del Jugador 1 (Blancas)");
        mensaje= new JLabel("Elija la ficha a mover");
        turno.setForeground(Color.white);
        mensaje.setForeground(Color.white);
        panelMS.add(turno);
        panelMS.add(mensaje);
        
        // Panel Cronometro
        JPanel p1 = new JPanel(new GridLayout(2,1,10,10));
        JPanel p2 = new JPanel(new GridLayout(2,1,10,10));
        
        contenedor.add(panelJuego);
        this.paintComponents(getGraphics());
    }

   //------------------------------------------------------------------------------------------------------------------------------------
    private void llenarTablero(){ //se recorren mediante un for la matriz para ir agregando los
                                 //botones en el tablero ademas se agrega el action listener a cada boton
        for(int i=0;i<8;i++)
            for (int j = 0; j < 8; j++) {
                Iterador it = new Iterador(this.matriz);
                Lista l=(Lista)it.getPos(i);
                Iterador it2 = new Iterador(l);
                Campo c=(Campo)it2.getPos(j);
                panelPiezas.add(c.getBoton());
                if(!c.isVacioBlanco())
                    c.getBoton().addActionListener(listener);
            }
    }
    
    public Pieza getFicha(int x, int y ) throws IllegalArgumentException{ //permite obtener la ficha ubicada en la posicion x,y de la matriz
        if((x >= 0 && x <9) && ( y >= 0 && y < 9)){
            Iterador it = new Iterador(this.matriz);
            Lista l=(Lista)it.getPos(x);
            Iterador it2 = new Iterador(l);
            Campo c=(Campo)it2.getPos(y);
            return c.getPieza();
        }
        else throw new IllegalArgumentException(" Debe estar entre 0 y 8 los dos argumentos");
    }
    
    public JButton getReiniciar() {
        return reiniciar;
    }

    public ActionListener getListener() {
        return listener;
    }

    public JLabel getTurno() {
        return turno;
    }

    public JButton getInfo() {
        return info;
    }

    public void SetMessage(String msg){
    
        this.mensaje.setText(msg);
    }
      
    public void CambiaTurnoJLabel(){
        if(this._turno) turno.setText("Turno del Jugador 1 (Blancas)");
        else turno.setText("Turno del Jugador 2 (Negras)");
        _turno = !_turno;
    }
    
    public JButton getRetirarse() {
        return retirarse;
    }
    
}
