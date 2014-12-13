package thewar2.events;

import thewar2.scenegraph.SceneNode;

public class EventHandler {
    public void solveEvent(Event event, SceneNode node){
        switch(event.type){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            default:
                System.err.println("Unknown event.");
                break;
        }
    }
}
