package com.example.coding.graph.algo.kahns;

import java.util.ArrayList;

class Node {
    int u;
    int v;
    int weight;

    public Node(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    public int getU() {
        return u;
    }

    public int getV() {
        return v;
    }

    public int getWeight() {
        return weight;
    }
}

public class BellmanFordNegativeCycleDetection {
    /**
     * 1. Relax all the edges N-1 times
     * if (dist[u] + weight < dist[v])
     *  dist[v] = dist[u] + weight // Do these steps for N-1 time.
     *
     *
     */

    public static void bellmanFord(ArrayList<Node> edges, int numberOfVertices, int source) {
        //take distance array
        int[] dist = new int[numberOfVertices];
        dist[source] = 0;

        for (int count = 1; count < numberOfVertices; count++) {
            dist[count] = 100000;
        }

        // Relax N-1 times
        for (int count = 1; count <= numberOfVertices-1; count++) {
            for (Node edge : edges) {
                if (dist[edge.getU()] + edge.getWeight() < dist[edge.getV()]) {
                    dist[edge.getV()] = dist[edge.getU()] + edge.getWeight();
                }
            }
        }

        // Now after relaxing for N-1 times, dist array will have shortest distance from source.
        // Now we have to relax for oe more time to detect negative cycle. If distance reduces then
        //there is negative cycle.

        int flag = 0;

        for (Node edge : edges) {
            if (dist[edge.getU()] + edge.getWeight() < dist[edge.getV()]) {
                flag = 1;
                System.out.println("There is negative cycle in the graph");
                break;
            }
        }


    }

    public static void main(String[] args) {
        ArrayList<Node> edges = new ArrayList<>();
        edges.add(new Node(0,1,-2));
        edges.add(new Node(1,2,-3));
        edges.add(new Node(2,0,2));

        int numberOfVertices = 3;

        bellmanFord(edges, 3, 0);
    }


}
