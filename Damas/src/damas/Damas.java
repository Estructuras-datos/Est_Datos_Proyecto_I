/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package damas;

import damas.model.Lista;

/**
 *
 * @author sheshovega
 */
public class Damas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lista<String> list = new Lista<String>();
        
        list.agregarFinal("uno");
        list.agregarFinal("dos");
        list.agregarFinal("tres");
        list.agregarFinal("cuatro");
        System.out.println(list.getTamanio());
        list.imprimir();
        
    }
    
}
