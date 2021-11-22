package com.example.coding.tree.check;

import com.example.coding.tree.Node;

import java.util.Map;
import java.util.TreeMap;

public class PrintTopView {

    public static void traverseVertical(Node root, Map<Integer, Node> map, int hd) {
        if (root == null) {
            return;
        }

        if (!map.containsKey(hd)) {
            map.put(hd, root);
        }

        traverseVertical(root.left, map, hd-1);
        traverseVertical(root.right, map, hd+1);
    }

    public static void printTopView(Node root) {
        Map<Integer, Node> map = new TreeMap<>();
        map.put(0, root);

        traverseVertical(root, map, 0);

        for (Map.Entry<Integer, Node> mapEntry : map.entrySet()) {
            System.out.println(mapEntry.getValue().key);
        }
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);

        printTopView(root1);
    }
}
