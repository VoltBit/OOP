package oop_lab4_var;


static abstract class AbstractDuckTest {
    AbstractDuck PseudoDonald;
    public void getDuckUnderTest(){
        System.out.println(PseudoDonald);
    }
    public void testQuacking(){
        PseudoDonald.quack();
    }
}
