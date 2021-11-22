package com.example.coding.tree.sum;

import com.example.coding.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class SumAtGivenLevel {

    Node root;

    public SumAtGivenLevel(int key) {
        this.root = new Node(key);
    }

    public SumAtGivenLevel() {
        root = null;
    }

    public static int solve(Node root, int k) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        int level = 0;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            while (size > 0) {
                Node temp = q.poll();
                if (level == k) {
                    sum = sum + temp.key;
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

        return sum;
    }

    public static void main(String[] args) {
        SumAtGivenLevel tree = new SumAtGivenLevel(1);
        tree.root.left = new Node(3);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(9);
        tree.root.right.left = new Node(8);
        System.out.println(tree.solve(tree.root, 3));
    }
}
