package graphimmplement.graph;

import java.util.LinkedList;

public class Graph extends AbstractGraph{
    
    int nodeCounter;
    public Graph(int nodes){
        this.nodeLists = new LinkedList[nodes];
        this.maxNodes = nodes;
        this.nodeCounter = 0;
        this.origin = null;
    }
    
    public boolean check(Vertex a){
        return a!= null;
    }
    
    @Override
    public void BFS(Vertex origin){
        
    }
    
    @Override
    public void DFS(Vertex origin){
        
    }
    public void DepthFirstSearch(){
        boolean[] marked = new boolean[this.nodeCounter];
        DFS(this.origin);
    }
    /**
     * Adds a vertex in current graph. Arguments received are the 
     * parent node (if it is the origin/root parent is null) and
     * the content of the node (which can also be null).
     * @param parent
     * @param content
     */
    @Override
    public void addVertex(GraphVertex parent, Object content) {
        GraphVertex aux = new GraphVertex(parent,content,nodeCounter);
        addEdge(aux,parent);
        nodeCounter++;
    }

    @Override
    public void getVertex(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Adds an edge between the two nodes received as parameters.
     * @param a
     * @param b
     */
    @Override
    public void addEdge(Vertex a, Vertex b) {
        if(!check(b)){
            if(this.origin == null)
                this.origin = a;
            return;
            /* added the first node */
        }
        if(check(a) && check(a)){
            nodeLists[((GraphVertex)a).label].add(b);
            nodeLists[((GraphVertex)b).label].add(a);
        }
        else{
            System.err.println("addEdgeError");
        }

    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
