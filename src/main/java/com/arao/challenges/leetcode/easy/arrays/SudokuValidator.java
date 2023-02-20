package com.arao.challenges.leetcode.easy.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Valid Sudoku
 *
 * Solution
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * Note:
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 *
 * Example 1:
 * Input: board =
 * [ ["5","3",".",".","7",".",".",".","."]
 *  ,["6",".",".","1","9","5",".",".","."]
 *  ,[".","9","8",".",".",".",".","6","."]
 *  ,["8",".",".",".","6",".",".",".","3"]
 *  ,["4",".",".","8",".","3",".",".","1"]
 *  ,["7",".",".",".","2",".",".",".","6"]
 *  ,[".","6",".",".",".",".","2","8","."]
 *  ,[".",".",".","4","1","9",".",".","5"]
 *  ,[".",".",".",".","8",".",".","7","9"]]
 * Output: true
 *
 * Example 2:
 * Input: board =
 * [["8","3",".",".","7",".",".",".","."]
 *  ,["6",".",".","1","9","5",".",".","."]
 *  ,[".","9","8",".",".",".",".","6","."]
 *  ,["8",".",".",".","6",".",".",".","3"]
 *  ,["4",".",".","8",".","3",".",".","1"]
 *  ,["7",".",".",".","2",".",".",".","6"]
 *  ,[".","6",".",".",".",".","2","8","."]
 *  ,[".",".",".","4","1","9",".",".","5"]
 *  ,[".",".",".",".","8",".",".","7","9"]]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 */
public class SudokuValidator {

    public boolean isValidSudoku(char[][] board) {
        // verify rows
        Set<Character> store = new HashSet<>();
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] != '.') {
                    if(store.contains(board[i][j]))
                        return false;
                    else
                        store.add(board[i][j]);
                }
            }
            store.clear();
        }
        // verify columns
        for(int j=0; j< board[0].length; j++) {
            for(int i=0; i<board.length; i++) {
                if (board[i][j] != '.') {
                    if (store.contains(board[i][j]))
                        return false;
                    else
                        store.add(board[i][j]);
                }
            }
            store.clear();
        }
        // verify sub matrix of 3X3
        // 9 loops
        // 	1st - 00, 01, 02, 10, 11, 12, 20, 21, 22
        // 	2nd - 03, 04, 05, 13, 14, 15, 23, 24, 25
        // 	3er - 06, 07, 08, 16, 17, 18, 26, 27, 28

        // 	4to - 30, 31, 32, 40, 41, 42, 50, 51, 52
        // 	5t0 - 33, 34, 35, 43, 44, 45, 53, 54, 55
        // 	6to - 36, 37, 38, 46, 47, 48, 56, 57, 58

        // 	7mo - 60, 61, 62, 70, 71, 72, 80, 81, 82
        // 	8vo - 63, 64, 65, 73, 74, 75, 83, 84, 85
        // 	9no - 66, 67, 68, 76, 77, 78, 86, 87, 88

        // verify 3x3 sub-matrix
        int lr=0, lc=0, count=1, loop=1;
        while(loop <= ((board.length * board[0].length) / 9)) {
            for(int r=lr; r<lr+3; r++) {
                for(int c=lc; c<lc+3; c++) {
                    if (board[r][c] != '.') {
                        if (store.contains(board[r][c]))
                            return false;
                        else
                            store.add(board[r][c]);
                    }
                }
            }
            store.clear();
            lc+=3;
            if (count == 3) {
                lr+=3;
                lc=0;
                count=1;
            } else {
                count++;
            }
            loop++;
        }
        return true;
    }
}
