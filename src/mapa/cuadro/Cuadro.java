/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa.cuadro;

import graficos.Pantalla;
import graficos.Sprite;

/**
 *
 * @author diana
 */
public abstract class Cuadro {
    public int x;
    public int y;
    
    public Sprite sprite;
    
    //colección de cuadros
    public static final Cuadro ASFALTO = new CuadroAsfalto(Sprite.ASFALTO);
    public static final Cuadro VACIO = new CuadroVacio(Sprite.VACIO);
    //fin de la coleccion de cuadros
    public Cuadro(Sprite sprite){
        this.sprite = sprite;
    }
    public void mostrar(int x, int y, Pantalla pantalla){
        pantalla.mostrarCuadro(x<<5, y<<5, this); //bitshifting
    }
    public boolean solido(){ //Para coalision xd
        return false;
    }
    
}
