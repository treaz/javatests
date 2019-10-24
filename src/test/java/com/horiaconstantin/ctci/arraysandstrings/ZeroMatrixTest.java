package com.horiaconstantin.ctci.arraysandstrings;

import org.junit.jupiter.api.Test;

class ZeroMatrixTest {

    @Test
    void bookSolutionO1Space() {
        int[][] a = new int[][]{{1, 0, 0, 1}, {3, 4, 1, 2}, {5, 6, 7, 3}};

        int[][] ints = ZeroMatrix.bookSolutionO1Space(a);
        printMatrix(ints);
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