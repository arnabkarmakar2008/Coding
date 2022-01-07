package com.example.coding.graph.traversal;


import java.util.LinkedList;
import java.util.Queue;

class Cell {
    int x;
    int y;
    int distance;

    public Cell(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}

public class MinimumStepsToTargetByKnight {
    /**
     * Given a square chessboard of N x N size, the position of Knight and position of a target
     * is given.
     * We need to find out the minimum steps a Knight will take to reach the target position.
     *
     * Grid traversal technique : If Knight is at position (x,y) then knight can move to following
     * cells :
     * 1. (x-2)(y+1), (x-2)(y-1), (x-1)(y+2), (x-1)(y-2), (x-2)(y+2), (x-2)(y-2), (x-1)(y+1), (x-1)(y-1)
     *
     */

    /**
     * e.g source = [3,4]
     * @param source
     * @param dest
     * @param N
     * @return
     */
    public static int minimumMove(int[] source, int[] dest, int N) {
        // Take the possible moves in x and y array

        int[] moveX = {-2,-1,1,2,1,-2,2,-1};
        int[] moveY = {-1,-2,2,1,-2,1,-1,2};

        boolean[][] visited = new boolean[N+1][N+1];

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                visited[i][j] = false;
            }
        }

        Queue<Cell> queue = new LinkedList<>();

        queue.add(new Cell(source[0], source[1], 0));
        visited[source[0]][source[1]] = true;

        while (!queue.isEmpty()) {
            Cell temCell = queue.poll();

            if (temCell.x == dest[0] && temCell.y == dest[1]) {
                return temCell.distance;
            }

            for (int i=0; i<8; i++) {
                int newXPosition = temCell.x + moveX[i];
                int newYPosition = temCell.y + moveY[i];

                if (isValidCellInBoard(newXPosition, newYPosition, N) && visited[newXPosition][newYPosition] == false) {
                    visited[newXPosition][newYPosition] = true;
                    queue.add(new Cell(newXPosition, newYPosition, temCell.distance+1));
                }
            }
        }

        return -1;

    }

    public static boolean isValidCellInBoard(int x, int y, int totalCell) {
        if (x >=1 && x <= totalCell && y>=1 && y<= totalCell) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int N = 30;
        int knightPos[] = { 1, 1 };
        int targetPos[] = { 30, 30 };
        System.out.println(
                minimumMove(
                        knightPos, targetPos, N));
    }


}
