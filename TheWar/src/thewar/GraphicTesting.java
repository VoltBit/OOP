package thewar;
import java.awt.*;  
import java.awt.event.*;  
import java.awt.geom.*;  
import java.util.*;  
import java.util.List;  
import javax.swing.*;  
/*  most of the code was copied from 
    http://www.coderanch.com/t/338737/GUI/java/draw-points-Java
*/
   
class PointPanel extends JPanel  
{  
    List pointList;  
    Color selectedColor;  
    Ellipse2D selectedPoint;  
   
    public PointPanel()  
    {  
        pointList = new ArrayList();  
        selectedColor = Color.red;  
        addMouseListener(new PointLocater(this));  
        setBackground(Color.white);  
    }  
   
    @Override
    protected void paintComponent(Graphics g)  
    {  
        super.paintComponent(g);  
        Graphics2D g2 = (Graphics2D)g;  
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,  
                            RenderingHints.VALUE_ANTIALIAS_ON);  
        Ellipse2D e;  
        Color color;  
        for(int j = 0; j < pointList.size(); j++)  
        {  
            e = (Ellipse2D)pointList.get(j);  
            if(e == selectedPoint)  
                color = selectedColor;  
            else  
                color = Color.blue;  
            g2.setPaint(color);  
            g2.fill(e);  
        }  
    }  
   
    public List getPointList()  
    {  
        return pointList;  
    }  
   
    public void setSelectedPoint(Ellipse2D e)  
    {  
        selectedPoint = e;  
        repaint();  
    }  
   
    public void addPoint(Point p)  
    {  
        Ellipse2D e = new Ellipse2D.Double(p.x - 3, p.y - 3, 4, 4);  
        pointList.add(e);  
        selectedPoint = null;  
        repaint();  
    }  
}  
   
class PointLocater extends MouseAdapter  
{  
    PointPanel pointPanel;  
   
    public PointLocater(PointPanel pp)  
    {  
        pointPanel = pp;  
    }  
   
    @Override
    public void mousePressed(MouseEvent e)  
    {  
        Point p = e.getPoint();  
        boolean haveSelection = false;  
        List list = pointPanel.getPointList();  
        Ellipse2D ellipse;  
        for(int j = 0; j < list.size(); j++)  
        {  
            ellipse = (Ellipse2D)list.get(j);  
            if(ellipse.contains(p))  
            {  
                pointPanel.setSelectedPoint(ellipse);  
                haveSelection = true;  
                break;  
            }  
        }  
        if(!haveSelection)  
            pointPanel.addPoint(p);  
    }  
}  