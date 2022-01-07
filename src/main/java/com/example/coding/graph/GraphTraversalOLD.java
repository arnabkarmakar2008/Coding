package com.example.coding.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphTraversalOLD {

    public static void dfs(MainGraphOLD graph) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        graph.getVertices()[0].wasVisited = true;
        graph.displayVertex(0);

        /**
         * 1. If possible visit adjacent vertex, mark it and push.
         * 2. If 1 is not possible, pop stack.
         * 3. If both are not possible return
         */

        while (!stack.empty()) {
            int adjIndex = adjUnvisitedVertex(graph, stack.peek());
            if (adjIndex == -1) {
                stack.pop();
            } else {
                stack.push(adjIndex);
                graph.getVertices()[adjIndex].wasVisited = true;
                graph.displayVertex(adjIndex);
            }
        }

        for (Vertex vertex : graph.getVertices()) {
            vertex.wasVisited = false;
        }
    }


    /**
     * 1. Visit next unvisited vertex, mark it, display and push to queue
     * 2. If rule 1 is not possible, then there are no more unvisited vertex, remove from queue and
     * make it as current vertex.
     * @param graph
     */
    public static void bfs(MainGraphOLD graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        graph.getVertices()[0].wasVisited = true;
        graph.displayVertex(0);
        int v2;

        while (!queue.isEmpty()) {
            int index = queue.remove();
            //graph.getVertices()[index].wasVisited = true;
            //graph.displayVertex(index);

            while ((v2 = adjUnvisitedVertex(graph, index)) != -1) {
                graph.getVertices()[v2].wasVisited = true;
                graph.displayVertex(v2);
                queue.add(v2);

            }
        }

        for (Vertex vertex : graph.getVertices()) {
            vertex.wasVisited = false;
        }
    }

    // Returns index of unvisited vertex
    private static int adjUnvisitedVertex(MainGraphOLD graph, int index) {
        for (int count=0; count < graph.getCurrentVertexIndex(); count ++) {
            if (graph.getAdjMatrix()[index][count] == 1
                    && graph.getVertices()[count].wasVisited == false) {
                return count;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        MainGraphOLD graph = new MainGraphOLD(8);

        graph.addVertex('A'); //0
        graph.addVertex('B'); //1
        graph.addVertex('C'); //2
        graph.addVertex('D'); //3
        graph.addVertex('E'); //4
        graph.addVertex('F'); //5
        graph.addVertex('G'); //6
        graph.addVertex('H'); //7


        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(0,4);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(6,7);

        System.out.println("DFS Display === ");

        dfs(graph);

        System.out.println("BFS Display === ");
        bfs(graph);

        /*for(int[] arr : graph.getAdjMatrix()){
            System.out.println(Arrays.toString(arr));
        }*/
    }
}
