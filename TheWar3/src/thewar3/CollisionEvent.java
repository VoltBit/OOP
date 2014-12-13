package thewar3;

public class CollisionEvent implements IEvent{
    Object u;
    public CollisionEvent(Object unit) {
        this.u = unit;
    }
    
}
