package main.usu.swingpaint.applayer.command;


import main.usu.swingpaint.applayer.receiver.Drawing;
import main.usu.swingpaint.applayer.facefeature.FaceFeature;
import main.usu.swingpaint.applayer.facefeature.FaceFeatureWithAllStates;

public class CommandFactory {

    private final Drawing drawing;

    public CommandFactory(Drawing drawing) {
        this.drawing = drawing;
    }

    public Command create(String commandType, Object... args) {

        Command command = null;
        switch (commandType) {
            case "add":
                command = new AddFaceFeature((String) args[0]);
                break;

            case "duplicate":
                FaceFeatureWithAllStates faceFeature = (FaceFeatureWithAllStates) args[0];
//                System.out.println(faceFeature.getLocation());
                command = new DuplicateFaceFeature(faceFeature.getFeatureType());
                break;

            case "remove":
                command = new RemoveFaceFeature((FaceFeature) args[0]);
                break;

            case "save":
                command = new Save();
                break;

            case "load":
                command = new Load();
                break;

            case "clear":
                command = new ClearAll();
                break;
        }

        if(command!= null) {
            command.setDrawing(drawing);
        }
        return command;
    }
}