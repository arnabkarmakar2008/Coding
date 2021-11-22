package com.example.coding.tree.check;

import com.example.coding.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class PrintCousins {

    public static void printCousin(Node root, int key) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            boolean flag = false;

            while (size > 0) {
                Node temp = q.remove();

                if (temp.left != null) {
                    if (temp.left.key == key) {
                       flag = true;
                    } else {
                        if (temp.right != null && temp.right.key != key) {
                            q.add(temp.left);
                        }

                    }

                }

                if (temp.right != null)  {
                    if (temp.right.key == key) {
                        flag = true;
                    } else {
                        if (temp.left != null && temp.left.key != key) {
                            q.add(temp.right);
                        }

                    }
                }

                size--;
            }

            if (flag == true) {
                while (!q.isEmpty()) {
                    System.out.println(q.remove().key);
                }

                break;
            }
        }
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);
        root1.right.left.right = new Node(9);
        root1.right.left.left = new Node(10);

        printCousin(root1, 4);

    }
}
