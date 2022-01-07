package com.example.coding.tree.check;

import com.example.coding.tree.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class PrintBottomView {

    public static void printBottomViewUtil(Node node, Map<Integer, int[]> map, int hd, int level) {
        if (node == null) {
            return;
        }

        if (!map.containsKey(hd)) {
            map.put(hd, new int[] {node.key, level});
        } else {
            // Check if level of existing entry is lesser than current level, then update data with
            //current node

            int[] existingEntry = map.get(hd);

            if (existingEntry[1] <= level) {
                existingEntry[0] = node.key;
                existingEntry[1] = level;
            }

            map.put(hd, existingEntry);
        }

        printBottomViewUtil(node.left, map, hd-1, level+1);
        printBottomViewUtil(node.right, map, hd+1, level+1);
    }

    public static void printBottomView(Node node) {
        if (node == null) {
            return;
        }

        Map<Integer, int[]> map = new HashMap<>();
        printBottomViewUtil(node, map, 0, 0);

        for (int[] arr : map.values()) {
            System.out.println( arr[0]);
        }

        System.out.println(map);
    }



    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);

        printBottomView(root1);
    }


}
