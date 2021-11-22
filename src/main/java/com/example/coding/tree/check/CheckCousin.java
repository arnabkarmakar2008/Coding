package com.example.coding.tree.check;

import com.example.coding.tree.Node;

public class CheckCousin {
    Node root;

    public CheckCousin(int key) {
        this.root = new Node(key);
    }

    public static int getNodeLevel(Node root, Node find, int level) {
        if (root == null) {
            return 0;
        }

        if (root == find) {
            return level;
        }

        int leftLevel = getNodeLevel(root.left, find, level+1);
        if (leftLevel != 0) {
            return leftLevel;
        }

        return getNodeLevel(root.right, find, level+1);
    }

    public static boolean isSibling(Node root, Node a, Node b) {
        if (root == null) {
            return false;
        }

        return (root.left == a && root.right == b) || (root.left == b && root.right == a)
                || isSibling(root.left, a, b) || isSibling(root.right, a, b);
    }

    public static boolean isCousin(Node root, Node a, Node b) {
        int aLevel = getNodeLevel(root, a, 1);
        int bLevel = getNodeLevel(root, b, 1);

        if ((aLevel == bLevel) && !isSibling(root, a, b)) {
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        CheckCousin tree = new CheckCousin(26);
        tree.root.left = new Node(10);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(50);
        tree.root.right.right = new Node(2);

        Node node1 = tree.root.left;
        Node node2 = tree.root.right.left;

        boolean flag = isCousin(tree.root, node1, node2);

        System.out.println(flag);
    }
}
