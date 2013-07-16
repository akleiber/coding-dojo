package main.java;

public class GCell
{
    private boolean isAlive = true;

    public boolean isAlive()
    {
        return isAlive;
    }

    public void die()
    {
        isAlive = false;
    }
}
