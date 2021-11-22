package com.example.coding.tree.check;

import com.example.coding.tree.Node;

public class TwoTreesAreMirror {

    /**
     * Trees are mirror when a) Have same key
     * a.left mirror of b.right
     * a.right mirror of b.left
     * @param
     * @return
     */

    public static boolean checkMirror(Node a, Node b) {
        //Base Case
        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        return (a.key == b.key) && checkMirror(a.left, b.right) && checkMirror(a.right, b.left);
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);

        Node root2 = new Node(1);
        root2.left = new Node(3);
        root2.right = new Node(2);

        System.out.println(checkMirror(root1, root2));

    }
}
