package oop_lab4_var;

public class Display implements Task {
    
    String out;
    Display(String x){
        this.out = x;
    }
    @Override
    public void execute(){
        System.out.println(this.out);
    }
}
