package com.example.coding.queue;

import java.util.HashMap;
import java.util.Map;

public class IceCreamProblem {
    public static void main(String[] args) {
        //int[] array = {5,5,5,10,20};
        int[] array = {5,10,10,20};
        System.out.println(solve(array, 5));
    }

    public static boolean solve(int arr[], int price) {
        int fiveCount = 0;
        int tenCount = 0;
        boolean flag = true;
        for (int i=0; i < arr.length; i++) {
            if (arr[i] == 5) {
                fiveCount = fiveCount + 1;
            } else if (arr[i] == 10) {
                if (fiveCount > 0) {
                    fiveCount = fiveCount - 1;
                    tenCount = tenCount + 1;
                } else {
                    flag = false;
                    break;
                }

            } else {
                if (fiveCount > 0 && tenCount > 0) {
                    fiveCount--;
                    tenCount--;
                } else if (fiveCount >= 3) {
                    fiveCount = fiveCount - 3;
                } else {
                    flag = false;
                    break;
                }
            }
        }


        return flag;
    }
}
