package com.example.coding.tree.check;

import com.example.coding.tree.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PrintRootToLeafPaths {


    public static void leafToRoot(Node leaf, Map<Node, Node> parentMap) {
        Stack<Integer> stack = new Stack<>();

        Node current = leaf;

        while (current != null) {
            stack.push(current.key);
            current = parentMap.get(current); // map<Node, ParentNode>
        }

        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }

        System.out.println("");
    }

    public static void preOrderTraversalWithoutRecursion(Node root) {
        if (root == null) {
            return;
        }

        Map<Node, Node> map = new HashMap<>();
        Stack<Node> stack = new Stack<>();

        stack.push(root);
        map.put(root, null);

        while (!stack.empty()) {
            Node current = stack.pop();

            if (current.left == null && current.right== null) {
                leafToRoot(current, map);
            }

            /**
             * Need to push right first...
             */
            if (current.right != null) {
                stack.push(current.right);
                map.put(current.right, current);
            }

            if (current.left != null) {
                stack.push(current.left);
                map.put(current.left, current);
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
        preOrderTraversalWithoutRecursion(root1);

    }
}
