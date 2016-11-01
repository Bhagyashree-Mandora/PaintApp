package main.usu.swingpaint;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Ear implements FaceFeature{
    private static final String IMAGES_PATH = "/images/";
    private static final String FILE_NAME = "ear.jpg";


    public BufferedImage add() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(this.getClass().getResource(IMAGES_PATH + FILE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
