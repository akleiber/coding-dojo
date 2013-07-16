package main.java;

import java.util.HashMap;
import java.util.Map;

public class PlayingField
{
    private GCell[][] cells;

    private String field;

    public PlayingField(String field)
    {
        cells = parseString(field);
    }

    private GCell[][] parseString(String field)
    {
        Map<Position, GCell> cellMap = new HashMap();
        String[] rows = field.split("\n");
        GCell[][] cells = new GCell[rows.length][rows[0].length()];
        for (int y = 0; y < rows.length; y++) {
            for (int x = 0; x < rows[y].length(); x++) {
                cells[x][y] = new GCell(rows[y].charAt(x) == 'x');
            }
        }
        
        return cells;
    }

    public String toString()
    {
        String field = "";
        for (GCell[] innerCells : cells) {
            for (GCell cell : innerCells) {
                field += cell.toString();
            }
            field += "\n";
        }

        return field.trim();
    }

    public void next()
    {
    }

    public int getAmountOfLivingNeighbours(Position position)
    {
        int amount = 0;
        String[] rows = toString().split("\n");

        int minY = Math.max(position.getY() -1, 0);
        int minX = Math.max(position.getX() - 1, 0);
        int maxY = Math.min(position.getY() +1, rows.length - 1);
        int maxX = Math.min(position.getX() + 1, rows.length -1);

        for (int y = minY; y <= maxY; y++) {
            for (int x = minX; x <= maxX; x++) {
                if (y == position.getY() && x == position.getX()) {
                    continue;
                }

                if(rows[y].charAt(x) == 'x') {
                    amount++;
                }
            }
        }

        return amount;
    }
}
