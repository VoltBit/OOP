package thewar2.scenegraph;

import java.util.HashMap;
import java.util.LinkedList;
import thewar2.events.Event;
import thewar2.events.EventHandler;
import thewar2.events.IEvent;
import thewar2.graph.Vertex;

/**
 * 
 * The array register keeps the type of an event that a listener can
 * receive.
 * 
 */
public class SceneNode implements ISceneNode,Vertex{

    final int MAX_EVENTS = 9;
    EventHandler handler = new EventHandler();
    int label,register[];
    Object content;
    SceneNode parent;
    LinkedList events, listeners;
    int listenerCounter = 0;
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
    public void addListener(Event ev,ISceneNode n) {
        if(events.contains(ev)){
            this.register[listenerCounter++] = ev.type;
            listeners.add(n);
        }
        else{
            System.err.println("Event will never happen.");
        }
    }

    @Override
    public void delete(ISceneNode n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dispacher(IEvent ev) {
        int i;
        for(i = 0 ; i < listeners.size(); i++){
            if(register[i] == ((Event)ev).type)
                ((SceneNode)listeners.get(i)).solveElement(ev);
        }
    }

    @Override
    public void dispacher() {
        int i,j;
        for(j = 0 ; j < events.size(); j++){
            for(i = 0 ; i < listeners.size(); i++){
                if(register[i] == ((Event)events.get(j)).type)
                    ((SceneNode)listeners.get(i)).solveElement((IEvent)events.get(j));
            } 
        }
    }
    
    @Override
    public void solveElement(IEvent e) {
        handler.solveEvent((Event)e,this);
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
    @Override
    public String toString(){
        if(this.content == null)return "Empty node - root";
        return this.content.toString();
    }
}
