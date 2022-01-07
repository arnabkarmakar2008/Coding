package com.example.coding.graph.leetcode;

import java.util.*;

public class FlowerPlanting1042 {

  public static int[] gardenNoAdj(int n, int[][] paths) {
    int[] flowers = new int[n+1];
    Arrays.fill(flowers, -1);

    ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

    for (int ct=0; ct<n+1; ct++) {
      adjList.add(ct, new ArrayList<>());
    }

    for (int ct=0; ct< paths.length; ct++) {
      adjList.get(paths[ct][0]).add(paths[ct][1]);
      adjList.get(paths[ct][1]).add(paths[ct][0]);
    }

    for (int ct=1; ct<=4; ct++) {
      if (flowers[ct] == -1) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(ct);
        flowers[ct] = 1;

        while (!queue.isEmpty()) {
          int topGarden = queue.remove();
          int topFlower = flowers[topGarden];

          ArrayList<Integer> availableFlowers = availableFlowers(topFlower);

          int count = 0;
          for (Integer adjGarden : adjList.get(topGarden)) {

            if (flowers[adjGarden] == -1) {
              flowers[adjGarden] = availableFlowers.get(count);
              queue.add(adjGarden);
            }

            count++;

          }

        }
      }
    }

    return flowers;
  }

  public static ArrayList<Integer> availableFlowers(int currentFlower) {
    ArrayList<Integer> availableFlowers = new ArrayList<Integer>();
    for (int i=1; i<=4; i++) {
      if (i != currentFlower) {
        availableFlowers.add(i);
      }
    }

    return availableFlowers;
  }

  public static void main(String[] args) {
    int n=4;
    //int[][] paths = {{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}};
    int[][] paths = {{1,2},{3,4}};
    int[] arr = gardenNoAdj(4, paths);

    for (int i :  arr) {
      System.out.println(i);
    }
  }
}
