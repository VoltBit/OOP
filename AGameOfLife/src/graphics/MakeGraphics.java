package graphics;

import agameoflife.Board;

public class MakeGraphics {
    public static GameDrawer initialize(Board b){
        GraphicSimulation gSim = new GraphicSimulation();
        return gSim.makeGraphicSimulation(b.getConfig());
    }
}
