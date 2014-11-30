package thewar.graph;

import thewar.IEvent;

public interface ISceneNode {
    void AddListener(ISceneNode n);
    void Delete(ISceneNode n);
    void Dispacher();
    void SolveElement(IEvent e);
    void AddEvent(IEvent e);
    
}
