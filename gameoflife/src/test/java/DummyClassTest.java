package test.java;

import junit.framework.Assert;
import org.junit.Test;

public class DummyClassTest
{
    @Test
    public void cellShouldDieWithMoreThanThreeNeighbours()
    {
        String s = "You must die! I alone am best!";
        Assert.assertEquals("testmessage", "Hooray for Boobies", s);
    }
}
