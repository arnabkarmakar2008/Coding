package com.example.coding.tree.check;

import com.example.coding.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class PrintNodesBetween2Levels {

    public static void printOddLevel(Node node, int lowLevel, int highLevel) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            System.out.println(node.key);
        }

        int level = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            int size = q.size();
            level++;

            while (size > 0) {
                Node temp = q.remove();
                if (level>= lowLevel && level <= highLevel) {
                    System.out.println(temp.key);
                }

                if (temp.left != null) {
                    q.add(temp.left);
                }

                if (temp.right != null) {
                    q.add(temp.right);
                }

                size--;
            }

        }

    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);

        root1.right.left.left = new Node(8);
        root1.right.left.right = new Node(9);
        printOddLevel(root1,2,4);
    }
}
