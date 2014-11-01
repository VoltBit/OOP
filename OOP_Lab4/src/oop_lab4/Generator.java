package oop_lab4;

import java.util.Random;

public class Generator implements Task {
    private Random r;
    private int x;
    Generator(){
        r = new Random();
        x = r.nextInt(100);
    }
    @Override
    public void execute(){
        System.out.println("Numar generat: " + this.x);
    }    
}
