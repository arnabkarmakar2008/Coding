package com.example.coding.slidingwindow;

import java.util.LinkedList;

public class FirstNegativeNumberInWindow {
    public static void main(String[] args) {
        int[] intArray = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;

        firstNegativeNumber(intArray, k);
    }

    public static void firstNegativeNumber(int[]  intArray, int subArraySize) {
        int windowStart = 0;
        int windowEnd = 0;
        LinkedList list = new LinkedList();
        LinkedList finalList = new LinkedList();

        while (windowEnd <= intArray.length -1) {
            if (intArray[windowEnd] < 0 ) {
                list.addLast(intArray[windowEnd]);
            }
            if (windowEnd - windowStart + 1 < subArraySize) {
                windowEnd ++;
            } else if (windowEnd - windowStart + 1 == subArraySize) {

                if (list.size() == 0) {
                    finalList.add(0);
                } else {
                    finalList.add(list.getFirst());
                }

                if (intArray[windowStart] < 0) {
                    list.removeFirst();
                }

                windowStart ++;
                windowEnd ++;
            }
        }

        System.out.println(finalList);

    }
}
