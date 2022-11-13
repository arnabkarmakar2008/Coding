package com.example.coding.string.leetcode.easy;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {

    /**
     * https://leetcode.com/problems/longest-common-prefix/discuss/1405155/Java-or-Detailed-solution-or-0-ms-or-Faster-than-100
     *
     * strs=["flower", "flow", "flight"]
     * prefix=flower
     * index=1
     *     while(strs[index].indexOf(prefix) != 0) means while("flow".indexOf("flower")!=0)
     *     Since flower as a whole is not in flow, it return -1 and  prefix=prefix.substring(0,prefix.length()-1) reduces prefix to "flowe"
     *     Again while(strs[index].indexOf(prefix) != 0) means while("flow".indexOf("flowe")!=0)
     *     Since flowe as a whole is not in flow, it return -1 and  prefix=prefix.substring(0,prefix.length()-1) reduces prefix to "flow"
     *     Again while(strs[index].indexOf(prefix) != 0) means while("flow".indexOf("flow")!=0)
     *     Since flow as a whole is in flow, it returns 0 so now prefix=flow
     * index=2
     *     while(strs[index].indexOf(prefix) != 0) means while("flight".indexOf("flow")!=0)
     *     Since flow as a whole is not in flight, it return -1 and  prefix=prefix.substring(0,prefix.length()-1) reduces prefix to "flo"
     *     Again while(strs[index].indexOf(prefix) != 0) means while("flight".indexOf("flo")!=0)
     *     Since flo as a whole is not in flight, it return -1 and  prefix=prefix.substring(0,prefix.length()-1) reduces prefix to "fl"
     *     Again while(strs[index].indexOf(prefix) != 0) means while("flight".indexOf("fl")!=0)
     *     Since fl as a whole is in flight, it returns 0 so now prefix=fl
     * index=3, for loop terminates and we return prefix which is equal to fl
     *
     *
     * @param strs
     * @return
     */
    public static String solve(String[] strs) {
        String prefix = strs[0];

        for (int ct=1; ct < strs.length; ct++) {
            while (strs[ct].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }

        return prefix;

    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flox"};

        System.out.println(solve(strs));

    }
}
