package com.example.coding.tree.construct;

import com.example.coding.tree.Node;

/**
 * In this case we have to keep node in Inorder
 *      1
 *   2     5
 * 3  4  6
 *      7
 *
 * So output should be 3 -> 2 -> 4 -> 1 -> 7 -> 6 > 5
 *
 * https://www.youtube.com/watch?v=nGNoTdav5bQ&t=501s Anuj
 */
public class ConvertBinaryTreeToDoublyLinkedList {
    static Node previous, head = null;


    public static void convert(Node root) {
        if (root == null) return;

        convert(root.left);

        if (previous == null) {
            head = root;
        } else {

            //When we add a new node in doubly linked list we do  ::: node.pre = previousNode
            // and previousNode.next = node. We have to do same here.

            previous.right = root;
            root.left = previous;
        }

        previous = root;

        convert(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node (10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);
    }
}
