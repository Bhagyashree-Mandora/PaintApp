package main.java.applayer.command;

public class Load extends Command {

    public void execute() {
        drawing.load();
    }

    @Override
    public void undo() {

    }
}
