package com.example.coding.tree.construct;


import com.example.coding.tree.Node;

/** Tree needs to be full binary tree. Otherwise not possible**/
public class ConstructFromPreAndPost {

    public static int preIndex = 0;

    public static Node construct(int[] pre, int preStart, int preEnd,int[] post, int postStart, int postEnd) {
        // First element of preorder is root. Go to next element in preorder. Find the index of the element in
        // post order. All the elements from starting to index in post order would be left subtree.

        /**
         * WE NEED 4 INDEXES HERE.
         * 1. preStart, preEnd, postStart, postEnd
         * index = index of the element in post order. Number of elements in left subtree = index - postStart +1
         *
         * We have to pass indexes in recurion.
         *
         * Left Recursion = preStart+1, preStart+number of elemets in left subtree, postStart, index
         * Right Recursion = preStart+number of elemets in left subtree + 1, preEnd, index+1,postEnd-1
         *  PRE : 1 2 4 5 3 6 7
         *  POS : 4 5 2 6 7 3 1
         */

        if (postStart > postEnd || preStart > preEnd) {
            return null;
        }

        Node root = new Node(pre[preStart]);

        if (postStart == postEnd || preStart == preEnd) {
            return root; // Single element
        }

        //Now we have find the index next element in post order. e.g 2's index i post order.
        int index = postStart;

        while (post[index] != pre[preStart+1]) {
            index++;
        }

        int numberOfElementInLeft = index - postStart + 1;

        root.left = construct(pre, preStart+1, preStart + numberOfElementInLeft, post, postStart, index);

        root.right = construct(pre, preStart + numberOfElementInLeft+1, preEnd, post, index+1, postEnd-1);

        return root;
    }

    public static int findIndex(int[] in, int key) {
        int i =0;
        for (int k=0; k < in.length; k++) {
            if (in[k] == key) {
                i = k;
                break;
            }
        }

        return i;
    }
}
