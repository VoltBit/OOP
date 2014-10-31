package oop_lab3_var;

public class Persoana {
    String nume;
    Persoana(){

    }
    Persoana(String x){
        this.nume = x;
    }
    @Override
    public String toString(){
        return this.nume;
    }
}
