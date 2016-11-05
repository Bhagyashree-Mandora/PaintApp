package main.usu.swingpaint.applayer.command;

import main.usu.swingpaint.applayer.facefeature.FaceFeatureExtrinsicState;
import main.usu.swingpaint.applayer.facefeature.FaceFeatureFactory;
import main.usu.swingpaint.applayer.facefeature.FaceFeature;

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
        faceFeature = FaceFeatureFactory.create(extrinsicState);
        drawing.add(faceFeature);
    }

    @Override
    public void undo() {
        drawing.remove(faceFeature);
    }
}