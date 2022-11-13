package com.example.coding.graph.traversal;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Node {
    int value;
    int steps;

    public Node(int value, int steps) {
        this.value = value;
        this.steps = steps;
    }
}

public class NumberOfOperationsToConvertNumbers {
    /**
     * Given a initial number x and two operations which are given below:
     *
     * Multiply number by 2.
     * Subtract 1 from the number.
     * The task is to find out minimum number of operation required to convert number x into y
     * using only above two operations. We can apply these operations any number of times.
     * Constraints:
     * 1 <= x, y <= 1000
     */


    public static int minOperation(int src, int target) {
        Queue<Node> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Node srcNode = new Node(src, 0);

        queue.add(srcNode);
        visited.add(srcNode.value);

        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            visited.add(tempNode.value);

            if (tempNode.value == target) {
                return tempNode.steps;
            }

            int mul = tempNode.value * 2;
            int sub = tempNode.value - 1;

            if (!visited.contains(mul) && (mul >0 && mul < 1000)) {
                queue.add(new Node(mul, tempNode.steps+1));
            }

            if (!visited.contains(sub) && (sub >0 && sub < 1000)) {
                queue.add(new Node(sub, tempNode.steps+1));
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(minOperation(4,7));
    }
}
