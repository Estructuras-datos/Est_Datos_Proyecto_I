/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package damas.model;

/**
 *
 * @author sheshovega
 */
public class Ficha {
    
    private char color;
    private boolean esReina;
    private int posicion;

    public Ficha(char color, boolean esReina, int posicion) {
        this.color = color;
        this.esReina = esReina;
        this.posicion = posicion;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public boolean esReina() {
        return esReina;
    }

    public void setEsReina(boolean esReina) {
        this.esReina = esReina;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
}
