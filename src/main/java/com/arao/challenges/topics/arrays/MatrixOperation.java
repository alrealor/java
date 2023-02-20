package com.arao.challenges.topics.arrays;

import java.util.Scanner;

public class MatrixOperation {

    /**
     * Create 2D array given a size for rows and columns
     * @return 2D array
     * @throws Exception
     */
    public static int[][] createMatrix() throws Exception {

        Scanner scanner = new Scanner(System.in);
        // get matrix rows
        System.out.print("  Type matrix row/s: ");
        int rows = scanner.nextInt();
        if (rows <= 0) {
            throw new Exception("Rows cannot be equals or lower than zero");
        }

        // get matrix columns
        System.out.print("  Type matrix column/s: ");
        int columns = scanner.nextInt();
        if (columns <= 0) {
            throw new Exception("Columns cannot be equals or lower than zero");
        }

        // create 2D array
        int[][] matrix = new int[rows][columns];

        // return 2D array
        return matrix;
    }

    /**
     * Create and populate 2D array
     * @return 2D array
     */
    public static int[][] populateMatrix(int[][] matrix) {
        Scanner scanner = new Scanner(System.in);
        // populate 2D array
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                System.out.print("  Type matrix element ["+i+","+j+"]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    /**
     * Print content of 2D arrary
     * @param matrix
     */
    public static void printMatrix(int[][] matrix) {
        // loop the matrix rows
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                System.out.print("  " + matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    /**
     * Convert 2D array into other one with equals or less dimension than original
     * @param currentMtx
     * @return 2D array
     */
    public static int[][] convertMatrix(int[][] currentMtx) throws Exception {

        // Get size of current matrix
        int currentRows = currentMtx.length;
        int currentCols = currentMtx[0].length;

        // Transform matrix to 1D array
        int[] currentMtxAsArray = new int[currentRows * currentCols];
        int index = 0;
        for (int i=0; i<currentMtx.length; i++) {
            for (int j=0; j<currentMtx[i].length; j++) {
                currentMtxAsArray[index] = currentMtx[i][j];
                index++;
            }
        }

        // get new matrix size
        Scanner scanner = new Scanner(System.in);
        // get new matrix rows
        System.out.print("  Type new row/s: ");
        int newRows = scanner.nextInt();

        // get new matrix columns
        System.out.print("  Type new column/s: ");
        int newCols = scanner.nextInt();

        // verify that new dimensions is inside the current dimension or re-dimension
        int[][] newMtx = null;
        if ((newRows * newCols) <= currentMtxAsArray.length) {
            newMtx = new int[newRows][newCols];
            index = 0;
            // loop over new matrix to populate it based on matrix converted as Array
            for (int i=0; i<newMtx.length; i++) {
                for (int j=0; j<newMtx[i].length; j++) {
                    newMtx[i][j] = currentMtxAsArray[index];
                    index++;
                }
            }
        } else {
            throw new Exception("New 2D array dimension is higher than current one");
        }
      return newMtx;
    }
}
