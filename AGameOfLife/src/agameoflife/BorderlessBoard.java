package agameoflife;

public class BorderlessBoard extends Board{
    public BorderlessBoard(){
        super();
    }
    public BorderlessBoard(int size){
        super(size);
    }
    public void resize(){
        Cell[][] cellT = new Cell[super.size + 2][super.size + 2];
        int i,j;
        for(i = 0; i < super.size + 2; i++){
            for(j = 0; j < super.size + 2; j++){
                cellT[i][j] = new Cell();
            }
        }
        for(i = 0; i < super.size; i++){
            for(j = 0; j < super.size; j++){
                if(super.getCell(i, j).getState() == State.Alive)
                    cellT[i+1][j+1].setState(State.Alive);
            }
        }
        super.putCells(cellT);
    }

    /**
     * Checks the edges of the board and if a living cell is found then the board
     * resizes so that the cell is no longer on the edge.
     * @return
     */
    public boolean checkEdgeProximity(){
        int i,j;
        for(i = 0; i < size; i++){
            if(super.getCell(0, i).getState() == State.Alive){
                return true;
            }else if(super.getCell(size - 1, i).getState() == State.Alive){
                return true;
            }else if(super.getCell(i, 0).getState() == State.Alive){
                return true;
            }else if(super.getCell(i, size - 1).getState() == State.Alive){
                return true;
            }
        }
        return false;
    }
    @Override
    public int getNeighbourCount(Cell cell){
        int counter = 0, i;
        int modifier = 0;
//        System.out.print(cell.getPosition().toString());
        if(checkEdgeProximity()){
            resize();
        }
        return super.getNeighbourCount(cell);
    }
}