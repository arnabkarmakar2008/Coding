package com.example.coding.tree.dp;

import com.example.coding.tree.Node;

public class MaximumPathSumFromAnyNodeToAnyNode {

    static class MaxStore {
        int MAX = Integer.MIN_VALUE;
    }

    /**
     * https://www.youtube.com/watch?v=Osz-Vwer6rw&t=579s
     * Aditya verma
     * @param root
     * @param result
     * @return
     */
    public static int maxPathSumFromNodeToNode(Node root, MaxStore result) {
        if (root == null) return 0;

        int leftSum = maxPathSumFromNodeToNode(root.left, result);
        int rightSum = maxPathSumFromNodeToNode(root.right, result);

        //when path will pass through this node, then either left or right
        //of this node will contribute max along with root. or root itself can be max
        int temp = Math.max((root.key + Math.max(leftSum, rightSum)), root.key);

        //Now if this node can itself become max path sum, then we have to calculate node+left+right
        //and compare.
        int answer = Math.max(temp, (root.key+leftSum+rightSum));

        result.MAX = Math.max(result.MAX, answer);

        //Have to pass max value from this node to its parent
        return temp;
    }

    public static void main(String[] args) {

    }
}
