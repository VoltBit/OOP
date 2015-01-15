package gameoflife;

/**
 * The Game class is a Singleton that represents the running Game of Life. It is characterized
 * by a given field, on which it can simulate steps of evolution.
 * @author Dumitru Mihai-Valentin - 325 CB
 */
public class Game {
    private static final Game INSTANCE = new Game();
    
    GameField gameField;
    
    private Game() {
    }
    
    /**
     * Returns the instance of the Game singleton.
     * @return reference to the singleton instance of the Game class
     */
    public static Game getInstance() {
        return INSTANCE;
    }
    
    /**
     * Associates a new field to the game object.
     * @param field the new field
     */
    public void associateField(GameField field) {
        gameField = field;
    }
   
    
    /**
     * Computes the next generation.
     */
    public void next() {
        Generator.generateNext(gameField);
    }
    
    /**
     * The method simulates a number of {@code steps} generations, through repeated calls
     * of the {@code next()} method.
     * @param steps number of generations to simulate
     */
    public void next(int steps) {
        if (steps < 0) {
            throw new RuntimeException("Can only generate a non-negative number of steps!");
        }
        
        while (steps != 0) {
            next();
            --steps;
        }
    }
    
    /**
     * Return the internal field of the game instance.
     * @return game field on which the game object currently operates
     */
    public GameField getField() {
        return gameField;
    }
}
