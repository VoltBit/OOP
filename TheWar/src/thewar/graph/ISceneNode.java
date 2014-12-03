package thewar.graph;

import thewar.IEvent;

public interface ISceneNode {
    void addListener(ISceneNode n);
    void delete(ISceneNode n);
    void dispacher();
    void solveElement(IEvent e);
    void addEvent(IEvent e);
    Object getContent();
    int edgeCount();
}
