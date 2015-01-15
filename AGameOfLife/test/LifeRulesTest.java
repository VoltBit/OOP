import agameoflife.Cell;
import agameoflife.LifeRules;
import agameoflife.State;
import org.junit.Test;
import static org.junit.Assert.*;

public class LifeRulesTest {

    public LifeRulesTest() {
    }
    @Test
    public void underPopulationTest(){
        Integer neighbourCount = 1;
        Cell c = MockingFactory.makeMockCell();
        LifeRules.underPopulationRule(c,neighbourCount);
        assertTrue(c.getState().equals(State.Dead));
        
        neighbourCount = 0;
        LifeRules.underPopulationRule(c, neighbourCount);
        assertTrue(c.getState().equals(State.Dead));
    }
    @Test
    public void liveOnTest(){
        Integer neighbourCount;
        Cell c;
        for(neighbourCount = 2; neighbourCount < 4; neighbourCount++){
            c = MockingFactory.makeMockCell(1,1,State.Dead);
            LifeRules.liveOnRule(c,neighbourCount);
            assertTrue(c.getState().equals(State.Dead));
            c = MockingFactory.makeMockCell(1,1,State.Alive);
            LifeRules.liveOnRule(c,neighbourCount);
            assertTrue(c.getState().equals(State.Alive));
        }
    }
    @Test
    public void checkOverPopulation(){
        Integer neighbourCount;
        Cell c;
        for(neighbourCount = 4; neighbourCount < 9; neighbourCount++){
            c = MockingFactory.makeMockCell();
            LifeRules.liveOnRule(c,neighbourCount);
            assertTrue(c.getState().equals(State.Dead));
        }
    }
    @Test
    public void checkBirthRule(){
        Integer neighbourCount = 3;
        Cell c = MockingFactory.makeMockCell(); 
        LifeRules.birthRule(c,neighbourCount);
        assertTrue(c.getState().equals(State.Alive));
    }
    
    /**
     * End-to-end test for life rules. Checks two specific inputs - for an alive
     * cell with 5 neighbours and for a dead one with 3 neighbours.
     */
    @Test
    public void checkGetNextState(){
        Integer neighbours = 5;
        Cell c;
        State nextState;
        c = MockingFactory.makeMockCell(0, 0, State.Alive);
        nextState = LifeRules.getNextState(c, neighbours);
        assertTrue(nextState.equals(State.Dead));
        neighbours = 3;
        c = MockingFactory.makeMockCell(0, 0, State.Alive);
        nextState = LifeRules.getNextState(c, neighbours);
        assertTrue(nextState.equals(State.Alive));
    }    
}