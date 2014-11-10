package oop_lab5;

import java.util.Random;

/* Internal classes (nested) */
public class OOP_Lab5 {

    private static void ex1(){
        String names[] = {
            "Andrei","Alin","Vlad","Stefan","Razvan","Calin","Radu","Octavian"};
        int elementCount = 10,i;
        Person list[] = new Person[100];
        Person aux = new Person();
        
        /* generate a Student list */
        Random rand = new Random();
        for(i = 0; i < elementCount; i++){
            list[i] = new Student(names[Math.abs(rand.nextInt()%8)],
                    Math.abs(rand.nextInt()%11));
            //System.out.println(list[i].name + ": " + ((Student)list[i]).getGrade());
        }
        System.out.println();
        
        /* Mr Bubbles */
        boolean check;
        do{
            check = false;
            for(i = 0; i < elementCount - 1; i++){
                if(Person.compare(list[i],list[i+1]) > 0){
                    aux = list[i];
                    list[i] = list[i+1];
                    list[i+1] = aux;
                    check = true;
                }
            }
        }while(check);
        
        
        for(i = 0; i < elementCount; i++){
            System.out.println(list[i].name + ": " + ((Student)list[i]).getGrade());
        }
    }
    public static void main(String[] args) {
        ex1();
    }

}
