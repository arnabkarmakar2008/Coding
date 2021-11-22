package com.example.coding.tree.check;

import com.example.coding.tree.Node;

import java.util.Stack;

public class PrintPathFromRootToNode {

    public static Stack<Integer> s = new Stack<>();

    public static boolean isPresent(Node root, int key) {
        if (root == null) {
            return false;
        }

        s.push(root.key);

        if (root.key == key) {
            System.out.println(root.key);
            return true;
        }

        if (isPresent(root.left, key) || isPresent(root.right, key)) {
            return true;
        } else {
            s.pop();
            return false;
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
        //root1.right.left.right = new Node(9);
        //root1.right.left.left = new Node(10);

        isPresent(root1, 5);

        System.out.println(s);

    }
}
