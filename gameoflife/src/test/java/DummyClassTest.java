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
    public void add_should_add_cell_to_field() throws Exception
    {
        PlayingField playingField = new PlayingField();
        GCell cell = new GCell();
        Position position = new Position(1,1);
        playingField.addCell(cell, position);
    }

    @Test(expected = PositionAlreadyOccupied.class)
    public void add_cell_to_occupied_position_should_throw_exception()
    {
        PlayingField playingField = new PlayingField();
        GCell cell = new GCell();
        Position position = new Position(1,1);
        playingField.addCell(cell, position);
        playingField.addCell(cell, position);

    }

    @Test
    public void construct_from_input_should_fill_field()
    {
        String pattern = "xox\nxox\nxxx\n";
        PlayingField playingField = new PlayingField(pattern);
        playingField.

    }

}
