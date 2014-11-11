package oop_lab5;

/* Internal classes (nested) */
public class OOP_Lab5 {

    private static void ex1(){
        int elementCount = 10;
        Person list[];
        list = Utils.listGen(10);
        Utils.sort_1(list, elementCount);
        Utils.display(list, elementCount);
    }
    public static void main(String[] args) {
        ex1();
    }

}
