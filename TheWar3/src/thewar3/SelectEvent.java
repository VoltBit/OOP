package thewar3;

public class SelectEvent implements IEvent{
    Vector2d selected;
    SelectEvent(Vector2d v){
        this.selected = v;
    }
}
