package com.example.coding.graph.leetcode;

import javafx.util.Pair;
import java.util.LinkedList;
import java.util.Queue;

/**
 * There is a ball in a maze with empty spaces and walls.
 * The ball can go through empty spaces by rolling up, down, left or right,
 * but it won't stop rolling until hitting a wall. When the ball stops,
 * it could choose the next direction.
 *
 * Given the ball's start position, the destination and the maze, determine whether
 * the ball could stop at the destination.
 *
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space.
 * You may assume that the borders of the maze are all walls. The start and destination coordinates are
 * represented by row and column indexes.
 */
public class TheMaze {

    /**
     * https://www.youtube.com/watch?v=0c5bE5kU5QI
     *
     * @param maze
     * @param start
     * @param destination
     * @return
     */
    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        //write your code here
        int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();

        queue.add(new Pair<>(start[0], start[1]));
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> tempPair = queue.poll();
            int tempRow = tempPair.getKey();
            int tempCol = tempPair.getValue();

            if (tempRow == destination[0] && tempCol == destination[1]) {
                return true;
            }

            for (int[] dir : direction) {
                int newRow = tempRow + dir[0];
                int newCol = tempCol + dir[1];

                if (newRow >= maze.length || newCol <= maze[0].length ||
                visited[newRow][newCol] == true) {
                    continue;
                } else {
                    visited[newRow][newCol] = true;
                    queue.add(new Pair<>(newRow, newCol));
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = {0,4};
        int[] dest = {3,2};
        System.out.println(hasPath(maze, start, dest));
    }
}
