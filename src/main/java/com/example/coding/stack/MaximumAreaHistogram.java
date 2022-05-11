package com.example.coding.stack;

import javafx.util.Pair;

import java.util.Stack;

public class MaximumAreaHistogram {

  /**
   * https://www.youtube.com/watch?v=vcv3REtIvEo
   * @param array
   * @return
   */
  public static int maxHistogramArea(int[] array) {
    int[] leftArray = new int[array.length];
    int[] rightArray = new int[array.length];

    Stack<Pair<Integer, Integer>> stack = new Stack();

    //Smaller index to left
    for (int i = 0; i < array.length; i++) {
      if (stack.empty()) {
        leftArray[i] = 0; // There is no element in left. So we have to include till 0 index
      } else {
        while (!stack.empty() && stack.peek().getValue() >= array[i]) {
          stack.pop();
        }

        if (stack.empty()) {
          leftArray[i] = 0; // There is no element in left. So we have to include till 0 index
        } else {
          // We have to add +1 because we have to take till element is higher than current.
          leftArray[i] = stack.peek().getKey() + 1;
        }
      }

      stack.push(new Pair(i, array[i]));

    }

    stack.clear();

    //Smaller index to right
    for (int i = array.length - 1; i >= 0; i--) {
      if (stack.empty()) {
        rightArray[i] = array.length - 1; // There is no smaller element in right. So we have to include till last index
      } else {
        while (!stack.empty() && stack.peek().getValue() >= array[i]) {
          stack.pop();
        }

        if (stack.empty()) {
          rightArray[i] = array.length - 1; // There is no smaller element in right. So we have to include till last index
        } else {
          rightArray[i] = stack.peek().getKey() - 1;
        }
      }

      stack.push(new Pair(i, array[i]));

    }

    // Calculate area
    //Formula = array[i] * (rightArray[i] - leftArray[i] + 1)
    int maxArea = Integer.MIN_VALUE;
    for (int i = 0; i < array.length; i++) {
      maxArea = Math.max(maxArea, ((rightArray[i] - leftArray[i] + 1) * array[i]));
    }

    return maxArea;

  }

  public static void main(String[] args) {
    int[] array = {3,1,3,2,2};
    System.out.println(maxHistogramArea(array));
  }
}
