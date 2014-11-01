package oop_lab4;

public class Counter implements Task{
    public int counter;
    Counter(){
        counter = 0;
    }
    @Override
    public void execute(){
        counter++;
        System.out.println("Counter value: " + counter);
    }
}
