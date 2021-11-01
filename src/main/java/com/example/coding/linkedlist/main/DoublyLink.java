package com.example.coding.linkedlist.main;

public class DoublyLink {
    public int data;
    public DoublyLink next;
    public DoublyLink previous;

    public DoublyLink(int data) {
        this.data = data;
    }

    public void displayLink() {
        System.out.println("{ " + data + " }");
    }
}
