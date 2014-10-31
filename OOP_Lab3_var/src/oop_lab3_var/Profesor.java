package oop_lab3_var;

public class Profesor extends Persoana{
    String materie;
    Profesor(){
        super();
    }
    Profesor(String nume, String x){
        super(nume);
        this.materie = x;
    }
    @Override
    public String toString(){
        return "Profesor: " + this.nume + ", " + this.materie;
    }
    public String preda(){
        return this.nume + " preda";
    }
}
