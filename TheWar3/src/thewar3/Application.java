package thewar3;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Application implements ISceneNode{
    EventQueue Q = new EventQueue();
    DrawDebugger debug = new DrawDebugger();
    ArrayList<ISceneNode> listeners = new ArrayList<>();
    SceneInfo info;
    PhysicsEngine PhyEn;
    EventHandler evH = new EventHandler();
    Unit selectedUnit = null;
    boolean paused,stopped = true;
    float lastTime = 0, timeSave;
    public Application(){
        this.initInfo();
        this.PhyEn = new PhysicsEngine(listeners, info);
    }
    
    public Application(SceneInfo s){
        this.info = s;
        this.PhyEn = new PhysicsEngine(listeners, info);
    }
    public void initInfo(){
        Vector2d left = new Vector2d(0,0);
        Vector2d right = new Vector2d(300,300);
        this.info = new SceneInfo(7,left,right,50,10,20);
    }

    /**
     * Initializes the physics engine with the listeners array and the 
     * information about the scene (SceneInfo).
     */
    public void initPhyEngine(){
        this.PhyEn = new PhysicsEngine(listeners, info);
    }
    void execute(){
        this.evH.solve(Q.pop());
        while(!stopped){
            this.evH.solve(Q.pop());
        }
    }
    /* Method described in readme */
    void Simulate(){
        while(!paused)
        {
            float time = System.currentTimeMillis();
            float dt = time - this.lastTime;
            this.lastTime = time;
            // compute time between 2 consecutive frames;
            // compute collisions
            // Dispatch events - don't forget about updates ( Update(float dt) ) events
            int i;
            this.PhyEn.simulateCombat(listeners, dt);
            this.PhyEn.sync(this.listeners);
            for(i = 0; i < this.listeners.size(); i++){
                Unit a = PhyEn.searchCollision((Unit)this.listeners.get(i),dt);
                if(a != null){ 
                    ((Unit)this.listeners.get(i)).solveEvent(new CollisionEvent(a));
                }else if(PhyEn.wallBounce(a, dt))
                        ((Unit)this.listeners.get(i)).solveEvent(new CollisionEvent(null));
                /*  lovirea unui zid va fi considerata tot coliziune si va avea
                    parametrul null
                */
                dispacher(dt);
            }              
            //ForEvaluation(); /* nu stiu ce reprezinta aceasta metoda */
        }
    }
    @Override
    public void addListener(ISceneNode n) {
        this.listeners.add(n);
    }

    @Override
    public void delete(ISceneNode n) {
        this.listeners.remove(this.listeners.indexOf(n));
    }

    /**
     * Registers update and select events for all the listeners.
     * @param dt delta time
     */
    @Override
    public void dispacher(float dt) {
        int i;
        for(i = 0; i < this.listeners.size(); i++){
            if( selectedUnit != null && 
                ((Unit)this.listeners.get(i)).equals(selectedUnit)){
            ((Unit)this.listeners.get(i)).solveEvent(new ChangeDirectionEvent());
            selectedUnit = null;
        }
        Vector2d ch = this.PhyEn.getNextPos((Unit)this.listeners.get(i), dt);
        ((Unit)this.listeners.get(i)).solveEvent(new UpdateEvent(dt,ch));
    }
    }

    /**
     * Calls the event handler method "solve" for a given event.
     * @param event
     */
    @Override
    public void solveEvent(IEvent event) {        
        this.evH.solve(event);
    }

    @Override
    public void addEvent(IEvent e) {
        this.Q.push(e);
    }
    private class EventHandler{
        EventHandler(){
        }
        /* solves the events this object can receive */
        private void solve(IEvent event){
            if(event == null){
                Simulate();
            }
            if(event instanceof StartEvent){
                lastTime = 0;
                paused = false;
                stopped = false;
                Simulate();
            }
            if(event instanceof CollisionEvent){
                System.err.println("Undefined behaviour for"
                        + " CollisionEvent");
            }
            if(event instanceof UpdateEvent){
                Simulate();
            }
            if(event instanceof PauseEvent){
                paused = true;
            }
            if(event instanceof ResumeEvent){
                paused = false;
            }
            if(event instanceof ChangeDirectionEvent){
                System.err.println("Undefined behaviour for"
                        + " ChangeDirectionEvent");
            }
            if(event instanceof SelectEvent){
                selectedUnit = PhyEn.getClosest(((SelectEvent)event).selected);  
            }
            if(event instanceof StopEvent){
                stopped = true;
            }
            if(event instanceof DrawEvent){
                debug.start(PhyEn);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
                }
                debug.ref();
            }
        }
    }
}
