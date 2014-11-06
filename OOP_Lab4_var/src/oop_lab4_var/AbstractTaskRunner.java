package oop_lab4_var;

import java.util.Random;

public abstract class AbstractTaskRunner {
    Task v[] = new Task[50];
    int index = 0;
    abstract protected void action(Task task);
    public void addTask(Task task){
        v[index++] = task;
    }
    public void executeAll(){
        int i;
        for(i = 0; i < index; i++){
            v[i].execute();
            action(v[i]);
        }
    }
    public Task[] generateTask(int elementCount){
        int i,aux;
        for(i = 0; i < elementCount; i++){
            Random r = new Random();
            aux = r.nextInt(100) % 3;
            if(aux == 0){
                addTask(new Display("D"));
            } else if(aux == 1){
                addTask(new Generator());
            } else {
                addTask(new Counter());
            }
        }
        return v;
    }
}
