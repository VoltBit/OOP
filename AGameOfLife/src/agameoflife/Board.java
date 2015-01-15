package agameoflife;

public class Board {
    Cell[][] cellTable = null;
    int deafultSize = 64;
    int size = 0;
    boolean borders;
    public Board(){
        this.borders = true;
    }
    public Board(int size){
        this.borders = true;
        this.cellTable = new Cell[size][size];
        this.size = size;
        initialize();
    }
    private void initialize(){
        int i,j;
        for(i = 0; i < this.size; i++){
            for(j = 0; j < this.size; j++){
                this.cellTable[i][j] = new Cell(i,j);
            }
        }
    }
    /**
     * Adds a double dimensional array of cells to the board.
     * @param x - double dimensional array of cells which represents a board 
     * configuration
     */
    public void putCells(Cell[][] x){
        this.cellTable = x;
        this.size = cellTable[0].length;
    }

    /**
     * Adds a cell to the board. If the board is empty at the time of adding
     * it is initialized first with the default size.
     * @param cell
     */
    public void addCell(Cell cell){
        if(cellTable == null){
            initBoard();
        }
        this.cellTable[cell.getPosition().x][cell.getPosition().y] = cell;
    }
    /**
     * Initializes the two dimensional array of cells with dead cells.
     */
    public void initBoard(){
        int i,j;
        if(cellTable == null){
            this.cellTable = new Cell[this.deafultSize][this.deafultSize];
        }
        for(i = 0; i < this.deafultSize; i++){
            for(j = 0; j < this.deafultSize; j++){
                this.cellTable[i][j] = new Cell(i,j);
            }
        }
    }

    /**
     * Allows access to the cellTable of the board.
     * @return double dimensional Cell array which holds the cell configuration
     */
    public Cell[][] getConfig(){
        return this.cellTable;
    }
    /**
     * Method called to set the borders of a board ON and OFF.
     * @param val boolean value; true for borders ON, false for borders OFF
     */
    public void borderSwitch(boolean val){
        this.borders = val;
    }

    /**
     *
     * @return the size of the current board
     */
    public int getSize(){
        return cellTable[0].length;
    }
    public Cell getCell(int x, int y){
        return this.cellTable[x][y];
    }
    public boolean isEmpty(){
        int i,j;
        if(size == 0){
            return true;
        }
        for(i = 0; i < this.size; i++){
            for(j = 0; j < this.size; j++){
                if(cellTable[i][j].state == State.Alive){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean equals(Board b){
        int i,j;
        for(i = 0; i < b.getSize(); i++){
            for(j = 0; j < b.getSize(); j++){
                if(this.cellTable[i][j].getState() != b.cellTable[i][j].getState()){
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Creates and returns a copy of the current board.
     * @return - copy of current board
     */
    public Board copy(){
        int i,j;
        Board copy = new Board(this.size);
        for(i = 0; i < this.size; i++)
            for(j = 0; j < this.size; j++){
                copy.cellTable[i][j] = new Cell(i,j,this.getCell(i, j).getState());
            }
        return copy;
    }
    /**
     * Changes the state of a cell at the given coordinates.
     * @param x coordinate x of the cell
     * @param y coordinate y of the cell
     * @param s the new state
     */
    public void setState(int x, int y,State s){
        if(x >= this.size || y >= this.size || x < 0 || y < 0){
            System.err.println("Illegal coordinates [Board:setState]");
        }
        this.cellTable[x][y].setState(s);
    }
    
    public boolean checkOutOfBounds(int x, int y){
        if(x < 0 || y < 0 || x >= this.size || y >= this.size){
            return false;
        }
        return true;
    }

    /**
     * Returns the number of neighbours of a given cell.
     * @param cell cell whose neighbours are to e returned
     * @return - number of neighbiurs
     */
    public int getNeighbourCount(Cell cell){
        int counter = 0, i;
//        System.out.print(cell.getPosition().toString());
        for(i = cell.getPosition().x - 1; i < cell.getPosition().x + 2; i++){
            if(checkOutOfBounds(cell.getPosition().y - 1,  i)){
                if(this.cellTable[i][cell.getPosition().y - 1]
                        .getState() == State.Alive){
                    counter++;
//                    System.out.print("{1}");
                }
            }
            if(checkOutOfBounds(cell.getPosition().y, i)){
                if(this.cellTable[i][cell.getPosition().y]
                        .getState() == State.Alive && i != cell.getPosition().x){
                    counter++;
//                    System.out.print("{2}");//: " + i + " " + cell.getPosition().y + "}");
                }
            }
            if(checkOutOfBounds(cell.getPosition().y + 1, i)){
                if(this.cellTable[i][cell.getPosition().y + 1]
                        .getState() == State.Alive){
                    counter++;
//                    System.out.print("{3}");
                }
            }
        }
//        System.out.print("counter: " + counter + "\n");
        return counter;
    }
    
    /**
     * Makes a numeric representation of the board in the console. Useful for
     * debugging.
     */
    public void consoleDisplay(){
        int i,j;
        for(i = 0; i < this.size; i++){
            for(j = 0; j < this.size; j++){
                if(this.cellTable[i][j].state == State.Dead)
                    System.out.print(0);
                else System.out.print(1);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}
