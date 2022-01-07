package com.example.coding.graph;

import java.util.Comparator;

public class GraphNode implements Comparable {
    int value;
    int weight;

    public GraphNode(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public GraphNode() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Object o) {
        GraphNode newNode = (GraphNode) o;

        if (this.weight < newNode.weight) return -1;
        if (this.weight > newNode.weight) return 1;
        else return 0;
    }
}
