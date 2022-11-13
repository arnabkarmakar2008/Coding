package com.example.coding.slidingwindow.leetcode.hard;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * The median is the middle value in an ordered integer list. If the size of the list is even,
 * there is
 * no middle value. So the median is the mean of the two middle values.
 *
 * For examples, if arr = [2,3,4], the median is 3.
 * For examples, if arr = [1,2,3,4], the median is (2 + 3) / 2 = 2.5.
 * You are given an integer array nums and an integer k. There is a sliding window of size k
 * which is moving from the very left of the array to the very right. You can only see the k
 * numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the median array for each window in the original array. Answers within 10-5 of the
 * actual value will be accepted.
 */
public class SlidingWindowMedian {

    /**
     * https://leetcode.com/problems/sliding-window-median/
     *
     * This is same as median of data stream.
     *
     * We will need to heap max and min heap.
     *
     * Max heap will store left elements and min will store right elements
     *
     * Insert element in min-heap. Remove element from min-heap and insert in max-heap.
     *
     * If size(max-heap) > size(min-heap) then remove element from max-heap and insert into min-heap.
     *
     * Once window size is reached calculate median.
     *
     * if window size is odd, then median is element from min-heap.
     * if even : first element from min-heap+first element from max-heap/2.
     *
     * Slide the window. Check which heap has start element. Then remove from that heap.
     *
     *
     *
     * @param nums
     * @param k
     * @return
     */
    public static double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int resultIndex = 0;
        double[] resultArray = new double[nums.length - k +1];
        int start = 0;
        int end = 0;

        while (end < nums.length) {
            if (end - start + 1 > k) {
                minHeap.remove(nums[start]);
                maxHeap.remove(nums[start]);
                start++;
            } else {
                minHeap.add(nums[end]);
                maxHeap.add(minHeap.poll());
                balanceHeap(minHeap, maxHeap);

                if (end - start + 1 == k) {
                    resultArray[resultIndex++] = getMedian(minHeap, maxHeap, k);
                }

                end++;

            }
        }

        return resultArray;

    }

    private static double getMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, int k) {
        if (k%2 == 0) {
            return (minHeap.peek() + maxHeap.peek())/2;
        } else {
            return minHeap.peek();
        }
    }

    private static void balanceHeap(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7}; int k = 3;

        double[] resultArray = medianSlidingWindow(nums, k);
        System.out.println(resultArray);
    }
}
