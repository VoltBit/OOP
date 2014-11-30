package thewar.graph;

import thewar.list.List;

/**
 *
 * @author smith
 */
public class Graph extends AbstractGraph{
    Graph(){
        this.edgeLists = new List[20];
    }
    
    @Override
    public void BFS(Vertex origin){
        
    }
    
    @Override
    public void DFS(Vertex origin){
        
    }

    @Override
    public void addVertex(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getVertex(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addEdge(Vertex a, Vertex b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
