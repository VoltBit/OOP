package thewar3;

public class UpdateEvent implements IEvent{
    float dt;
    Vector2d pos;
    public UpdateEvent(float dt){
        this.dt = dt;
        this.pos = null;        
    }
    public UpdateEvent(float dt, Vector2d pos){
        this.dt = dt;
        this.pos = pos;
    }
}
