import main.java.applayer.command.Load;
import main.java.applayer.receiver.Drawing;
import org.junit.Test;
import org.mockito.Mockito;

public class LoadTest {
        Load command = new Load();

        @Test
        public void verifyLoadMethodIsCalledOnExecute(){
            Drawing drawing = Mockito.mock(Drawing.class);
            command.setDrawing(drawing);

            command.execute();

            Mockito.verify(drawing).load();
        }
}
