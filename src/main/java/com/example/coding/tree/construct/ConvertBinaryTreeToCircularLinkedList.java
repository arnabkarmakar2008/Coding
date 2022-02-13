package com.example.coding.tree.construct;

import com.example.coding.tree.Node;

public class ConvertBinaryTreeToCircularLinkedList {

    public static Node concat(Node leftList, Node rightList) {

        if (leftList == null) {
            return rightList;
        }

        if (rightList == null) {
            return leftList;
        }

        Node leftLast = leftList.left;
        Node rightLast = rightList.left;

        rightLast.right = leftList;
        leftList.left = rightLast;
        leftLast.right = rightList;
        rightList.left = leftLast;
        return leftList;
    }

    public static Node constructCircularList(Node node) {
        if (node == null) {
            return null;
        }

        Node leftList = constructCircularList(node.left);
        Node rightList = constructCircularList(node.right);

        // To convert tree node to circular linked node, left and right should point to itself
        // Make a circular linked list of single node
        // (or root). To do so, make the right and
        // left pointers of this node point to itself
        node.left = node.right = node;

        //Now concat leftlist + root + rightlist annd return

        return concat(concat(leftList, node), rightList);

    }

    public static void displayCircularList(Node head) {
        Node itr = head;
        do
        {
            System.out.println(itr.key);
            itr = itr.right;
        } while (itr != head);
    }

    public static void main(String[] args) {
        // Build the tree
        Node root = new Node (10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);
        // head refers to the head of the Link List
        Node head = constructCircularList(root);

        // Display the Circular LinkedList
        displayCircularList(head);
    }
}
