package com.example.coding.tree.lca;

import com.example.coding.tree.Node;

import java.util.HashMap;
import java.util.Map;

public class KthAncestorOfANode {

    public static void traverseNodeToStoreParents (Node root, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            map.put(root.left.key, root.key);
            traverseNodeToStoreParents(root.left, map);
        }

        if (root.right != null) {
            map.put(root.right.key, root.key);
            traverseNodeToStoreParents(root.right, map);
        }
    }

    public static void printKthAncestor(Node root, int key, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(root.key, 0);

        traverseNodeToStoreParents(root, map);

        int mapKey = map.get(key);
        int counter = 1;

        while (mapKey != 0) {
            mapKey = map.get(mapKey);

            counter ++;

            if (counter >= k) {
                break;
            }
        }

        if (mapKey == 0 && counter < k) {
            mapKey = -1;
        }

        System.out.println(k + "th Ancestor of Node " + key + " is " + mapKey);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        printKthAncestor(root, 8, 6);

    }
}
