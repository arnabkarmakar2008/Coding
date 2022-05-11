package com.example.coding.twopointers.leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianOfDataStream {

  /**
   * https://leetcode.com/problems/find-median-from-data-stream/discuss/1330646/C%2B%2BJavaPython-MinHeap-MaxHeap-Solution-Picture-explain-Clean-and-Concise
   *
   * @param args
   */
  public static void main(String[] args) {
    MedianFinder medianFinder = new MedianFinder();
  }
}

class MedianFinder {

  PriorityQueue<Integer> minPriorityQueue = new PriorityQueue<>();
  PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
  boolean even = false;

  public MedianFinder() {

  }

  public void addNum(int num) {
    maxPriorityQueue.offer(num);
    minPriorityQueue.offer(maxPriorityQueue.poll());

    if (minPriorityQueue.size() > maxPriorityQueue.size()) {
      maxPriorityQueue.offer(minPriorityQueue.poll());
    }
  }

  public double findMedian() {
    if (minPriorityQueue.size() == maxPriorityQueue.size()) {
      return (minPriorityQueue.peek() + maxPriorityQueue.peek())/2;
    } else {
      return maxPriorityQueue.peek();
    }
  }
}
