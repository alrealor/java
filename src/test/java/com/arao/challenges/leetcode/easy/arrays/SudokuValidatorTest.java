package com.arao.challenges.leetcode.easy.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuValidatorTest {

    SudokuValidator validator;

    @BeforeEach
    void setUp() {
        validator = new SudokuValidator();
    }

    @Test
    void test_isValidSudoku_success() {
        char[][] matrix1 = new char[][]
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                ,{'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                ,{'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                ,{'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                ,{'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                ,{'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                ,{'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                ,{'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                ,{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        ArrayCommons.printMatrix(matrix1);
        System.out.print("\nExpected output: Sudoku is valid");

        assertEquals(true, (validator.isValidSudoku(matrix1)));
    }

    @Test
    void isValidSudoku_fail() {
        // invalid sudoku
        char[][] matrix2 = new char[][]
                {{'8','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};

        ArrayCommons.printMatrix(matrix2);
        System.out.print("\nExpected output: Sudoku is invalid");

        assertEquals(false, validator.isValidSudoku(matrix2));
    }
}