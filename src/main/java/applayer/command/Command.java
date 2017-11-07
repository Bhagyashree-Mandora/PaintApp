package main.java.applayer.command;

import main.java.applayer.receiver.Drawing;

public abstract class Command {
    protected Drawing drawing;

    public void execute(){}

    public void setDrawing(Drawing drawing){
        this.drawing = drawing;
    }

    public abstract void undo();
}