package fieldtests;

import testsextra.TestUtil;
import gameoflife.BoundedField;
import gameoflife.BoundlessField;
import gameoflife.Cell;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dumitru Mihai-Valentin - 325 CB
 */
public class BoundlessFieldTest {
   @Test
    public final void whenTheGetterIsCalledReturnTheCorrectArray() {
        ArrayList<Cell> arr = new ArrayList<>();
        ArrayList<Cell> state;
        
        arr.add(new Cell(1, 0));
        arr.add(new Cell(1, 1));
        arr.add(new Cell(2, 2));
        
        BoundlessField f = new BoundlessField(arr);
        state = f.getState();
        state.sort(TestUtil.cc);
        arr.sort(TestUtil.cc);
        assertTrue(TestUtil.compareLists(arr, state));
    }
    
    @Test
    public final void whenTogglingADeadCellItBecomesAlive() {
        ArrayList<Cell> arr = new ArrayList<>();
        
        arr.add(new Cell(1, 0));
        arr.add(new Cell(1, 1));
        arr.add(new Cell(2, 2));
        
        BoundlessField f = new BoundlessField(arr);
        f.toggle(0, 0);
        assertTrue(f.getState().contains(new Cell(0, 0)));
    }
    
    @Test
    public final void whenTogglingALivingCellItBecomesDead() {
        ArrayList<Cell> arr = new ArrayList<>();
        
        arr.add(new Cell(1, 0));
        arr.add(new Cell(1, 1));
        arr.add(new Cell(2, 2));
        
        BoundlessField f = new BoundlessField(arr);
        f.toggle(1, 0);
        assertFalse(f.getState().contains(new Cell(1, 0)));
    }
}
