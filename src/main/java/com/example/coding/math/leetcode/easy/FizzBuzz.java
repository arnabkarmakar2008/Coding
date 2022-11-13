package com.example.coding.math.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return a string array answer (1-indexed) where:
 *
 * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 * answer[i] == "Fizz" if i is divisible by 3.
 * answer[i] == "Buzz" if i is divisible by 5.
 * answer[i] == i (as a string) if none of the above conditions are true.
 */
public class FizzBuzz {

    public static List<String> fizzBuzz(int n) {
        List<String> answerList = new ArrayList<>();

        for (int i = 0, fizz = 3, buzz = 5; i <= n; i++) {
            if (i == fizz && i == buzz) {
                answerList.add("FizzBuzz");
                fizz+=3;
                buzz+=5;
            } else if (i == fizz) {
                answerList.add("Fizz");
                fizz+=3;
            } else if (i == buzz) {
                answerList.add("Buzz");
                buzz+=5;
            } else {
                answerList.add(String.valueOf(i));
            }
        }

        return answerList;
    }

    public static void main(String[] args) {
        List<String> list = fizzBuzz(15);

        for (String str : list) {
            System.out.print(str + " ");
        }
    }
}
