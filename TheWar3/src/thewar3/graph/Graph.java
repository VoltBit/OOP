package thewar3.graph;

import java.util.LinkedList;
import thewar3.Vector2d;

public class Graph extends AbstractGraph{
    
    int nodeCounter;
    public enum VertexState{
        White, Gray, Black
    }
    public Graph(int nodes){
        this.nodeList = new LinkedList();
        this.edgeLists = new LinkedList[nodes];
        this.maxNodes = nodes;
        this.nodeCounter = 0;
        this.origin = null;
    }
    
    public boolean check(Vertex a){
        return a!= null;
    }
    
    public boolean isEdge(int a, int b){
        if(edgeLists[a] == null || edgeLists[b] == null) return false;
        return edgeLists[a].isEmpty() && 
                edgeLists[((GraphVertex)nodeList.get(a)).label].indexOf(nodeList.get(b)) != -1;
    }
    
    public boolean isEdge(Vertex a, Vertex b){
        if(edgeLists[((GraphVertex)a).label] == null ||
                nodeList.get(((GraphVertex)b).label) == null )return false;
        return edgeLists[((GraphVertex)a).label].isEmpty() &&
                edgeLists[((GraphVertex)a).label].indexOf(b) != -1;
    }
    
    @Override
    public void BFS(Vertex origin){
        
    }
    
    @Override
    public void DFS(Vertex start){
        int i;
        VertexState state[] = new VertexState[this.nodeCounter];
        for(i = 0; i < this.nodeCounter; i++){
            state[i] = VertexState.White;
        }
        runDFS(((GraphVertex)start).label,state);
    }
    public void DFS(int start){
        int i;
        String output = new String();
        VertexState state[] = new VertexState[this.nodeCounter];
        for(i = 0; i < this.nodeCounter; i++){
            state[i] = VertexState.White;
        }
        runDFS(start,state);
    }
    public void runDFS(int current, VertexState[] state){
        state[current] = VertexState.Gray;
        int i;
        for(i = 0; i < this.nodeCounter; i++){
            if(isEdge(current,i) && state[i] == VertexState.White){
                runDFS(i,state);
            }
        }
        state[current] = VertexState.Black;
        System.out.println("Current node: " + current);
        System.out.println("Total number of nodes: " + this.nodeCounter);
        for(i = 0 ; i< this.nodeCounter; i++){
            System.out.print(((GraphVertex)(this.nodeList.get(i))).label + " ");
            if(edgeLists[i] != null)
                System.out.println(edgeLists[i].toString());
        }
    }
    /**
     * Adds a vertex in current graph. Arguments received are the 
     * parent node (if it is the origin/root parent is null) and
     * the content of the node (which can also be null).
     * @param parent
     * @param content
     */
    @Override
    public void addVertex(Vertex parent, Object content) {
        GraphVertex aux = new GraphVertex((GraphVertex)parent,content,nodeCounter);
        edgeLists[((GraphVertex)aux).label] =  new LinkedList();
        nodeList.add(aux);
        addEdge(aux,parent);
        nodeCounter++;
    }
    public void addVertex(int parent, Object content) {
        
        GraphVertex aux = new GraphVertex((GraphVertex)nodeList.get(parent),content,nodeCounter);
        edgeLists[((GraphVertex)aux).label] =  new LinkedList();
        nodeList.add(aux);
        if(nodeCounter == 0){
            this.origin = aux;
            //edgeLists[0].add(aux);
            nodeCounter++;
            return;
        }
        addEdge(aux,(Vertex)nodeList.get(parent));
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
            if(this.origin == null){
                this.origin = a;
            }
            System.out.println("test1");
            return;
            /* added the first node */
        }
        if(check(a) && check(a)){
            System.out.print(a);
            System.out.print( " -> " + ((GraphVertex)a).label + "; ");
            System.out.print(b);
            System.out.println( " -> " + ((GraphVertex)b).label);
            if(edgeLists[((GraphVertex)a).label] == null){
                edgeLists[((GraphVertex)a).label] = new LinkedList();
                System.out.println("?!");
            }
            if(edgeLists[((GraphVertex)b).label] == null){
                edgeLists[((GraphVertex)b).label] = new LinkedList();
                System.out.println("?!");
            }
            edgeLists[((GraphVertex)a).label].add(b);
            edgeLists[((GraphVertex)b).label].add(a);
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
