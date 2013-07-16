package main.java;

import java.util.HashMap;
import java.util.List;
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

    public List<GCell> getLivingNeighbours(Position position)
    {

    }
}
