package com.example.coding.bst.leetcode;

import com.example.coding.linkedlist.main.Link;
import com.example.coding.tree.Node;

/**
 * Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height
 * balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees
 * of every node never differ by more than 1
 */
public class ConvertSortedListToBST {

    public Node sortedListToBST(Link head) {
        if (head == null) {
            return null;
        }

        return toBST(head, null);
    }

    private static Node toBST(Link head, Link tail) {
        Link slow = head;
        Link fast = head;

        if (head == tail) return null;

        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node rootNode = new Node(slow.data);

        rootNode.left = toBST(head, slow);
        rootNode.right = toBST(slow.next, tail);

        return rootNode;


    }

    public static void main(String[] args) {

    }





}
