package com.example.coding.string.leetcode.medium;

/**
 * Given a string s and an integer k, return true if you can use all the characters in s to
 * construct k palindrome strings or false otherwise.
 *
 * Input: s = "annabelle", k = 2
 * Output: true
 * Explanation: You can construct two palindromes using all characters in s.
 * Some possible constructions "anna" + "elble", "anbna" + "elle", "anellena" + "b"
 *
 */
public class ConstructKPalindromeStrings {
    /**
     * Count of odd occurrences should be less than or equal to K.
     *
     * With abc we will not be able to create 2 palindromes.
     * But we can create 3 palindromes a, b , c
     *
     * And k <= s.length
     *
     * eg
     * aabb, k=1| abba
     * aabb, k=2 | aa, bb
     * aabb, k=3 | a, a, bb
     * aabb, k=4 | a, a, b, b
     *
     * For any string with odd character count <=k , we can always form k palindrome string for sure with k<=n
     * eg2
     * aabbc, k=1 | aacbb
     * aabbc, k=2 | aca, bb
     * aabbc, k=3 | a,a, bcb
     * aabbc, k=4 | a, a, c ,bb
     * aabbc, k=5 | a, a, c, b, b
     *
     * eg3
     * aabc, k=1 | N/A
     * aabc, k=2 | aba, c
     * aabc, k=3 | aa, b, c
     * aabc, k=4 | a, a, b, c
     *
     * @param s
     * @param k
     * @return
     */
    public static boolean canConstruct(String s, int k) {
        int[] countArray = new int[26];

        for (int i=0; i<s.length(); i++) {
            countArray[s.charAt(i) - 'a']++;
        }

        int oddNum = 0;

        for (int i=0; i<26; i++) {
            oddNum = countArray[i]%2;
        }

        return oddNum <= k && k <= s.length();
    }

    public static void main(String[] args) {
        String s = "annabelle";
        int k = 2;
        System.out.println(canConstruct(s, k));
    }
}
