package com.example.coding.linkedlist;

import com.example.coding.linkedlist.main.DoubleEndedLinkedList;
import com.example.coding.linkedlist.main.Link;
import com.example.coding.linkedlist.main.LinkedList;

public class DoubleEndedMainApp {
    public static void main(String[] args) {
        DoubleEndedLinkedList list = new DoubleEndedLinkedList();

        list.insertFirst(1);
        list.deleteFirst();
        list.insertFirst(1);
        list.insertFirst(2);
        System.out.println("=======");
        list.displayList();
        System.out.println("=======");
        list.deleteFirst();
        list.displayList();

    }
}
