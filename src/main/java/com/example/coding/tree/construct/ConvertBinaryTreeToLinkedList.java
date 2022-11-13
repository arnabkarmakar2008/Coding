package com.example.coding.tree.construct;

import com.example.coding.tree.Node;

/**
 *    1
 * 2     5
 3  4  6
 *    7
 *
 * Above tree can be modified to create linkedlist like below:
 *
 * 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
 *
 * 1's right will point to 2, 2's right will point to 3 and so on..
 *
 * So first we have to work for 7. So it will be Right -> Left and then Root
 *
 */
public class ConvertBinaryTreeToLinkedList {

    static Node previous;

    /**
     * https://www.youtube.com/watch?v=sWf7k1x9XR4
     * @param root
     */
    public static void convertLinkedList(Node root) {

        if (root == null) {
            return;
        }

        convertLinkedList(root.right);
        convertLinkedList(root.left);

        root.right = previous;
        root.left = null;
        previous = root;
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
