import agameoflife.Board;
import agameoflife.Cell;
import agameoflife.LifeRules;
import agameoflife.State;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {

    public BoardTest() {
    }

    @Test
    public void isEmptyShouldReturnFalse(){
        Board mockBoard = new Board();
        mockBoard.putCells(MockingFactory.makeBoardInputSet("minimal"));
        assertFalse(mockBoard.isEmpty());
    }
    @Test
    public void isEmptySouldReturnTrue(){
        Board mockBoard = new Board();
        mockBoard.putCells(MockingFactory.makeBoardInputSet("empty"));
        assertTrue(mockBoard.isEmpty());
    }
    @Test
    public void boardGetSizeTest(){
        Board mockBoard = new Board();
        mockBoard.putCells(MockingFactory.makeBoardInputSet("basic"));
        assertTrue(mockBoard.getSize() == 8);
    }
    @Test
    public void equalsShouldReturnTrue(){
        Board mockBoard1 = new Board();
        Board mockBoard2 = new Board();
        mockBoard1.putCells(MockingFactory.makeBoardInputSet("empty"));
        mockBoard2.putCells(MockingFactory.makeBoardInputSet("empty"));
        assertTrue(mockBoard1.equals(mockBoard2));
        mockBoard1.putCells(MockingFactory.makeBoardInputSet("minimal"));
        mockBoard2.putCells(MockingFactory.makeBoardInputSet("minimal"));
        assertTrue(mockBoard1.equals(mockBoard2));
    }
    @Test
    public void equalsShouldReturnFalse(){
        Board mockBoard1 = new Board();
        Board mockBoard2 = new Board();
        mockBoard1.putCells(MockingFactory.makeBoardInputSet("empty"));
        mockBoard2.putCells(MockingFactory.makeBoardInputSet("empty"));
        mockBoard1.addCell(new Cell(5,5,State.Alive));
        mockBoard2.addCell(new Cell(1,1,State.Alive));
        mockBoard1.setState(3,3,State.Alive);
        assertFalse(mockBoard1.equals(mockBoard2));
//        MakeGraphics.initialize(mockBoard2);
//        MakeGraphics.initialize(mockBoard1);
    }
    @Test
    public void addCellTest(){
        Board mock = new Board(4);
        mock.addCell(new Cell(1,1,State.Alive));
        mock.addCell(new Cell(1,0,State.Alive));
        mock.addCell(new Cell(3,3,State.Alive));
        assertTrue(mock.getCell(1, 1).getState() == State.Alive);
        assertTrue(mock.getCell(1, 0).getState() == State.Alive);
        assertTrue(mock.getCell(3, 3).getState() == State.Alive);
    }
    @Test
    public void checkOutOfBoundsTest(){
        int x = -1, y = 0;
        Board b = new Board();
        assertFalse(b.checkOutOfBounds(x, y));
        x = 100; y = 100;
        assertFalse(b.checkOutOfBounds(x, y));
        x = 0; y = -1;
        assertFalse(b.checkOutOfBounds(x, y));
    }
    @Test
    public void copyTest(){
        Board b1 = new Board();
        b1.putCells(MockingFactory.makeBoardInputSet("minimal"));
        Board b2 = b1.copy();
        assertTrue(b1.equals(b2));
    }
    @Test
    public void getNeighbourTest(){
        Board board = new Board();
        board.putCells(MockingFactory.makeBoardInputSet("minimal"));
//        MakeGraphics.initialize(board);
        board.borderSwitch(true);
        assertTrue(board.getNeighbourCount(board.getCell(0,0)) == 1);
        assertTrue(board.getNeighbourCount(board.getCell(1,0)) == 3);
        assertTrue(board.getNeighbourCount(board.getCell(2,0)) == 1);
        assertTrue(board.getNeighbourCount(board.getCell(0,1)) == 3);
        assertTrue(board.getNeighbourCount(board.getCell(1,1)) == 4);
        assertTrue(board.getNeighbourCount(board.getCell(2,1)) == 3);
        assertTrue(board.getNeighbourCount(board.getCell(0,2)) == 1);
        assertTrue(board.getNeighbourCount(board.getCell(1,2)) == 3);
        assertTrue(board.getNeighbourCount(board.getCell(2,2)) == 1);
//        System.out.println(LifeRules.getNextState(board.getCell(0,1), 
//                board.getNeighbourCount(board.getCell(0, 1))) + " vecini: " + board.getNeighbourCount(board.getCell(0, 1)));
//        System.out.println(LifeRules.getNextState(board.getCell(0,0), 
//                board.getNeighbourCount(board.getCell(0, 0))));
        
        board.putCells(MockingFactory.makeBoardInputSet("basic"));
//        board.consoleDisplay();
        assertTrue(board.getNeighbourCount(board.getCell(4,3)) == 3);
        assertTrue(board.getNeighbourCount(board.getCell(0,0)) == 0);
        assertTrue(board.getNeighbourCount(board.getCell(3,3)) == 3);
        assertTrue(board.getNeighbourCount(board.getCell(5,2)) == 4);
        assertTrue(board.getNeighbourCount(board.getCell(7,3)) == 1);
        System.out.print(LifeRules.getNextState(board.getCell(3,3), 
                board.getNeighbourCount(board.getCell(3, 3))));
    }
}