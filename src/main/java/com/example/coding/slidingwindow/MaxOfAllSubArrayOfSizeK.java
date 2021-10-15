package com.example.coding.slidingwindow;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MaxOfAllSubArrayOfSizeK {
    public static void main(String[] args) {
        int[] intArray = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        maxOfAllSubArrayOfSizeK(intArray, k);
    }

    public static void maxOfAllSubArrayOfSizeK(int[] intArray, int windowSize) {

        int start = 0;
        int end = 0;
        int max = 0;

        List<Integer> list = new ArrayList<>();

        while (end <= intArray.length - 1) {
            if (intArray[end] > max) {
                max = intArray[end];
            }

            if (end - start + 1 < windowSize) {

                end++;

            } else if (end - start +1 == windowSize) {
                list.add(max);
                end++;

                if (intArray[start] == max) {
                    max = 0;
                }
                start++;
            }
        }

        System.out.println(list);
    }
}
