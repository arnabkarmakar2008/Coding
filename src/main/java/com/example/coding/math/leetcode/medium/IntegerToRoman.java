package com.example.coding.math.leetcode.medium;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 */
public class IntegerToRoman {

    public static String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return "";
        }

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder stringBuilder = new StringBuilder();
        int counter = 0;
        while (num > 0) {
            while (num >= values[counter]) {
                stringBuilder.append(roman[counter]);
                num -= values[counter];
            }

            counter++;
        }

        return stringBuilder.toString();


    }

    public static void main(String[] args) {
        int num = 1994;
        System.out.println(intToRoman(num));
    }
}
