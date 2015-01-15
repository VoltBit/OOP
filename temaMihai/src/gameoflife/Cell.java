package gameoflife;

/**
 * The class represents a cell in the Game Of Life, needed for the boundless representation of the field.
 * <p>Besides two basic constructors, it also overrides the Object.equals and Object.toString
 * methods. The class also implements the {@code Comparable} interface for testing purposes.
 * @author Dumitru Mihai-Valentin
 */
public class Cell implements Comparable<Cell> {
    int y;
    int x;
    
    /**
     * Creates a cell at line {@code y}, column {@code x}.
     * @param y line of the cell
     * @param x column of the cell
     */
    public Cell(int y, int x) {
        this.y = y;
        this.x = x;
    }
    /**
     * Copy constructor.
     * @param arg value to be copied
     */
    public Cell(Cell arg) {
        this.y = arg.y;
        this.x = arg.x;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof Cell) {
            Cell right = (Cell) o;
            return y == right.y && x == right.x;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "(" + y + ", " + x + ") ";
    }

    @Override
    public int compareTo(Cell right) {
        if (y == right.y ) {
            return x - right.x;
        }
        return y - right.y;
    }
}
