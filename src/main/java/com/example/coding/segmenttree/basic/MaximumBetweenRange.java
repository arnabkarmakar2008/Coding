package com.example.coding.segmenttree.basic;

/**
 * https://www.youtube.com/watch?v=-dUiRtJ8ot0
 */
public class MaximumBetweenRange {

    public static int findMaxBetweenRange(int[] nums, int low, int high) {
        int[] st = new int[4* nums.length];
        buildSegmentTree(st, nums, 0, 0, nums.length-1);
        return querySegmentTree(st, 0, 0, nums.length-1, low, high);
    }

    public static void buildSegmentTree(int[] st, int[] nums, int index, int start, int end) {
        if (start == end) {
            st[index] = nums[start];
            return;
        }

        int mid = (start+end)/2;
        buildSegmentTree(st, nums, 2*index+1, start, mid); //left call
        buildSegmentTree(st, nums, 2*index+2, mid+1, end); //right call
        st[index] = Math.max(st[2*index+1], st[2*index+2]);
    }

    public static int querySegmentTree(int[] st, int index, int start, int end, int low, int high) {
        //completely lies between
        if (start>= low && end <= high) {
            return st[index];
        }

        //Doesn't lie between
        if (end < low || start > high) {
            return Integer.MIN_VALUE;
        }

        int mid = (start+end)/2;

        int left = querySegmentTree(st, 2*index+1, start, mid, low, high);
        int right = querySegmentTree(st, 2*index+2, mid+1, end, low, high);
        return Math.max(left, right);

    }

    public static void main(String[] args) {
        int[] nums = {8,2,5,1,4,5,3,9,6,10};
        System.out.println(findMaxBetweenRange(nums, 3, 8));
    }
}
