package oop_lab4_var;

public class Main {

    static void ex1(){
        
        
        ConcreteDuckTest duckTest = new ConcreteDuckTest();
        AbstractDuckTest absDuckTest = new ConcreteDuckTest();

        duckTest.testFlying();
        absDuckTest.getDuckUnderTest();
        absDuckTest.testQuacking();

    }
    static void ex2(){
        Display a = new Display("Greetings!");
        Generator b = new Generator();
        Counter c = new Counter();
        a.execute();
        b.execute();
        c.execute(); c.execute(); c.execute();
    }
    static void ex3_4(){
        TestingRunner obj = new TestingRunner();
        obj.display();
    }
    public static void main(String[] args) {
        ex1();
        ex2();
        ex3_4();
    }

}
