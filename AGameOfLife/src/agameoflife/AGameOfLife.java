package agameoflife;

import graphics.MakeGraphics;

public class AGameOfLife {

    private static void runGame(String mode){
        switch(mode){
            case "bordered":
                LifeSimulation x = new LifeSimulation(BoardFactory.makeBoard("basic"));
                x.start(3);
                break;
            case "borderless":
                
                break;
        }
    }
    public static void main(String[] args) {
        runGame("bordered");
//        runGame("borderless");
    }
}
