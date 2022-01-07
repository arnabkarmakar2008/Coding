package com.example.coding.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraphCheck {


    public static boolean checkBipartiteGraph(int vertexCount, ArrayList<ArrayList<Integer>> adjList) {
        int[] colorArray = new int[vertexCount+1];
        Arrays.fill(colorArray, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        colorArray[1] = 0; // 2 colors are 0 and 1

        while (!queue.isEmpty()) {
            int tempVertex = queue.poll();

            for (Integer itr : adjList.get(tempVertex)) {
                if (colorArray[itr] != -1 && colorArray[itr] == colorArray[tempVertex]) {
                    // if any adj node is already colored with same color then not bipartiate
                    return false;
                } else if (colorArray[itr] == -1) {
                    if (colorArray[tempVertex] == 0) {
                        colorArray[itr] = 1;
                    } else {
                        colorArray[itr] = 0;
                    }
                    queue.add(itr);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        /**
         * A bipartite graph is possible if the graph coloring is possible using two colors
         * such that vertices in a set are colored with the same color.
         * Note that it is possible to color a cycle graph with even cycle using two colors.
         * If graph contains odd length cycle - then not bipartite else all are bipartite
         */

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        int numberOfVertex = 4;

        for (int count=0; count <= numberOfVertex; count++) {
            adjList.add(new ArrayList<Integer>());
        }

        //prepare adjList
        //1-2
        //2-3 2-5
        //3-5


        adjList.get(1).add(2);
        adjList.get(2).add(1);

        adjList.get(2).add(3);
        adjList.get(2).add(4);
        adjList.get(3).add(2);
        adjList.get(4).add(2);

        adjList.get(3).add(4);
        adjList.get(4).add(3);

        System.out.println(checkBipartiteGraph(numberOfVertex, adjList));
    }
}
