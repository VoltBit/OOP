package oop_lab3_var;

public class Main {
    static void ex1_2(){
        Student s = new Student("Andrei",10);
        Profesor p = new Profesor("Sever","TS");
        System.out.println(p.toString());
        System.out.println(s.toString());
    }
    static void ex3(){
        Student a = new Student("Student1",10);
        Student b = new Student("Student1",10);
        if(a.equals(b)){
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
    static Persoana[] ex4(){
        Persoana[] v = new Persoana[10];
        int i;
        for(i = 0; i < 6; i+=2){
            v[i] = new Student("Student",10);
            v[i+1] = new Profesor("Profesor","???");
        }
        for(i = 0; i < 6; i++){
            //if( v[i] instanceof Student){
                System.out.println(v[i].toString());
            //}
           // if( v[i] instanceof Profesor){
            //    System.out.println(v[i].toString());
            //}
        }
        return v;
    }

    static void ex5(){
        Persoana[] v = ex4();
        int i;
        for(i = 0; i < 6; i++){
            if( v[i] instanceof Student){
                System.out.println(((Student)v[i]).invata());
            }
            if( v[i] instanceof Profesor){
                System.out.println(((Profesor)v[i]).preda());
            }
        }
    }

    public static void main(String[] args) {
        ex1_2();
        ex3();
        //ex4();
        ex5();
    }

}
