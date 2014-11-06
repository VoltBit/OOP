package oop_lab4;

import java.util.ArrayList;
import java.util.Random;

public class MemStruct implements Container {
    @Override
    public Task pop(ArrayList a, int index){
        return (Task)a.get(index);
    }
    
    @Override
    public void push(Task task){
        
    }

    @Override
    public int size(){
        int x = 0;
        
        return x;
    }
    
    @Override
    public boolean isEmpty(){
        return true;
    }
    
    @Override
    public void transferFrom(Container container){
        
    }
    
    protected ArrayList genIntStruct(int elementCount){
        ArrayList a = new ArrayList();
        int i,aux;
        for(i = 0; i < elementCount; i++){
            Random r = new Random();
            aux = r.nextInt(100) % 3;
            if(aux == 0){
                a.add(new Display("D"));
            } else if(aux == 1){
                a.add(new Generator());
            } else {
                a.add(new Counter());
            }
        }
        return a;
    }
    
    protected static void displayStruct(ArrayList a){
        int i;
        for(i = 0; i < a.size(); i++){
            System.out.print(a.get(i) + " ");
        }
    }
    
}
