package oop_lab12;

public class Counter {
    Integer counter = 0;
    public void inc(){
        while(this.counter < 1000000)
        this.counter++;
    }
}
