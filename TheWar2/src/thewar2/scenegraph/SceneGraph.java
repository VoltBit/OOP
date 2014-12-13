package thewar2.scenegraph;

import java.util.LinkedList;
import thewar2.Army;
import thewar2.Unit;
import thewar2.Vector2d;
import thewar2.graph.AbstractGraph;
import thewar2.graph.Vertex;

public class SceneGraph{
    InnerGraph SG;

    public SceneGraph(int nodeCount) {
        this.SG = new InnerGraph(nodeCount);
        /* make the root: army controler */
        this.SG.addVertex(null, null);
        /*  make the two main army nodes
            red army: node 1
            blue army: node2
        */
        Army redArmy = new Army();
        this.SG.addVertex(0, redArmy);
        Army blueArmy = new Army();
        this.SG.addVertex(0, blueArmy);
    }

    /**
     * Adds a unit to the SceneGraph.
     * @param u : unit object to be inserted in a node.
     */
    public void addUnit(Unit u){
        if(u.getColour() == 'r')
            this.SG.addVertex(1, u);
        else
            this.SG.addVertex(2, u);
    }
    public SceneNode getArmyNode(char colour){
        if(colour == 'r')
            return (SceneNode)this.SG.nodeList.get(1);
        else
            return (SceneNode)this.SG.nodeList.get(2);
    }
    /* graph structure that holds all SceneNodes */
    static class InnerGraph extends AbstractGraph{
        int maxNodes;
        Vertex origin;
        LinkedList nodeList;
        LinkedList[] edgeLists;
        int nodeCounter;
        public enum VertexState{
            White, Gray, Black
        }
        public InnerGraph(int nodes){
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
                    edgeLists[((SceneNode)nodeList.get(a)).label].indexOf(nodeList.get(b)) != -1;
        }

        public boolean isEdge(Vertex a, Vertex b){
            if(edgeLists[((SceneNode)a).label] == null ||
                    nodeList.get(((SceneNode)b).label) == null )return false;
            return edgeLists[((SceneNode)a).label].isEmpty() &&
                    edgeLists[((SceneNode)a).label].indexOf(b) != -1;
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
            runDFS(((SceneNode)start).label,state);
        }
        public void DFS(int start){
            int i;
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
                System.out.print(((SceneNode)(this.nodeList.get(i))).label + " ");
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
            SceneNode aux = new SceneNode((SceneNode)parent,content,nodeCounter);
            edgeLists[((SceneNode)aux).label] =  new LinkedList();
            nodeList.add(aux);
            addEdge(aux,parent);
            nodeCounter++;
        }
        public void addVertex(int parent, Object content) {

            SceneNode aux = new SceneNode((SceneNode)nodeList.get(parent),content,nodeCounter);
            edgeLists[((SceneNode)aux).label] =  new LinkedList();
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
                System.out.print( " -> " + ((SceneNode)a).label + "; ");
                System.out.print(b);
                System.out.println( " -> " + ((SceneNode)b).label);
                if(edgeLists[((SceneNode)a).label] == null){
                    edgeLists[((SceneNode)a).label] = new LinkedList();
                    System.out.println("?!");
                }
                if(edgeLists[((SceneNode)b).label] == null){
                    edgeLists[((SceneNode)b).label] = new LinkedList();
                    System.out.println("?!");
                }
                edgeLists[((SceneNode)a).label].add(b);
                edgeLists[((SceneNode)b).label].add(a);
            }
            else{
                System.err.println("addEdgeError");
            }

        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    } /* end of Graph inner class */
    
    
}
