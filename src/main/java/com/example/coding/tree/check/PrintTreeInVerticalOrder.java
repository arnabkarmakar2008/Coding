package com.example.coding.tree.check;

import com.example.coding.tree.Node;

import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

public class PrintTreeInVerticalOrder {

    public static void traverseInVerticalOrder(Node root, Map<Integer, Vector<Integer>> map, int horizontalDistance) {
        if (root == null) {
            return;
        }

        Vector<Integer> levelVector = map.get(horizontalDistance);

        if (levelVector == null) {
            levelVector = new Vector<>();
        }

        levelVector.add(root.key);
        map.put(horizontalDistance, levelVector);

        traverseInVerticalOrder(root.left, map, horizontalDistance-1);
        traverseInVerticalOrder(root.right, map, horizontalDistance+1);

    }

    public static void printInVerticalOrder(Node root) {
        if (root ==null) {
            return;
        }

        Map<Integer, Vector<Integer>> map = new TreeMap<>();
        Vector<Integer> vector = new Vector<>();
        vector.add(root.key);
        map.put(0, vector);

        traverseInVerticalOrder(root, map, 0);

        for (Map.Entry<Integer, Vector<Integer>> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }

        System.out.println("Done");

    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);

        printInVerticalOrder(root1);

    }
}
