package oop_lab2;

import java.util.Random;


public class Tests {
    
    public static void matrixFill(){
        int i,j;
        int[][] m = new int[100][100];
        Random randomGenerator = new Random();
        for(i = 0; i < 100; i++)
            for(j = 0; j < 100; j++)
                m[i][j] = randomGenerator.nextInt(100);
    }
    
    public static void makeIntegerOne(){
       Integer a = new Integer(2+3);
    }
    
    public static void makeIntegerTwo(){
       Integer a = 2+3;
    }
    
    public static void speedTest(){
        long start;
        /*  cand apelez o metoda dintr-o clasa intr-o 
            alta metoda din aceeasi clasa este mai bine
            sa scriu doar metoda sau sa scriu si clasa in fata
        ex: matrixFill() vs. Tests.matrixFill()
        */
        System.out.print("Matrix [100][100] fill: ");
        start = System.nanoTime();
        Tests.matrixFill();
        System.out.println(System.nanoTime() - start);
        
        System.out.print("[1]: ");
        start = System.nanoTime();
        Tests.makeIntegerOne();
        System.out.println(System.nanoTime() - start);
        
        System.out.print("[2]: ");
        start = System.nanoTime();
        Tests.makeIntegerTwo();
        System.out.println(System.nanoTime() - start);
    }
}
