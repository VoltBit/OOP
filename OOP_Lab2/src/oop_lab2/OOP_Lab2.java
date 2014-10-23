package oop_lab2;

import java.util.Scanner;

public class OOP_Lab2 {
    public static void ex1(){
        Point p = new Point(11.2f,14.5f);
        Point.displayPoint(p);
        Scanner fl = new Scanner(System.in);
        float x,y;
        x = fl.nextFloat();
        y = fl.nextFloat();
        p.changeCoords(x,y);
        Point.displayPoint(p);
    }
    
    public static void ex2(){
        
    }
    
    public static void ex3(){
        Tests.speedTest();
    }
    
    public static void ex4(){
        System.out.println("[1]: " + String.valueOf(Tests.memTest(1)));
        System.out.println("[2]: " + String.valueOf(Tests.memTest(2)));
    }
    
    public static void ex5(){
        RandomStringGenerator s = new RandomStringGenerator(10, "wasdqf");
        System.out.println("Alphabet provided: wasdqf");
        s.next();
        System.out.println("Random string: " + s.next());
    }
    
    public static void ex6(){
        PasswordMaker pass = new PasswordMaker("Andrei","Dobre",20);
        System.out.println("Password: " + pass.getPassword());
    }
    
    public static void main(String[] args) {
        
        /* Ex1 */
        //OOP_Lab2.ex1();
        /* Ex2 */
        
        /* Ex3 */
        //OOP_Lab2.ex3();
        /* Ex4 */
        //OOP_Lab2.ex4();
        /* Ex5 */
        //OOP_Lab2.ex5();
        /* Ex6 */
        OOP_Lab2.ex6();
    }
    
}
