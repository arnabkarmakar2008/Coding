package com.example.coding.tree.sum;

import com.example.coding.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class DiffBetweenSumOfOddAndEvenLevelNodes {
    public Node root;

    public DiffBetweenSumOfOddAndEvenLevelNodes(int key) {
        this.root = new Node(key);
    }

    public DiffBetweenSumOfOddAndEvenLevelNodes() {
        this.root = null;
    }

    public static int MAX_LEVEL = Integer.MIN_VALUE;
    public static int sum;
    public static int evenSum;
    public static int oddSum;

    public void solve(Node node, int level) {
        if (node == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            int size = q.size();
            level ++;

            while (size > 0) {

                Node current = q.peek();
                q.remove();

                if (level % 2 == 0) {
                    evenSum = evenSum + current.key;
                } else {
                    oddSum = oddSum + current.key;
                }

                if (current.left != null) {
                    q.add(current.left);
                }

                if (current.right != null) {
                    q.add(current.right);
                }

                size--;
            }
        }
    }

    public static void main(String[] args) {
        DiffBetweenSumOfOddAndEvenLevelNodes tree = new DiffBetweenSumOfOddAndEvenLevelNodes(1);
        tree.root.left = new Node(3);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(9);
        tree.root.right.left = new Node(8);


        tree.solve(tree.root, 0);

        System.out.println(evenSum);
        System.out.println(oddSum);



    }
}
