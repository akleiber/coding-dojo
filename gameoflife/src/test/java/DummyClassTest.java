package test.java;

import main.java.Cell;
import main.java.PlayingField;
import main.java.Position;
import org.junit.Test;

import static junit.framework.Assert.*;

public class DummyClassTest
{
    @Test
    public void cell_should_die() throws Exception
    {
        Cell gCell = new Cell();
        assertTrue(gCell.isAlive());
        gCell.die();
        assertFalse(gCell.isAlive());
    }

    @Test
    public void cell_should_be_createable_as_dead_cell()
    {
        Cell gCell = new Cell('o');
        assertFalse(gCell.isAlive());
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
        Cell gCell = new Cell();
        boolean isAlive = rules.isAliveInNextIteration(gCell, 1);
        assertFalse(isAlive);
    }

    @Test
    public void is_alive_should_return_false_for_more_than_three_living_neighbours()
    {
        DefaultRules rules = new DefaultRules();
        Cell gCell = new Cell();
        boolean isAlive = rules.isAliveInNextIteration(gCell, 4);
        assertFalse(isAlive);
    }

    @Test
    public void is_alive_should_return_true_for_two_living_neighbours()
    {
        DefaultRules rules = new DefaultRules();
        Cell gCell = new Cell();
        boolean isAlive = rules.isAliveInNextIteration(gCell, 2);
        assertTrue(isAlive);
    }

    @Test
    public void is_alive_for_dead_cell_should_return_false_for_two_living_neighbours() {
        DefaultRules rules = new DefaultRules();
        Cell gCell = new Cell('o');
        boolean isAlive = rules.isAliveInNextIteration(gCell, 2);
        assertFalse(isAlive);
    }

    @Test
    public void is_alive_for_dead_cell_should_return_true_for_three_living_neighbours() {
        DefaultRules rules = new DefaultRules();
        Cell gCell = new Cell('o');
        boolean isAlive = rules.isAliveInNextIteration(gCell, 3);
        assertTrue(isAlive);
    }

    @Test
    public void is_alive_should_return_true_for_three_living_neighbours()
    {
        DefaultRules rules = new DefaultRules();
        Cell gCell = new Cell();
        boolean isAlive = rules.isAliveInNextIteration(gCell, 3);
        assertTrue(isAlive);
    }

    @Test
    public void get_amount_of_living_neighbours_should_return_4()
    {
        PlayingField playingField = new PlayingField("oxo\nxxx\noxo");
        Position position = new Position(1, 1);
        int amount = playingField.getAmountOfLivingNeighbours(position);

        assertEquals(4, amount);
    }

    @Test
    public void get_amount_of_living_neighbours_should_return_3()
    {
        PlayingField playingField = new PlayingField("ooo\nxxx\noxo");
        Position position = new Position(1, 1);
        int amount = playingField.getAmountOfLivingNeighbours(position);

        assertEquals(3, amount);
    }

    @Test
    public void get_amount_of_living_neighbours_should_return_2()
    {
        PlayingField playingField = new PlayingField("ooo\nxxx\noxo");
        Position position = new Position(0, 0);
        int amount = playingField.getAmountOfLivingNeighbours(position);

        assertEquals(2, amount);
    }

    @Test
    public void iterate()
    {
        PlayingField playingField = new PlayingField("ooo\nxxx\noxo");
        PlayingField nextGeneration = playingField.evolve();
        assertEquals("oxo\nxxx\nxxx", nextGeneration.toString());
    }
}
