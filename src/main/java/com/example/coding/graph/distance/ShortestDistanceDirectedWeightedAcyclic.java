package com.example.coding.graph.distance;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ShortestDistanceDirectedWeightedAcyclic {
    //Have to find toposort first. Use that same stack for calculation

    public static void topoSort (int vertex, int[] visited, ArrayList<ArrayList<Pair<Integer, Integer>>> adjList, Stack<Integer> stack) {

        visited[vertex] = 1;

        for (Pair<Integer, Integer> pair : adjList.get(vertex)) {
            if (visited[pair.getKey()] != 1) {
                topoSort(pair.getKey(),visited,adjList, stack);
            }
        }
        stack.add(vertex);
    }

    public static void printShortestPath(int vertexCount, int source, ArrayList<ArrayList<Pair<Integer, Integer>>> adjList) {
        Stack<Integer> stack = new Stack<>();
        int[] dist = new int[vertexCount];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int[] visited = new int[vertexCount];

        for (int ct = 0; ct < vertexCount; ct++) {
            if (visited[ct] != 1) {
                topoSort(ct, visited, adjList, stack);
            }
        }

        dist[source] = 0;

        while (!stack.empty()) {
            int tempVertex = stack.pop();

            if (dist[tempVertex] != Integer.MAX_VALUE) {
                for (Pair<Integer, Integer> pair : adjList.get(tempVertex)) {
                    if (dist[tempVertex] + pair.getValue() < dist[pair.getKey()]) {
                        dist[pair.getKey()] = dist[tempVertex] + pair.getValue();
                    }
                }
            }
        }

        for (Integer itr : dist) {
            System.out.println(itr);
        }
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Pair<Integer, Integer>>> adjList = new ArrayList<>();
        int numberOfVertex = 6;

        for (int count=0; count < numberOfVertex; count++) {
            adjList.add(new ArrayList<Pair<Integer, Integer>>());
        }

        adjList.get(0).add(new Pair(1,2));
        adjList.get(0).add(new Pair(4,1));

        adjList.get(1).add(new Pair(2,3));

        adjList.get(2).add(new Pair(3,6));

        adjList.get(4).add(new Pair(2,2));
        adjList.get(4).add(new Pair(5,4));

        adjList.get(5).add(new Pair(3,1));

        printShortestPath(6, 0, adjList);
    }
}
