
package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
    La clase Reglas es una clase dedicada para crear una ventana que aparecera al 
    presionar el boton de reglas en la pantalla de bienvenida del programa.

*/

public class Reglas extends JFrame implements ActionListener{
    private JTextArea texto; //En este Jtextarea se incluye el texto a mostrar en la ventana
    private JButton botonSalir; //Este boton es una alternativa al boton de cierre de ventana
    
    public Reglas(){
        super("Reglas Damas");
        this.setSize(770,430);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        setIconImage(new ImageIcon("iconos/icon_damas.png").getImage());
         this.setLocationRelativeTo(null);
        
        String text=" Reglas:\n"
                + "  \n\n- Se emplea un tablero de 8 filas por 8 columnas y 64 fichas idénticas, redondeadas, blancas y negras.  Juegan dos contendores, uno lleva las de color blanco y el otro las de color negro."
                + "  \n\n- Las damas es un juego de mesa para dos contrincantes.  El juego consiste en mover las piezas en diagonal (un espacio) en un tablero de 64 cuadros con la intención de capturar (comer) las piezas del contrario saltando por encima de ellas (dos espacios)."
                + "  \n\n- Las damas es un juego para dos personas en un tablero de 64 casillas de 8 x 8 celdas. El tablero se coloca de manera que cada jugador tenga una casilla blanca en su parte inferior derecha."
                + "  \n\n- Cada jugador dispone de 12 piezas de un mismo color (blanco o negro) que al principio de la partida se colocan en las casillas negras de las tres filas más próximas a él."
                + "  \n\n- El objetivo del juego de damas es capturar las fichas del oponente o acorralarlas para que los únicos movimientos que puedan realizar sean los que lleven a su captura."
                + "  \n\n- Se juega por turnos alternos. Empieza el juego quien tiene las fichas más claras o blancas. En su turno cada jugador mueve una pieza propia."
                + "  \n\n- El jugador solo puede mover una pieza en su turno. Cada pieza se mueve (cuando no comen) una posición hacia adelante (nunca hacia atrás) diagonalmente a la derecha o a la izquierda, a una posición adyacente y vacía."
                + "  \n\n- Captura de una pieza oponente. Cuando existe la posibilidad de capturar una pieza del oponente, hay que hacerlo obligatoriamente.  Por ejemplo: Cuando una pieza blanca normal, tiene la posibilidad de capturar a una pieza negra, quiere decir que esta pieza negra, se encuentra adelante, inmediatamente adyacente y diagonal (a la izquierda o derecha) de la pieza blanca. La captura se realiza pasando la pieza blanca por encima de la negra, es decir saltándola y depositándola en el siguiente espacio vacío.  Si el espacio (después de la posición de la pieza negra) no está vacío, no se puede realizar dicha captura." +
                    "\n\n- Cuando un jugador hace llegar una de sus fichas al final del tablero, entonces puede cambiarla por una reina.\n" +
                    "\n\n- La reina es una pieza muy importante y es la que tiene mayor prioridad para capturar una pieza del oponente, es decir, si existe una reina y está en su turno, entonces esta debe capturar obligatoriamente una o varias piezas de su oponente, en caso de que se pueda.  Aquí se nota que la reina puede capturar secuencialmente las piezas No1, No.2 y No 3. en una sola jugada.\n" +
                    "\n\n- Acordarse que la reina siempre tiene prioridad para comer antes que cualquiera otra ficha. Además, en su turno, una pieza normal puede capturar a la reina oponente, si se diera el caso. \n" +
                    "\n\n- La reina puede desplazarse o moverse, los cuadros que desee sobre las diagonales en las  que se encuentre, puede hacerlo, tanto para adelante como para atrás, siempre y cuando no salte por encima de alguna(s) de sus compañeras. Además, se pueden tener varias reinas en la partida.  La reina no puede capturar o pasar por encima de dos o más piezas consecutivas de igual o diferente color.\n" +
                    "\n\n- Final del juego o partida. Una partida de damas finaliza cuando estamos en una de estas 4 situaciones:\n" +
                    "a) Pierde quien se queda sin piezas sobre el tablero.\n" +
                    "b) Pierde también, si cuando llega el turno de un jugador, éste no puede moverse, puesto que todas sus piezas están bloqueadas.\n" +
                    "c) Gana quien más piezas tenga, a igual número de piezas gana quién más reinas tenga, y si en esto también se empata la partida termina en tablas.\n" +  
                    "d) El jugador que tenga muy pocas piezas puede retirarse del juego.\n" +
                    "\n\n- ";
        
        
        texto=new JTextArea(text, 25, 55);
        JScrollPane scroll=new JScrollPane(texto);
        botonSalir=new JButton("Salir");
        texto.setEditable(false);
        
        this.setLayout(null);
        this.add(scroll);
        this.add(botonSalir);
        
        
        scroll.setBounds(30, 10, 700, 300);
        botonSalir.setBounds(300, 330, 100, 40);
        
        texto.setSize(800, 400);
        botonSalir.addActionListener(this);
        texto.setLineWrap(true);
        texto.setWrapStyleWord(true);
        
    }

    
    public void actionPerformed(ActionEvent ae) {
        
        this.dispose();
        
    }
    
}
