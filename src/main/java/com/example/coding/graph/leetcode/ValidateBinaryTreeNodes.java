package com.example.coding.graph.leetcode;

/**
 * You have n binary tree nodes numbered from 0 to n - 1 where node i has two children leftChild[i] and rightChild[i],
 * return true if and only if all the given nodes form exactly one valid binary tree.
 *
 * If node i has no left child then leftChild[i] will equal -1, similarly for the right child.
 *
 * Note that the nodes have no values and that we only use the node numbers in this problem.
 */
public class ValidateBinaryTreeNodes {

  /**
   * Note : This solution uses Union Find (a.k.a Disjoint Set Union) which counts connected components
   * and allows only the single child-root assignment.
   * @param n
   * @param leftChild
   * @param rightChild
   * @return
   */

  public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
    UnionFind uf = new UnionFind(n);

    for (int ct=0; ct < n; ct++) {
      if (leftChild[ct] >= 0 && !uf.unionFind(ct, leftChild[ct])) {
        return false;
      }

      if (rightChild[ct] >= 0 && !uf.unionFind(ct, rightChild[ct])) {
        return false;
      }
    }

    return uf.components == 1; // If number of connected component is 1 that means possible binary tree.
  }

  public static void main(String[] args) {
    int n = 4;
    int[] left = {1,-1,3,-1};
    int[] right = {2,-1,-1,-1};
    System.out.println(validateBinaryTreeNodes(n, left, right));
  }
}

class UnionFind {
  private int length;
  private int[] parents;
  public int components;

  public UnionFind(int length) {
    this.length = length;

    parents = new int[length];

    for (int ct = 0; ct <length; ct++) {
      parents[ct] = ct;
    }

    this.components = length;
  }

  public boolean unionFind(int parent, int child) {
    int parentParent = findParent(parent);
    int childParent = findParent(child);

    if (childParent != child || parentParent == child) { //1st condition will check if child has already connected to parent // 2nd condition
      //will check parallel edges 0->1 1->0
      return false;
    }

    parents[childParent] = parentParent;
    components--;
    return true;
  }

  public int findParent(int node) {
    if (parents[node] == node) {
      return node;
    }

    return parents[node] = findParent(parents[node]);
  }
}
