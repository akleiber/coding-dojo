package test.java;

import main.java.GCell;

public class DefaultRules
{
    public boolean isAliveInNextIteration(GCell gCell, int i)
    {
        if (gCell.isAlive()) {
            return !(i < 2 || i > 3);
        } else {
            return i == 3;
        }
    }
}
