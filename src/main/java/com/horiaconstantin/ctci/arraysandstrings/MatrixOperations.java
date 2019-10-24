package com.horiaconstantin.ctci.arraysandstrings;

public class MatrixOperations {

    /**
     * See https://en.wikipedia.org/wiki/Transpose
     */
    static int[][] transposeSquareMatrix(int[][] a) {
        for (int r = 0; r < a.length; r++) {
            for (int c = 0; c <= r; c++) {
                int temp = a[r][c];
                a[r][c] = a[c][r];
                a[c][r] = temp;
            }
        }
        return a;
    }

    // the matrix is rotated by layers, coming from the outside to the inside
    static int[][] rotateMatrixCounterClockwise(int[][] mat) {
        int maxIndex = mat.length - 1;
        //since we're swapping values in all four corners at once, we only need to iterate the top left corner
        for (int i = 0; i < mat.length / 2; i++) {
            //because of the layers, j, is limited by i at both ends
            for (int j = i; j < maxIndex - i; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][maxIndex - i];
                mat[j][maxIndex - i] = mat[maxIndex - i][maxIndex - j];
                mat[maxIndex - i][maxIndex - j] = mat[maxIndex - j][i];
                mat[maxIndex - j][i] = temp;
            }
        }

        return mat;
    }

    static int[][] rotateMatrixClockwise(int[][] mat) {
        int maxIndex = mat.length - 1;

        //since we're swapping values in all four corners at once, we only need to iterate the top left corner
        for (int i = 0; i < mat.length / 2; i++) {

            for (int j = i; j < maxIndex - i; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[maxIndex - i][j];
                mat[maxIndex - i][j] = mat[maxIndex - i][maxIndex - j];
                mat[maxIndex - i][maxIndex - j] = mat[i][maxIndex - j];
                mat[i][maxIndex - j] = temp;
            }
        }

        return mat;
    }
}
