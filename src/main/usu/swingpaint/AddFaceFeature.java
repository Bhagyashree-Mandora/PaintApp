package main.usu.swingpaint;

import java.awt.image.BufferedImage;

public class AddFaceFeature implements Command {

    FaceFeature faceFeature;

    public AddFaceFeature(FaceFeature faceFeature) {
        this.faceFeature = faceFeature;
    }

    @Override
    public BufferedImage execute() {
        return faceFeature.add();
    }
}