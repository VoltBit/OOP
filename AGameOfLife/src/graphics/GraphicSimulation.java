package graphics;
import agameoflife.Cell;
import javax.swing.JFrame;
public class GraphicSimulation extends JFrame{
    Cell[][] boardConfig;

    public GameDrawer makeGraphicSimulation(Cell[][] board){
        this.boardConfig = board;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("A Game of Life");
        this.setSize(620,648);
        this.setVisible(true);
        GameDrawer drawer = new GameDrawer(boardConfig);
        add(drawer);
        return drawer;
    }
    public void refresh(GameDrawer drawer){
        add(drawer);
    }
}

