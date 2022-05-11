package com.example.coding.backtracking.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter
 * combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 */
public class LetterCombinationPhoneNumber {

  public static List<String> letterCombinations(String digits) {
    String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> stringList = new ArrayList<>();
    recursion(digits, mapping, 0, "", stringList);
    return stringList;
  }

  public static void recursion(String digits, String[] mapping, int index, String currentString, List<String> stringList) {
    if (currentString.length() == digits.length()) {
      stringList.add(currentString);
      return;
    }

    String mappingString = mapping[Integer.parseInt(""+ digits.charAt(index))];

    for (int i=0; i<mappingString.length(); i++) {
      recursion(digits, mapping, index+1, currentString + mappingString.charAt(i), stringList);
    }
  }

  public static void main(String[] args) {
    String digits = "234";
    List<String> stringList = letterCombinations(digits);
    System.out.println(stringList.size());
  }

}
