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
public class Fila {
    
    private Lista<Ficha> listaDeFichas;
    private char etiqueta;
    
//    index es el indice de la fila del tablero
//    color es el color de las fichas de la fila
//    conFichas es un boleano que indica si es un fila con fichas o sin estas
    public Fila(int index,char color) {
        this.listaDeFichas = new Lista<Ficha>();
        this.etiqueta = ETIQUETAS.charAt(index);
        agregarFichas(index,color);
    }

    public Fila() {
        this.listaDeFichas = new Lista<Ficha>();
        for(int i=0;i<8;i++){
            Ficha ficha = new Ficha(i);
            this.listaDeFichas.agregarFinal(ficha);
        }
    }
    
    public Lista<Ficha> getListaDeFichas() {
        return listaDeFichas;
    }

    public void setListaDeFichas(Lista<Ficha> listaDeFichas) {
        this.listaDeFichas = listaDeFichas;
    }

    public char getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(char etiqueta) {
        this.etiqueta = etiqueta;
    }
    
    public void agregarFichas(int index, char color){
        if(index%2 == 0){//indice par, insertar fichas en las posiciones impares
            for(int i=0;i<8;i++){
                if(i%2 == 0){
                    Ficha ficha = new Ficha(i);
                    this.listaDeFichas.agregarFinal(ficha);
                }else{
                    Ficha ficha = new Ficha(i,color);
                    this.listaDeFichas.agregarFinal(ficha);
                }
            }
        }else{//indice impar, insertar fichas en las posiciones pares
            for(int i=0;i<8;i++){
                if(i%2 == 0){
                    Ficha ficha = new Ficha(i,color);
                    this.listaDeFichas.agregarFinal(ficha);
                }else{
                    Ficha ficha = new Ficha(i);
                    this.listaDeFichas.agregarFinal(ficha);
                }
            }
        }
    }
    
    public void agregarNulas(){
        for(int i=0;i<8;i++){
            Ficha ficha = new Ficha(i);
            this.listaDeFichas.agregarFinal(ficha);
        }
    }
    
    public void mostrarFila(){
        Iterador it = new Iterador(getListaDeFichas());
        Nodo<Ficha> i = it.siguiente();
        System.out.print("| ");
        while(i != null){
            System.out.print(i.getDato().getColor()+" ");
            i = it.siguiente();
        }
        System.out.print("|");
    }
    
    public static final String ETIQUETAS = "ABCDEFGH";
        
}
