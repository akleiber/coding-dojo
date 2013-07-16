package test.java;

import main.java.GCell;
import main.java.PlayingField;
import main.java.Position;
import org.junit.Test;

import java.util.List;

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
    public void cell_should_be_createable_as_dead_cell()
    {
        GCell gCell = new GCell(false);
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
    public void is_alive_should_return_false_for_one_living_neighbours()
    {
        DefaultRules rules = new DefaultRules();
        GCell gCell = new GCell();
        boolean isAlive = rules.isAliveInNextIteration(gCell, 1);
        assertFalse(isAlive);
    }

    @Test
    public void is_alive_should_return_false_for_more_than_three_living_neighbours()
    {
        DefaultRules rules = new DefaultRules();
        GCell gCell = new GCell();
        boolean isAlive = rules.isAliveInNextIteration(gCell, 4);
        assertFalse(isAlive);
    }

    @Test
    public void is_alive_should_return_true_for_two_living_neighbours()
    {
        DefaultRules rules = new DefaultRules();
        GCell gCell = new GCell();
        boolean isAlive = rules.isAliveInNextIteration(gCell, 2);
        assertTrue(isAlive);
    }

    @Test
    public void is_alive_for_dead_cell_should_return_false_for_two_living_neighbours() {
        DefaultRules rules = new DefaultRules();
        GCell gCell = new GCell(false);
        boolean isAlive = rules.isAliveInNextIteration(gCell, 2);
        assertFalse(isAlive);
    }

    @Test
    public void is_alive_for_dead_cell_should_return_true_for_three_living_neighbours() {
        DefaultRules rules = new DefaultRules();
        GCell gCell = new GCell(false);
        boolean isAlive = rules.isAliveInNextIteration(gCell, 3);
        assertTrue(isAlive);
    }

    @Test
    public void is_alive_should_return_true_for_three_living_neighbours()
    {
        DefaultRules rules = new DefaultRules();
        GCell gCell = new GCell();
        boolean isAlive = rules.isAliveInNextIteration(gCell, 3);
        assertTrue(isAlive);
    }

    @Test
    public void playing_field_should_return_living_neighbours()
    {
        PlayingField playingField = new PlayingField("oxo\nxxx\noxo");
        Position position = new Position(1, 1);
        List<GCell> cellist = playingField.getLivingNeighbours(position);

        assertNotNull(cellist);
        assertEquals(4, cellist.size());
    }



}
