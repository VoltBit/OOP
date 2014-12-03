package thewar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Queue;
import thewar.graph.ISceneNode;
import java.util.Scanner;

public class Application implements ISceneNode{

    @Override
    public void addListener(ISceneNode n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(ISceneNode n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dispacher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void solveElement(IEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addEvent(IEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    Queue Q;
    //PhysicsEngine phyEngine;
    SceneInfo info;
    
    //abstract void ForEvaluation(double dt);
    
    void readInput() throws FileNotFoundException{
        String fileName = new String();
        File file = new File(fileName);
        int count = 0;
        Scanner scan = new Scanner(file);
        while(scan.hasNext()){
            System.out.println(scan.next());
            count++;
        }   
    }
    void generate(){
        
    }
    
    void Simulate(){
        // compute time between 2 consecutive frames;
        // compute collisions
        // Dispatch events - don't forget about updates ( Update(float dt) ) events
        // ForEvaluation(float dt);
    }
    
}
