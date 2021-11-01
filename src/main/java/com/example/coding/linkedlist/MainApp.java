package com.example.coding.linkedlist;

import com.example.coding.linkedlist.main.Link;
import com.example.coding.linkedlist.main.LinkedList;

public class MainApp {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertFirst(1);
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(5);
        list.insertFirst(2);
        list.insertFirst(3);
        list.displayList();

        System.out.println("============");

        list.deleteFromPosition(1);
        System.out.println("============");
        list.displayList();

        list.deleteFromPosition(0);
        System.out.println("============");
        list.displayList();

        list.deleteFromPosition(4);
        System.out.println("============");
        list.displayList();

        System.out.println("Linkedlist length :: " + list.lengthRecursion(list.first));

        System.out.println("Get Nth Element :: " + list.getNth(4));

        System.out.println("Get Nth Element From End:: " + list.getNthFromEnd(3));

    }
}
