/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @authors Denis Rodriguez, Sergio Vega
 */
public class Lista<T> {
    
    private Nodo inicio;
    private Nodo fin;
    private int tamanio;

    public Lista() {
        inicio = fin = null;
        this.tamanio = 0;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public Nodo getFin() {
        return fin;
    }

    public int getTamanio() {
        return tamanio;
    }
    
    public boolean esVacia(){
        return (inicio == null);
    }
    
    public void agregarFinal(T dato){
        Nodo<T> nuevo = new Nodo<T>(dato);
        if(esVacia()){
            inicio = fin = nuevo;
            tamanio++;
        }else{
            fin.setSiguiente(nuevo);
            nuevo.setAnterior(fin);
            fin = nuevo;
            tamanio++;
        }
    }
    
        
    public void imprimir(){
        Nodo aux = inicio;
        while(aux != null){
            System.out.print(aux.getDato() + "->");
            aux = aux.getSiguiente();
        }
        System.out.println();
    }
}

