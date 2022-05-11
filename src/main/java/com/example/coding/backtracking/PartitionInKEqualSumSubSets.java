package com.example.coding.backtracking;

import java.util.ArrayList;

public class PartitionInKEqualSumSubSets {

  /**
   * https://www.youtube.com/watch?v=rszwy53vaP0&t=40s
   * @param arr
   * @param arrayIndx
   * @param subSetSum
   * @param n
   * @param k
   * @param countOfNonEmptySets
   * @param answerList
   */
  public static void solution(int[] arr, int arrayIndx, int[] subSetSum, int n, int k, int countOfNonEmptySets, ArrayList<ArrayList<Integer>> answerList) {

    if (arrayIndx == arr.length) {
      if (countOfNonEmptySets == k) {
        boolean flag = true;
        for (int i=0; i<subSetSum.length-1; i++) {
          if (subSetSum[i] != subSetSum[i+1]) {
            flag = false;
            break;
          }
        }

        if (flag) {
          for (ArrayList<Integer> partition: answerList) {
            System.out.println(partition + " ");
          }
        }

      }

      return;
    }

    for (int j=0; j< answerList.size(); j++) {
      if (answerList.get(j).size() > 0) {
        answerList.get(j).add(arr[arrayIndx]);
        subSetSum[j] += arr[arrayIndx];
        solution(arr, arrayIndx+1, subSetSum, n, k, countOfNonEmptySets, answerList ); // As we are not adding any new list..
        subSetSum[j] -= arr[arrayIndx];
        answerList.get(j).remove(answerList.get(j).size()-1);
      } else {
        answerList.get(j).add(arr[arrayIndx]);
        subSetSum[j] += arr[arrayIndx];
        solution(arr, arrayIndx+1, subSetSum, n, k, countOfNonEmptySets+1, answerList ); // As we are not adding any new list..
        subSetSum[j] -= arr[arrayIndx];
        answerList.get(j).remove(answerList.get(j).size()-1);
        break;
      }
    }
  }


  /**
   * Partition n elements in k subsets. If n-1 elements form k subsets then n can join any subset. If n-1 elements form
   * k-1 subsets then nth element will form k subset.
   * @param args
   */
  public static void main(String[] args) {
    int[] arr = {4,3,2,3,5,2,1};
    int n = 7;
    int k = 4;
    ArrayList<ArrayList<Integer>> answerList = new ArrayList<>();

    for (int i=0; i<k; i++) {
      answerList.add(new ArrayList());
    }

    int[] subsetSum = new int[k];

    solution(arr, 0, subsetSum, n, k, 0, answerList);

  }
}
