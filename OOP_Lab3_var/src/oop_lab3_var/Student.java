package oop_lab3_var;

public class Student extends Persoana{
    int nota;
    Student(){
        super();
    }
    Student(String nume, int x){
        super(nume);
        this.nota = x;
    }
    @Override
    public String toString(){
        return "Student: " + this.nume + ", " + this.nota;
    }
    public String invata(){
        return this.nume + " invata";
    }
    @Override
    public boolean equals(Object a){
        if(this.nota == ((Student)a).nota)
            return this.nume.equals(((Student)a).nume);
        return false;
    }
}
