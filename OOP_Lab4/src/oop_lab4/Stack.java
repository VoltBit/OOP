package oop_lab4;

public class Stack extends MemStruct implements Container{

    public void initStack(int elementCount){
        this.a = this.genStruct(elementCount);
    }
    
    public void displayStack(){
        System.out.println("Stack: ");
        MemStruct.displayStruct(a);
    }
    
    @Override
    public Task pop(){
        int index = a.size()-1;
        Object aux = a.get(index);
        a.remove(index);
        return (Task)aux;
    }
}