package com.example.coding.slidingwindow.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * You are given an array of integers nums, there is a sliding window
 * of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves
 * right by one position.
 *
 * Return the max sliding window.
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 */
public class SlidingWindowMaximum {

    /**
     * https://www.youtube.com/watch?v=CZQGRp93K4k
     *
     * We have to use deque. It is nothing but doubly linked list. Can be inserted/deleted from
     * both ends.
     * In deque we will be maintaining decreasing values. Front of the deque will have max value
     * and end will have the lowest value.
     *
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int[] answerArray = new int[nums.length-k+1];
        int ansCount = 0;
        Deque<Integer> deque = new ArrayDeque<>(); // We will be storing index here

        for (int i=0; i< nums.length; i++) {

            //if queue is not empty and there is no out of bound index - remove from front
            if (!deque.isEmpty() && deque.peek() == i - k) {
                deque.poll();
            }

            //As we are maintaining decreasing queue.
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(nums[i]);

            if (i >= k-1) {
                answerArray[ansCount++] = nums[deque.peek()];
            }
        }

        return answerArray;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        int[] resultArray = maxSlidingWindow(nums, k);
    }
}
