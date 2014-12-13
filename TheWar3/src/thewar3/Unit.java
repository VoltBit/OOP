package thewar3;

import java.util.ArrayList;

public class Unit implements ISceneNode{
    EventHandler evH = new EventHandler();
    Vector2d pos,direction;
    float speed;
    float defence;
    float offence;
    char color; /* 'r' or 'g' */
    public Unit(){
        
    }
    public Unit(Vector2d a, Vector2d b, float c, float d, float e, char f){
        this.pos = a;
        this.direction = b;
        this.speed = c;
        this.defence = d;
        this.offence = e;
        this.color = f;
    }
    
    EventQueue Q = new EventQueue();
    ArrayList<ISceneNode> listeners = new ArrayList<>();
    
    public char getColour(){
        return this.color;
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
    public void dispacher(float dt) {
        
    }

    @Override
    public void solveEvent(IEvent event) {
            evH.solve(event);
    }

    @Override
    public void addEvent(IEvent e) {
        this.Q.push(e);
    }

    @Override
    public String toString() {
        if(this.color == 'r')
            return "[r]".concat(this.pos.toString().concat(String.valueOf(this.defence)));
        else 
            return "[b]".concat(this.pos.toString().concat(String.valueOf(this.defence)));
    }
    private class EventHandler{
        EventHandler(){
        }
        /* solves the events this object can receive */
        private void solve(IEvent event){
            if(event == null){
                
            }
            if(event instanceof StartEvent){
                System.err.println("Undefined behaviour for"
                        + " StartEvent");
            }
            if(event instanceof CollisionEvent){
                direction.x *= (-1);
                direction.y *= (-1);
            }
            if(event instanceof UpdateEvent){
                if(((UpdateEvent)event).pos == null){
                    System.err.println("Wrong update event");
                }
                pos = ((UpdateEvent)event).pos;
            }
            if(event instanceof PauseEvent){
                System.err.println("Undefined behaviour for"
                        + " PauseEvent");
            }
            if(event instanceof ResumeEvent){
                System.err.println("Undefined behaviour for"
                        + " ResumeEvent");
            }
            if(event instanceof ChangeDirectionEvent){
                direction.x *= (-1);
                direction.y *= (-1);
            }
            if(event instanceof SelectEvent){
                System.err.println("Undefined behaviour for"
                        + " SelectEvent");
            }
            if(event instanceof StopEvent){
                System.err.println("Undefined behaviour for"
                        + " StopEvent");
            }
            if(event instanceof DrawEvent){
                System.err.println("Undefined behaviour for"
                        + " DrawEvent");
            }
        }
    }
}