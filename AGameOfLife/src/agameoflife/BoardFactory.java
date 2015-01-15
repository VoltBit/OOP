package agameoflife;

import java.util.Random;

public class BoardFactory {
    static Board board;
    private static void init(int size){
        board = new Board(size);
    }
    static Board makeBoard(String type){
        int boardSize,i,j;
        switch (type) {
            case "beacon":
                init(6);
                board.addCell(new Cell(1,1,State.Alive));
                board.addCell(new Cell(1,2,State.Alive));
                board.addCell(new Cell(2,1,State.Alive));
                board.addCell(new Cell(3,4,State.Alive));
                board.addCell(new Cell(4,3,State.Alive));
                board.addCell(new Cell(4,4,State.Alive));
                break;
            case "beehive":
                init(6);
                board.addCell(new Cell(1,2,State.Alive));
                board.addCell(new Cell(1,3,State.Alive));
                board.addCell(new Cell(2,1,State.Alive));
                board.addCell(new Cell(2,4,State.Alive));
                board.addCell(new Cell(3,2,State.Alive));
                board.addCell(new Cell(3,3,State.Alive));
                break;
            case "blinker":
                init(6);
                board.addCell(new Cell(3,1,State.Alive));
                board.addCell(new Cell(3,2,State.Alive));
                board.addCell(new Cell(3,3,State.Alive));
                break;
            case "random":
                boardSize = 64;
                init(boardSize);
                Random rand = new Random();
                for(i = 0; i < boardSize; i++){
                    for(j = 0; j < boardSize; j++){
                        board.addCell(new Cell(i,j));
                        if(rand.nextBoolean())
                            board.setState(i,j,State.Alive);
                    }
                }
            break;
            case "large":
                boardSize = 32;
                board = new Board(boardSize);
                for(i = 0; i < boardSize; i++){
                    for(j = 0; j < boardSize; j++){
                        board.addCell(new Cell(i,j));
                    }
                }
                board.setState(3,2,State.Alive);
                board.setState(4,2,State.Alive);
                board.setState(3,3,State.Alive);
                board.setState(5,3,State.Alive);
                board.setState(1,4,State.Alive);
                board.setState(2,4,State.Alive);
                board.setState(0,5,State.Alive);
                board.setState(2,5,State.Alive);
                board.setState(1,6,State.Alive);
                board.setState(2,6,State.Alive);
                board.setState(3,7,State.Alive);
                break;
            case "basic":
                boardSize = 8;
                //initBoardInputSet(board, boardSize);
                board = new Board(boardSize);
                for(i = 0; i < boardSize; i++){
                    for(j = 0; j < boardSize; j++){
                        board.addCell(new Cell(i,j));
                    }
                }
                board.setState(2,3,State.Alive);
                board.setState(2,4,State.Alive);
                board.setState(3,3,State.Alive);
                board.setState(3,5,State.Alive);
                board.setState(4,1,State.Alive);
                board.setState(4,2,State.Alive);
                board.setState(5,0,State.Alive);
                board.setState(5,2,State.Alive);
                board.setState(6,1,State.Alive);
                board.setState(6,2,State.Alive);
                board.setState(7,3,State.Alive);
                break;
            case "minimal":
                boardSize = 3;
                board = new Board(boardSize);
                for(i = 0; i < boardSize; i++){
                    for(j = 0; j < boardSize; j++){
                        board.addCell(new Cell(i,j));
                    }
                }
                board.setState(0,0,State.Alive);
                board.setState(2,0,State.Alive);
                board.setState(0,2,State.Alive);
                board.setState(2,2,State.Alive);
                board.setState(1,1,State.Alive);
                break;
            case "empty":
                boardSize = 10;
                board = new Board(boardSize);
                for(i = 0; i < boardSize; i++){
                    for(j = 0; j < boardSize; j++){
                        board.addCell(new Cell(i,j));
                    }
                }
                break;
        }
        return board;
    }
}