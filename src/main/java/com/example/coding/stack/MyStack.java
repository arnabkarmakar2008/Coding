package com.example.coding.stack;

import java.util.ArrayList;
import java.util.List;

public class MyStack<T> {
    int top;
    int size;
    List<T> elements;

    public MyStack(int size) {
        this.top = -1;
        this.size = size;
        elements = new ArrayList<>(size);
    }

    public void push(T element) {
        elements.add(element);
        top++;
    }

    public T pop() {
         return elements.get(top--);
    }

    public T seek() {
        return elements.get(top);
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size-1;
    }
}
