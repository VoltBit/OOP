package oop_lab6;

import java.util.Random;

public class Main {

    public static void testFunctionX() throws X{
        System.out.println("Throw X?");
        throw new X();
    }
    public static void testFunctionY() throws Y{
        System.out.println("Throw Y?");
        throw new Y();
    }
    public static void testFunctionZ() throws Z{
        System.out.println("Throw Z?");
        throw new Z();
    }

    private static void ex1(){
        try{
            Random rand = new Random();
            if(rand.nextInt() % 3 == 0)
                testFunctionX();
            else 
                if(rand.nextInt() % 3 == 1)testFunctionY();
                else  testFunctionZ();
        }
        catch(X e){
             System.out.println("Yes! X!");
        }
        catch(Y e){
            System.out.println("Yes! Y!");
        }
        catch(Z e){
            System.out.println("Yes! Z!");
        }
        finally{
            System.out.println("Out!");
        }
    }

    private static void ex2(){
        Random rand = new Random();
        try{
            if(rand.nextInt() % 2 == 0)
                ErrorGen.stackOver();
            else ErrorGen.memoryOut();
        }
        catch(Error e){
            System.out.println(e);
        }
    }
    private static void ex3(){
        Calculator calc = new Calculator();
        int[] a = {1,2,3,4,Integer.MAX_VALUE};
        int[] a2 = {-1,-2,Integer.MIN_VALUE};
        
//        try{
//            int[] a = {1,2,3,4,Integer.MAX_VALUE};
//            Random rand = new Random();
//            if(rand.nextInt() % 3 == 0)
//                calc.add(Integer.MAX_VALUE, 1);
//            else if(rand.nextInt() % 3 == 1)
//                calc.divide(1, Integer.MIN_VALUE);
//            else calc.average(a, 5);
//        }
//        catch(RuntimeException e){
//            System.out.println(e);
//        }
//        //calc.add(Integer.MAX_VALUE, 100);
//        //calc.divide(1, Integer.MIN_VALUE);
        calc.average(a, 5);
        //calc.average(a2, 3);
    }
    public static void main(String[] args) {
        //ex1();
        ex2();
        //ex3();
    }
}
