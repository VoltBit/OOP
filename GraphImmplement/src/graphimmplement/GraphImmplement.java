package graphimmplement;

import graphimmplement.graph.Graph;
import java.util.Random;
import graphimmplement.graph.Vector2d;

public class GraphImmplement {

    static float limit1 = 1, limit2 = 2;
    static void graphTester(){
        Graph g = new Graph(20);
        int i;
        Random r = new Random();
        g.addVertex(null, null);
        for(i = 0; i < 10; i++){
            Vector2d v;
            v = new Vector2d(r.nextFloat() * 100 / limit1, r.nextFloat() * 100 / limit2);
            g.addVertex(0,v);
        }
        g.DFS(0);
    }
    public static void main(String[] args) {
        graphTester();
    }

}
