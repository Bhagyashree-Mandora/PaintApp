package main.java.applayer.command;

import main.java.applayer.facefeature.FaceFeature;

public class RemoveFaceFeature extends Command {

    private FaceFeature faceFeature;

    public RemoveFaceFeature(FaceFeature faceFeature) {
        this.faceFeature = faceFeature;
    }

    @Override
    public void execute() {
        drawing.remove(faceFeature);
    }

    @Override
    public void undo() {
        drawing.add(faceFeature);
    }
}