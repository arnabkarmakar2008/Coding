package com.example.coding.dynamicprogramming.leetcode.grid;

/**
 * The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon.
 * The dungeon consists of m x n rooms laid out in a 2D grid. Our valiant knight was initially positioned in the
 * top-left room and must fight his way through dungeon to rescue the princess.
 *
 * The knight has an initial health point represented by a positive integer.
 * If at any point his health point drops to 0 or below, he dies immediately.
 *
 * Some of the rooms are guarded by demons (represented by negative integers),
 * so the knight loses health upon entering these rooms; other rooms are either empty (represented as 0)
 * or contain magic orbs that increase the knight's health (represented by positive integers).
 *
 * To reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
 *
 * Return the knight's minimum initial health so that he can rescue the princess.
 *
 * Note that any room can contain threats or power-ups, even the first room the knight enters
 * and the bottom-right room where the princess is imprisoned.
 */
public class DungeonGame {

    /**
     * https://www.youtube.com/watch?v=LbC0ejgACkE
     *
     * Have to start from bottom. First feel [row-1][col-1] cell. Then fill last row and col.
     * Then do calculation : Math.min(dp[i][j+1], dp[i+1][j]]) - grid[i][j]. If above is equal or below 0 then 1.
     * Energy cannot go below 0. So setting it to 1.
     * @param dungeon
     * @return
     */
    public static int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        int[][] dp = new int[rows][cols];

        dp[rows-1][cols-1] = dungeon[rows-1][cols-1] <= 0 ? Math.abs(dungeon[rows-1][cols-1]) + 1 : 1;


        for (int i = rows-1; i>=0; i--) {
            for (int j = cols-1; j>=0; j--) {

                if (i == rows-1 && j == cols-1) {
                    continue;
                } else {
                    if (i == rows-1) {
                        dp[i][j] = dp[i][j+1] - dungeon[i][j] < 0 ? 1 : dp[i][j+1] - dungeon[i][j];
                    }

                    if (j == cols-1) {
                        dp[i][j] = dp[i+1][j] - dungeon[i][j] < 0 ? 1 : dp[i+1][j] - dungeon[i][j];
                    }
                }

            }
        }

        for (int i = rows-2; i>=0; i--) {
            for (int j = cols-2; j>=0; j--) {
                dp[i][j] = Math.max(Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j], 1);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] grid = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        System.out.println(calculateMinimumHP(grid));
    }
}
