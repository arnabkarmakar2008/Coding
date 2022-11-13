package com.example.coding.slidingwindow.variablesize;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayOfKUniqueChar {
    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'b', 'a', 'c', 'b', 'e', 'b', 'e', 'b', 'e'};
        int  ct = 3;
        func(chars, ct);
    }

    public static void func (char[] charArray, int uniqueCount) {
        int start = 0;
        int end = 0;
        int maxSize = 0;

        Map<Character, Integer> map = new HashMap<>();

        while (end <= charArray.length-1) {
            //calculation
            map.put(charArray[end], map.getOrDefault(charArray[end],0)+1);

            if (map.size() < uniqueCount) {
                end ++;
            } else if (map.size() == uniqueCount) {
                maxSize = Math.max(maxSize, end - start + 1);
                end ++;
            } else if (map.size() > uniqueCount) {

                while(map.size() > uniqueCount) {
                    if (map.containsKey(charArray[start])) {
                        int ct = map.get(charArray[start]);

                        if (ct - 1 == 0) {
                            map.remove(charArray[start]);
                        } else {
                            map.put(charArray[start] , ct - 1);
                        }
                    }

                    start ++;

                }

                end ++;
            }


            /**
            if (cond < uniqueCount) {
                end++;
             } else if (cond == uniqueCount) {
                // answer from calculation
                start++;
                end ++;
             } else if (cond > uniqueCount) {

                while (cond > uniqueCount) {
                    //reverse
                    start ++;
                    end ++;
                }


             }


            **/
        }

        System.out.println("Max size = " + maxSize);

    }
}
