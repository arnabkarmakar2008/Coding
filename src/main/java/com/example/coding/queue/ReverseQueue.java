package com.example.coding.queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(4);
        queue.add(3);
        queue.add(10);
        queue.add(12);

        Iterator iterator = queue.iterator();
        while(iterator.hasNext()) {
            System.out.println("(" + iterator.next() +")");
        }

        reverseQueue(queue);

        iterator = queue.iterator();
        while(iterator.hasNext()) {
            System.out.println("(" + iterator.next() +")");
        }

    }

    public static Queue reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return queue;
        }
        int temp = queue.remove();

        Queue reversedQueue = reverseQueue(queue);
        reversedQueue.add(temp);
        return reversedQueue;
    }
}
