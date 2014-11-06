package oop_lab4_var;

public class CountTaskRunner extends AbstractTaskRunner {
    static int counter = 0;
    protected void action(Task task){
        //task.execute();
        counter++;
    }
}
