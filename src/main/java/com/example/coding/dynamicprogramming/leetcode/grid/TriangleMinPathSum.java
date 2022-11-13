package com.example.coding.dynamicprogramming.leetcode.grid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a triangle array, return the minimum path sum from top to bottom.
 *
 * For each step, you may move to an adjacent number of the row below.
 * More formally, if you are on index i on the current row, you may move to either
 * index i or index i + 1 on the next row.
 */
public class TriangleMinPathSum {

    /**
     * https://www.youtube.com/watch?v=1IL5sxfoA-I&t=548s
     *
     *
     * @param triangle
     * @return
     */
    public static int minTotalBottomUp(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int rows = triangle.size(); // rows
        int cols = triangle.get(rows-1).size(); // last row size

        int[] dp = new int[rows];

        List<Integer> lastRowList = triangle.get(rows-1);

        for (int i=0; i< lastRowList.size(); i++) {
            dp[i] = lastRowList.get(i);
        }

        for (int i=rows-2; i>=0; i--) {
            for (int j=0; j < triangle.get(i).size(); j++) {
                dp[i] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }

        return dp[0]; // Finally we are converging to top.
    }


    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();

        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3,4));
        list.add(Arrays.asList(6,5,7));
        list.add(Arrays.asList(4,1,8,3));

        System.out.println(minTotalBottomUp(list));

    }
}
