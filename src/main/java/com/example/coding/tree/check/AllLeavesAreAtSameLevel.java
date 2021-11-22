package com.example.coding.tree.check;

import com.example.coding.tree.Node;
import com.example.coding.tree.sum.SumAtGivenLevel;

import java.util.LinkedList;
import java.util.Queue;

public class AllLeavesAreAtSameLevel {
    Node root;

    public AllLeavesAreAtSameLevel(int k) {
        this.root = new Node(k);
    }

    public static boolean checkAllLeafLevel(Node root) {
        if (root == null) {
            return false;
        }

        if (root.right == null && root.left == null) {
            return true;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        boolean flag = true;
        int level = 0;
        int leafLevel = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            while (size > 0) {
                Node temp = q.remove();
                if (temp.left == null && temp.right == null) {

                    if (leafLevel == 0) {
                        leafLevel = level;
                    } else {
                        if (leafLevel != level) {
                            flag = false;
                            break;
                        }
                    }

                }

                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);

                size--;
            }

            if (flag == false) {
                break;
            }

        }

        return flag;

    }

    public static void main(String[] args) {
        AllLeavesAreAtSameLevel tree = new AllLeavesAreAtSameLevel(1);
        tree.root.left = new Node(3);
        tree.root.right = new Node(6);
        //tree.root.left.left = new Node(5);
        //tree.root.left.right = new Node(9);
        tree.root.right.left = new Node(8);

        System.out.println(checkAllLeafLevel(tree.root));
    }
}
