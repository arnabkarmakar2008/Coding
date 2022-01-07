package com.example.coding.graph;

public class TopologicalTraversaOLD {

    public static char[] sortedList;

    /**
     * 1. Find vertex that has no successor
     * 2. Delete vertex from the graph and insert its label at the beginning of the list
     */
    public static void topologySorting(MainDirectedGraphOLD graph) {
        int vertexCount = graph.getVertexCount();
        sortedList = new char[vertexCount];
        while (graph.getVertexCount() > 0) {
            int successorIndex = noSuccessorIndex(graph);

            if (successorIndex == -1) {
                System.out.println("Cyclic graph. Topology sort not possible");
                break;
            }

            sortedList[graph.getVertexCount()-1] = graph.getVertices()[successorIndex].data;
            deleteVertex(graph, successorIndex);
            graph.setVertexCount(graph.getVertexCount()-1);
        }
    }

    private static int noSuccessorIndex(MainDirectedGraphOLD graph) {
        int numberOfVertices = graph.getVertexCount();
        int[][] adjMatrix = graph.getAdjMatrix();

        for (int row = 0; row < numberOfVertices;  row ++) {
            boolean flag = false;

            for (int column = 0; column < numberOfVertices; column ++) {
                if (adjMatrix[row][column] > 0) {
                    flag = true;
                }
            }

            if (flag == false) {
                return row;
            }
        }

        return -1;
    }

    private static void deleteVertex(MainDirectedGraphOLD graph, int index) {
        int numberOfVertices = graph.getVertexCount();
        Vertex[] verticesList = graph.getVertices();

        //Not last index
        if (index != numberOfVertices-1) {
            for (int count = index; count < numberOfVertices-1; count ++) {
                // need to shift position in array due to delete from middile
                verticesList[count] = verticesList[count+1];
                verticesList[count+1] = new Vertex('X');
            }

            // Shift row in adjmatrix
            for (int row = index; row < numberOfVertices-1; row ++ ) {
                for (int column =0; column < numberOfVertices-1; column ++ ) {
                    graph.getAdjMatrix()[row][column] = graph.getAdjMatrix()[row+1][column];
                    graph.getAdjMatrix()[row+1][column] = -1;
                }
            }

            // Shift column in adjmatrix
            for (int column = index; column < numberOfVertices-1; column ++ ) {
                for (int row =0; row < numberOfVertices-2; row ++ ) {
                    graph.getAdjMatrix()[row][column] = graph.getAdjMatrix()[row][column+1];
                    graph.getAdjMatrix()[row][column+1] = -1;
                }
            }
        }
    }




    public static void main(String[] args) {
        MainDirectedGraphOLD graph = new MainDirectedGraphOLD(8);

        graph.addVertex('A'); //0
        graph.addVertex('B'); //1
        graph.addVertex('C'); //2
        graph.addVertex('D'); //3
        graph.addVertex('E'); //4
        graph.addVertex('F'); //5
        graph.addVertex('H'); //6
        graph.addVertex('G'); //7


        graph.addEdge(0,3);
        graph.addEdge(0,4);
        graph.addEdge(1,4);
        graph.addEdge(2,5);
        graph.addEdge(3,7);
        graph.addEdge(4,7);
        graph.addEdge(5,6);
        graph.addEdge(7,6);

        topologySorting(graph);


        for (char c : sortedList) {
            System.out.println(c);
        }

    }
}
