package test;

import main.usu.swingpaint.applayer.command.AddFaceFeature;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

class AddFaceFeatureTest {

    AddFaceFeature command;

    @Before
    public void setup() {
//        command = new AddFaceFeature();
    }

    @Test
    public void t(){
        command = new AddFaceFeature("ear");

        command.execute();

        Assert.assertNotNull(command.getFaceFeature());
    }

}
