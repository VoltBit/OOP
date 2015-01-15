package fieldtests;

import gameoflife.BoundlessField;
import gameoflife.Cell;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dumitru Mihai-Valentin - 325 CB
 */
public class BoundlessFieldConstructorTest {
   @Test
    public final void whenGivenARectangularBooleanArrayANonNullObjectIsReturned() {
        boolean[][] arr = {{false, true}, {true, true}};
        BoundlessField f = new BoundlessField(arr);
        assertNotNull(f);
    }
    
    @Test(expected = RuntimeException.class)
    public final void whenGivenANonRectungularArrayAnExceptionIsThrown() {
        boolean[][] arr = {{false, true, true}, {true, true}};
        BoundlessField f = new BoundlessField(arr);
    }
    
    @Test
    public final void whenGivenACellListANonNullObjectIsReturned() {
        List<Cell> l = new ArrayList<>();
        l.add(new Cell(1, 1));
        BoundlessField f = new BoundlessField(l);
        assertNotNull(f);
    }
    
    @Test
    public final void whenTheNoArgConstructorIsCalledANonNullObjectIsReturned() {
        BoundlessField f = new BoundlessField();
        assertNotNull(f);
    }
}
