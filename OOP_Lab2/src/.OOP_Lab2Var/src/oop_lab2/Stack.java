package oop_lab2;

public class Stack {
    MyArrayList a = new MyArrayList(10);
    int count = 0;
    boolean check = false;
    public void push(int x){
        check = true;
        a.add(x);
        count++;
    }
    public void pop(){
        if(count < 0){
            check = false;
            return;
        }
        System.out.println(count - 1);
        a.remove(count - 1);
        count--;
    }
    public boolean isEmpty(){
        return check;
    }
    public void displayStack(){
        a.display();
    }
}
