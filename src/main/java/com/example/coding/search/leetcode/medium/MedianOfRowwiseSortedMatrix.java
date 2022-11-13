package com.example.coding.search.leetcode.medium;

public class MedianOfRowwiseSortedMatrix {

    /**
     * https://www.youtube.com/watch?v=63fPPOdIr2c
     * @param matrix
     * @return
     */
    public static int median(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int medianPosition = (row*col) / 2;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int i=0; i<row; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.min(high, matrix[i][col-1]); // As rows are sorted, max will be always on last col
        }

        while (low <= high) {
            int mid = (low+high)/2;
            int count = 0;

            //For each row count the total number of elements lesser or equal to mid.
            for (int i=0; i<row; i++) {
                count = count + countNumberOfElementsSmallerEqualToMid(matrix[i], mid);
            }

            //If count is less than or equal to medianPosition, move right
            if (count <= medianPosition) {
                low = mid+1;
            } else {
                high = mid -1;
            }
        }

        return low;

    }

    private static int countNumberOfElementsSmallerEqualToMid(int[] nums, int target) {
        int l = 0;
        int high = nums.length-1;

        while (l <= high) {
            int mid = (l+high)/2;

            if (nums[mid] <= target) {
                l = mid+1;
            } else {
                high = mid-1;
            }
        }

        return l;
    }


    public static void main(String[] args) {
        int[][] matrix = {{1,3,6}, {2,6,9}, {3,6,9}};


    }
}
