package oop_lab4;

import java.util.ArrayList;

public class Stack extends MemStruct{// implements Container{
    ArrayList a = new ArrayList();
    public void test(){
        int i;
        for(i = 0; i < 10; i++){
            a.add(i);
        }
        for(i = 0; i < 10; i++){
            System.out.println(a.get(i));
        }
    }
}
