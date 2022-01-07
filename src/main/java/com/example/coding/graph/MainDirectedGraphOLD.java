package com.example.coding.graph;

import java.util.Arrays;

public class MainDirectedGraphOLD {
    private int MAX_COUNT;
    private int vertexCount;
    private Vertex[] vertices;
    private int[][] adjMatrix;

    public MainDirectedGraphOLD(int MAX_COUNT) {
        this.MAX_COUNT = MAX_COUNT;
        vertices = new Vertex[MAX_COUNT];
        adjMatrix = new int[MAX_COUNT][MAX_COUNT];

        for (int row=0; row < MAX_COUNT; row ++) {
            for (int column=0; column < MAX_COUNT; column++ ) {
                adjMatrix[row][column] = 0;
            }
        }
    }

    public void addVertex(char vertexData) {
        vertices[vertexCount++] = new Vertex(vertexData);
    }

    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
    }

    public void displayVertex(int index) {
        System.out.println(vertices[index].data);
    }

    public Vertex[] getVertices() {
        return vertices;
    }

    public void setVertices(Vertex[] vertices) {
        this.vertices = vertices;
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    public void setAdjMatrix(int[][] adjMatrix) {
        this.adjMatrix = adjMatrix;
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public void setVertexCount(int vertexCount) {
        this.vertexCount = vertexCount;
    }

    public static void main(String[] args) {
        MainDirectedGraphOLD graph = new MainDirectedGraphOLD(4);
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');

        graph.addEdge(0,1);
        graph.addEdge(0,2);

        for(int[] arr : graph.adjMatrix){
            System.out.println(Arrays.toString(arr));
        }
    }
}
