package main.java;

import java.util.HashMap;
import java.util.Map;

public class PlayingField
{
    private Map<Position, GCell> cells = new HashMap<Position, GCell>();

    public void addCell(GCell cell, Position position)
    {
        if (cells.containsKey(position)) {
            throw new PositionAlreadyOccupied();
        }
        cells.put(position, cell);
    }
}
