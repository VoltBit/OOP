package oop_lab4_var;

import java.util.Date;

public class PrintTaskRunner extends AbstractTaskRunner {
    protected void action(Task task){
        Date date = new Date();
        //task.execute();
        System.out.println(date);
    }
}
