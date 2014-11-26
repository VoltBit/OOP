package oop_lab6;

public class Calculator extends RuntimeException{
    public int add(int a, int b){
        //int res = a + b;
        if(a + b < 0 && a > 0 && b > 0 ){
            System.out.println("add");
            throw new OverflowException();
        }
        if(a + b > 0 && a < 0 && b < 0){
            System.out.println("add");
            throw new UnderflowException();
        }
        return a + b;
    }
    public int divide(int a, int b){
        return a / b;
    }
    public int average(int[] a, int size){
        int i,sum = 0,av;
        for(i = 0; i < size; i++)
            sum = add(sum,a[i]);
        av = divide(sum,size);
        return av;
    }
}
