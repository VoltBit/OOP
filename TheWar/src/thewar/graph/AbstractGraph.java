package thewar.graph;

import thewar.list.List;

public abstract class AbstractGraph {
    List[] edgeLists;
    public abstract void addEdge(Vertex a, Vertex b);
    public abstract void addVertex(Object o);
    public abstract void getVertex(Object o);
    public abstract void BFS(Vertex origin);
    public abstract void DFS(Vertex origin);
}
