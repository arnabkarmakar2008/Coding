package com.example.coding.linkedlist;

import com.example.coding.linkedlist.main.DoubleEndedLinkedList;

public class QueueList {
    DoubleEndedLinkedList list;

    public QueueList() {
        this.list = new DoubleEndedLinkedList();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void insert(int value) {
        list.insertLast(value);
    }

    public int delete() {
        return list.deleteFirst();
    }

    public void displayQueue() {
        System.out.println("=============");
        list.displayList();
    }

    public static void main(String[] args) {
        QueueList queue = new QueueList();
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.displayQueue();
        queue.delete();
        queue.displayQueue();
    }
}
