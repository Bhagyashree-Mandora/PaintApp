package main.java.applayer.command;

import main.java.applayer.facefeature.FaceFeature;
import main.java.applayer.facefeature.FaceFeatureExtrinsicState;
import main.java.applayer.facefeature.FaceFeatureFactory;

import java.awt.*;

public class DuplicateFaceFeature extends Command {

    private String faceFeatureType;
    private FaceFeature faceFeature;

    public DuplicateFaceFeature(String type) {
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
}