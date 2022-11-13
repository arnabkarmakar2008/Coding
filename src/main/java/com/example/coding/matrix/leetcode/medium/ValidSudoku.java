package com.example.coding.matrix.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells
 * need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9
 * without repetition.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 */
public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    if (!set.add(ch + "seen in row " +i)
                    || !set.add(ch +"seen in col "+j)
                            || !set.add(ch +"seen in block "+ i/3 +"-"+j/3))
                        return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
