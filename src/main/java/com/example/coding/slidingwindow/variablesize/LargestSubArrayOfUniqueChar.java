package com.example.coding.slidingwindow.variablesize;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayOfUniqueChar {
    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'b', 'a', 'c', 'b', 'e', 'b', 'e', 'b', 'e'};
        func(chars);
    }

    public static void func (char[] charArray) {
        int start = 0;
        int end = 0;
        int maxSize = 0;

        Map<Character, Integer> map = new HashMap<>();

        while (end <= charArray.length-1) {
            //calculation

            if (map.containsKey(charArray[end])) {
                int ct = map.get(charArray[end]);
                map.put(charArray[end], ct + 1);
            } else {
                map.put(charArray[end], 1);
            }

            if (map.size() == end - start + 1) {
                maxSize = Math.max(maxSize, end - start + 1);
            } else if (map.size() < (end - start + 1)) {

                while(map.size() < (end - start + 1)) {
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


            }

            end ++;


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
