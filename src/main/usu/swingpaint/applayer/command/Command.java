package main.usu.swingpaint.applayer.command;

import main.usu.swingpaint.applayer.receiver.Drawing;

public abstract class Command {
    protected Drawing drawing;

    public void execute(){}

    void setDrawing(Drawing drawing){
        this.drawing = drawing;
    }

    public abstract void undo();
}