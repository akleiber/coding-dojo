package main.java;

public class GCell
{
    private boolean isAlive = true;

    public GCell(boolean b)
    {
        isAlive = b;
    }

    public GCell()
    {
        this(true);
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
