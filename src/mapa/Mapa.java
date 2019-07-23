/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa;

import graficos.Pantalla;
import mapa.cuadro.Cuadro;

/**
 *
 * @author diana
 */
public abstract class Mapa { //no se puede instanciar mapa 
    protected int ancho;
    protected int alto; //alto y ancho del mapa
    
    protected int[]cuadros; // Tiles es un recuadro y cada tile contiene un sprite
    //dos tipos de mapas, los que se generan aleatoriamente y los por defecto
    public Mapa(int ancho, int alto){
        this.ancho=ancho;
        this.alto=alto;
        cuadros=new int [ancho*alto];
        generarMapa();
    }
    public Mapa(String ruta){
        cargarMapa(ruta);
    }
    protected void generarMapa(){
        
    }
    private void cargarMapa(String ruta){
        
    }
    public void actualizar(){
        
    }
    public void mostrar (int compensacionX, int compensacionY, Pantalla pantalla){
        int o = compensacionX>>5;//compensacionX/32; moverse a nivel de pixel y no de tiles
        int e = (compensacionX +pantalla.obtenAncho())>>5;
        int n = compensacionY>>5;
        int s = (compensacionY + pantalla.obtenAlto())>>5;
        for(int y=n; y<s; y++){
            for(int x=o;x<e;x++){
                obtenCuadro(x,y).mostrar(x,y,pantalla);
            }
        }
    }
    public Cuadro obtenCuadro(final int x, final int y){ //buscar en el array una posicion 
        switch(cuadros[x+y*ancho]){
            case 0:
                return Cuadro.ASFALTO;
            
            default:
                return Cuadro.VACIO;
        }
    }
}
