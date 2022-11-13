package com.example.coding.graph.algo.kahns;

import com.example.coding.graph.GraphNode;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ShortestDistanceUndirectedWeightedDijkstarsAlgo {

    /**
     * Dijkstars Algo :: Find the shortest distances of all nodes from source node.
     * @param numberOfVertices
     * @param sourceVertex
     * @param adjList
     */

    public static void shortestPath(int numberOfVertices, GraphNode sourceVertex, ArrayList<ArrayList<GraphNode>> adjList) {

        // Initialize distance array
        int distance[] = new int[numberOfVertices];
        int parent[] = new int[numberOfVertices];
        boolean shortestPathArray[] = new boolean[numberOfVertices];

        for (int i=0; i < numberOfVertices; i++) {
            distance[i] = Integer.MAX_VALUE;
            parent[i] = -1;
            shortestPathArray[i] = false;
        }

        /**
         * Traverse adj vertex. If new weight is less than in the dist[], then update it and store in PQ.
         * We need PQ as we always want to move to minimum distance from the current vertex. PQ is based on the distance.
         * Minimum distance vertex will always be returned from PQ for poll()
         */

        PriorityQueue<GraphNode> priorityQueue = new PriorityQueue<>();
        distance[0] = 0;
        priorityQueue.add(new GraphNode(0, distance[0]));


        while (!priorityQueue.isEmpty()) {
            GraphNode tempNode = priorityQueue.poll();

            for (GraphNode adjNode : adjList.get(tempNode.getValue())) {
                if (distance[tempNode.getValue()] + adjNode.getValue() < distance[adjNode.getValue()]) {
                    distance[adjNode.getValue()] = distance[tempNode.getValue()] + adjNode.getValue();
                    priorityQueue.add(new GraphNode(adjNode.getValue(), distance[adjNode.getValue()]));
                }
            }
        }



        /*for (int i=0; i < numberOfVertices; i++) {
            GraphNode tempNode = priorityQueue.poll();
            shortestPathArray[tempNode.getValue()] = true;

            for (GraphNode adjNode : adjList.get(tempNode.getValue())) {
                int newDistance = distance[tempNode.getValue()] + adjNode.getWeight();

                if (shortestPathArray[adjNode.getValue()] == false && distance[adjNode.getValue()] > newDistance) {
                    distance[adjNode.getValue()] = newDistance;
                    parent[adjNode.getValue()] = tempNode.getValue();
                    priorityQueue.add(adjNode);
                }
            }
        }

        for (int i=1; i <numberOfVertices; i++) {
            System.out.println(parent[i] + "-" + i);
        }
*/
        for (int i=0; i<numberOfVertices; i++) {
            System.out.println("Shortest distance from 0 to "+i +" is " + distance[i]);
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


        shortestPath(numberOfVertex, new GraphNode(0,0), adjList);

    }
}
