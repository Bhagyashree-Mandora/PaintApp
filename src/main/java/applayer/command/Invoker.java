package main.java.applayer.command;

import java.util.ArrayList;
import java.util.List;


public class Invoker {
    private List<Command> history = new ArrayList<>();

    public void enqueueAndExecuteCommand(Command command) {
        history.add(command);
        command.execute();
    }

    public void undo() {
        if(!history.isEmpty()) {
            history.get(history.size()-1).undo();
            history.remove(history.size()-1);
        }
    }
}