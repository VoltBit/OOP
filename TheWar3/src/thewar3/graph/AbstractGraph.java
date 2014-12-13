package thewar3.graph;

import java.util.LinkedList;

public abstract class AbstractGraph {
    int maxNodes;
    Vertex origin;
    LinkedList nodeList;
    LinkedList[] edgeLists;
    public abstract void addEdge(Vertex a, Vertex b);
    public abstract void addVertex(Vertex parent, Object content);
    public abstract void getVertex(Object o);
    public abstract void BFS(Vertex origin);
    public abstract void DFS(Vertex origin);
    @Override
    public abstract String toString();
}
