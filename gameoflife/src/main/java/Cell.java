package main.java;

public class Cell
{
    private boolean isAlive = true;

    public Cell(char chr)
    {
        isAlive = chr == 'x';
    }

    public Cell()
    {
        this('x');
    }

    public boolean isAlive()
    {
        return isAlive;
    }

    public void die()
    {
        isAlive = false;
    }

    @Override
    public String toString()
    {
        return isAlive ? "x" : "o";
    }
}
