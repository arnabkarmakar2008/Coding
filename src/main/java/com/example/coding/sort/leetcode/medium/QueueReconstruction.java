package com.example.coding.sort.leetcode.medium;

import java.util.Arrays;

/**
 * You are given an array of people, people, which are the attributes of some people in a queue
 * (not necessarily in order). Each people[i] = [hi, ki] represents the ith person of height hi with exactly ki
 * other people in front who have a height greater than or equal to hi.
 *
 * Reconstruct and return the queue that is represented by the input array people. The returned queue should be
 * formatted as an array queue, where queue[j] = [hj, kj] is the attributes of the jth person in the queue (queue[0]
 * is the person at the front of the queue).
 *
 * Input: people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 * Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
 *
 */
public class QueueReconstruction  {

  /**
   * https://www.youtube.com/watch?v=khddrw6Bfyw
   * @param people
   * @return
   */
  public static int[][] reconstructQueue(int[][] people) {

    //Sort array asc based on height. For equal heights, sort asc based on 2nd element.
    Arrays.sort(people, (arr1, arr2) -> arr1[0] == arr2[0] ? arr1[1]-arr2[1] : arr1[0]-arr2[0]);

    int[][] answerArray = new int[people.length][2];

    for (int ct=0; ct< answerArray.length; ct++) {
      Arrays.fill(answerArray[ct], -1);
    }

    for (int i=0; i< people.length; i++) {
      int count = people[i][1];

      for (int j=0; j< people.length; j++) {
        if (answerArray[j][1] == -1 && count == 0 ) {
          answerArray[j][0] = people[i][0];
          answerArray[j][1] = people[i][1];
          break;
        } else if (answerArray[j][1] == -1 || answerArray[j][0] >= people[i][0]) {
          //If cell is blank or height of the left element is greater than current ith element then decease count.
          // If left element is smaller then it will have not significance.
          count--;
        }
      }
    }


    return answerArray;
  }

  public static void main(String[] args) {
    int[][] people = {{6,0},{5,1},{4,0},{3,2},{2,2},{1,4}};
    int[][] arrangedArray = reconstructQueue(people);
  }
}
