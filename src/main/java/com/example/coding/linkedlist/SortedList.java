package com.example.coding.linkedlist;

import com.example.coding.linkedlist.main.Link;

public class SortedList {
    private Link first;

    public SortedList() {
        this.first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void displayList() {
        if (isEmpty()) {
            System.out.println("=====Empty List=====");
        }

        Link current = first;
        while (current != null) {
            System.out.println("{ " + current.data + " }");
            current = current.next;
        }
    }

    public void insert(int value) {
        Link previous = null;
        Link current = first;
        Link newLink = new Link(value);
        while (current != null && value > current.data) {
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            first = newLink;
        } else {
            previous.next = newLink;
        }

        newLink.next = current;
    }

    public int delete() {
        Link temp = first;
        first = temp.next;
        return temp.data;
    }

    public static void main(String[] args) {
        SortedList sortedList = new SortedList();

        sortedList.insert(10);
        sortedList.insert(20);
        sortedList.insert(5);
        sortedList.insert(50);
        sortedList.displayList();
    }
}
