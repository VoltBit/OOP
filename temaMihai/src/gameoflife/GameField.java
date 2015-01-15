package gameoflife;

/**
 * This abstract class is the basis for creating a game field. It is used by the {@link Game} and
 * {@link Generator} classes.
 * @author Dumitru Mihai-Valentin - 325 CB
 */
public abstract class GameField {
    /** 
     * The toggle function takes the coordinates of a cell and changes its state, so that
     * a living cell will die and a dead cell will revive.
     * @param x horizontal coordinate
     * @param y vertical coordinate
     * @return the previous value of the cell (false = dead, true = alive)
     */
    public abstract boolean toggle(int y, int x);
}
