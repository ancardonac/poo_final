

package graficos;

import mapa.cuadro.Cuadro;

/**
 *
 * @author diana
 */
public class Pantalla {
    //Variables
    private int ancho;
    private int alto;
    
    private int diferenciaX;
    private int diferenciaY;
    public final int[] pixeles; //Array de pixeles para mostrar en pantalla
    //Variables temporales
    private final static int LADO_SPRITE = 32;
    private final static int MASCARA_SPRITE = LADO_SPRITE - 1;
    //Fin variable temporal
    //constructor de la pantalla
    public Pantalla(final int ancho, final int alto ){ 
        this.ancho =ancho;
        this.alto=alto;
        pixeles= new int [ancho*alto]; //Definicion del area de la imagen
    }
     //Se va a limpiar lo que habia antes y limpiar lo que estaba con la excepcion de negro
    //Metodo limpiar
    public void limpiar(){ //limpia todos los pixeles (en negro)
        for (int i = 0; i < pixeles.length; i++) {
            pixeles[i]=0;  //0 es el color negro en la pantalla en Hexadecimal
        }
    }
    //metodo mostrar TEMPORAL
    public void mostrar (final int compensacionX, final int compensacionY){ //movimiento con wasd en la pantalla
        //Se debe hacer un doble bucle for anidado para dibujar las x y las y de la pantalla
        
        //Bucle para y
        for (int y = 0; y < alto; y++) {
            int posicionY= y + compensacionY;  //calcular posicion en y exacta en la pantalla
            if (posicionY < 0 ||posicionY>=alto){ //al llegar a ese punto, se sale del bucle for (no salir de la pantalla en Y)
                continue;
            }
            //Bucle para x
            for (int x = 0; x < ancho; x++) {
                int posicionX= x + compensacionX; //calcular posicion exacta en x de la pantalla
                if (posicionX < 0 ||posicionX>=ancho){ //al llegar a ese punto, se sale del bucle for (no salir de la pantalla en X)
                    continue;
                    //Temporal
                } 
                    pixeles[posicionX + posicionY*ancho] = Sprite.ASFALTO.pixeles[(x & MASCARA_SPRITE) + (y & MASCARA_SPRITE) *LADO_SPRITE];  //coordenada de dos ejes con un array de una dimension
            }
        }
    }
    //Fin temporal
    public void mostrarCuadro(int compensacionX, int compensacionY, Cuadro cuadro){
        compensacionX -= diferenciaX;
        compensacionY -= diferenciaY;
        for(int y=0; y<cuadro.sprite.obtentenLado();y++){
            int posicionY = y+compensacionY;
            for (int x=0; x<cuadro.sprite.obtentenLado();x++){
                int posicionX=x+compensacionX;
                if(posicionX < 0|| posicionX > ancho || posicionY < 0 || posicionY > alto){
                break;
                }
                pixeles[posicionX+posicionY*ancho]=cuadro.sprite.pixeles[x+y*cuadro.sprite.obtentenLado()];
            } 
        }
    }
    public void estableceDiferencia(final int diferenciaX, final int diferenciaY){
       this.diferenciaX=diferenciaX;
       this.diferenciaY=diferenciaY;
    }
    public int obtenAncho(){
        return ancho;
    }
    public int obtenAlto(){
        return alto;
    }
}
