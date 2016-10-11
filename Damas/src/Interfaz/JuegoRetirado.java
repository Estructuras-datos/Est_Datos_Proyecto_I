

package Interfaz;

import Juego.Jugador;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @authors Denis Rodriguez, Sergio Vega
 */

public class JuegoRetirado extends JFrame implements ActionListener {
   
    JLabel jugadorRetirado, gameOver, mensaje1, mensaje2, ganador;
    JButton JugarNuevo, Salir;
        
    public JuegoRetirado(Jugador _ganador, int fichasJ1, int fichasJ2){
        super("Juego Retirado");
        this.setSize(900,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        ((JPanel)getContentPane()).setOpaque(false);
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon("iconos/icon_damas.png").getImage());
        ImageIcon uno=new ImageIcon("iconos/Fondo21.jpeg");
        JLabel fondo= new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0,0,900,600);
        String fichasGanador;
        if(_ganador.getNum()=="1"){
            fichasGanador="Jugador fichas Blancas";
        }
        else fichasGanador="Jugador fichas Negras";
        
        this.jugadorRetirado = new JLabel("Juego Retirado por "+fichasGanador);
        jugadorRetirado.setFont(new Font(jugadorRetirado.getFont().getName(),Font.BOLD|Font.ITALIC,25));
        jugadorRetirado.setBounds(80,170, 600,100);
        jugadorRetirado.setForeground(Color.WHITE);
        add(jugadorRetirado);
        
        this.mensaje1 = new JLabel("Fichas restantes del Jugador fichas blancas: "+fichasJ1);
        mensaje1.setFont(new Font(mensaje1.getFont().getName(),Font.BOLD|Font.ITALIC,18));
        mensaje1.setBounds(80,215, 500,100);
        mensaje1.setForeground(Color.WHITE);
        add(mensaje1);
        
        this.mensaje2 = new JLabel("Fichas restantes del Jugador fichas negras: "+fichasJ2);
        mensaje2.setFont(new Font(mensaje2.getFont().getName(),Font.BOLD|Font.ITALIC,18));
        mensaje2.setBounds(80,235, 500,100);
        mensaje2.setForeground(Color.WHITE);
        add(mensaje2);
        
        String Ganador;
        if(fichasJ1>fichasJ2){
            Ganador="El jugador de fichas blancas es el Ganador!";
        }
        else if(fichasJ2>fichasJ1){
            Ganador="El jugador de fichas negras es el Ganador!";
        }
        else{
            Ganador="Hubo un empate!";
        }
        
        this.ganador = new JLabel(Ganador);
        ganador.setFont(new Font(ganador.getFont().getName(),Font.BOLD|Font.ITALIC,18));
        ganador.setBounds(80,275, 500,100);
        ganador.setForeground(Color.WHITE);
        add(ganador);
        
        
        this.gameOver = new JLabel();
        ImageIcon _img = new ImageIcon("iconos/GameOver.png");
        gameOver.setIcon(_img);
        gameOver.setBounds(60,20,700,100);
        add(gameOver);
        this.JugarNuevo = new JButton("Jugar de Nuevo");
        JugarNuevo.setBounds(620,190,140,30);
        JugarNuevo.setBackground(Color.WHITE);
        add(JugarNuevo);
        JugarNuevo.addActionListener(this);
        this.Salir = new JButton("Salir");
        Salir.setBounds(620,250,140,30);
        Salir.setBackground(Color.WHITE);
        add(Salir);
        Salir.addActionListener(this);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == JugarNuevo){
            this.dispose();
            Juego.Juego ob = new Juego.Juego();
        }
        else if(ae.getSource() == Salir){
            this.dispose();
        }
    }
}
