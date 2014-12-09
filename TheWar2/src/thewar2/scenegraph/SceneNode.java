package thewar2.scenegraph;

import java.util.LinkedList;
import thewar2.events.IEvent;
import thewar2.graph.Vertex;

public class SceneNode implements ISceneNode,Vertex{

    int label;
    Object content;
    SceneNode parent;
    LinkedList listeners,events;
    SceneNode(SceneNode p, Object c, int l){
        this.label = l;
        this.content = c;
        this.parent = p;
    }
    SceneNode(Object c, int l){
        this.content = c;
        this.label = l;
        this.parent = null;
    }
    SceneNode(int l){
        this.label = l;
        this.content = null;
        this.parent = null;
    }
    @Override
    public void addListener(ISceneNode n) {
        this.listeners.add(n);
    }

    @Override
    public void delete(ISceneNode n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dispacher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void solveElement(IEvent e) {
        
    }

    @Override
    public void addEvent(IEvent e) {
        this.events.add(e);
    }

    @Override
    public Object getContent() {
        return this.content;
    }

    @Override
    public Vertex getParent() {
        return this.parent;
    }
    
    public boolean collisionCheck(){
        
        return false;
    }
}
