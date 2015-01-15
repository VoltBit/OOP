package agameoflife;

import static agameoflife.LifeSimulation.board;

public class LifeBorderlessSimulation{
    static BorderlessBoard board = null;
    static int size;
    public LifeBorderlessSimulation(){
        board = new BorderlessBoard();
    }
    public LifeBorderlessSimulation(int s){
        size = s;
    }
    public LifeBorderlessSimulation(BorderlessBoard b){
        board = b;
        size = b.getSize();
    }
    public Board genNextGeneraton(){
        int i,j;
        int neighboursCount = 0;
        BorderlessBoard aux = (BorderlessBoard) board.copy();
        State s;
        board.consoleDisplay();
        for(i = 0; i < size; i++){
            for(j = 0 ; j < size; j++){
                
            }
        }
        return board;
    }
}
