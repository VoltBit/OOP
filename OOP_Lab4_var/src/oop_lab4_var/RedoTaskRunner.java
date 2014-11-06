package oop_lab4_var;

public class RedoTaskRunner extends AbstractTaskRunner {
    Task a[] = new Task[100];
    int index = 0;
    protected void action(Task task){
        a[this.index++] = task;
    }
}
