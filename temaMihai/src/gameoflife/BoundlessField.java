package gameoflife;

import java.util.ArrayList;
import java.util.List;

/**
 * A boundless {@link gameoflife.GameField}, represented internally as a list of {@link Cell} objects.
 * @author Dumitru Mihai-Valentin
 */
public class BoundlessField extends GameField {
    ArrayList<Cell> cells;
    
    /**
     * The no-args constructors initializes a boundless game field.
     */
    public BoundlessField() {
        cells = new ArrayList<>();
    }
    
    /**
     * Creates a boundless field with the initial configuration given by a bounded,
     * 2D boolean matrix.
     * @param zerothGeneration initial configuration of the game field
     */
    public BoundlessField(boolean[][] zerothGeneration) {
        this();
        int height = zerothGeneration.length;
        int width = zerothGeneration[0].length;
        
        for (int i = 0; i < height; ++i) {
            if (zerothGeneration[i].length != width) {
                throw new RuntimeException("Only rectangular arrays allowed!");
            }
            
            for (int j = 0; j < width; ++j) {
                if (zerothGeneration[i][j]) {
                    cells.add(new Cell(i, j));
                }
            }
        }
    }
    
    /**
     * Creates a boundless field with the initial configuration given by a list of Cells.
     * @param zerothGeneration initial configuration of the game 
     */
    public BoundlessField(List<Cell> zerothGeneration) {
        this();
        int sz = zerothGeneration.size();
        
        for (int i = 0; i < sz; ++i) {
            /* Do not allow duplicates */
            if (!cells.contains(zerothGeneration.get(i))) {
                cells.add(new Cell(zerothGeneration.get(i)));
            }
        }
    }
    
    @Override
    public boolean toggle(int y, int x) {
        Cell temp = new Cell(y, x);
        if (cells.contains(temp)) {
            cells.remove(temp);
            return true;
        }
        cells.add(temp);
        return false;
    }
    
    /**
     * Getter for the current state of the game. The current generation is represented
     * as an {@link java.util.ArrayList} of living {@link gameoflife.Cell}.
     * @return a value-copy of the current generation's ArrayList.
     */
    public ArrayList<Cell> getState() {
        int sz = cells.size();
        ArrayList<Cell> result = new ArrayList<>(sz);
        
        for (int i = 0; i < sz; ++i) {
            result.add(new Cell(cells.get(i)));
        }
        
        return result;
    }
    
    /* Package-private getter */
    ArrayList<Cell> get() {
        return cells;
    }
    
    @Override
    public String toString() {
        return cells.toString();
    }
}
