package com.example.coding.tree.sum;

import com.example.coding.tree.Node;

public class SumOfNodesAtMaxDepth {
    public Node root;

    public SumOfNodesAtMaxDepth(int key) {
        this.root = new Node(key);
    }

    public SumOfNodesAtMaxDepth() {
        this.root = null;
    }

    public static int MAX_LEVEL = Integer.MIN_VALUE;
    public static int sum;

    public void solve(Node node, int level) {
        if (node == null) {
            return;
        }

        /**
         * This is the way to traverse tree. If level>MAX_LEVEL, means new level is starting. Else on the same level
         * as previous calls.
         */
        if (level > MAX_LEVEL) {
            sum = node.key;
            MAX_LEVEL = level;
        } else if (level == MAX_LEVEL) {
            sum = sum + node.key;
        }

        solve(node.left, level+1);
        solve(node.right, level+1);
    }

    public static void main(String[] args) {
        SumOfNodesAtMaxDepth tree = new SumOfNodesAtMaxDepth(1);
        tree.root.left = new Node(3);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(9);
        tree.root.right.left = new Node(8);


        tree.solve(tree.root, 0);

        System.out.println(sum);



    }
}
