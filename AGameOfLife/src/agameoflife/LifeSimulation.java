package agameoflife;

public class LifeSimulation {
    static Board board = null;
    static int boardSize = 0;
    public LifeSimulation() {
        board = new Board();
    }
    public LifeSimulation(int size){
        boardSize = size;
    }
    public LifeSimulation(Board inputBoard) {
        board = inputBoard;
        boardSize = inputBoard.getSize();
    }
    private void initBoard(){
        int defaultSize = 10;
        if(boardSize == 0){
            boardSize = defaultSize;
        }
        if(board == null){
            board = BoardFactory.makeBoard("basic");
            boardSize = board.getSize();
        }
    }

    /**
     * Generates the new generation of cells based on the four rules of the 
     * game. 
     * @return board which holds the new configuration of cells
     */
    public Board genNewGeneration(){
        int i,j;
        int neighboursCount = 0;
        Board aux = board.copy();
        State s;
        board.consoleDisplay();
        for(i = 0; i < boardSize; i++){
            for(j = 0 ; j < boardSize; j++){
                neighboursCount = board.getNeighbourCount(board.getCell(i, j));
                //System.out.print("Cell[" + i + "][" + j + "]: " + neighboursCount + "  ");
                s = LifeRules.getNextState(board.getCell(i, j), neighboursCount);
                aux.setState(i,j,s);
            }
//            System.out.println("");
        }
        board = aux;
        return board;
    }

    /**
     * Method that starts the life simulation and return the final configuration
     * of the board. The method can either receive a number of generations until
     * it stops or receive nothing and run indefinitely or until a halting
     * pattern emerge (*indefinitely = 200 generations).
     * @param generations - number of generations, if no argument is received
     * then the number of generations defaults to 10
     * @return 
     */
    public Board start(int generations){
        int i;
        initBoard();
//        MakeGraphics.initialize(board);
        for(i = 0; i < generations; i++){
            System.out.println("Generation " + i + "\n");
            genNewGeneration();
        }
        return board;
    }
    public Board start(){
        int i; 
        int generations = 200;
        initBoard();
        Board aux;
        for(i = 0; i < generations; i++){
            aux = board.copy();
            genNewGeneration();
            if(aux.equals(board)){
                System.out.println("Reached halting configuration");
                break;
            }
        }
        return board;
    }
}
