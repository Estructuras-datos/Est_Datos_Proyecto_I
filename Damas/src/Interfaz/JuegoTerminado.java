

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

/*
    Esta clase es una ventana, que se muestra cuando un jugador mate al rey,
    En ese momento se mostrara dando la opcion de reiniciar o salir del juego
    Ademas muestra el nombre del jugador que gano y el tiempo que tardo
*/
public class JuegoTerminado extends JFrame implements ActionListener {
   
    JLabel ganador, msg;
    JButton JugarNuevo, Salir;
    
    
    public JuegoTerminado(Jugador _ganador){
     
        super("Juego Ajedrez");
        
        this.setSize(900,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        ((JPanel)getContentPane()).setOpaque(false);
        this.setLocationRelativeTo(null);
        
        
        setIconImage(new ImageIcon("iconos/icon_damas.png").getImage());
        ImageIcon uno=new ImageIcon("iconos/Fondo2.jpeg");
               
        JLabel fondo= new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0,0,900,600);
        
        String fichasGanador;
        if(_ganador.getNum()=="1"){
            fichasGanador="Fichas Blancas";
        }
        else fichasGanador="Fichas Negras";
        
        this.ganador = new JLabel("Ganador  "+fichasGanador);
        ganador.setFont(new Font(ganador.getFont().getName(),Font.BOLD|Font.ITALIC,35));
        ganador.setBounds(80,170, 500,50);
        ganador.setForeground(Color.WHITE);
        add(ganador);
        
       
        this.msg     = new JLabel();
        ImageIcon _img = new ImageIcon("iconos/GameOver.png");
        msg.setIcon(_img);
        msg.setBounds(60,20,700,100);
        add(msg);
        
        this.JugarNuevo = new JButton("Jugar de Nuevo");
        JugarNuevo.setBounds(570,190,150,30);
        JugarNuevo.setBackground(Color.WHITE);
        add(JugarNuevo);
        JugarNuevo.addActionListener(this);
        
        this.Salir = new JButton("Salir");
        Salir.setBounds(570,250,150,30);
        Salir.setBackground(Color.WHITE);
        add(Salir);
        Salir.addActionListener(this);
       
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    
        if(ae.getSource() == JugarNuevo){
        
            Juego.Juego ob = new Juego.Juego();
            this.dispose();
        }
        
        else if(ae.getSource() == Salir){
            this.dispose();
        }
    }
    
    public void Empate(){
    
        this.ganador.setText("Empate");
        this.ganador.setFont(new Font(ganador.getFont().getName(), ganador.getFont().getStyle(),70));
        this.ganador.setBounds(ganador.getX(), ganador.getY()+20, 300, 80);
    
    }
}
