package com.example.coding.tree.misc;

import com.example.coding.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfATree {

    public static int MAX_WIDTH = Integer.MIN_VALUE;

    public static void getMaxWidth(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            MAX_WIDTH = Math.max(MAX_WIDTH, size);

            while (size > 0) {
                Node temp = q.remove();

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
        Node root = new Node (10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);
        root.right.left.left = new Node(37);
        root.right.left.left.left = new Node(38);
        getMaxWidth(root);
        System.out.println(MAX_WIDTH);
    }
}
