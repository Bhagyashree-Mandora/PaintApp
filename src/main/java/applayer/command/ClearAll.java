package main.java.applayer.command;

public class ClearAll extends Command {
    public void execute() {
        drawing.clearAll();
    }

    @Override
    public void undo() {

    }
}
