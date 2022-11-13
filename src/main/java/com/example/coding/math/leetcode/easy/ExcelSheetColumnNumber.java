package com.example.coding.math.leetcode.easy;

public class ExcelSheetColumnNumber {

    /**
     * https://www.youtube.com/watch?v=g-l4UpF62x0
     * @param columnTitle
     * @return
     */
    public static int titleToNumber(String columnTitle) {

        /**
         * How do we represent 123 in dec : 1 * 10^2 + 2 * 10^1 + 3 *10^0
         *
         * Same concept here as well.
         *
         * BDA = B * 26^2 + D * 26^1 + A * 26^0
         */

        int num = 0;
        int power = 0;
        for (int i=columnTitle.length()-1; i>=0 ; i--) {
            char ch = columnTitle.charAt(i);
            int charIntVal = ch - 'A' + 1; //Calculating offset here. For A ch - 'A' will be zero. So adding 1.

            num += Math.pow(26, power) * charIntVal;
            power++;
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }
}
