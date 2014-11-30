package thewar.graph;

import thewar.list.List;

public class SceneGraph extends AbstractGraph{

    public SceneGraph(int unitCount) {
        Vector2d[] units = new Vector2d[unitCount];
        this.edgeLists = new List[unitCount];
    }

    @Override
    public void addEdge(Vertex a, Vertex b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addVertex(Object o) {
        Vector2d aux = (Vector2d)o;
        
    }

    @Override
    public void getVertex(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void BFS(Vertex origin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DFS(Vertex origin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
