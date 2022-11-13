package com.example.coding.graph.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * You are given an array of variable pairs equations and an array of real numbers values,
 * where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i].
 * Each Ai or Bi is a string that represents a single variable.
 *
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find
 * the answer for Cj / Dj = ?.
 *
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 *
 * Note: The input is always valid. You may assume that evaluating the queries will not result in division by
 * zero and that there is no contradiction.
 */
public class EvaluateDivision {

    /**
     * https://leetcode.com/problems/evaluate-division/discuss/171649/1ms-DFS-with-Explanations
     *
     * Does the direction of an edge matters? -- Yes. Take a / b = 2 for example, it indicates a --2--> b as well as b --1/2--> a.
     * Thus, it is a directed weighted graph.
     * In this graph, how do we evaluate division?
     * Take a / b = 2, b / c = 3, a / c = ? for example,
     *
     * a --2--> b --3--> c
     * We simply find a path using DFS from node a to node c and multiply the weights of edges passed, i.e. 2 * 3 = 6.
     *
     * Please note that during DFS,
     *
     * Rejection case should be checked before accepting case.
     * Accepting case is (graph.get(u).containsKey(v)) rather than (u.equals(v)) for it takes O(1) but (u.equals(v))
     * /hfo,bntakes O(n) for n is the length of the longer one between u and v.
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        //Build graph
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);

        double[] result = new double[queries.length];

        for (int ct=0; ct< queries.length; ct++) {
            result[ct] = getPathWeight(queries[ct][0], queries[ct][1], new HashSet<>(), graph);
        }

        return result;

    }

    private double getPathWeight(String start, String end, HashSet<String> visited, Map<String, Map<String, Double>> graph) {
        //Rejection case
        if (!graph.containsKey(start)) {
            return -1;
        }

        //If there exists a direct path
        if (graph.get(start).containsKey(end)) {
            return graph.get(start).get(end);
        }

        visited.add(start);

        for (Map.Entry<String, Double> neighbour : graph.get(start).entrySet()) {
            //If neigh not visited
            if (!visited.contains(neighbour.getKey())) {
                double productWeight = getPathWeight(neighbour.getKey(), end, visited, graph);
                if (productWeight != -1) {
                    return neighbour.getValue() * productWeight;
                }
            }
        }

        return -1;
    }

    private Map<String, Map<String, Double>> buildGraph(String[][] equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        String u, v;

        for (int ct=0; ct < equations.length; ct++) {
            u = equations[ct][0];
            v = equations[ct][1];

            graph.putIfAbsent(u, new HashMap<String, Double>());
            graph.get(u).put(v, values[ct]);

            graph.putIfAbsent(v, new HashMap<String, Double>());
            graph.get(v).put(u, 1/values[ct]);
        }

        return graph;
    }


    public static void main(String[] args) {

    }
}
