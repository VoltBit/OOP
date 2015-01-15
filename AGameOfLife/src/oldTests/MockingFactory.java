package oldTests;
import agameoflife.Cell;
import agameoflife.State;
import java.util.Random;

public class MockingFactory {
    public static Cell makeMockCell(int x, int y, State s){
        Cell c = new Cell(x,y,s);
        return c;
    }
    public static Cell makeMockCell(int x, int y){
        Cell c = new Cell(x,y);
        return c;
    }
    public static Cell makeMockCell(){
        Cell c = new Cell();
        return c;
    }
    private static void initBoardInputSet(Cell[][] mockBoard, int size){
        int i,j;
        mockBoard = new Cell[size][size];
        for(i = 0; i < size; i++){
            for(j = 0; j < size; j++){
                mockBoard[i][j] = new Cell(i,j);
            }
        }
    }

    /**
     * Generates a two dimensional array of cells generated accordingly to the
     * command given as follows:
     * "empty": 10x10 board full of dead cells
     * "basic": 8x8 board with a specific patters
     * "minimal": 3x3 board with living cells along the diagonals
     * "random": 64x64 board with randomly set living cells on it
     * @param type - the string that tells which kind of board should be made
     * @return
     */
    public static Cell[][] makeBoardInputSet(String type){
        Cell[][] mockBoard = null;
        int i,j,boardSize;
        switch (type) {
            case "random":
                boardSize = 64;
                Random rand = new Random();
                mockBoard = new Cell[boardSize][boardSize];
                for(i = 0; i < boardSize; i++){
                    for(j = 0; j < boardSize; j++){
                        mockBoard[i][j] = new Cell(i,j);
                        if(rand.nextBoolean())
                            mockBoard[i][j].setState(State.Alive);
                    }
                }
            break;
            case "large":
                boardSize = 32;
                mockBoard = new Cell[boardSize][boardSize];
                for(i = 0; i < boardSize; i++){
                    for(j = 0; j < boardSize; j++){
                        mockBoard[i][j] = new Cell(i,j);
                    }
                }
                mockBoard[3][2].setState(State.Alive);
                mockBoard[4][2].setState(State.Alive);
                mockBoard[3][3].setState(State.Alive);
                mockBoard[5][3].setState(State.Alive);
                mockBoard[1][4].setState(State.Alive);
                mockBoard[2][4].setState(State.Alive);
                mockBoard[0][5].setState(State.Alive);
                mockBoard[2][5].setState(State.Alive);
                mockBoard[1][6].setState(State.Alive);
                mockBoard[2][6].setState(State.Alive);
                mockBoard[3][7].setState(State.Alive);
                break;
            case "basic":
                boardSize = 8;
                //initBoardInputSet(mockBoard, boardSize);
                mockBoard = new Cell[boardSize][boardSize];
                for(i = 0; i < boardSize; i++){
                    for(j = 0; j < boardSize; j++){
                        mockBoard[i][j] = new Cell(i,j);
                    }
                }
                mockBoard[3][2].setState(State.Alive);
                mockBoard[4][2].setState(State.Alive);
                mockBoard[3][3].setState(State.Alive);
                mockBoard[5][3].setState(State.Alive);
                mockBoard[1][4].setState(State.Alive);
                mockBoard[2][4].setState(State.Alive);
                mockBoard[0][5].setState(State.Alive);
                mockBoard[2][5].setState(State.Alive);
                mockBoard[1][6].setState(State.Alive);
                mockBoard[2][6].setState(State.Alive);
                mockBoard[3][7].setState(State.Alive);
                break;
            case "minimal":
                boardSize = 3;
                mockBoard = new Cell[boardSize][boardSize];
                for(i = 0; i < boardSize; i++){
                    for(j = 0; j < boardSize; j++){
                        mockBoard[i][j] = new Cell(i,j);
                    }
                }
                mockBoard[0][0].setState(State.Alive);
                mockBoard[2][0].setState(State.Alive);
                mockBoard[0][2].setState(State.Alive);
                mockBoard[2][2].setState(State.Alive);
                mockBoard[1][1].setState(State.Alive);
                break;
            case "empty":
                boardSize = 10;
                mockBoard = new Cell[boardSize][boardSize];
                for(i = 0; i < boardSize; i++){
                    for(j = 0; j < boardSize; j++){
                        mockBoard[i][j] = new Cell(i,j);
                    }
                }
                break;
        }
        return mockBoard;
    }

    /**
     * Provides the configuration that the "basic" board should have after one
     * generation. It is used inside tests to check if all the life rules work
     * well together.
     * @param type - tells what kind of configuration is need
     * @return - the two dimensional array created
     */
    public static Cell[][] makeSolvedBoardInputSet(String type){
        Cell[][] mockBoard = null;
        switch (type) {
            case "basic":
                mockBoard = makeBoardInputSet("basic");
                mockBoard[5][3].setState(State.Dead);
                mockBoard[3][4].setState(State.Alive);
                mockBoard[2][5].setState(State.Dead);
                mockBoard[3][5].setState(State.Alive);
                mockBoard[3][6].setState(State.Alive);
                mockBoard[2][7].setState(State.Alive);
                mockBoard[4][7].setState(State.Dead);
                break;
        }
        return mockBoard;
    }
}
