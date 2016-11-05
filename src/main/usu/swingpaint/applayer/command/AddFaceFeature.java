package main.usu.swingpaint.applayer.command;

import main.usu.swingpaint.applayer.facefeature.FaceFeature;
import main.usu.swingpaint.applayer.facefeature.FaceFeatureExtrinsicState;
import main.usu.swingpaint.applayer.facefeature.FaceFeatureFactory;

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