/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @authors Denis Rodriguez, Sergio Vega
 */
public class Ficha {
    
    private char color;
    private boolean esReina;
    private int posicion;
    private boolean usada;

    public Ficha(int posicion) {
        this.color = '%';
        this.esReina = false;
        this.posicion = posicion;
        this.usada = false;
    }
    
    
    public Ficha(int posicion, char color) {
        this.color = color;
        this.esReina = false;
        this.posicion = posicion;
        this.usada = true;
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

    public boolean isUsada() {
        return usada;
    }

    public void setUsada(boolean usada) {
        this.usada = usada;
    }
    
    
    
}
