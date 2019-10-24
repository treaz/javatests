package com.horiaconstantin.ctci.arraysandstrings;

public class ZeroMatrix {

    static int[][] bookSolutionO1Space(int[][] a) {
        boolean firstRowHas0 = false;
        boolean firstColHas0 = false;

        for (int j = 0; j < a[0].length; j++) {
            if (a[0][j] == 0) {
                firstRowHas0 = true;
                break;
            }
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i][0] == 0) {
                firstColHas0 = true;
                break;
            }
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a[0].length; j++) {
                if (a[i][j] == 0) {
                    a[0][j] = 0;
                    a[i][0] = 0;
                }
            }

        }

        for (int j = 0; j < a[0].length; j++) {
            if (a[0][j] == 0) {
                makeColumnZero(a, j);
            }
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i][0] == 0) {
                makeRowZero(a, i);
            }
        }

        if (firstColHas0) makeColumnZero(a, 0);
        if (firstRowHas0) makeRowZero(a, 0);

        return a;
    }

    private static void makeRowZero(int[][] a, int i) {
        for (int j = 0; j < a[0].length; j++) {
            a[i][j] = 0;
        }
    }

    private static void makeColumnZero(int[][] a, int j) {
        for (int i = 0; i < a.length; i++) {
            a[i][j] = 0;
        }
    }
}
