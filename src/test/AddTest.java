import main.java.applayer.command.AddFaceFeature;
import main.java.applayer.receiver.Drawing;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import javax.swing.*;

import static org.mockito.Matchers.any;

public class AddTest {

    AddFaceFeature command = new AddFaceFeature("ear");

//    @Test
//    public void test(){
//        command.setDrawing(new Drawing(new JPanel()));
//
//        command.execute();
//
//        Assert.assertNotNull(command.getFaceFeature());
//    }
//
//    @Test
//    public void verifyAddMethodIsCalledOnExecute(){
//        Drawing drawing = Mockito.mock(Drawing.class);
//        command.setDrawing(drawing);
//
//        command.execute();
//
//        Mockito.verify(drawing).add(any());
//    }

    @Test
    public void verifyRemoveMethodIsCalledOnUndo(){
        Drawing drawing = Mockito.mock(Drawing.class);
        command.setDrawing(drawing);

        command.undo();

        Mockito.verify(drawing).remove(any());
    }
}
