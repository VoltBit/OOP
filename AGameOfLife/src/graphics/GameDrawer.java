package graphics;

import agameoflife.Cell;
import agameoflife.State;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import javax.swing.JPanel;

public class GameDrawer extends JPanel {
    Cell[][] cellInput;
    int cellSize;
    int cellNumber;
    public GameDrawer(Cell[][] input){
        this.cellInput = input;
        this.cellSize = 600 / input[0].length;
        this.cellNumber = input[0].length;
    }
    private void drawGrid(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                                            RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING,
               RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);
//        int i, cellSize = 10;
//        int cellNumber = 600 / cellSize;
        int i;
        for(i = 0; i < cellNumber; i++){
            g2d.draw(new Line2D.Float(0, cellSize * i, cellSize * cellNumber, cellSize * i));
            g2d.draw(new Line2D.Float(cellSize * i, 0, cellSize * i, cellSize * cellNumber));
        }
        if(this.cellInput == null){
            System.err.println("null board");
        } else
            drawCells(g2d);
    }
    public void drawCells(Graphics2D g2d){
        Rectangle cell;
        g2d.setColor(Color.GREEN);
        int i,j;
        for(i = 0; i < cellNumber; i++)
            for(j = 0; j < cellNumber; j++){
                if(this.cellInput[i][j].getState() == State.Alive){
                    cell = new Rectangle(this.cellInput[i][j].getPosition().y 
                            * cellSize + 1, this.cellInput[i][j].getPosition().x 
                                    * cellSize + 1, cellSize - 1, cellSize - 1);
                    g2d.fill(cell); 
                }
            }
        //g2d.drawRect(20, 20, cellSize, cellSize);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawGrid(g);
    }
}
