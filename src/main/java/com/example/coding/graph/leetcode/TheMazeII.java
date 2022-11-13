package com.example.coding.graph.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up,
 * down, left or right, but it won't stop rolling until hitting a wall. When the ball stops,
 * it could choose the next direction.
 *
 * Given the ball's start position, the destination and the maze, find the shortest distance for the ball
 * to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from
 * the start position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.
 *
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume
 * that the borders of the maze are all walls. The start and destination coordinates are represented by row and
 * column indexes.
 */
public class TheMazeII {
    static int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
    /**
     * BFS will not work here though it is looking like non-weighted graph. Ball will change direction when it will
     * hit wall only. So have to consider distance as weight of the edge.
     * https://www.youtube.com/watch?v=E2DpGhLF2nM
     *
     *
     * @param maze
     * @param start
     * @param destination
     * @return
     */
    public static int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // write your code here
        int n = maze.length;
        int m = maze[0].length;

        int[][] distance = new int[n][m];

        for (int i=0; i<n; i++) {
            Arrays.asList(distance[i], Integer.MAX_VALUE);
        }

        distance[start[0]][start[1]] = 0;
        dijkstra(maze, start, destination, distance);

        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];

    }

    private static void dijkstra(int[][] maze, int[] start, int[] destination, int[][] distance) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[2]-b[2])); // index 0 = x, 1 = y, 2 = step
        pq.offer(new int[] {start[0], start[1], 0});

        int m = maze.length;
        int n = maze[0].length;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            for (int[] dir : direction) {
                int x = current[0] + dir[0];
                int y = current[1] + dir[1];
                int currentStep = 1;

                while (x >=0 && y>=0 && x < m && y <n) {
                    x += dir[0];
                    y += dir[1];
                    currentStep++;
                }

                x -= dir[0];
                y -= dir[1];
                currentStep--;

                if (distance[current[0]][current[1]] + currentStep < distance[x][y]) {
                    distance[x][y] = distance[current[0]][current[1]] + currentStep;
                    pq.add(new int[] {x, y, distance[x][y]});
                }
            }
        }

    }


    public static void main(String[] args) {
        int[][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = {0,4};
        int[] dest = {3,2};
        System.out.println(shortestDistance(maze, start, dest));
    }
}
