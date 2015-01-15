package agameoflife;

import java.awt.Point;

/**
 * The basic object that represents a cell in the game of life. 
 * It has two integer coordinates which marks the row and column where it is
 * placed on the table. The String value "state" can contain the values 'Dead'
 * and 'Alive'.
 */
public class Cell {
    private int x,y;
    State state;
    public Cell(){
        this.x = 0;
        this.y = 0;
        this.state = State.Dead;
    }
    public Cell(int x, int y){
        this.x = x;
        this.y = y;
        this.state = State.Dead;
    }
    public Cell(int x, int y, State s){
        this.x = x;
        this.y = y;
        this.state = s;
    }    
    public State getState(){
        return this.state;
    }
    public void setState(State st){
        this.state = st;
    }
    public Point getPosition(){
        return new Point(this.x,this.y);
    }
}
