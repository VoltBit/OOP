package thewar;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import thewar.graph.Graph;

public class TheWar {

    public void input(SceneInfo SI){
        Scanner scan = new Scanner("data.in");
        
    }
    public void testGraph(){
        Graph gr = new Graph();
        SceneInfo SI = new SceneInfo();
        input(SI);
        int i;
        for(i = 0; i < 10; i++){
            Unit u = new Unit();
            gr.addVertex(gr);
        }
    }
    public static void main(String[] args)  
    {  /*
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new PointPanel());
        f.setSize(400,400);
        f.setLocation(200,200);
        f.setVisible(true);  */
    }  
}
