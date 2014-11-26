package oop_lab6;

public class ErrorGen {
    public static void stackOver(){
        stackOver();
    }
    public static void memoryOut(){
        char[] a = new char[10];
        int i = 2,n = 11;
        while(true){
            a = new char[i];
            i*=i;
        }
    }
}
