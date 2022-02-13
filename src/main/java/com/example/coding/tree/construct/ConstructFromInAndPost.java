package com.example.coding.tree.construct;

import com.example.coding.tree.Node;

public class ConstructFromInAndPost {

    public static Node buildTree(int[] post, int postStart, int postEnd, int[] in, int inStart, int inEnd) {

        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        Node root = new Node(post[postEnd]);

        if (postStart == postEnd || inStart == inEnd) {
            return root;
        }

        int index = inStart;
        while (in[index] != post[postEnd]) {
            index++;
        }

        int numberOfLeftElement = index - inStart;

        root.left = buildTree(post, postStart,postStart+numberOfLeftElement-1, in, inStart, index-1);
        root.right = buildTree(post, postStart+numberOfLeftElement,postEnd-1, in, index+1, inEnd);

        return root;

    }

    public static void printInOrder(Node root) {
        if (root == null) {
            return;
        }

        printInOrder(root.left);
        System.out.println(root.key + " ");
        printInOrder(root.right);
    }



    public static void main(String[] args) {
        int[] inOrder = {4,8,10,12,14,20,22};
        int[] postOrder = {4,10,14,12,8,22,20};

        Node root = buildTree(postOrder, 0, (postOrder.length-1), inOrder, 0, inOrder.length-1);
        printInOrder(root);


    }
}
