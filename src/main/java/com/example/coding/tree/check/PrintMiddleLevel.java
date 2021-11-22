package com.example.coding.tree.check;

import com.example.coding.tree.Node;

public class PrintMiddleLevel {
    //Slow and fast pointer
    public static void print(Node a, Node b) {
        if (a== null || b == null) {
            return;
        }

        if (b.left == null && b.right == null) {
            System.out.println(a.key);
        }

        if (b.left.left != null) {
            //Move twice
            print(a.left, b.left.left);
            print(a.right, b.left.left);

        } else {
            print(a.left, b.left);
            print(a.right, b.left);
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
        print(root1,root1);

    }
}
