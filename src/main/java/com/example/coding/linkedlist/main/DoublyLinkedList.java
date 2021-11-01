package com.example.coding.linkedlist.main;

public class DoublyLinkedList {
    public DoublyLink first;
    public DoublyLink last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void displayList() {
        DoublyLink current = first;
        System.out.println("============");

        while (current != null) {
            System.out.println("{ " + current.data + " }");
            current = current.next;
        }
    }

    public void insertFirst(int value) {
        DoublyLink newLink = new DoublyLink(value);

        if (!isEmpty()) {
            newLink.next = first;
            newLink.previous = null;
            first.previous = newLink;
            first = newLink;
        } else {
            first = newLink;
            last = newLink;
        }
    }

    public void insertLast(int value) {
        DoublyLink newLink = new DoublyLink(value);

        if (!isEmpty()) {
            last.next = newLink;
            newLink.previous = last;
            last = newLink;
        } else {
            first = newLink;
            last = newLink;
        }
    }

    public void insertAfter(int value, int newValue) {
        DoublyLink newLink = new DoublyLink(newValue);
        DoublyLink current = first;

        while (current != null && current.data != value) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Key not found");
        } else {

            if (current == last) {
                last.next = newLink;
                newLink.previous = last;
                last = newLink;
            } else {

                newLink.next = current.next;
                current.next.previous = newLink;
                newLink.previous = current;
                current.next = newLink;
            }
        }

    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);

        list.displayList();

        list.insertAfter(2,4);

        list.displayList();

        list.insertLast(10);

        list.displayList();

        list.insertAfter(10,11);

        list.displayList();

    }
}
