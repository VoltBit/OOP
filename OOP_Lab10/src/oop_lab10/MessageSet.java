package oop_lab10;

import java.util.ArrayList;
import java.util.Iterator;

public class MessageSet {
    /* Subject */
    private ArrayList<String> messageList = new ArrayList();
    ArrayList<Observer> managers = new ArrayList();
    public void attach(Observer disp){
        this.managers.add(disp);
    }
    public void callUpdate(String s){
        Iterator<Observer> it = managers.iterator();
        while(it.hasNext()){
            it.next().update(s);
        }
    }
    public void removeObserver(ViewRomanian disp){
        this.managers.remove(disp);
    }
    public void addMessage(String msg){
        this.messageList.add(msg);
        callUpdate(msg);
    }
}
