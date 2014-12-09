package thewar2.events;

public interface IEvent {
    public Object getSource();
    @Override
    public String toString();
}
