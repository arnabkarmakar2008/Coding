package com.example.coding.greedy.leetcode.easy;

import java.util.Arrays;

/**
 * You are assigned to put some amount of boxes onto one truck.
 * You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:
 *
 * numberOfBoxesi is the number of boxes of type i.
 * numberOfUnitsPerBoxi is the number of units in each box of the type i.
 * You are also given an integer truckSize, which is the maximum number of boxes that can be put
 * on the truck. You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.
 *
 * Return the maximum total number of units that can be put on the truck.
 */
public class MaxUnitsOnTruck {

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> Integer.compare(b[1], a[1]));
        int maxUnits = 0;

        for (int row = 0; row < boxTypes.length; row++) {
            int[] boxType = boxTypes[row];

            if (truckSize >= boxType[0]) {
                truckSize -= boxType[0];
                maxUnits += boxType[0]*boxType[1];
            } else {
                maxUnits += truckSize * boxType[1];
                return maxUnits;
            }

        }

        return maxUnits;
    }

    public static void main(String[] args) {
        int[][] boxTypes = {{3,1},{1,3},{2,2}};
        int truckSize = 4;

        System.out.println(maximumUnits(boxTypes, truckSize));
    }
}
