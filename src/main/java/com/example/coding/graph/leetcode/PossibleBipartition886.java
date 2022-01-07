package com.example.coding.graph.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * We want to split a group of n people (labeled from 1 to n) into two groups of any size.
 * Each person may dislike some other people, and they should not go into the same group.
 *
 * Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that
 * the person labeled ai does not like the person labeled bi, return true if it is possible to
 * split everyone into two groups in this way.
 */
public class PossibleBipartition886 {




  public static boolean possibleBipartitionUnionFind(int n, int[][] dislikes) {
    UnionFind1 uf = new UnionFind1(n);
    ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
    for (int ct=0; ct<=n; ct++) {
      adjList.add(ct, new ArrayList<>());
    }

    for (int ct=0; ct< dislikes.length; ct++) {
      adjList.get(dislikes[ct][0]).add(dislikes[ct][1]);
      adjList.get(dislikes[ct][1]).add(dislikes[ct][0]);
    }

    for (int i=1; i<n+1; i++) {
      ArrayList<Integer> adj = adjList.get(i);

      if (adj.size() == 0) {
        continue;
      }

      //get the first neighbour
      int firstNeighbour = adj.get(0);

      for (Integer neighbour : adj) {
        if (uf.isConnected(i, neighbour))  {
          return false;
        } else {
          uf.union(firstNeighbour, neighbour);
        }
      }
    }

    return true;
  }

  /**
   * Color approach
   * @param n
   * @param dislikes
   * @return
   */
  public static boolean possibleBipartition(int n, int[][] dislikes) {
    int[] color = new int[n+1];
    ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
    Arrays.fill(color, -1);


    for (int ct=0; ct<=n; ct++) {
      adjList.add(ct, new ArrayList<>());
    }

    for (int ct=0; ct< dislikes.length; ct++) {
      adjList.get(dislikes[ct][0]).add(dislikes[ct][1]);
      adjList.get(dislikes[ct][1]).add(dislikes[ct][0]);
    }

    Queue<Integer> queue = new LinkedList<>();
    queue.add(1);
    color[1] = 1;

    while (!queue.isEmpty()) {
      int topPerson = queue.remove();
      int topPersonColor = color[topPerson];
      for (Integer adjPerson : adjList.get(topPerson)) {
        if (color[adjPerson] != -1 && color[adjPerson] == topPersonColor) {
          return false;
        } else if (color[adjPerson] == -1) {
          color[adjPerson] = (topPersonColor == 0) ? 1 : 0;
          queue.add(adjPerson);
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    //int[][] dislikes = {{1,2},{1,3},{2,4}};
    int[][] dislikes = {{1,2},{1,3},{2,3}};
    System.out.println(possibleBipartition(4, dislikes));
  }
}

class UnionFind1 {
  int[] parent;
  int[] rank;

  public UnionFind1(int n) {
    this.parent = new int[n];
    this.rank = new int[n];

    Arrays.fill(rank, -1);

    for (int ct=0; ct<n; ct++) {
      parent[ct] = ct;
    }
  }

  public int findParent(int vertex) {
    if (parent[vertex] == vertex) {
      return vertex;
    }

    return parent[vertex] = findParent(parent[vertex]);
  }

  public void union(int vertex1, int vertex2) {
    int parent1 = findParent(vertex1);
    int parent2 = findParent(vertex2);

    if (parent1 != parent2) {
      if (rank[parent1] > rank[parent2]) {
        rank[parent1]++;
        parent[parent2] = parent1;
      } else {
        rank[parent2]++;
        parent[parent1] = parent2;
      }
    }
  }

  public boolean isConnected(int vertex1, int vertex2) {
    return findParent(vertex1) == findParent(vertex2);
  }
}
