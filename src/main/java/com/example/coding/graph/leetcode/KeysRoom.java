package com.example.coding.graph.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeysRoom {

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] visited  = new int[rooms.size()];

        visited[0] = 1;

        dfs(rooms, visited, 0);

        for (int i=0; i<visited.length; i++) {
            if (visited[i] != 1) {
                return false;
            }
        }

        return true;
    }

    public static void dfs(List<List<Integer>> rooms, int[] visited, int source) {
        visited[source] = 1;

        for (Integer room : rooms.get(source)) {
            if (visited[room] == 0) {
                dfs(rooms, visited, room);
            }
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        int numberOfVertices = 4;

        rooms.add(0, new ArrayList<>(Arrays.asList(1)));
        rooms.add(1, new ArrayList<>(Arrays.asList(2)));
        rooms.add(2, new ArrayList<>(Arrays.asList(3)));
        rooms.add(3, new ArrayList<>(new ArrayList<>()));

        System.out.println(canVisitAllRooms(rooms));
    }
}
