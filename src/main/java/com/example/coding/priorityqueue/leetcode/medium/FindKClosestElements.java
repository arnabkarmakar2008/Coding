package com.example.coding.priorityqueue.leetcode.medium;

import java.util.*;

/**
 * Given a sorted integer array arr, two integers k and x,
 * return the k closest integers to x in the array. The result should also be sorted in ascending order.
 *
 * An integer a is closer to x than an integer b if:
 *
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,3,4,5], k = 4, x = 3
 * Output: [1,2,3,4]
 * Example 2:
 *
 * Input: arr = [1,2,3,4,5], k = 4, x = -1
 * Output: [1,2,3,4]
 */
public class FindKClosestElements {

    /**
     * https://www.youtube.com/watch?v=1otAwCQG7XM
     *
     * Complexity to add/remove element from pq is logk where k is the current size of pq.
     *
     *
     * Complexity : nlogk for adding/removing loop is running for n times but adding/removing only k times.
     * Also to sort klogk
     * So total :: nlogk + klogk
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> resultList = new ArrayList<>();

        PriorityQueue<Pair> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());

        for (int ct=0; ct < arr.length; ct++) {
            Pair pair = new Pair(arr[ct], Math.abs(arr[ct] - x));

            if (maxPQ.size() < k) {
                maxPQ.offer(pair);
            } else {
                Pair tempPair = maxPQ.peek();

                if (tempPair.gap > pair.gap) {
                    maxPQ.poll();
                    maxPQ.offer(pair);
                }
            }
        }

        while (!maxPQ.isEmpty()) {
            resultList.add(maxPQ.poll().value);
        }

        Collections.sort(resultList);

        return resultList;

    }

    static class Pair implements Comparable<Pair> {
        int value;
        int gap;

        public Pair(int value, int gap) {
            this.value = value;
            this.gap = gap;
        }

        public Pair() {

        }

        public int compareTo(Pair other) {
            if (other.gap == this.gap) {
                return this.value - other.value;
            } else {
                return this.gap - other.gap;
            }
        }
    }

    /**
     * https://www.youtube.com/watch?v=6AackEaa0Qs
     * Complexity :: logn for BS and then klogk for sorting
     * logn + klogk
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public static List<Integer> findClosestElementsOptimized(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length-1;
        int mid = 0;

        while (low < high) {
            mid = low + (high-low)/2;

            if (arr[mid] == x) {
                break;
            } else if (x < arr[mid]) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        int leftPointer = mid-1;
        int rightPointer = mid;

        List<Integer> list = new ArrayList<>();

        while (leftPointer >=0 && rightPointer < arr.length && k >0) {

            if (Math.abs(arr[leftPointer] - x) <= Math.abs(arr[rightPointer] - x)) {
                list.add(arr[leftPointer]);
                leftPointer--;
            } else {
                list.add(arr[rightPointer]);
                rightPointer++;
            }

            k--;
        }

        if (k > 0 && leftPointer >=0) {
            list.add(arr[leftPointer]);
            k--;
            leftPointer--;
        }

        if (k > 0 && rightPointer < arr.length) {
            list.add(arr[rightPointer]);
            k--;
            rightPointer++;
        }

        Collections.sort(list);

        return list;
    }



    public static void main(String[] args) {

    }
}
