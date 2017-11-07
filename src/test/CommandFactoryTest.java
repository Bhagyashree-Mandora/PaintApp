import main.java.applayer.command.*;
import main.java.applayer.facefeature.FaceFeatureWithAllStates;
import main.java.applayer.receiver.Drawing;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import javax.swing.*;

public class CommandFactoryTest {
    CommandFactory commandFactory = new CommandFactory(new Drawing(new JPanel()));

    @Test
    public void testAddCommandClassIsCreated(){
        Command c = commandFactory.create("add", "eye");

        Assert.assertTrue(c instanceof AddFaceFeature);
    }

    @Test
    public void testRemoveCommandClassIsCreated(){
        FaceFeatureWithAllStates faceFeature = Mockito.mock(FaceFeatureWithAllStates.class);
        Command c = commandFactory.create("remove", faceFeature);

        Assert.assertTrue(c instanceof RemoveFaceFeature);
    }

    @Test
    public void testSaveCommandClassIsCreated(){
        Command c = commandFactory.create("save");

        Assert.assertTrue(c instanceof Save);
    }

    @Test
    public void testLoadCommandClassIsCreated(){
        Command c = commandFactory.create("load");

        Assert.assertTrue(c instanceof Load);
    }
}
