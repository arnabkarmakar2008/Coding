package com.example.coding.slidingwindow.variablesize;

import java.util.LinkedList;

public class LargestSubArraySequence {
    public static void main(String[] args) {
        int[] array = {1,3,4,5,6,7,8,2,8,9,10,11,12};
        func(array);

    }

    public static void func(int[] array) {
        int start = 0;
        int end = 0;
        int max = 0;

        LinkedList<Integer> list = new LinkedList<>();

        while (end < array.length) {
            if (list.size() == 0) {
                list.addFirst(array[end]);
            } else if (list.getFirst() + 1 == array[end]) {
                list.addFirst(array[end]);

                if (end == array.length-1) {
                    max = Math.max(max, list.size());
                }

            } else {
                max = Math.max(max, list.size());
                start = end;
                list.clear();
                list.addFirst(array[end]);
            }

            end ++;
        }

        System.out.println("Max Size = " + max);
    }
}
