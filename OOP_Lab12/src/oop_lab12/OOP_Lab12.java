package oop_lab12;

public class OOP_Lab12 {
    static void ex1_1() throws InterruptedException{
        //ThreadUser t = new ThreadUser();
        Thread t1,t2,t3,t4;
        t1 = new Thread(new ThreadUser());
        t2 = new Thread(new ThreadUser());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        ThreadUser.display();
    }
    static void ex1_2() throws InterruptedException{
        //ThreadUser t = new ThreadUser();
        Thread t3,t4;
        t3 = new Thread(new SyncThreadUser());
        t4 = new Thread(new SyncThreadUser());
        t3.start();
        t4.start();
        t3.join();
        t4.join();
        SyncThreadUser.display();
    }
    static void makesum(int[][] m){
        int i,j,sum = 0;
        for(i = 0; i < 4; i++){
            for(j = 0; j < 4; j++){
                sum += m[i][j];
            }
        }
        System.out.println("Suma: " + sum);        
        for(i = 0; i < 4; i++){
            for(j = 0; j < 4; j++){
                System.out.print(m[i][j] + " ");
            }
            System.out.println("");
        }
    }
    static void ex2() throws InterruptedException{
        Thread t1,t2,t3,t4;
        int s1,s2,s3,s4;
        int[][] m = new int[4][4];
        t1 = new Thread(new MatrixMaker(m,1));
        //t2 = new Thread(new MatrixMaker(m,2));
        t3 = new Thread(new MatrixMaker(m,3));
        //t4 = new Thread(new MatrixMaker(m,4));
        t1.start();
        //t2.start();
        t3.start();
        //t4.start();
        t1.join();
        //t2.join();
        t3.join();
        //t4.join();
        makesum(m);
    }
    public static void main(String[] args) throws InterruptedException {
        ex1_1();
        ex1_2();
        ex2();
    }
}
