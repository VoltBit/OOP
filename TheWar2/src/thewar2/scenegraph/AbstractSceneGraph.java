package thewar2.scenegraph;

public interface AbstractSceneGraph {
    public abstract void addEdge(SceneNode a, SceneNode b);
    public abstract void addSceneNode(SceneNode parent, Object content);
    public abstract void getSceneNode(Object node);
    public abstract void BFS(SceneNode origin);
    public abstract void DFS(SceneNode origin);
}
