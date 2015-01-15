package testsextra;

import gameoflife.Cell;
import java.util.Comparator;

/**
 *
 * @author Dumitru Mihai-Valentin - 325 CB
 */
public class CellComparator implements Comparator<Cell> {
    @Override
    public int compare(Cell left, Cell right) {
        return left.compareTo(right);
    }
}
