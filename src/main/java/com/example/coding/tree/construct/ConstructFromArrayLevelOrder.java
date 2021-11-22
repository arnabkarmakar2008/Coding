package com.example.coding.tree.construct;

import com.example.coding.tree.Node;

public class ConstructFromArrayLevelOrder {

    public static Node construct(int[] arr, int index) {
        if (index >= arr.length) {
            return null;
        }

        Node root = new Node(arr[index]);

        if ((index*2 + 1) < arr.length) {
            root.left = construct(arr, (index*2 + 1));
        }

        if ((index*2 + 2) < arr.length) {
            root.right = construct(arr, (index*2 + 2));
        }

        return root;
    }



    public static void main(String[] args) {
        /**
         * Left child = 2*i + 1;
         * Right Child = 2*i +2;
         */

        int arr [] = {1,2,3,4,5,6};
        Node node = construct(arr, 0);
        System.out.println(node);
    }
}
