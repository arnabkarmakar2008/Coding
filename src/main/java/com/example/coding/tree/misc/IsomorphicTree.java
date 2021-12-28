package com.example.coding.tree.misc;

import com.example.coding.tree.Node;

/**
 *  Two trees are called isomorphic if one of them can be obtained from other by a series of flips,
 *  i.e. by swapping left and right children of a number of nodes.
 */
public class IsomorphicTree {

    public static boolean isIsomorphic(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1==null || node2==null) {
            return false;
        }

        if (node1.key == node2.key) {
            return true;
        }

        return (isIsomorphic(node1.left, node2.left) && isIsomorphic(node1.right, node2.right))
                || (isIsomorphic(node1.left, node2.right) && isIsomorphic(node1.right, node2.left));



    }
    public static void main(String[] args) {

    }
}
