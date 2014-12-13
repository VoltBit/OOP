package thewar3;

import java.awt.*;  
import java.awt.geom.*;  
import java.text.NumberFormat;  
import java.util.*;  
import java.util.List;  
import javax.swing.*;  
   
public class DrawDebugger  
{  
    static JFrame f;
    public void start(PhysicsEngine PE)  
    {  
        f = new JFrame("Dots total war");  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        f.getContentPane().add(new PointGrapher(PE));  
        f.setSize((int)PE.info.dreaptaJos.x,(int)PE.info.dreaptaJos.y);  
        f.setLocation(200,200);  
        f.setVisible(true);
        PE.placeUnits();
        
    }  
    public void ref(){
        f.repaint();
    }
}  
   
class PointGrapher extends JPanel  
{  
    List points;  
    String[] xLabels, yLabels;  
    final int PAD;  
    double xScale ,yScale;  
    NumberFormat nf;  
    PhysicsEngine PE;
    
    public PointGrapher(PhysicsEngine PhyE)  
    {  
        this.PE = PhyE;
        points = new ArrayList();  
        //populatePoints();  
        xLabels = new String[11];  
        yLabels = new String[11];  
        PAD = 20;  
        nf = NumberFormat.getNumberInstance();  
        nf.setMaximumFractionDigits(1);  
        setBackground(Color.white);  
    }  
   
    @Override
    protected void paintComponent(Graphics g)  
    {  
        super.paintComponent(g);  
        Graphics2D g2 = (Graphics2D)g;  
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,  
                            RenderingHints.VALUE_ANTIALIAS_ON);    
        // plot points  
        int i,j,k;
        for(i = 0 ; i < this.PE.numCellX; i++){
            g2.setPaint(Color.black);
            g2.draw(new Line2D.Float(0, this.PE.cellSize * i, this.PE.cellSize * this.PE.numCellX, this.PE.cellSize * i));
            g2.draw(new Line2D.Float(this.PE.cellSize * i, 0, this.PE.cellSize * i, this.PE.cellSize * this.PE.numCellY));
            for(j = 0; j < this.PE.numCellY; j++){
                if(this.PE.Grid[i][j] != null)
                    for(k = 0; k < this.PE.Grid[i][j].size(); k++){
                        if(((Unit)this.PE.Grid[i][j].get(k)).defence > 0)
                        {
                            if(((Unit)this.PE.Grid[i][j].get(k)).color == 'r')
                                g2.setPaint(Color.red);
                            else
                                g2.setPaint(Color.blue);
                            g2.fill(new Ellipse2D.Double(((Unit)this.PE.Grid[i][j].get(k)).pos.x - 2, ((Unit)this.PE.Grid[i][j].get(k)).pos.y - 2, 4, 4));
                        }
                        /*
                            Observatie!
                            Este foarte important ca dimensiunea UnitDistance sa 
                            fie mai mare de sqrt(dim) unde dim este dimensiunea 
                            unitatii, in cazul de fata dim = 4.
                        */
                    }
            }
        }
    } 
}  
