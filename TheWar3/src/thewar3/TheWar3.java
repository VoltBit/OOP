package thewar3;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TheWar3 {

    public static void display(Application a){
        int i;
        for(i = 0; i < a.listeners.size(); i++){
            System.out.println(a.listeners.get(i).toString());
        }
    }
    public static void makeArmy(int unitCounter, Application A, char color){
        int i;
        Random rand = new Random(); 
        for(i = 0; i < unitCounter; i++){
            Vector2d a = new Vector2d(rand.nextFloat() * 1000 % A.info.dreaptaJos.x,
                    rand.nextFloat() * 1000 % A.info.dreaptaJos.y);
            float length = (float)Math.sqrt(a.x * a.x + a.y * a.y);
            Vector2d b = new Vector2d(a.x / length, a.y / length);
            Unit unit = new Unit(a, b, 30, 100, 10, color);
            A.addListener(unit);
            unit.addListener(A);
        }
        
    }
    
    public static void test2(Application App) throws InterruptedException{
        SceneInfo info = new SceneInfo(10,new Vector2d(0,0),new Vector2d(500,500),50,10,50);
        App.info = info;
        makeArmy(100, App, 'r');
        makeArmy(100, App, 'b');
        App.addEvent(new StartEvent());
        App.addEvent(new DrawEvent());
        App.initPhyEngine();
        //App.addEvent(new StopEvent());
        App.execute();
        //display(App);
    }
    
    public static void test1(Application App) throws InterruptedException{
        DrawDebugger debug = new DrawDebugger();
        SceneInfo info = new SceneInfo(10,new Vector2d(0,0),new Vector2d(500,500),50,10,50);
        App.info = info;
        makeArmy(200, App, 'r');
        makeArmy(200, App, 'b');
        App.initPhyEngine();
        App.PhyEn.placeUnits();
        debug.start(App.PhyEn);
        Thread.sleep(500);
        
        //App.PhyEn.moveUnit(null, dt);
        App.PhyEn.simulateCombat(App.listeners,1000);
        
        //App.PhyEn.printGrid();
        debug.ref();
        //debug.start(App.PhyEn);
    }
    public static void main(String[] args) throws InterruptedException {
        Application App = new Application();
        test1(App);
        //test2(App);
    }

}
