package oldTests;



import agameoflife.Cell;
import agameoflife.LifeRules;
import agameoflife.State;

/**
 * Testing class for the four rules of the game of life.
 */
public class LifeRulesTest extends Test{
    boolean pass;
    public void checkUnderPopulation(){
        pass = true;
        Integer neighbourCount = 1;
        Cell c = MockingFactory.makeMockCell();
        LifeRules.underPopulationRule(c,neighbourCount);
        if(c.getState().equals(State.Alive)){
            pass = false;
        }
        
        neighbourCount = 0;
        LifeRules.underPopulationRule(c, neighbourCount);
        if(c.getState().equals(State.Alive)){
            pass = false;
        }
        if(pass)
            System.out.println("Under-population rule [PASSED]");
        else
            System.out.println("Under-population rule [FAILED]");
    }

    public void checkLiveOn(){
        pass = true;
        Integer neighbourCount;
        Cell c;
        for(neighbourCount = 2; neighbourCount < 4; neighbourCount++){
            c = MockingFactory.makeMockCell(1,1,State.Dead);
            LifeRules.liveOnRule(c,neighbourCount);
            if(c.getState().equals(State.Alive)){
                pass = false;
                break;
            }
            c = MockingFactory.makeMockCell(1,1,State.Alive);
            LifeRules.liveOnRule(c,neighbourCount);
            if(c.getState().equals(State.Dead)){
                pass = false;
                break;
            }
        }
        if(pass)
            System.out.println("Live on rule [PASSED]");
        else
            System.out.println("Live on rule [FAILED]");
    }
    
    public void checkOverPopulation(){
        pass = true;
        Integer neighbourCount;
        Cell c;
        for(neighbourCount = 4; neighbourCount < 9; neighbourCount++){
            c = MockingFactory.makeMockCell();
            LifeRules.liveOnRule(c,neighbourCount);
            if(c.getState().equals(State.Alive)){
                pass = false;
                break;
            }
        }
        if(pass)
            System.out.println("Over-population rule [PASSED]");
        else
            System.out.println("Over-population rule [FAILED]");
    }
    
    public void checkBirthRule(){
        pass = true;
        Integer neighbourCount = 3;
        Cell c = MockingFactory.makeMockCell(); 
        LifeRules.birthRule(c,neighbourCount);
        if(c.getState().equals(State.Dead)){
            pass = false;
        }
        if(pass)
            System.out.println("Birth rule [PASSED]");
        else
            System.out.println("Birth rule [FAILED]");
    }
    
    /**
     * End-to-end test for life rules. Checks two specific inputs - for an alive
     * cell with 5 neighbours and for a dead one with 3 neighbours.
     */
    public void checkGetNextState(){
        pass = true;
        Integer neighbours = 5;
        Cell c;
        State nextState;
        c = MockingFactory.makeMockCell(0, 0, State.Alive);
        nextState = LifeRules.getNextState(c, neighbours);
        if(nextState.equals(State.Alive)){
            pass = false;
        }
        
        neighbours = 3;
        c = MockingFactory.makeMockCell(0, 0, State.Alive);
        nextState = LifeRules.getNextState(c, neighbours);
        if(nextState.equals(State.Dead)){
            pass = false;
        }
        if(pass)
            System.out.println("GetNextState [PASSED]");
        else
            System.out.println("GetNextState [FAILED]");        
    }
    
    @Override
    public void run() {
        this.checkUnderPopulation();
        this.checkLiveOn();
        this.checkOverPopulation();
        this.checkBirthRule();
        this.checkGetNextState();
    }
}
