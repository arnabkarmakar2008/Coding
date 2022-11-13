package com.example.coding.bst.leetcode;

import com.example.coding.tree.Node;

public class SerializeDeserializeBST {


    public static void main(String[] args) {

    }

    class Codec {

        // Encodes a tree to a single string.
        public String serialize(Node root) {
            if (root == null) return "";
            StringBuilder sb = new StringBuilder();
            dfs(root, sb);

            return sb.toString();
        }

        private void dfs(Node root, StringBuilder sb) {
            if (root == null) {
                return;
            }

            sb.append(root.key + " ");
            dfs(root.left, sb);
            dfs(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            if (data.isEmpty()) return null;

            String[] arr = data.split(" ");
            return constructBST(arr, 0, arr.length-1);
        }

        private Node constructBST(String[] arr, int start, int end) {
            if (start > end) {
                return null;
            }

            Node root = new Node(Integer.parseInt(arr[start]));
            int index;
            for (index=start; index<=end; index++) {
                if (Integer.parseInt(arr[index]) > Integer.parseInt(arr[start])) {
                    break;
                }
            }

            root.left = constructBST(arr, start+1, index-1);
            root.right = constructBST(arr, index, end);

            return root;
        }
    }
}
