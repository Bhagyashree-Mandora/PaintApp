import main.java.applayer.command.DuplicateFaceFeature;
import main.java.applayer.receiver.Drawing;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Matchers.any;

public class DuplicateTest {
        DuplicateFaceFeature command = new DuplicateFaceFeature("ear");

//        @Test
//        public void verifyAddMethodIsCalledOnExecute(){
//            Drawing drawing = Mockito.mock(Drawing.class);
//            command.setDrawing(drawing);
//
//            command.execute();
//
//            Mockito.verify(drawing).add(any());
//        }

        @Test
        public void verifyRemoveMethodIsCalledOnUndo(){
            Drawing drawing = Mockito.mock(Drawing.class);
            command.setDrawing(drawing);

            command.undo();

            Mockito.verify(drawing).remove(any());
        }
    }