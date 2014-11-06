package oop_lab4;

public class Queue extends MemStruct implements Container{
    
    public void initQueue(int elementCount){
        this.a = this.genStruct(elementCount);
    }
    
    public void displayQueue(){
        System.out.println("Queue: ");
        MemStruct.displayStruct(a);
    }
    
    @Override
    public Task pop(){
        int index = 0;
        Object aux = a.get(index);
        a.remove(index);
        return (Task)aux;
    }
    @Override
    public void transferFrom(Container container){
        while(!container.isEmpty()){
            this.push(container.pop());
            this.pop();
        }
    }
}
