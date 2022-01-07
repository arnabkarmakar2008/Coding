package com.example.coding.tree.misc;

import com.example.coding.tree.Node;

public class LengthOfLongestSubsequence {

    public static int MAX_LENGTH = Integer.MIN_VALUE;

    public static void longestSubsequence(Node root, int expectedValue, int length) {
        if (root==null) {
            return;
        }

        if (root.key == expectedValue) {
            length = length+1;
        } else {
            length = 1;
        }

        MAX_LENGTH = Math.max(MAX_LENGTH, length);
        longestSubsequence(root.left, root.key+1,length );
        longestSubsequence(root.right, root.key+1,length );
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(9);
        root.right = new Node(4);
        root.left.left = new Node(10);
        root.left.right = new Node(7);
        root.right.right = new Node(11);
        root.right.right.left = new Node(3);

        longestSubsequence(root, 0, root.key);
        System.out.println(MAX_LENGTH);
    }
}
