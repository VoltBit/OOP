package oop_lab2;

import java.util.Random;

public class Main {

    private static void ex1(){
        MyArrayList a = new MyArrayList(1);
        int i;
        for(i = 0; i < 10; i++)
           a.add(i);
        a.display();
        if(a.contains(3))System.out.println("Yes");
        else System.out.println("No");
        System.out.println("Size: " + a.size());
        System.out.println("Index nr 3: " + a.get(4));
        a.remove(2);
        a.display();
    }
    private static void ex2(){
        System.out.println();
        System.out.println("Ex2________________");
        Stack s = new Stack();
        Random rand = new Random();
        int i;
        for(i = 0; i < 20; i++)
            s.push(rand.nextInt(10));
        s.displayStack();
        System.out.println();
        s.pop();
        s.displayStack();
    }
    public static void main(String[] args) {
        ex1();
        ex2();
    }

}
