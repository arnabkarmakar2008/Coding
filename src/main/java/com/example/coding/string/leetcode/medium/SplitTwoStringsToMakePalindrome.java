package com.example.coding.string.leetcode.medium;

/**
 * You are given two strings a and b of the same length.
 * Choose an index and split both strings at the same index,
 * splitting a into two strings: aprefix and asuffix where a = aprefix + asuffix, and
 * splitting b into two strings: bprefix and bsuffix where b = bprefix + bsuffix. Check if aprefix + bsuffix or bprefix + asuffix forms a palindrome.
 *
 * When you split a string s into sprefix and ssuffix, either ssuffix or sprefix is allowed to be empty. For example, if s = "abc", then "" + "abc", "a" + "bc", "ab" + "c" , and "abc" + "" are valid splits.
 *
 * Return true if it is possible to form a palindrome string, otherwise return false.
 *
 * Notice that x + y denotes the concatenation of strings x and y.
 *
 * Input: a = "ulacfd", b = "jizalu"
 * Output: true
 * Explaination: Split them at index 3:
 * aprefix = "ula", asuffix = "cfd"
 * bprefix = "jiz", bsuffix = "alu"
 * Then, aprefix + bsuffix = "ula" + "alu" = "ulaalu", which is a palindrome.
 */
public class SplitTwoStringsToMakePalindrome {

    /**
     * https://www.youtube.com/watch?v=NakS6SHUcmo
     *
     * We have to take two pointers. One starting from a and one starting from end of b.
     * Now move pointer as long as chars are matching. Now when not matching that point may be the
     * possible split point.
     *
     * Now if sub str of a from (left to right) or sub str of b from (left to right) is palindrome then
     * we return true.
     *           l
     *     0 1 2 3 4 5 6 7 8
     * a = u l a g g g c f d
     * b = j l z u v t a l u
     *               r
     * In the above example, l is at index 3 and r is at index 5. Substr 0->2 of a is palindrome of Substr 6->8.
     *
     * Now if substr a from l->r is palindrome then we can split at r
     * Or if substr b of l->r is palindrome then we can split at l
     *
     * This we have done for a prefix + b suffix.
     *
     * Same we have to do from b prefix + a suffix
     *
     * @param a
     * @param b
     * @return
     */

    public static boolean checkPalindromeFormation(String a, String b) {
        return checkFormation(a,b) || checkFormation(b,a);
    }

    public static boolean checkFormation(String a, String b) {
        for (int start = 0, end = a.length()-1; start < end; start++, end--) {
            if (a.charAt(start) != b.charAt(end)) {
                return isPalindrome(a, start, end) || isPalindrome(b, start, end);
            }
        }

        return true;
    }

    private static boolean isPalindrome(String a, int start, int end) {
        while (start < end) {
            if (a.charAt(start) != a.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        String a = "ulacfd";
        String b = "jizalu";
        System.out.println(checkPalindromeFormation(a, b));
    }
}
