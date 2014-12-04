package graphimmplement.graph;

public interface Vertex {
    public Object getContent();
    public Vertex getParent();
    @Override
    public String toString();
}
