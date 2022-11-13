package com.example.coding.tree.check;

import com.example.coding.tree.Node;

import java.util.*;

/**
 * Given a Binary Tree and a positive integer k, print all nodes that are distance k from a leaf node.
 *
 * Here the meaning of distance is different from previous post. Here k distance from a leaf means k
 * levels higher than a leaf node. For example if k is more than height of Binary Tree, then nothing
 * should be printed. Expected time complexity is O(n) where n is the number nodes in the given Binary Tree.
 */
public class PrintNodesAtKDistFromLeaf {

    public static void printAtKFromLeaf(Node leaf, Map<Node, Node> parentMap, int distance) {
        int i = 1;
        Node toPrint = leaf;
        while(i <= distance) {
            toPrint = parentMap.get(toPrint);
            i++;
        }

        System.out.println(toPrint.key);
    }

    public static void traverseTree(Node root, int distance) {
        if (root == null) {
            return;
        }

        Map<Node, Node> map = new HashMap<>();
        Stack<Node> stack = new Stack<>();

        stack.push(root);
        map.put(root, null);

        while (!stack.empty()) {
            Node temp = stack.pop();

            if (temp.left==null && temp.right==null) {
                printAtKFromLeaf(temp, map, distance);
            }

            if (temp.right != null) {
                stack.push(temp.right);
                map.put(temp.right, temp);
            }

            if (temp.left != null) {
                stack.push(temp.left);
                map.put(temp.left, temp);
            }
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
        root1.right.left.right = new Node(8);
        traverseTree(root1, 2);
        //printOddLevel(root1, 1);
    }
}
