package fieldtests;

import testsextra.TestUtil;
import gameoflife.BoundedField;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dumitru Mihai-Valentin - 325 CB
 */
public class BoundedFieldTest {
   @Test
    public final void whenTheGetterIsCalledReturnTheCorrectArray() {
        boolean[][] arr = {{false, true}, {true, true}};
        BoundedField f = new BoundedField(arr);
        assertNotNull(TestUtil.matrixEquals(f.getState(), arr));
    }
    
    @Test
    public final void whenTogglingADeadCellItBecomesAlive() {
        boolean[][] arr = {{false, true}, {true, true}};
        BoundedField f = new BoundedField(arr);
        f.toggle(0, 0);
        assertTrue(f.getState()[0][0]);
    }
    
    @Test
    public final void whenTogglingALivingCellItBecomesDead() {
        boolean[][] arr = {{false, true}, {true, true}};
        BoundedField f = new BoundedField(arr);
        f.toggle(0, 1);
        assertFalse(f.getState()[0][1]);
    }
}
