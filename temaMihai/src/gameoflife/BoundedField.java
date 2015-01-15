package gameoflife;

import java.util.List;

/**
 * A bounded {@link gameoflife.GameField}, represented internally as a matrix of cells.
 * @author Dumitru Mihai-Valentin
 */
public class BoundedField extends GameField {
    static final int DEFAULT_HEIGHT = 30;
    static final int DEFAULT_WIDTH = 30;
    
    int height;
    int width;
    boolean[][] currentGen;
    
    /**
     * The no-args constructor creates a game field with a size of {@value #DEFAULT_HEIGHT} x
     * {@value #DEFAULT_WIDTH}
     */
    public BoundedField() {
        this(DEFAULT_HEIGHT, DEFAULT_WIDTH);
    }
    
    /**
     * The constructor creates a game field of the specified size, with dead cells only.
     * @param height number of rows
     * @param width number of columns
     */
    public BoundedField(int height, int width) {
        if (height <= 0 || width <= 0) {
            throw new RuntimeException("Only strictly positive sizes allowed!");
        }
        
        this.height = height;
        this.width = width;
        
        currentGen = new boolean[height][];
        for (int i = 0; i < height; ++i) {
            currentGen[i] = new boolean[width];
        }
    }
    
    /**
     * The constructor creates a game field based on the size and the content of the
     * given argument.
     * @param zerothGeneration initial configuration of the game field
     */
    public BoundedField(boolean[][] zerothGeneration) {
        this(zerothGeneration.length, zerothGeneration[0].length);
        
        for (int i = 0; i < height; ++i) {
            if (zerothGeneration[i].length != width) {
                throw new RuntimeException("Only rectangular arrays allowed!");
            }
            
            for (int j = 0; j < width; ++j) {
                currentGen[i][j] = zerothGeneration[i][j];
            }
        }
    }

    /**
     * The constructor creates a game field based on the content of the given argument.
     * The size of the game field is determined as minimal for all the elements to fit.
     * @param zerothGeneration initial configuration of the game field
     */
    public BoundedField(List<Cell> zerothGeneration) {
        this(zerothGeneration, 0, 0);
    }
    
    /**
     * The constructor creates a game field based on the content of the given argument.
     * It ensures a minimum game field size of {@code minHeight} x {@code minWidth}.
     * @param zerothGeneration initial configuration of the game field
     * @param minHeight minimum number of rows
     * @param minWidth minimum number of columns
     */
    public BoundedField(List<Cell> zerothGeneration, int minHeight, int minWidth) {
        int sz = zerothGeneration.size();
        Cell temp;
        
        if (zerothGeneration.isEmpty()) {
            throw new RuntimeException("The list must be non-empty");
        }
        if (minHeight < 0 || minWidth < 0) {
            throw new RuntimeException("Sizes must be non-negative!");
        }
        height = minHeight;
        width = minWidth;
        for (int i = 0; i < sz; ++i) {
            temp = zerothGeneration.get(i);
            if (temp.x < 0 || temp.y < 0) {
                throw new RuntimeException("Invalid cell coordinates!");
            }
            
            if (temp.y+1 > height) {
                height = temp.y+1;
            }
            if (temp.x+1 > width) {
                width = temp.x+1;
            }
        }
        currentGen = new boolean[height][];
        for (int i = 0; i < height; ++i) {
            currentGen[i] = new boolean[width];
        }
        
        for (int i = 0; i < sz; ++i) {
            temp = zerothGeneration.get(i);
            currentGen[temp.y][temp.x] = true;
        }
    }

    
    @Override
    public boolean toggle(int y, int x) {
        validateCoordinates(y, x);
        
        currentGen[y][x] = !currentGen[y][x];
        return !currentGen[y][x];
    }

    /**
     * Getter for the current state of the game. The current generation is represented
     * as a boolean matrix, where a {@code false} value represents a dead cell and a {@code true}
     * value represents a living cell.
     * @return a value-copy of the current generation's boolean matrix
     */
    public boolean[][] getState() {
        boolean[][] result = new boolean[height][];
        
        for (int i = 0; i < height; ++i) {
            result[i] = new boolean[width];
            for (int j = 0; j < width; ++j) {
                result[i][j] = currentGen[i][j];
            }
        }
        return result;
    }
    
    /* Package-private getter */
    boolean[][] get() {
        return currentGen;
    }
    
    /* Throws a runtime exceptions if the coordinates are out of bounds */
    private void validateCoordinates(int y, int x) {
        if (y < 0 || x < 0 || y >= height || x >= width) {
            throw new RuntimeException("Invalid cell coordinates!");
        }
    }
    
    @Override
    public String toString() {
        char[] result = new char[height * (2 * width)];
        int l = 0;
        
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width-1; ++j) {
                result[l++] = currentGen[i][j] ? '1' : '0';
                result[l++] = ' ';
            }
            result[l++] = currentGen[i][width-1] ? '1' : '0';
            if (i != height-1) {
                result[l++] = '\n';
            }
        }
        return new String(result);
    }
}
