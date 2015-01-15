package oop_lab12;

import java.util.Random;

public class MatrixMaker implements Runnable{
    static Object obj = new Object();
    static int[][] m = new int[40][40];
    public int place;
    public int sum = 0;
    public MatrixMaker(int[][] matrix, int p){
        m = matrix;
        place = p;
    }
    public void builder(){
        int i;
        Random rand = new Random();
        for(i = place - 1; i < 4; i++){
            m[i][place - 1] = Math.abs(rand.nextInt() % 2);
            m[place - 1][i] = Math.abs(rand.nextInt() % 2);
            //System.out.println("[" + i + "][" + place + "]");
            this.sum += m[i][place - 1];
            this.sum += m[place - 1][i];
        }
    }
    public void display(){
        System.out.println("Lini si coloana " + place + ": " + sum);
    }
    @Override
    public void run() {
        synchronized(obj){
            builder();
        }
        display();
    }
}
