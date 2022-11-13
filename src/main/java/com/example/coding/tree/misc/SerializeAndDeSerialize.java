package com.example.coding.tree.misc;

import com.example.coding.tree.Node;

/**
 * https://www.youtube.com/watch?v=T2-dVDWLQtE&t=1061s
 */
public class SerializeAndDeSerialize {


    public static String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        treeSerialize(root, sb);

        return sb.toString();
    }

    public static int index = 0;

    public static Node deserialize(String treeStr) {
        String[] arr = treeStr.split(",");
        return treeDeserialize(arr);
    }

    private static Node treeDeserialize(String[] arr) {
        if (index >= arr.length || arr[index].equals("null")) {
            index++;
            return null;
        }

        Node root = new Node(Integer.valueOf(arr[index++]));
        root.left = treeDeserialize(arr);
        root.right = treeDeserialize(arr);

        return root;
    }

    private static void treeSerialize(Node root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }

        sb.append(root.key).append(",");
        treeSerialize(root.left, sb);
        treeSerialize(root.right, sb);
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);

        System.out.println(serialize(root1));
    }
}
