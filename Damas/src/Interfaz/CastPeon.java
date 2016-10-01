package Interfaz;

import Juego.Campo;
import Juego.Juego;
import Piezas.*;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*
    Esta clase es muestra una ventana en el momento en que un peon llega al borde 
    opuesto del tablero, permitiendole asi convertirse en una pieza a eleccion del usuario
*/

public class CastPeon extends JFrame implements ActionListener{
    
    private JRadioButton reina,torre,caballo,alfil; //botones que permiten informar el tipo de pieza en la que se convertira el peon
    private JButton cast; //boton que permite realizar el cambio
    private Campo from,to;
    public CastPeon(Campo from, Campo to){
        
        super("Casteo del Peon");
         setIconImage(new ImageIcon(getClass().getResource("/Imagen/corona.jpg")).getImage());
         this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //De esta forma no se pueden salir sin antes hacer el casteo
         this.setSize(280, 340);
         this.setResizable(false);
         this.setLayout(new FlowLayout());
        
         reina = new JRadioButton("Reina");
         torre = new JRadioButton("Torre");
         caballo = new JRadioButton("Caballo");
         alfil = new JRadioButton("Alfil");
         
         cast = new JButton("Cast");
         
         ImageIcon i = new ImageIcon(new ImageIcon(getClass().getResource("/Imagen/IconoCast.png")).getImage());
         
         add(new JLabel(" Seleccione La Pieza Que Desea Castear:"));
         
         JLabel img= new JLabel();
         img.setIcon(new ImageIcon(i.getImage().getScaledInstance(250, 220, Image.SCALE_DEFAULT)));
         
         add(img);
         add(reina);
         add(torre);
         add(caballo);
         add(alfil);
         add(cast);
         
         ButtonGroup b = new ButtonGroup();
         b.add(reina);
         b.add(torre);
         b.add(caballo);
         b.add(alfil);
         
         cast.addActionListener(this);
         
         setVisible(true);
         this.from = from;
         this.to = to;
         
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
    
        boolean sel = true;
        
        if(ae.getSource() == cast){
            
            if(reina.isSelected()){
            
               to.setPieza(new Reina(from.getPieza().getColor(),to.getColor()));
               from.setPieza(new Vacio(from.getColor()));
            
            }else{
               sel = false;
                JOptionPane.showMessageDialog(null,"Debe Seleccionar Un Espacio.","Error Logico",JOptionPane.ERROR_MESSAGE);
            
            }
            
            if(sel) this.dispose();
            
        }
  
        
        
    }
    
}
