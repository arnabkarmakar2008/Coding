package com.example.coding.tree.sum;

import com.example.coding.tree.Node;

import java.util.Vector;


public class ReplaceNodeWithInorderSuccessorPre {

    static class INT
    {
        int data;
    }

    public static void inorder(Node root, Vector<Integer> vec) {
        if(root == null)
            return;

        inorder(root.left, vec);
        vec.add(root.key);
        inorder(root.right, vec);
    }

    public static void inorderPrint(Node root) {
        if(root == null)
            return;

        inorderPrint(root.left);
        System.out.println(root.key);
        inorderPrint(root.right);
    }


    static void replaceNodeWithSum(Node root, Vector<Integer> vec, INT i) {
        if (root == null) {
            return;
        }

        replaceNodeWithSum(root.left, vec, i);
        root.key = vec.get(i.data-1) + vec.get(i.data+1);

        //Move pointer to next element
        i.data++;
        replaceNodeWithSum(root.right, vec, i);
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);

        Vector<Integer> vec = new Vector<>();
        vec.add(0);
        inorder(root1, vec);
        vec.add(0);

        INT i = new INT();
        i.data = 1;

        replaceNodeWithSum(root1, vec, i);
        System.out.println("Populated");

        inorderPrint(root1);
    }
}
