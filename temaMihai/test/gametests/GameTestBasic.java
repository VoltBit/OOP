package gametests;

import gameoflife.BoundlessField;
import gameoflife.BoundedField;
import gameoflife.Game;
import gameoflife.GameField;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dumitru Mihai-Valentin - 325 CB
 */
public class GameTestBasic {
    @Test
    public final void whenRequestedANonNullReferenceToTheGameSingletonIsReturned() {
        Game g = Game.getInstance();
        assertNotNull(g);
    }
    
    @Test
    public final void whenAccessedMultipleTimesItWillAlwaysReturnTheSameInstance() {
        Game g = Game.getInstance();
        Game h = Game.getInstance();
        assertTrue(g == h);
    }
    
    @Test
    public final void whenAFieldIsAssociatedItCanBeReturnedByTheGetter() {
        GameField f = new BoundedField();
        Game g = Game.getInstance();
        g.associateField(f);
        assertTrue(f == g.getField());
    }
}
