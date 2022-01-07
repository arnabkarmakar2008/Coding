package com.example.coding.graph.leetcode;

import java.util.*;

public class LoudAndRich851 {
    /**
     * There is a group of n people labeled from 0 to n - 1 where each person has a different amount of money and a different level of quietness.
     *
     * You are given an array richer where richer[i] = [ai, bi] indicates that ai has more money than bi and an integer array quiet where quiet[i] is the quietness of the ith person. All the given data in richer are logically correct (i.e., the data will not lead you to a situation where x is richer than y and y is richer than x at the same time).
     *
     * Return an integer array answer where answer[x] = y if y is the least quiet person (that is, the person y with the smallest value of quiet[y]) among all people who definitely have equal to or more money than the person x.
     *
     */

     public static Map<Integer, List<Integer>> map = new HashMap<>();
     public static int[] result;

     public static int[] compute(int[][] richer, int[] quite) {
         int numberOfPersons = quite.length;

         //populate hashmap as person -> richer person
         for (int ct=0; ct<numberOfPersons; ct++) {
             map.put(ct, new ArrayList<>());
         }

         for (int[] v : richer) {
             map.get(v[1]).add(v[0]);
         }

         // fill result array with -1
         result = new int[numberOfPersons];
         Arrays.fill(result, -1);

         //Call dfs for each person
         for (int person=0; person<numberOfPersons; person++) {
             dfs(person, quite);
         }

         return result;
     }

     public static int  dfs (int person, int[] quiet) {
         if (result[person] >= 0) {
             return result[person]; //memorization step
         }

         result[person] = person;

         for (int richerPerson : map.get(person)) {
             if (quiet[person] > dfs(richerPerson, quiet)) {
                 result[person] = result[richerPerson];
             }
         }

         return result[person];
     }
}
