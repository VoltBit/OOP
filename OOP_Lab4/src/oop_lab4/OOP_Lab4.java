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
        s.initStack(5);
        s.displayStack();
        System.out.println();
        System.out.print("Pop stack: ");
        System.out.println(s.pop()); System.out.println(s.pop());
        s.displayStack();
        System.out.println("\n");
        
        Queue q = new Queue();
        q.initQueue(5);
        q.displayQueue();
        System.out.println();
        System.out.print("Queue stack: ");
        System.out.println(q.pop()); System.out.println(q.pop());
        q.displayQueue();
        
    }
    
    private static void ex3(){
        
    }
    
    public static void main(String[] args) {
        //ex1();
        ex2();
        //ex3();
    }

}
