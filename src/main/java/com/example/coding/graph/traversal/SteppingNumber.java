package com.example.coding.graph.traversal;

import java.util.LinkedList;
import java.util.Queue;

public class SteppingNumber {
    /**
     * Given two integers ‘n’ and ‘m’, find all the stepping numbers in range [n, m]. A number is called stepping number
     * if all adjacent digits have an absolute difference of 1.
     * 321 is a Stepping Number while 421 is not.
     *
     * Every node in the graph represents a stepping number; there will be a directed edge
     * from a node U to V if V can be transformed from U. (U and V are Stepping Numbers)
     * A Stepping Number V can be transformed from U in following manner.
     * lastDigit refers to the last digit of U (i.e. U % 10)
     * An adjacent number V can be:
     *
     * U*10 + lastDigit + 1 (Neighbor A)
     * U*10 + lastDigit – 1 (Neighbor B)
     */

    public static void steppingNumber(int start, int end, int startingNumber) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startingNumber);

        while (!queue.isEmpty()) {
            int tempNumber = queue.poll();

            if (tempNumber >= start && tempNumber <= end) {
                System.out.println(" " + tempNumber + " ");
            }

            if (tempNumber > end || tempNumber == 0) {
                continue;
            }

            int lastDigit = tempNumber%10;

            int neighbour1 = tempNumber*10 + (lastDigit-1);
            int neighbour2 = tempNumber*10 + (lastDigit+1);

            if (lastDigit == 0) { //exception for 0
                queue.add(neighbour2);
            } else if (lastDigit == 9) { //exception for 9
                queue.add(neighbour1);
            } else {
                queue.add(neighbour1);
                queue.add(neighbour2);
            }

        }
    }

    public static void main(String[] args) {
        int start = 100;
        int end = 200;

        for (int i=0; i<=9; i++) {
            steppingNumber(start, end, i);
        }
    }
}
