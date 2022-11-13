package com.example.coding.priorityqueue.leetcode.medium;

import java.util.PriorityQueue;

/**
 * https://www.youtube.com/watch?v=dYfM6J1y0mU&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=4
 */
public class SortAKSortedArray {

    /**
     * In this array right element can be found within K range.
     * @param nums
     * @param k
     */
    public static void kSorted(int[] nums, int k) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        int index = 0;

        for (int ct=0; ct< nums.length; ct++) {
            minPQ.offer(nums[ct]);

            if (minPQ.size() > k) {
                int element = minPQ.poll();
                nums[index++] = element;
            }
        }

        while (index < nums.length && !minPQ.isEmpty()) {
            nums[index++] = minPQ.poll();
        }
    }

    public static void main(String[] args) {
        int[] arr = {6,5,3,2,8,10,9};
        kSorted(arr, 3);
    }
}
