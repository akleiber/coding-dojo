package main.java;

import java.util.HashMap;
import java.util.Map;

public class PlayingField
{
    private Map<Position, main.java.GCell> cells = new HashMap<Position, main.java.GCell>();

    private String field;

    public PlayingField(String field)
    {
        this.field = field;

    }

    public String toString()
    {
        return field;
    }

    public void next()
    {
    }

    public int getAmountOfLivingNeighbours(Position position)
    {
        int amount = 0;
        String[] rows = field.split("\n");
        for (int i = position.getY() - 1; i < position.getY() + 1; i++) {
            for (int j = position.getX() - 1; j < position.getX() + 1; j++) {
                if(rows[i].charAt(j) == 'x') {
                    amount++;
                }
            }
        }
        return amount;
    }
}
