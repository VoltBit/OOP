package oop_lab12;

public class ThreadUser implements Runnable{
    static Integer count = 0;
    static void display(){
        System.out.println("counter: " + count + " \n");
    }
    @Override
    public void run() {
        int i;
        for(i = 0; i < 1000000; i++)
            count++;
    }
}
