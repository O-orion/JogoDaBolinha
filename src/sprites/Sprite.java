package sprites;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Sprite {

    private BufferedImage spriteSheet;

    public Sprite(String path){

        try {
            spriteSheet = ImageIO.read(getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public  BufferedImage getSprite(int x, int y, int largura, int altura){
        return  spriteSheet.getSubimage(x,y,largura,altura);

    }

}
