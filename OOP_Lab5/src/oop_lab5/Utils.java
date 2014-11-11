package oop_lab5;

import java.util.Random;

public class Utils {
    static Person list[] = new Person[100];
    static Person[] listGen(int elementCount){
        /* generate a Student list */
        String names[] = {
            "Andrei","Alin","Vlad","Stefan","Razvan","Calin","Radu","Octavian"};
        int i;
        Random rand = new Random();
        
        for(i = 0; i < elementCount; i++){
            list[i] = new Student(names[Math.abs(rand.nextInt()%8)],
                    Math.abs(rand.nextInt()%11));
            //System.out.println(list[i].name + ": " + ((Student)list[i]).getGrade());
        }
        System.out.println();
        return list;
    }
    static void sort_1(Person list[], int elementCount){
        Person aux;
        int i;
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
                } else if(Person.compare(list[i],list[i+1]) == 0){
                    if(Student.compare((Student)list[i],(Student)list[i+1])){
                        aux = list[i];
                        list[i] = list[i+1];
                        list[i+1] = aux;
                        check = true;
                    }
                }
            }
        }while(check);
    }
    
    static void display(Person list[], int elementCount){
        int i;
        for(i = 0; i < elementCount; i++){
            System.out.println(list[i].name + ": " + ((Student)list[i]).getGrade());
        }
    }
    
}
