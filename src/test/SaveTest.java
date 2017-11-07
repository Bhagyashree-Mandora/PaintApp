import main.java.applayer.command.Save;
import main.java.applayer.receiver.Drawing;
import org.junit.Test;
import org.mockito.Mockito;

public class SaveTest {
        Save command = new Save();

        @Test
        public void verifySaveMethodIsCalledOnExecute(){
            Drawing drawing = Mockito.mock(Drawing.class);
            command.setDrawing(drawing);

            command.execute();

            Mockito.verify(drawing).save();
        }
}
