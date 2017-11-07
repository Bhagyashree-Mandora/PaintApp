package main.java.applayer.command;

public class Save extends Command {

    public void execute() {
        drawing.save();
    }

    @Override
    public void undo() {

    }
}
