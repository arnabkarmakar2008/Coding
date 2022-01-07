package com.example.coding.graph.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CouplesHoldingHands {

    public static int swapCount(int[] row) {
        int length = row.length;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int ct=0; ct<length; ct++) {
            map.put(row[ct], ct);
        }

        for (int ct =0; ct <length; ct = ct+2) {
            int first = row[ct];
            int second = first + (first%2 == 0 ? 1 : -1);

            if (second != row[ct+1]) {
                // get the index of second and row[ct+1] from map and swap
                count++;
                swapArray(row, map.get(second), map.get(row[ct+1]));
            }
        }
        return count;
    }

    public static void swapArray(int[] row, int index1, int index2) {
        int temp = row[index1];
        row[index1] = row[index2];
        row[index2] = temp;
    }

    public static void main(String[] args) {
        int[] coupleArray = {0,2,1,3,4,5};
        System.out.println(swapCount(coupleArray));
    }
}
