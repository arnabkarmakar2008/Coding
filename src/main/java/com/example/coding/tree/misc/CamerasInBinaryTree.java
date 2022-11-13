package com.example.coding.tree.misc;

import com.example.coding.tree.Node;

/**
 * You are given the root of a binary tree. We install cameras on the tree nodes
 * where each camera at a node can monitor its parent, itself, and its immediate children.
 *
 * Return the minimum number of cameras needed to monitor all nodes of the tree.
 */
public class CamerasInBinaryTree {


    /**
     * https://www.youtube.com/watch?v=uoFrIIrp5_g
     * We have to determine state of a node.
     * 0 = Node has camera
     * 1 = Node is already covered by camera
     * -1 = Node needs a camera
     *
     * Leaves will always return -1 as they need camera.
     * If any of the child nodes need camera, then parent needs to install camera and return 0 to its parent
     *
     * Null node will always return 1 :: We do not have to bother about null
     * @param root
     * @return
     */

    public static int cameras;

    private static int countCameras(Node root) {
        if (root == null) return 1;

        int leftChild = countCameras(root.left);
        int rightChild = countCameras(root.right);

        //If any child needs camera, then parent needs to install it
        if (leftChild == -1 || rightChild == -1) {
            cameras++;
            return 0;
        }

        //If any of the child has camera then parent do not need camera
        if (leftChild == 0 || rightChild == 0) {
            return 1;
        }

        //left and right both are covered. So node will not install camera. But will tell its parent to cover.
        return -1;
    }

    public static int minCameraCover(Node root) {
        if (countCameras(root) == -1) {
            cameras++;
        }

        return cameras;
    }

    public static void main(String[] args) {
        Node root = new Node (10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);
        root.right.left.left = new Node(37);

        System.out.println(minCameraCover(root));
    }
}
