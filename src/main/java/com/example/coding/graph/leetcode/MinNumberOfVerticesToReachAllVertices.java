package com.example.coding.graph.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinNumberOfVerticesToReachAllVertices {


    public static void minVertices(List<List<Integer>> edges, int N) {
        //create indegree array
        int[] indegree = new int[N];

        for (List<Integer> edge : edges) {
            indegree[edge.get(1)] ++;
        }

        // 0 indegree will be min vertices to reach all vertices
        for (int ct = 0; ct < N ; ct ++) {
            if (indegree[ct] == 0) {
                System.out.println("Min Node == " + ct);
            }
        }
    }

    public static void main(String[] args) {

        //graph edges
        List<List<Integer>> edges = new ArrayList<>();
        int numberOfVertices = 6;

        edges.add(0, new ArrayList<>(Arrays.asList(0,1)));
        edges.add(1, new ArrayList<>(Arrays.asList(0,2)));
        edges.add(2, new ArrayList<>(Arrays.asList(2,5)));
        edges.add(3, new ArrayList<>(Arrays.asList(3,4)));
        edges.add(4, new ArrayList<>(Arrays.asList(4,2)));

        minVertices(edges, numberOfVertices);
    }
}
