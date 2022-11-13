package com.example.coding.board;

import javafx.util.Pair;

import java.util.List;
import java.util.PriorityQueue;

public class Fibo {
    public static void main(String[] args) {
        int input = 4;

        /**
         * 0 1 1 2 3 5 8
         */
        System.out.println(fib(7));
    }

    public static int fib (int input) {
        if (input == 0 || input ==1) {
            return input;
        }

        return fib(input-1) + fib(input-2);
    }

    static int[][] directions = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};

    public static void dfs (int[][] land, List<int[]> resultList, int row, int col) {
        int endRow = -1;
        int endCol = -1;

        land[row][col] = 0;
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<Pair<Integer, Integer>>();
        pq.add(new Pair<>(row, col));

        while (!pq.isEmpty()) {
            endRow = pq.poll().getKey();
            endCol = pq.poll().getValue();

            for (int[] dir : directions) {
                int newEndRow = endRow + dir[0];
                int newEndCol = endCol + dir[1];

                if (newEndRow < land.length && newEndRow >=0 && newEndCol < land[0].length && newEndCol>= 0 &&
                land[newEndRow][newEndCol] == 1) {
                    pq.add(new Pair<>(newEndRow, newEndCol));
                }
            }
        }

        resultList.add(new int[] {row, col, endRow, endCol});
    }
}
