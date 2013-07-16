package test.java;

import main.java.GCell;
import main.java.PlayingField;
import main.java.Position;
import main.java.PositionAlreadyOccupied;
import org.junit.Test;

import static junit.framework.Assert.*;

public class DummyClassTest
{
    @Test
    public void cell_should_die() throws Exception
    {
        GCell gCell = new GCell();
        assertTrue(gCell.isAlive());
        gCell.die();
        assertFalse(gCell.isAlive());
    }

    @Test
    public void construct_from_input_should_fill_field()
    {
        String pattern = "xox\nxox\nxxx\n";
        PlayingField playingField = new PlayingField(pattern);

    }

    @Test
    public void tostring_should_return_current_evolution()
    {
        String pattern = "oxo\nxxx\noxo";
        PlayingField playingField = new PlayingField(pattern);
        assertEquals(pattern, playingField.toString());
    }

    @Test
    public void evolution_irgendwas()
    {
        String pattern = "ooo\nooo\nxxx";
        PlayingField playingField = new PlayingField(pattern);
        playingField.next();
        assertEquals("ooo\noxo\noxo", playingField.toString());
    }
}
