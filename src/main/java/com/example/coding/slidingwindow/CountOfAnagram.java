package com.example.coding.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class CountOfAnagram {

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'b', 'a', 'd', 'a', 'b', 'a', 'b'};
        char[] ana = {'a', 'b', 'b', 'a'};
        countAnagram(chars, ana);
     }

     public static void countAnagram(char[] chars, char[] ana) {
        Map<Character, Integer> countMap = new HashMap<>();

        for (char c : ana) {
            if (countMap.containsKey(c)) {
                int count = countMap.get(c);
                countMap.put(c, count+1);
            } else {
                countMap.put(c, 1);
            }
        }

        int counter = countMap.size();

        int start = 0;
        int end = 0;
        int windowSize = ana.length;
        int anaCount = 0;

        while (end <= chars.length -1) {

            char firstChar = chars[end];

            if (countMap.containsKey(chars[end])) {
                int ct = countMap.get(chars[end]);
                ct = ct - 1 ;

                if (ct == 0) {
                    counter--;
                }

                countMap.put(chars[end], ct);

            }


            if (end - start + 1 < windowSize) {
                end ++;
            } else if (end - start + 1 == windowSize) {

                if (counter == 0) {
                    anaCount ++;
                }

                end ++;

                if (countMap.containsKey(chars[start])) {
                    int ct = countMap.get(chars[start]);

                    if (ct == 0) {
                        counter ++;
                    }

                    countMap.put(chars[start], ct+1);


                }

                start ++;
            }


        }

         System.out.println("Ana Count == " + anaCount);

     }
}
