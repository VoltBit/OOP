package gametests;

import gameoflife.BoundlessField;
import gameoflife.Cell;
import gameoflife.Game;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import testsextra.TestUtil;

/**
 *
 * @author Dumitru Mihai-Valentin - 325 CB
 */
public class GameTestBoundless {
    private final Game g = Game.getInstance();
    private BoundlessField f;
    private ArrayList<Cell> check = new ArrayList<>();
    private ArrayList<Cell> result;
    
    @Test
    public final void whenGivenABlockReturnABlock() {
        boolean[][] arr = {{true, true}, {true, true}};
        
        TestUtil.fromBooleanMatrixToList(arr, check);
        f = new BoundlessField(arr);
        g.associateField(f);
        g.next();
        result = ((BoundlessField)g.getField()).getState();
        result.sort(TestUtil.cc);
        check.sort(TestUtil.cc);
        assertTrue(TestUtil.compareLists(result, check));
    }
    
    @Test
    public final void whenGivenABlockWithAMissingCornerReturnABlock() {
        boolean[][] arr = {{true, true}, {true, false}};
        boolean[][] block = {{true, true}, {true, true}};
        
        TestUtil.fromBooleanMatrixToList(block, check);
        f = new BoundlessField(arr);
        g.associateField(f);
        g.next();
        result = ((BoundlessField)g.getField()).getState();
        result.sort(TestUtil.cc);
        check.sort(TestUtil.cc);
        assertTrue(TestUtil.compareLists(result, check));
    }
    
    @Test
    public final void whenGivenAHorizontalBlinkerReturnAVerticalOne() {
        boolean[][] hb = {{false, false, false}, {true, true, true}, {false, false, false}};
        boolean[][] vb = {{false, true, false}, {false, true, false}, {false, true, false}};
        
        TestUtil.fromBooleanMatrixToList(vb, check);
        f = new BoundlessField(hb);
        g.associateField(f);
        g.next();
        result = ((BoundlessField)g.getField()).getState();
        result.sort(TestUtil.cc);
        check.sort(TestUtil.cc);
        assertTrue(TestUtil.compareLists(result, check));
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
        
        TestUtil.fromBooleanMatrixToList(answer, check);
        f = new BoundlessField(original);
        g.associateField(f);
        g.next();
        result = ((BoundlessField)g.getField()).getState();
        result.sort(TestUtil.cc);
        check.sort(TestUtil.cc);
        assertTrue(TestUtil.compareLists(result, check));
    }
    
    @Test(expected = RuntimeException.class)
    public final void whenGivenANegativeNumberOfStepsAnExceptionIsThrown() {
        boolean[][] dummy = {{false}};
        f = new BoundlessField(dummy);
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
        
        TestUtil.fromBooleanMatrixToList(original, check);
        f = new BoundlessField(original);
        g.associateField(f);
        g.next(0);
        result = ((BoundlessField)g.getField()).getState();
        result.sort(TestUtil.cc);
        check.sort(TestUtil.cc);
        assertTrue(TestUtil.compareLists(result, check));
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
        
        TestUtil.fromBooleanMatrixToList(answer, check);
        check.add(new Cell(2, -1));
        f = new BoundlessField(original);
        g.associateField(f);
        g.next(5);
        result = ((BoundlessField)g.getField()).getState();
        result.sort(TestUtil.cc);
        check.sort(TestUtil.cc);
        assertTrue(TestUtil.compareLists(result, check));
    }
}
