package thewar2.scenegraph;

import thewar2.events.IEvent;

public interface ISceneNode {
    void addListener(ISceneNode n);
    void delete(ISceneNode n);
    void dispacher();
    void solveElement(IEvent e);
    void addEvent(IEvent e);
    
}