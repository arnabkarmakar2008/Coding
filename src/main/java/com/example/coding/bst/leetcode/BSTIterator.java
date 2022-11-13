package com.example.coding.bst.leetcode;

import com.example.coding.tree.Node;

import java.util.Stack;


/**
 * Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
 *
 * BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
 * boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
 * int next() Moves the pointer to the right, then returns the number at the pointer.
 * Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.
 *
 * You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.
 */
public class BSTIterator {

    /**
     * https://www.youtube.com/watch?v=D2jMcmxU4bs&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=51
     *
     * SC = O(h) height of the tree
     * TC = O(1)
     *
     * Insert all extreme left nodes in stack.
     * On next : Pop from stack. Return. If there is right child, then insert all left nodes from right child
     * @param args
     */
    public static void main(String[] args) {

    }

    class Iterator {

        Stack<Node> stack = new Stack<>();

        public Iterator(Node root) {
            pushAll(root);
        }

        public int next() {
            Node tempNode = stack.pop();
            pushAll(tempNode.right);
            return tempNode.key;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        private void pushAll(Node root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }
    }


}
