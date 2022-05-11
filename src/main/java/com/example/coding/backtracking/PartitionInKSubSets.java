package com.example.coding.backtracking;

import java.util.ArrayList;

public class PartitionInKSubSets {

  public static void solution(int i, int n, int k, int countOfNonEmptySets, ArrayList<ArrayList<Integer>> answerList) {

    if (i > n) {
      if (countOfNonEmptySets == k) {
        for (ArrayList<Integer> list : answerList) {
          System.out.println(list);
        }
        System.out.println();
      }

      return;
    }

    for (int j=0; j< answerList.size(); j++) {
      if (answerList.get(j).size() > 0) {
        answerList.get(j).add(i);
        solution(i+1, n, k, countOfNonEmptySets, answerList ); // As we are not adding any new list..
        answerList.get(j).remove(answerList.get(j).size()-1);
      } else {
        answerList.get(j).add(i);
        solution(i+1, n, k, countOfNonEmptySets+1, answerList );
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

    int n = 10;
    int k = 9;
    ArrayList<ArrayList<Integer>> answerList = new ArrayList<>();

    for (int i=0; i<k; i++) {
      answerList.add(new ArrayList());
    }

    solution(1, n, k, 0, answerList);

  }
}
