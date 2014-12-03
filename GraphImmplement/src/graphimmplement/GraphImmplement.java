package graphimmplement;

import graphimmplement.graph.Graph;
import java.util.Random;
import graphimmplement.graph.Vector2d;

public class GraphImmplement {

    static double limit1 = 1, limit2 = 20;
    static void graphTester(){
        Graph g = new Graph(10);
        int i;
        Random r = new Random();
        g.addVertex(null, null);
        for(i = 0; i < 10; i++){
            Vector2d v;
            v = new Vector2d(r.nextDouble() % limit1, r.nextDouble() % limit2);
            g.addVertex(null,v);
        }
    }
    public static void main(String[] args) {
        graphTester();
    }

}
