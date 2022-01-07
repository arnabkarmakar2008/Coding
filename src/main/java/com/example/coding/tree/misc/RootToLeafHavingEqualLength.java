package com.example.coding.tree.misc;

import com.example.coding.tree.Node;

import java.util.HashMap;
import java.util.Map;

public class RootToLeafHavingEqualLength {

    public static void rootToLeafPath(Node root, Map<Integer, Integer> map, int pathLength) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            if (!map.containsKey(pathLength)) {
                map.put(pathLength, 0);
            }

            map.put(pathLength, map.get(pathLength) + 1);
        }

        rootToLeafPath(root.left, map, pathLength+1);
        rootToLeafPath(root.right, map, pathLength+1);
    }

    public static void printEqualPaths(Node root) {
        Map<Integer, Integer> map = new HashMap<>();
        rootToLeafPath(root, map, 1);

        // Print all path lengths and their counts.
        for(Map.Entry<Integer,
                Integer> entry : map.entrySet())
        {
            System.out.printf("%d paths have length %d\n",
                    entry.getValue(),
                    entry.getKey());
        }
    }

    public static void main(String[] args)
    {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(4);
        root.left.left = new Node(9);
        root.left.right = new Node(7);
        root.right.right = new Node(11);
        root.right.right.left = new Node(3);

        printEqualPaths(root);
    }
}
