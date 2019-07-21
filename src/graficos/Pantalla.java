

package graficos;

/**
 *
 * @author andre
 */
public class Pantalla {
    //Variables
    private int ancho;
    private int alto;
    public final int[] pixeles; //Array de pixeles para mostrar en pantalla
    //Variables temporales
    private final static int LADO_SPRITE = 32;
    private final static int MASCARA_SPRITE = LADO_SPRITE-1;
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
    //metodo mostrar
    public void mostrar (final int compensacionX, final int compensacionY){ //movimiento con wasd en la pantalla
        //Se debe hacer un doble bucle for anidado para dibujar las x y las y de la pantalla
        
        //Bucle para y
        for (int y = 0; y < alto; y++) {
            int posicionY= y + compensacionY;  //calcular posicion en y exacta en la pantalla
            if (posicionY < 0 ||posicionY>alto){ //al llegar a ese punto, se sale del bucle for (no salir de la pantalla en Y)
                        continue;
            }
            //Bucle para x
            for (int x = 0; x < ancho; x++) {
                int posicionX= x + compensacionX; //calcular posicion exacta en x de la pantalla
                if (posicionX < 0 ||posicionX>alto){ //al llegar a ese punto, se sale del bucle for (no salir de la pantalla en X)
                        continue;
                        //Temporal
                        pixeles[posicionX + posicionY*ancho] = Sprite.asfalto.pixeles[(x & MASCARA_SPRITE) + (y & MASCARA_SPRITE) *LADO_SPRITE];  //coordenada de dos ejes con un array de una dimension
                } 
            }

        }
    
    }
    
}
