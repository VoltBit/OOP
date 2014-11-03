package oop_lab4;

import java.util.ArrayList;

public class Stack extends MemStruct implements Container{
    ArrayList a = new ArrayList();
    public void initStack(int elementCount){
        a = this.genStruct(elementCount);
    }
    
    public void displayStack(){
        System.out.println("Stack: ");
        MemStruct.displayStruct(a);
    }
    
    @Override
    public void push(Task task){
        
    }
}