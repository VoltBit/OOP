package testsextra;

import gameoflife.Cell;
import java.util.List;

/**
 *
 * @author Dumitru Mihai-Valentin - 325 CB
 */
public class TestUtil {
    public static final CellComparator cc = new CellComparator();
    
    /* Compares two boolean 2D matrixes to see if they're the same */
    public static boolean matrixEquals(boolean[][] a, boolean[][] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; ++i) {
            if (a[i].length != b[i].length) {
                return false;
            }
            for (int j = 0; j < a[i].length; ++j) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /* Compare two lists to see if they have the same elements in the same order */
    public static boolean compareLists(List a, List b) {
        if (a.size() != b.size()) {
            return false;
        }
        
        for (int i = 0; i < a.size(); ++i) {
            if (!a.get(i).equals(b.get(i))) {
                return false;
            }
        }
        return true;
    }
    
        /* Adds the cells held in a 2D boolean matrix into a list */
    public static void fromBooleanMatrixToList(boolean[][] arr, List l) {
        int height = arr.length;
        int width = arr[0].length;
        
        l.clear();
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (arr[i][j]) {
                    l.add(new Cell(i, j));
                }
            }
        }
    }
}
