package thewar2.scenegraph;

import thewar2.events.Event;
import thewar2.events.IEvent;

public interface ISceneNode {
    void addListener(Event ev,ISceneNode n);
    void delete(ISceneNode n);
    void dispacher(IEvent ev);
    void dispacher();
    void solveElement(IEvent e);
    void addEvent(IEvent e);
    
}