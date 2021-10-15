package com.example.coding.slidingwindow.variablesize;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        char[] chars = {'T', 'O', 'T', 'M', 'T', 'A', 'P', 'T', 'A', 'T'};
        Map<Character, Integer> map = new HashMap<>();
        map.put('T', 2);
        map.put('A', 1);
        func(chars, map);
    }

    public static void func(char[] charArray, Map<Character, Integer> map) {

        int start = 0;
        int end = 0;
        int min = 0;

        int count = map.size();

        while (end < charArray.length) {

            if (map.containsKey(charArray[end])) {
                int ct = map.get(charArray[end]);

                if (ct-1 == 0) {
                    count--;
                }

                map.put(charArray[end], ct-1);
            }

            if (count > 0) {
                end ++;
            } else if (count == 0) {

                if (min ==0) {
                    min = (end - start +1);
                } else {
                    min = Math.min(min, (end - start +1));
                }

                while (count ==0) {
                    if (min ==0) {
                        min = (end - start +1);
                    } else {
                        min = Math.min(min, (end - start +1));
                    }

                    if (map.containsKey(charArray[start])) {
                        int ct = map.get(charArray[start]);
                        map.put(charArray[start], ct + 1);

                        if (ct + 1 > 0) {
                            count = 1;
                        }
                        start++;
                    } else {
                        start ++;
                    }
                }
                end++;
            }
        }

        System.out.println("Min = "+ min);
    }
}
