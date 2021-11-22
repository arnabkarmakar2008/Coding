package com.example.coding.queue;

public class CircularQueueMainApp {
    private int front, rear, size;
    private int[] array;

    public CircularQueueMainApp(int size) {
        this.size = size;
        array = new int[size];
        front = rear = -1;
    }

    public void enqueue(int data) {
        //check full condition
        if ( (rear == size-1 && front == 0) || rear == (front-1)%(size-1)) {
            System.out.println("Queue is full");
        }

        // Check for empty queue
        else if (front == -1) {
            front = 0;
            rear = 0;
            array[rear] = data;
        } else if (rear == size-1 && front!=0) {
            rear = 0;
            array[rear] = data;
        } else {
            rear = rear + 1;
            array[rear] = data;
        }
    }

    public int dequeue() {
       //Check empty condition
       if (front == -1) {
           System.out.println("Queue is empty");
           return Integer.MIN_VALUE;
       }

       int data = array[front];
       array[front] = -1;

       if (front == rear) {
           front = -1;
           rear = -1;
       } else if (front == size-1) {
           front = 0;
       } else {
           front++;
       }

       return data;
    }

    public void displayQueue() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return;
        }

        if (rear > front) {
            for (int i=front; i<=rear; i++) {
                System.out.println("(" + array[i] + ")");
            }
        } else {
            for (int i= front; i<size; i++) {
                System.out.println("(" + array[i] + ")");
            }

            for (int i=0; i<=rear; i++ ) {
                System.out.println("(" + array[i] + ")");
            }
        }
    }

    public static void main(String[] args) {
        CircularQueueMainApp circularQueueMainApp = new CircularQueueMainApp(5);

        circularQueueMainApp.enqueue(1);
        circularQueueMainApp.enqueue(2);
        circularQueueMainApp.enqueue(3);
        circularQueueMainApp.enqueue(4);
        circularQueueMainApp.enqueue(5);

        circularQueueMainApp.displayQueue();

        circularQueueMainApp.dequeue();
        System.out.println("=========");

        circularQueueMainApp.displayQueue();
        circularQueueMainApp.enqueue(6);

        System.out.println("=========");

        circularQueueMainApp.displayQueue();



    }
}
