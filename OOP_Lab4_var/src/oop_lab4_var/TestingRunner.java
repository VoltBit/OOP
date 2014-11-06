package oop_lab4_var;


public class TestingRunner extends AbstractTaskRunner {
    protected void action(Task task){
    
    }
    Task test[] = generateTask(10);
    int i;
    CountTaskRunner ttt = new CountTaskRunner();

    public void display(){
        executeAll();
            System.out.println("");
    ttt.action(test[0]);
    }
}
