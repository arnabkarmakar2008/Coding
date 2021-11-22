package com.example.coding.queue;

public class MainApp {

    public int front, rear, size, capacity;

    public int[] array;

    public MainApp(int capacity) {
        this.capacity = capacity;
        this.front = 0;
        this.size = 0;
        this.rear = capacity - 1;
        array = new int[capacity];
    }

    public boolean isFull () {
        if (size == capacity) {
            return true;
        }

        return false;
    }

    public boolean isEmpty () {
        if (size == 0) {
            return true;
        }

        return false;
    }

    public void enqueue(int value) {
        if (isFull()) {
            return;
        }

        rear = (rear + 1) % capacity;
        array[rear] = value;
        size ++;
    }

    public int dequeue() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }

        int value = array[front];
        front = (front+1)%capacity;
        size--;

        return value;
    }

    public int peek() {
        return array[front];
    }

    public void displayQueue() {
        for (int i = front; i <=rear; i++) {
            System.out.println("( " + array[i] + " )" );
        }
    }

    public static void main(String[] args) {
        MainApp mainQueueApp = new MainApp(5);
        mainQueueApp.enqueue(1);
        mainQueueApp.enqueue(2);
        mainQueueApp.enqueue(3);
        mainQueueApp.displayQueue();
        System.out.println("==========");
        System.out.println("Dequeue = " + mainQueueApp.dequeue());
        System.out.println("Dequeue = " + mainQueueApp.dequeue());
        mainQueueApp.displayQueue();
        System.out.println("Dequeue = " + mainQueueApp.dequeue());
        mainQueueApp.displayQueue();
        mainQueueApp.enqueue(4);

    }
}
