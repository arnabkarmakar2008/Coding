package com.example.coding.math.leetcode.hard;

/**
 * Convert a non-negative integer num to its English words representation.
 */
public class IntegerToEnglishWord {

    static String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    static String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten","Eleven",
            "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    /**
     * https://leetcode.com/problems/integer-to-english-words/discuss/70625/My-clean-Java-solution-very-easy-to-understand
     * @param num
     * @return
     */
    public static String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        return helper(num);
    }

    public static String helper(int num) {

        if (num > 1000000000) {
            return helper(num/1000000000) + " Billion " + helper(num%1000000000);
        }

        if (num > 1000000) {
            return helper(num/1000000) + " Million " + helper(num%1000000);
        }

        if (num > 1000) {
            return helper(num/1000) + " Thousand " + helper(num%1000);
        }

        if (num > 100) {
            return helper(num/100) + " Hundred " + helper(num%100);
        }

        if (num > 20) {
            return tens[num/10] + " " + helper(num%10);
        }

        return ones[num];
    }

    public static void main(String[] args) {
        int num = 1234567;
        System.out.println(numberToWords(num));
    }
}
