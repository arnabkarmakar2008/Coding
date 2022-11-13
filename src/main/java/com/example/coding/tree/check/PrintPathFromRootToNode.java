package com.example.coding.tree.check;

import com.example.coding.tree.Node;

import java.util.ArrayList;
import java.util.Stack;

public class PrintPathFromRootToNode {

    public static Stack<Integer> s = new Stack<>();

    public static boolean hasPath(Node root, int key, ArrayList<Integer> list) {
        //if root is null there is no path
        if (root == null) {
            return false;
        }

        //push node value in list
        list.add(root.key);


        //if root is the key then true
        if (root.key == key) {
            return true;
        }

        //if key present in the left or right subtree then true
        if (hasPath(root.left, key, list) || hasPath(root.right, key, list)) {
            return true;
        }

        //else remove the node from path, return false
        list.remove(list.size()-1);
        return false;
    }

    public static void printRootToNodePath(Node root, int key) {
        ArrayList<Integer> list = new ArrayList<>();

        if (hasPath(root, key, list)) {
            for (int ct=0; ct < list.size()-1; ct++) {
                System.out.print(list.get(ct) + "->");
            }

            System.out.print(list.get(list.size()-1));
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
        //root1.right.left.right = new Node(9);
        //root1.right.left.left = new Node(10);

        printRootToNodePath(root1, 7);

    }
}
