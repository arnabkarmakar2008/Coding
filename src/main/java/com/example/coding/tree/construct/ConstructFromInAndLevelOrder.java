package com.example.coding.tree.construct;

import com.example.coding.tree.Node;

import java.util.HashSet;

public class ConstructFromInAndLevelOrder {


    public static Node constructTree(int[] in, int[] level, int start, int end, int n) {
        if (n <= 0) {
            return null;
        }

        Node root = new Node(level[start]);

        //Search root in inorder
        int index = -1;
        for (int i = start; i <= end; i++) {
            if (in[i] == root.key) {
                index = i;
                break;
            }
        }

        // Insert all left nodes in HashSet
        HashSet<Integer> set = new HashSet<>();
        for (int i= start; i<index; i++) {
            set.add(in[i]);
        }

        int[] leftLevel = new int[set.size()];
        int[] rightLevel = new int[end - start - set.size()];

        int li = 0;
        int ri = 0;

        for (int i=1; i<n; i++ ) {
            if (set.contains(level[i])) {
                leftLevel[li++] = level[i];
            } else {
                rightLevel[ri++] = level[i];
            }
        }

        root.left = constructTree(in, leftLevel, start, index-1, index-start);
        root.right = constructTree(in, rightLevel, index+1, end, end-index);
        return root;
    }

    public static int findIndex(int[] in, int start, int end, int key) {
        int i =-1;
        for (int k=start; k <= end; k++) {
            if (in[k] == key) {
                i = k;
                break;
            }
        }

        return i;
    }


    public static void main(String[] args) {
        int[] in = {4,8,10,12,14,20,22};
        int[] level = {20,8,22,4,12,10,14};

        Node root = constructTree(in, level, 0, in.length-1, in.length);
        System.out.println(root);
    }
}
