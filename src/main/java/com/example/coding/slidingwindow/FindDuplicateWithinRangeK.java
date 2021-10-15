package com.example.coding.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicateWithinRangeK {
    public static void main(String[] args) {
        int[] array = {5, 5, 6, 6, 8, 2, 4, 6, 9}; // Output yes. 6 is duplicate and within k
        int k = 5;
        func(array, k);
    }

    public static void func(int[] array, int range) {

        int start = 0;
        int end = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int totalCount = 0;

        while (end < array.length) {

            if (map.containsKey(array[end])) {
                int ct = map.get(array[end]);

                if (ct == 1) {
                    count++;
                }
                map.put(array[end], ct + 1);

            } else {
                map.put(array[end], 1);
            }

            if (end - start + 1 < range) {
                end++;
            } else if (end - start + 1 == range) {
                if (map.size() < end - start + 1) {
                    //duplicate found
                    totalCount = totalCount + count;
                }

                if (map.get(array[start]) == 1) {
                    map.remove(array[start]);
                } else {
                    int ct = map.get(array[start]);

                    if (ct - 1 == 1) {
                        count--;
                    }

                    map.put(array[start], ct - 1);
                }

                end++;
                start++;

            }
        }

        System.out.println("Duplicates found = " + totalCount);

    }
}
