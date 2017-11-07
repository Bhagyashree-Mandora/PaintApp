package main.java.applayer.command;

import main.java.applayer.facefeature.FaceFeature;
import main.java.applayer.facefeature.FaceFeatureFactory;
import main.java.applayer.facefeature.FaceFeatureExtrinsicState;

import java.awt.*;

public class AddFaceFeature extends Command {

    private FaceFeature faceFeature;
    private String faceFeatureType;
    public AddFaceFeature(String type) {
        this.faceFeatureType = type;
    }

    @Override
    public void execute() {
        FaceFeatureExtrinsicState extrinsicState = new FaceFeatureExtrinsicState();
        extrinsicState.setFeatureType(faceFeatureType);
        extrinsicState.setLocation(new Point(0,0));
        faceFeature = FaceFeatureFactory.create(extrinsicState);
        drawing.add(faceFeature);
    }

    @Override
    public void undo() {
        drawing.remove(faceFeature);
    }

    public FaceFeature getFaceFeature() {
        return faceFeature;
    }
}