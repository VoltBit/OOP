package agameoflife;

public class LifeRules {
    public static void underPopulationRule(Cell c, Integer neighbours){
        if(neighbours < 2){
            c.setState(State.Dead);
        }
    }
    
    public static void liveOnRule(Cell c, Integer neighbours){
        if(c.getState().equals(State.Dead)){
            return;
        }
        if(neighbours == 2 || neighbours == 3){
            c.setState(State.Alive);
        }
    }
    
    public static void overPopulationRule(Cell c, Integer neighbours){
        if(neighbours > 3){
            c.setState(State.Dead);
        }
    }
    
    public static void birthRule(Cell c, Integer neighbours){
        if(neighbours == 3)
            c.state = State.Alive;
    }
    
    public static State getNextState(Cell c, Integer neighbours){
        Cell aux = new Cell(c.getPosition().x, c.getPosition().y, c.getState());
        underPopulationRule(aux, neighbours);
        liveOnRule(aux, neighbours);
        overPopulationRule(aux, neighbours);
        birthRule(aux, neighbours);
        return aux.getState();
    }
    
}
