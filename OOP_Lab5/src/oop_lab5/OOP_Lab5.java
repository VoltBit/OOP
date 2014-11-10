package oop_lab5;

import java.util.Random;

/* Internal classes (nested) */
public class OOP_Lab5 {

    private static void ex1(){
        String names[] = {
            "Andrei","Alin","Vlad","Stefan","Razvan","Calin","Radu"};
        int elementCount = 10,i;
        Person list[] = new Person[100];
        
        /* generate a Student list */
        Random rand = new Random();
        for(i = 0; i < elementCount; i++){
            list[i] = new Student(names[Math.abs(rand.nextInt()%7)],
                    Math.abs(rand.nextInt()%11));
            System.out.println(list[i].name + ": " + ((Student)list[i]).getGrade());
        }
        System.out.println();
        
    }
    public static void main(String[] args) {
        ex1();
    }

}
