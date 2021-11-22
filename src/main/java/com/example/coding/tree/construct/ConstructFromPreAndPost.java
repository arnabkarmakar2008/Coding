package com.example.coding.tree.construct;


import com.example.coding.tree.Node;

/** Tree needs to be full binary tree. Otherwise not possible**/
public class ConstructFromPreAndPost {

    public static int preIndex = 0;

    public static Node construct(int[] pre, int[] post, int start, int end, int size) {

        //Base Case
        if ((preIndex >= size) || start>end) {
            return null;
        }


        Node root = new Node(pre[preIndex++]);

        //If after incrementing preIndex, if there is no element then return or
        //if start == end return root.
        if ((preIndex>=size) || start == end ) {
            return root;
        }

        int indexInPost = findIndex(post, pre[preIndex]);

        if (indexInPost <= end) {
            root.left = construct(pre, post, start, indexInPost, size);
            root.right = construct(pre, post, indexInPost+1, end-1, size);
        }

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
