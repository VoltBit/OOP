package thewar3;

import java.util.LinkedList;

public class EventQueue {
    LinkedList queue = new LinkedList();
    
    public void push(IEvent ev){
        this.queue.add(ev);
    }
    
    public IEvent pop(){
        IEvent aux = (IEvent)this.queue.getLast();
        this.queue.removeLast();
        return aux;
    }
    public boolean hasNext(){
        return this.queue.isEmpty();
    }
}
