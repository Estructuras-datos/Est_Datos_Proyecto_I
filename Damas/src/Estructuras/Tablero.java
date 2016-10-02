/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @authos Denis Rodriguez, Sergio Vega
 */

public class Tablero {
    private Lista<Fila> matriz;

    public Tablero() {
        this.matriz = new Lista<Fila>();
        inicializarTablero();
    }
    
    private void inicializarTablero(){
        for(int i=0;i<8;i++){
            if(i<3){ //fichas del jugador negro
                Fila fi = new Fila(i,'N');
                this.matriz.agregarFinal(fi);
            }else if(i>4){ //fichas del jugador blanco
                Fila fi = new Fila(i,'B');
                this.matriz.agregarFinal(fi);
            }else{ //fichas vacias
                Fila fi = new Fila();
                this.matriz.agregarFinal(fi);
            }
        }
    }
    
    public Lista<Fila> getMatriz() {
        return matriz;
    }

    public void setMatriz(Lista<Fila> matriz) {
        this.matriz = matriz;
    }
    
    public void mostrarMatriz(){
        Iterador it = new Iterador(getMatriz());
        Nodo<Fila> i = it.siguiente();
        while(i != null){
            i.getDato().mostrarFila();
            System.out.println();
            i = it.siguiente();
        }
    }
    
    public static final String[] CELDAS_VALIDAS = {
                            "A1","A3","A5","A7",
                            "B0","B2","B4","B6",
                            "C1","C3","C5","C7",
                            "D0","D2","D4","D6",
                            "E1","E3","E5","E7",
                            "F0","F2","F4","F6",
                            "G1","G3","G5","G7",
                            "H0","H2","H4","H6"
    };
    
}
