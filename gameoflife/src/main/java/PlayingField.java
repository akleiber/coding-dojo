package main.java;

import test.java.DefaultRules;

public class PlayingField
{
    private Cell[][] cells;

    public PlayingField(String field)
    {
        cells = parseString(field);
    }

    private Cell[][] parseString(String field)
    {
        String[] rows = field.split("\n");
        Cell[][] cells = new Cell[rows.length][rows[0].length()];
        for (int x = 0; x < rows.length; x++) {
            for (int y = 0; y < rows[x].length(); y++) {
                cells[x][y] = new Cell(rows[x].charAt(y));
            }
        }
        
        return cells;
    }

    public String toString()
    {
        String field = "";
        for (Cell[] innerCells : cells) {
            for (Cell cell : innerCells) {
                field += cell.toString();
            }
            field += "\n";
        }

        return field.trim();
    }

    public int getAmountOfLivingNeighbours(Position position)
    {
        int amount = 0;

        for (int y = position.getY() - 1; y <= position.getY() + 1; y++) {
            for (int x = position.getX() - 1; x <= position.getX() + 1; x++) {
                if (position.getX() == x && position.getY() == y) {
                    continue;
                }
                amount += getCell(new Position(x, y)).isAlive() ? 1 : 0;
            }
        }
        return amount;
    }

    private Cell getCell(Position pos)
    {
        try {
            return cells[pos.getX()][pos.getY()];
        } catch (ArrayIndexOutOfBoundsException ex) {
            return new Cell('o');
        }
    }

    public PlayingField evolve()
    {
        DefaultRules rules = new DefaultRules();
        StringBuilder sb = new StringBuilder();

        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                int livingNeighbours = getAmountOfLivingNeighbours(new Position(x, y));

                if (rules.isAliveInNextIteration(cells[x][y], livingNeighbours)) {
                    sb.append('x');
                } else {
                    sb.append('o');
                }
            }

            sb.append("\n");
        }


        return new PlayingField(sb.toString().trim());
    }
}
