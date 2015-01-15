package oldTests;



import oldTests.Test;
import agameoflife.Board;
import graphics.MakeGraphics;

public class LifeSimulationTest extends Test{

    Board board;
    int generations;
    boolean blockage = false;
    
    private void initBoard(){
        this.board = new Board();
        board.putCells(MockingFactory.makeBoardInputSet("basic"));
    }
    
    public void getNeighboursTest(){
        initBoard();
        this.board.borderSwitch(true);
        
    }
    
    @Override
    public void run() {
        
    }

}
