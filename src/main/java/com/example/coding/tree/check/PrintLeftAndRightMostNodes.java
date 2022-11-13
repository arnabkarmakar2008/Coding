package com.example.coding.tree.check;

import com.example.coding.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a Binary Tree, Print the corner nodes at each level.
 * The node at the leftmost and the node at the rightmost.
 * For example, output for following is 15, 10, 20, 8, 25.
 */
public class PrintLeftAndRightMostNodes {


    public static void printLeftRightMost(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            int currentQSize = q.size();
            int index = 0;

            while (size > 0) {
                Node temp = q.remove();

                if (index == 0 || index == currentQSize-1) {
                    System.out.println(temp.key);
                }

                if (temp.left != null) {
                    q.add(temp.left);
                }

                if (temp.right != null) {
                    q.add(temp.right);
                }

                index++;
                size --;
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

        printLeftRightMost(root1);
    }
}
