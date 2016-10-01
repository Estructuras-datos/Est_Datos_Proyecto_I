package Juego;
import Piezas.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*La clase matriz contiene los campos del tablero de juego.
  Tiene las piezas de ajedrez como atributos, las cuales son inicializadas en un metodo dentro de la misma
  Luego de ser inicializadas, las piezas se ingresan en la matriz

*/

public class Matriz{
    
    private Campo [][] matriz; //matriz de campos, incluye tanto los espacios vacios como las piezas de ajedrez
    
    public Matriz() {
        
        matriz=new Campo[8][8];
        inicializarPiezas();
        
    }
    
    
    private void inicializarPiezas(){
        
        
        matriz[0][0]=new Campo(new Ficha('b','n'),0,0,'n');
        matriz[0][1]=new Campo(new Ficha('b','b'),1,0,'b');
        matriz[0][2]=new Campo(new Ficha('b','n'),2,0,'n');
        matriz[0][3]=new Campo(new Ficha('b','b'),3,0,'b');
        matriz[0][4]=new Campo(new Ficha('b','n'),4,0,'n');
        matriz[0][5]=new Campo(new Ficha('b','b'),5,0,'b');
        matriz[0][6]=new Campo(new Ficha('b','n'),6,0,'n');
        matriz[0][7]=new Campo(new Ficha('b','b'),7,0,'b');
        
        matriz[1][0]=new Campo(new Ficha('b','b'),0,1,'b');
        matriz[1][1]=new Campo(new Ficha('b','n'),1,1,'n');
        matriz[1][2]=new Campo(new Ficha('b','b'),2,1,'b');
        matriz[1][3]=new Campo(new Ficha('b','n'),3,1,'n');
        matriz[1][4]=new Campo(new Ficha('b','b'),4,1,'b');
        matriz[1][5]=new Campo(new Ficha('b','n'),5,1,'n');
        matriz[1][6]=new Campo(new Ficha('b','b'),6,1,'b');
        matriz[1][7]=new Campo(new Ficha('b','n'),7,1,'n');
        
        
        
        //Fichas sin pieza del centro del tablero
        for(int i=2;i<6;i++){
            for(int j=0;j<8;j++){
                if((i & 1) == 0 && (j & 1) == 0){
                    matriz[i][j]=new Campo(new Vacio('n'),j,i,'n');
                }
                else{
                    if((i & 1) != 0 && (j & 1) != 0){
                        matriz[i][j]=new Campo(new Vacio('n'),j,i,'n');
                    }
                    
                    else{
                        matriz[i][j]=new Campo(new Vacio('b'),j,i,'b');
                    }
                }
                
            }
        }
        
        
        matriz[7][0]=new Campo(new Ficha('n','b'),0,7,'b');
        matriz[7][1]=new Campo(new Ficha('n','n'),1,7,'n');
        matriz[7][2]=new Campo(new Ficha('n','b'),2,7,'b');
        matriz[7][3]=new Campo(new Ficha('n','n'),3,7,'n');
        matriz[7][4]=new Campo(new Ficha('n','b'),4,7,'b');
        matriz[7][5]=new Campo(new Ficha('n','n'),5,7,'n');
        matriz[7][6]=new Campo(new Ficha('n','b'),6,7,'b');
        matriz[7][7]=new Campo(new Ficha('n','n'),7,7,'n');
        
        matriz[6][0]=new Campo(new Ficha('n','n'),0,6,'n');
        matriz[6][1]=new Campo(new Ficha('n','b'),1,6,'b');
        matriz[6][2]=new Campo(new Ficha('n','n'),2,6,'n');
        matriz[6][3]=new Campo(new Ficha('n','b'),3,6,'b');
        matriz[6][4]=new Campo(new Ficha('n','n'),4,6,'n');
        matriz[6][5]=new Campo(new Ficha('n','b'),5,6,'b');
        matriz[6][6]=new Campo(new Ficha('n','n'),6,6,'n');
        matriz[6][7]=new Campo(new Ficha('n','b'),7,6,'b');
    
    }
    
    
    public Campo[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(Campo[][] matriz) {
        this.matriz = matriz;
    }

    
    public Campo getCampo(int x, int y){
    
        return this.matriz[y][x];
    
    }
    
    
}
