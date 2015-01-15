package gametests;

import gameoflife.BoundedField;
import gameoflife.Game;
import org.junit.Test;
import static org.junit.Assert.*;
import testsextra.TestUtil;

/**
 *
 * @author Dumitru Mihai-Valentin - 325 CB
 */
public class GameTestBounded {
    private final Game g = Game.getInstance();
    private BoundedField f;
    
    @Test
    public final void whenGivenABlockReturnABlock() {
        boolean[][] arr = {{true, true}, {true, true}};
        f = new BoundedField(arr);
        g.associateField(f);
        g.next();
        assertTrue(TestUtil.matrixEquals(((BoundedField)g.getField()).getState(), arr));
    }
    
    @Test
    public final void whenGivenAHorizontalBlinkerReturnAVerticalOne() {
        boolean[][] hb = {{false, false, false}, {true, true, true}, {false, false, false}};
        boolean[][] vb = {{false, true, false}, {false, true, false}, {false, true, false}};
        f = new BoundedField(hb);
        g.associateField(f);
        g.next();
        assertTrue(TestUtil.matrixEquals(((BoundedField)g.getField()).getState(), vb));
    }
    
    @Test
    public final void whenGivenACertainArrayReturnTheCorrectResult() {
        boolean[][] original = {
            {true, false, false, false, false},
            {false, true, true, false, true},
            {false, false, true, false, false},
            {true, true, false, true, false},
            {false, true, false, true, false},
        };
        boolean[][] answer = {
            {false, true, false, false, false},
            {false, true, true, true, false},
            {true, false, false, false, false},
            {true, true, false, true, false},
            {true, true, false, false, false}
        };
        f = new BoundedField(original);
        g.associateField(f);
        g.next();
        assertTrue(TestUtil.matrixEquals(((BoundedField)g.getField()).getState(), answer));
    }
    
    @Test(expected = RuntimeException.class)
    public final void whenGivenANegativeNumberOfStepsAnExceptionIsThrown() {
        boolean[][] dummy = {{false}};
        f = new BoundedField(dummy);
        g.associateField(f);
        g.next(-1);
    }
    
    @Test
    public final void whenGivenZeroItReturnsExactlyTheSameArray() {
        boolean[][] original = {
            {true, false, false, false, false},
            {false, true, true, false, true},
            {false, false, true, false, false},
            {true, true, false, true, false},
            {false, true, false, true, false},
        };
        f = new BoundedField(original);
        g.associateField(f);
        g.next(0);
        assertTrue(TestUtil.matrixEquals(((BoundedField)g.getField()).getState(), original));
    }
    
    @Test
    public final void whenGivenACertainArrayReturnTheCorrectResult2() {
        boolean[][] original = {
            {true, false, false, true, true},
            {false, true, false, false, false},
            {false, false, true, false, false},
            {false, true, false, true, false},
            {false, false, true, false, false},
        };
        boolean[][] answer = {
            {false, true, true, false, false},
            {true, false, true, false, false},
            {true, false, false, false, false},
            {true, false, true, false, false},
            {false, true, true, false, false}
        };
        f = new BoundedField(original);
        g.associateField(f);
        g.next(5);
        assertTrue(TestUtil.matrixEquals(((BoundedField)g.getField()).getState(), answer));
    }
}
