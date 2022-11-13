package com.example.coding.math.leetcode.easy;

/**
 * Given an integer columnNumber,
 * return its corresponding column title as it appears in an Excel sheet.
 */
public class ExcelSheetColumnTitle {

    /**
     * 1 -> A
     * 2 -> B
     * 3 -> C
     * ....
     * ....
     * 26 -> Z
     * 27 -> AA
     * 28 -> AB
     * ....
     * ....
     * 52 -> AZ
     * 53 -> BA
     * 54 -> BB
     * ...
     * ....
     *
     * For 1 digit there are 26 possibilities. For 2 digit there are 26 * 26 = 676 numbers
     *
     * |1 -> 26 | 27 -> 702 | 703
     *                  ZZ  | AAA
     *
     * A A A
     *
     * First A from right will change for every increment. 2nd A will remain constant for 26.
     * 3rd A will remain constant for 26*26  = 676 times.
     *
     *
     * So last char can be obtained by number%26. c = (n-1)%26 + 'A'
     *
     * 1 -> A
     * 26 -> Z
     * That is why we have to do 'A' + (n-1)%26
     *
     *
     *
     * @param columnNumber
     * @return
     */
    public static String convertToTitle(int columnNumber) {
        StringBuilder stringBuilder = new StringBuilder();

        while (columnNumber > 0) {
            char ch = (char)('A' + (columnNumber-1)%26);
            stringBuilder.append(ch);
            columnNumber  = (columnNumber-1)/26;
        }

        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }
}
