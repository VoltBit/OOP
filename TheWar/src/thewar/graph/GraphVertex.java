package thewar.graph;

public class GraphVertex implements Vertex {

    Object content;
    @Override
    public Object getContent() {
        return this.content;
    }

    @Override
    public int edgeCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
