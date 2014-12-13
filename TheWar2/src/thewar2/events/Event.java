package thewar2.events;

public class Event implements IEvent {

    public int type;
    public String name;
    public Event(){
        this.name = "default";
        this.type = 0;
    }
    @Override
    public Object getSource() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
