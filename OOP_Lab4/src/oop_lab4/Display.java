package oop_lab4;

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
