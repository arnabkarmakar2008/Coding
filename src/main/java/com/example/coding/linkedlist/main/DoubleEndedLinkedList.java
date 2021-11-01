package com.example.coding.linkedlist.main;

public class DoubleEndedLinkedList {
    public Link first;
    public Link last;

    public DoubleEndedLinkedList() {
        last = null;
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int value) {
        Link link = new Link(value);

        if (isEmpty()) {
            first = link;
            last = link;
        } else {
            link.next = first;
            first = link;
        }

    }

    public void insertLast(int value) {
        Link link = new Link(value);
        if (isEmpty()) {
            first = link;
            last = link;
        } else {
            last.next = link;
            last = link;
        }
    }

    public int deleteFirst() {
        Link current = first;

        if (first == last) {
            int data = current.data;
            first = null;
            last = null;
            return data;
        } else {
            first = current.next;
            return current.data;
        }
    }

    public void displayList() {
        Link current = first;

        while (current != null) {
            current.displayLink();
            current = current.next;
        }

    }

}
