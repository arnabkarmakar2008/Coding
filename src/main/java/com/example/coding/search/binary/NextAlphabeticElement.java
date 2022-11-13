package com.example.coding.search.binary;

/**
 * https://www.youtube.com/watch?v=X45c37QMdX0&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=12
 *
 *
 */
public class NextAlphabeticElement {

    public static char nextAlphabet(char[] chars, char element) {
        int start = 0;
        int end = chars.length-1;
        char result = '0';

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (chars[mid] == element) {
                start = mid+1;
            } else if (chars[mid] < element) {
                start = mid+1;
            } else if (chars[mid] > element) {
                result = chars[mid];
                end = mid-1;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'f', 'h'};
        char element = 'g';

        System.out.println(nextAlphabet(chars, element));
    }
}
