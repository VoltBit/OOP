package fieldtests;

import gameoflife.BoundedField;
import gameoflife.Cell;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dumitru Mihai-Valentin - 325 CB
 */
public class BoundedFieldConstructorTest {
   @Test
    public final void whenGivenARectangularBooleanArrayANonNullObjectIsReturned() {
        boolean[][] arr = {{false, true}, {true, true}};
        BoundedField f = new BoundedField(arr);
        assertNotNull(f);
    }
    
    @Test(expected = RuntimeException.class)
    public final void whenGivenANonRectungularArrayAnExceptionIsThrown() {
        boolean[][] arr = {{false, true, true}, {true, true}};
        BoundedField f = new BoundedField(arr);
    }
    
    @Test(expected = RuntimeException.class)
    public final void whenGivenAnEmptyCellListAnExceptionIsThrown() {
        List<Cell> l = new ArrayList<>();
        BoundedField f = new BoundedField(l);
    }
    
    @Test
    public final void whenGivenACellListANonNullObjectIsReturned() {
        List<Cell> l = new ArrayList<>();
        l.add(new Cell(1, 1));
        BoundedField f = new BoundedField(l);
        assertNotNull(f);
    }
    
    @Test(expected = RuntimeException.class)
    public final void whenGivenAListAndNegativeSizesAnExceptionIsThrown() {
        List<Cell> l = new ArrayList<>();
        l.add(new Cell(1, 1));
        BoundedField f = new BoundedField(l, 2, -2);
    }
    
    @Test
    public final void whenGivenACellListAndSizesANonNullObjectIsReturned() {
        List<Cell> l = new ArrayList<>();
        l.add(new Cell(1, 1));
        BoundedField f = new BoundedField(l, 2, 2);
        assertNotNull(f);
    }
    
    @Test
    public final void whenTheNoArgConstructorIsCalledANonNullObjectIsReturned() {
        BoundedField f = new BoundedField();
        assertNotNull(f);
    }
}
