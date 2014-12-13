package thewar3;

public interface ISceneNode {
    void addListener(ISceneNode n);
    void delete(ISceneNode n);
    void dispacher(float dt);
    void solveEvent(IEvent e);
    void addEvent(IEvent e);
    @Override
    String toString();
}