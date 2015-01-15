import agameoflife.Board;
import agameoflife.BoardFactory;
import agameoflife.LifeSimulation;
import org.junit.Test;
import static org.junit.Assert.*;

public class LifeSimulationTest {

    public LifeSimulationTest() {
    }

    /**
     * Creates an acceptance test for the Game of Life by creating an input
     * ("basic") and also a set known to be solved for one generation. It 
     * applies the new generation generator from LifeSimulation class on the
     * input and then compares it to the set known to be correct.
     */
    @Test
    public void genNewGenerationTest(){
        Board board = new Board();
        board.putCells(MockingFactory.makeBoardInputSet("basic"));
        Board solvedBoard = new Board();
        solvedBoard.putCells(MockingFactory.makeSolvedBoardInputSet("basic"));
        System.out.println("");
        LifeSimulation x = new LifeSimulation(board);
        //x.start(1);
        Board aux = x.genNewGeneration();
        aux.consoleDisplay();
        solvedBoard.consoleDisplay();
        assertTrue(solvedBoard.equals(aux));
    }
    @Test
    public void acceptanceTest(){
        Board board = new Board();
        Board solvedBoard = new Board();
        board.putCells(MockingFactory.makeBoardInputSet("blinker"));
        solvedBoard.putCells(MockingFactory.makeSolvedBoardInputSet("blinker"));
        LifeSimulation x= new LifeSimulation(board);
        assertTrue(x.start(4).equals(solvedBoard));
    }
}