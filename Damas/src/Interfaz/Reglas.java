
package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        super("Reglas del Juego");
        this.setSize(770,430);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
         this.setLocationRelativeTo(null);
        
        String text=" Consideraciones Generales:\n"
                + "  \n\n- Los jugadores mueven, alternadamente, una de sus piezas, a excepción del caso del enroque en que se mueven dos, como se explicará más adelante."
                + "  \n\n- Empieza el jugador que tiene las blancas, lo que supone una pequeña ventaja: se ha visto que el blanco consigue aproximadamente el 55% de los puntos en juego frente a un 45% del negro, en bases de datos que recopilan millones de partidas."
                + "  \n\n- Si un escaque está ocupado por una pieza propia, no se puede poner otra; en cambio, sí es posible ocupar un escaque que previamente estaba ocupado por una pieza adversaria: dicha pieza propia ocupará este escaque y la pieza adversaria se retirará del juego: este hecho se denomina capturar, comer o matar la pieza contraria por parte de la nuestra."
                + "  \n\n- Cada pieza tiene su manera de moverse, que se conserva a lo largo de toda la partida, incluyendo los movimientos especiales: captura al paso del peón y enroque."
                + "  \n\n- Las únicas piezas que pueden saltar son los caballos, o también las torres en el caso excepcional del enroque.Por saltar se entiende que una pieza pase en su movimiento por encima de otra pieza, ya sea adversaria o del mismo bando."
                + "  \n\n- No hay obligación de comer, pero sí sacar de jaque al rey, no pudiendo mover otra pieza que no involucre dicha acción."
                + "  \n\n- Con excepción de los peones, las piezas pueden moverse hacia atrás, es decir en dirección a su respectivo jugador."
                + "  \n\n- Las piezas no pueden saltar, en su movimiento, una por encima de la otra (a excepción del caballo, que puede saltar sobre otras, moviendo en ‘L’, y de la torre, en el enroque)." +
                    "\n\n- Una pieza no puede ocupar una casilla ocupada por otra pieza del mismo color, pero sí una ocupada por otra del contrario, retirándola del tablero. Esta acción se conoce como “tomar” o “capturar”, y es voluntaria, a decisión del jugador.\n" +
                    "\n\n- Las casillas a las cuales puede moverse una pieza, se dice que están controladas por ésta. Si una pieza se encuentra dentro de las casillas controladas por una pieza de color contrario, se encuentra atacada por aquélla.\n" +
                    "\n\n- El rey es la única pieza que no puede moverse o pasar por casillas controladas por piezas contrarias.";
        
        
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
