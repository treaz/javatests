package com.horiaconstantin.ctci.arraysandstrings;

import org.junit.jupiter.api.Test;

class MatrixOperationsTest {

    @Test
    void transposeSquareMatrix() {
        int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] transposed = MatrixOperations.transposeSquareMatrix(a);
        printMatrix(transposed);
    }

    @Test
    void solutionInPlace() {
        int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] rotated = MatrixOperations.rotateMatrixCounterClockwise(a);
        printMatrix(a);
        System.out.println("\n");
        printMatrix(rotated);
    }

    public void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%4d", matrix[row][col]);
            }
            System.out.println();
        }
    }
}