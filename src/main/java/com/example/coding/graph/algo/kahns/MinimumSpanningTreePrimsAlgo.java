package com.example.coding.graph.algo.kahns;

import com.example.coding.graph.GraphNode;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * If we can convert a graph to tree such that it has N nodes and N-1 edges and nodes are reachable
 * from every other nodes : Spanning tree. Minimum edge weight is min spanning tree. Min cost of edges
 */
public class MinimumSpanningTreePrimsAlgo {
    //Fine min weight edge of first vertex. Then move to the vertex which edge is pointing. Then find
    // the min weight edge of both vertices and select that. And this continues until all the vertices are
    //visited

    public static void primsAlgo(int numberOfVertices, ArrayList<ArrayList<GraphNode>> adjList) {
        int weight[] = new int[numberOfVertices];
        int parent[] = new int[numberOfVertices];
        boolean mstArray[] = new boolean[numberOfVertices];

        for (int i=0; i < numberOfVertices; i++) {
            weight[i] = Integer.MAX_VALUE;
            parent[i] = -1;
            mstArray[i] = false;
        }

        PriorityQueue<GraphNode> queue = new PriorityQueue();
        weight[0] = 0;
        queue.add(new GraphNode(0, weight[0]));

        for (int i=0; i < numberOfVertices; i++) {
            int tempVertex = queue.poll().getValue();
            mstArray[tempVertex] = true;

            for (GraphNode graphNode : adjList.get(tempVertex)) {
                if (mstArray[graphNode.getValue()] == false && weight[graphNode.getValue()] > graphNode.getWeight()) {
                    weight[graphNode.getValue()] = graphNode.getWeight();
                    parent[graphNode.getValue()] = tempVertex;
                    queue.add(graphNode);
                }
            }
        }

        for (int i=1; i <numberOfVertices; i++) {
            System.out.println(parent[i] + "-" + i);
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<GraphNode>> adjList = new ArrayList<>();
        int numberOfVertex = 4;

        for (int count=0; count < numberOfVertex; count++) {
            adjList.add(new ArrayList<GraphNode>());
        }

        adjList.get(0).add(new GraphNode(1,2));
        adjList.get(0).add(new GraphNode(2,2));

        adjList.get(1).add(new GraphNode(0,2));
        adjList.get(1).add(new GraphNode(2,1));
        adjList.get(1).add(new GraphNode(3,3));

        adjList.get(2).add(new GraphNode(0,2));
        adjList.get(2).add(new GraphNode(1,1));
        adjList.get(2).add(new GraphNode(3,2));

        adjList.get(3).add(new GraphNode(1,3));
        adjList.get(3).add(new GraphNode(2,2));



        primsAlgo(4, adjList);

    }
}
