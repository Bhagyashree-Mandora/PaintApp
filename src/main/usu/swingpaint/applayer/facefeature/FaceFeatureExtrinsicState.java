package main.usu.swingpaint.applayer.facefeature;

import java.awt.*;

public class FaceFeatureExtrinsicState {
    Point location;
    float scale;
    String featureType;

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public String getFeatureType() {
        return featureType;
    }

    public void setFeatureType(String featureType) {
        this.featureType = featureType;
    }
}