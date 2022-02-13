package com.example.coding.graph.leetcode;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an m x n grid. Each cell of the grid has a sign pointing to the next cell you should visit
 * if you are currently in this cell. The sign of grid[i][j] can be:
 *
 * 1 which means go to the cell to the right. (i.e go from grid[i][j] to grid[i][j + 1])
 * 2 which means go to the cell to the left. (i.e go from grid[i][j] to grid[i][j - 1])
 * 3 which means go to the lower cell. (i.e go from grid[i][j] to grid[i + 1][j])
 * 4 which means go to the upper cell. (i.e go from grid[i][j] to grid[i - 1][j])
 * Notice that there could be some signs on the cells of the grid that point outside the grid.
 *
 * You will initially start at the upper left cell (0, 0). A valid path in the grid is a path that starts from the upper left cell (0, 0) and ends at the bottom-right cell (m - 1, n - 1) following the signs on the grid. The valid path does not have to be the shortest.
 *
 * You can modify the sign on a cell with cost = 1. You can modify the sign on a cell one time only.
 */
class Cell {
    int row;
    int column;
    int cost;

    public Cell(int row, int column, int cost) {
        this.row = row;
        this.column = column;
        this.cost = cost;
    }
}
public class MinCostToMakeValidPathInGrid1368 {

    public static int minCost(int[][] grid) {
        int totalRows = grid.length;
        int totalColumns = grid[0].length;

        int targetRow = totalRows-1;
        int targetColumn = totalColumns-1;

        boolean[][] visited = new boolean[totalRows][totalColumns];
        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));

        pq.add(new Cell(0,0,0));
        //visited[0][0] = true;

        while (!pq.isEmpty()) {
            Cell tempCell = pq.poll();
            int tempRow = tempCell.row;
            int tempCol = tempCell.column;
            visited[tempCell.row][tempCell.column] = true;

            if (tempCell.row == targetRow && tempCell.column == targetColumn) {
                return tempCell.cost;
            }

            //Visit neighbours
            //if current cell is 1 -> Can go to next right cell
            if (tempCol+1 <= totalColumns-1 && !visited[tempRow][tempCol+1]) {
                pq.add(new Cell(tempRow, tempCol+1, (grid[tempRow][tempCol] == 1 ? 0 : 1) + tempCell.cost));
            }

            //if current cell is 2 -> Can go to right cell
            if (tempCol-1 >= 0 && !visited[tempRow][tempCol-1]) {
                pq.add(new Cell(tempRow, tempCol-1, (grid[tempRow][tempCol] == 2 ? 0 : 1) + tempCell.cost));
            }

            //if current cell is 3 -> Can go to lower cell
            if (tempRow+1 <= totalRows-1 && !visited[tempRow+1][tempCol]) {
                pq.add(new Cell(tempRow+1, tempCol, (grid[tempRow][tempCol] == 3 ? 0 : 1) + tempCell.cost));
            }

            //if current cell is 4 -> Can go to upper cell
            if (tempRow-1 >= 0 && !visited[tempRow-1][tempCol]) {
                pq.add(new Cell(tempRow-1, tempCol, (grid[tempRow][tempCol] == 4 ? 0 : 1) + tempCell.cost));
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1},{2,2,2,2},{1,1,1,1},{2,2,2,2}};
        System.out.println(minCost(grid));
    }
}
