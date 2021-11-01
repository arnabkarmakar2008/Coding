package com.example.coding.linkedlist;

import com.example.coding.linkedlist.main.LinkedList;

public class StackList {
    public LinkedList list;

    public StackList() {
        this.list = new LinkedList();
    }

    public void push(int value) {
        list.insertFirst(value);
    }

    public int pop() {
        return list.deleteFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void displayStack() {
        System.out.println("===========");
        list.displayList();
    }

    public static void main(String[] args) {
        StackList stackList = new StackList();
        stackList.push(1);
        stackList.push(2);
        stackList.push(3);
        stackList.push(4);
        stackList.displayStack();

        stackList.pop();
        stackList.displayStack();


    }
}

