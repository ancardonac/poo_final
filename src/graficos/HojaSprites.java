
package graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author andre
 */
public class HojaSprites {
    //Variables
    private final int ancho;
    private final int alto;
    public final int[] pixeles;
    //colección de hojas de sprites
    public static HojaSprites desierto = new HojaSprites("/imagenesDesierto/desierto.png", 320,320); //solo va a haber una hoja llamada desierto
    //fin de la colección
    public HojaSprites(final String ruta, final int ancho,final int alto){
        this.ancho=ancho;
        this.alto=alto;
        pixeles=new int[ancho*alto];
        
        BufferedImage imagen;
        try {
            imagen = ImageIO.read(HojaSprites.class.getResource(ruta));
            
            imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
        } catch (IOException ex) {
            Logger.getLogger(HojaSprites.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int obtenerAncho(){
    return ancho;
    }
}
