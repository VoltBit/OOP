import agameoflife.BorderlessBoard;
import org.junit.Test;
import static org.junit.Assert.*;

public class BorderlessBoardTest extends BoardTest{

    public BorderlessBoardTest() {
        
    }
    @Test
    public void resizeTest(){
        int aux;
        BorderlessBoard b = new BorderlessBoard();
        b.putCells(MockingFactory.makeBoardInputSet("basic"));
        b.borderSwitch(false);
        aux = b.getSize();
        b.resize();
        System.out.println();
        assertTrue(b.getSize() == aux + 2);
        
        b.putCells(MockingFactory.makeBoardInputSet("minimal"));
        b.consoleDisplay();
        b.resize();
        System.out.println("");
        b.consoleDisplay();
    }
    @Test
    @Override
    public void getNeighbourTest(){
        BorderlessBoard b = new BorderlessBoard();
        b.putCells(MockingFactory.makeBoardInputSet("basic"));
//        b.consoleDisplay();
        int aux = b.getSize();
        System.out.println("[0,0]: " + b.getNeighbourCount(b.getCell(0, 0)));
        assertTrue(b.getNeighbourCount(b.getCell(0, 0)) == 1);
        assertTrue(b.getNeighbourCount(b.getCell(2, 4)) == 2);
        assertTrue(b.getSize() == aux + 2);
    }
    @Test
    public void checkEdgeProximityTest(){
        BorderlessBoard b = new BorderlessBoard();
        b.putCells(MockingFactory.makeBoardInputSet("basic"));
        assertTrue(b.checkEdgeProximity());
    }
}