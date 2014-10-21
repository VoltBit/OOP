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
    
    public static void main(String[] args) {
        
        /* Ex1 */
        //OOP_Lab2.ex1();
        /* Ex2 */
        
        /* Ex3 */
        OOP_Lab2.ex3();
        
    }
    
}
