package oldTests;



import agameoflife.Board;
import agameoflife.Cell;
import agameoflife.State;
import graphics.MakeGraphics;

public class BoardTest extends Test{
    public void isEmptyShouldReturnFalse(){
        Board mockBoard = new Board();
        mockBoard.putCells(MockingFactory.makeBoardInputSet("minimal"));
        if(mockBoard.isEmpty()){
            System.out.println("Board isEmptyShouldReturnFalse [FAILED]");
        } else System.out.println("Board isEmptyShouldReturnFalse [PASSED]");
    }
    public void isEmptySouldReturnTrue(){
        Board mockBoard = new Board();
        mockBoard.putCells(MockingFactory.makeBoardInputSet("empty"));
        if(!mockBoard.isEmpty()){
            System.out.println("Board isEmptyShouldReturnTrue [FAILED]");
        }else System.out.println("Board isEmptyShouldReturnTrue [PASSED]");
    }
    
    public void boardGetSizeTest(){
        Board mockBoard = new Board();
        mockBoard.putCells(MockingFactory.makeBoardInputSet("basic"));
        if(mockBoard.getSize() != 8){
            System.out.println("Board getSizeTest [FAILED]");
        }else System.out.println("Board getSizeTest [PASSED]");
    }
    public void equalsShouldReturnTrue(){
        Board mockBoard1 = new Board();
        Board mockBoard2 = new Board();
        mockBoard1.putCells(MockingFactory.makeBoardInputSet("empty"));
        mockBoard2.putCells(MockingFactory.makeBoardInputSet("empty"));
        if(!mockBoard1.equals(mockBoard2)){
            System.out.print("Board boardEqualsShouldReturnTrue [FAILED]");
            return;
        }
        mockBoard1.putCells(MockingFactory.makeBoardInputSet("minimal"));
        mockBoard2.putCells(MockingFactory.makeBoardInputSet("minimal"));
        if(!mockBoard1.equals(mockBoard2)){
            System.out.println("Board boardEqualsShouldReturnTrue [FAILED]");
        }
        System.out.println("Board boardEqualsShouldReturnTrue [PASSED]");
    }
    public void equalsShouldReturnFalse(){
        Board mockBoard1 = new Board();
        Board mockBoard2 = new Board();
        mockBoard1.putCells(MockingFactory.makeBoardInputSet("empty"));
        mockBoard2.putCells(MockingFactory.makeBoardInputSet("empty"));
        mockBoard1.addCell(new Cell(5,5,State.Alive));
        mockBoard2.addCell(new Cell(1,1,State.Alive));
        mockBoard1.setState(3,3,State.Alive);
        if(mockBoard1.equals(mockBoard2)){
            System.out.println("Board boardEqualsShouldReturnFalse [FAILED]");
        }else System.out.println("Board boardEqualsShouldReturnFalse [PASSED]");
//        MakeGraphics.initialize(mockBoard2);
//        MakeGraphics.initialize(mockBoard1);
    }
    public void run() {
        System.out.println();
        this.isEmptyShouldReturnFalse();
        this.isEmptySouldReturnTrue();
        this.boardGetSizeTest();
        this.equalsShouldReturnFalse();
        this.equalsShouldReturnTrue();
    }
    
}
