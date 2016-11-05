package main.usu.swingpaint.applayer.facefeature;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class FaceFeatureWithIntrinsicState extends FaceFeature {

    private static final String IMAGES_PATH = "/images/";

    BufferedImage image;

    public void loadImage(String featureType) {
        BufferedImage loadedImage = null;
        try {
            loadedImage = ImageIO.read(this.getClass().getResource(IMAGES_PATH + featureType));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.image = loadedImage;
    }

    public BufferedImage getImage() {
        return image;
    }
}