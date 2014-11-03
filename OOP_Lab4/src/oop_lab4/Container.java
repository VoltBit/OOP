package oop_lab4;

import java.util.ArrayList;

public interface Container {
    Task pop(ArrayList a, int index);
    void push(Task task);
    int size();
    boolean isEmpty();
    void transferFrom(Container container);
}
