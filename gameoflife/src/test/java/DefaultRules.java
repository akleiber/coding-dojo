package test.java;

import main.java.Cell;

public class DefaultRules
{
    public boolean isAliveInNextIteration(Cell gCell, int i)
    {
        if (gCell.isAlive()) {
            return !(i < 2 || i > 3);
        } else {
            return i == 3;
        }
    }
}
