package oop_lab4_var;

import java.util.ArrayList;
import java.util.Random;

public abstract class MemStruct{
    ArrayList a = new ArrayList();
    
    public void push(Task task){
        this.a.add(task);
    }

    public int size(){
        return this.a.size();
    }
    
    public boolean isEmpty(){
        return this.a.isEmpty();
    }
    
    protected ArrayList genStruct(int elementCount){
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
            System.out.print((Task)(a.get(i)) + " ");
        }
        System.out.println();
    }
    
}
