package oop_lab4;

public class OOP_Lab4 {
    
    private static void ex1(){
        Display a = new Display("Greetings!");
        Generator b = new Generator();
        Counter c = new Counter();
        a.execute();
        b.execute();
        c.execute(); c.execute(); c.execute();
    }
    private static void ex2(){
        Stack s = new Stack();
        s.initStack(10);
        s.displayStack();
        
        Queue q = new Queue();
        q.initQueue(10);
        q.displayQueue();
    }
    private static void ex3(){
        
    }
    
    public static void main(String[] args) {
        //ex1();
        //ex2();
        ex3();
    }

}
