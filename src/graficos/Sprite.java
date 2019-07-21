/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

/**
 *
 * @author andre
 */
public class Sprite {
    
    private final int lado;
    //Variables
    private int x;
    private int y;
    public int [] pixeles;
    private final HojaSprites hoja;
    //Coleccion de sprites
    public static Sprite asfalto = new Sprite(32,0,0, HojaSprites.desierto);
    //Fin de la coleccion
    
    public Sprite (final int lado, final int columna,final int fila, final HojaSprites hoja){
        this.lado=lado;
        pixeles= new int [lado*lado];
        
        this.x= columna*lado;
        this.y=fila*lado;
        this.hoja=hoja;
        
        for (int y = 0; y < lado; y++) {
            for (int x = 0; x < lado; x++) {
                
                pixeles[x+y*lado]= hoja.pixeles[(x+this.x)+ (y+this.y)*hoja.obtenerAncho()];
                
            }
            
        }
    
    
    }
    
}
