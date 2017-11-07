package main.java.applayer.facefeature;

import java.awt.*;
import java.awt.image.ImageObserver;

public class FaceFeatureWithAllStates extends FaceFeature implements ImageObserver {
    private final FaceFeatureWithIntrinsicState intrinsicState;
    private final FaceFeatureExtrinsicState extrinsicState;

    public String getFeatureType(){
        return extrinsicState.getFeatureType();
    }

    public FaceFeatureWithAllStates(FaceFeatureWithIntrinsicState intrinsicState, FaceFeatureExtrinsicState extrinsicState) {
        super();

        this.intrinsicState = intrinsicState;
        this.extrinsicState = extrinsicState;
        setLayout(null);
        setBackground(Color.black);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        int x,y;
        Graphics2D graphics2D = (Graphics2D) graphics;
        x = (int) extrinsicState.getLocation().getX();
        y = (int) extrinsicState.getLocation().getY();
        graphics2D.clearRect(0, 0, getWidth(), getHeight());
        if (intrinsicState.getImage() != null) {
            graphics2D.drawImage(intrinsicState.getImage(), 0, 0, getWidth(), getHeight(), this);
        } else {
            graphics2D.setColor(getBackground());
            graphics2D.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    public boolean imageUpdate(Image img, int infoFlags,
                               int x, int y, int w, int h) {
        if (infoFlags == ALLBITS) {
            repaint();
            return false;
        }
        return true;
    }

    public FaceFeatureExtrinsicState getExtrinsicState() {
        return extrinsicState;
    }
}