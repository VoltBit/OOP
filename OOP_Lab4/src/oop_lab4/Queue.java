package oop_lab4;

import java.util.ArrayList;

public class Queue extends MemStruct implements Container{
    ArrayList a = new ArrayList();
    public void initQueue(int elementCount){
        a = this.genStruct(elementCount);
    }
    
    public void displayQueue(){
        System.out.println("Queue: ");
        MemStruct.displayStruct(a);
    }
    
    @Override
    public void push(Task task){
        
    }
}
