// Record which rows and columns are in the zero state by n+m space
// Time is O(n^2), space is O(n+m)
public class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return;
        int m = matrix[0].length;
        boolean[] row = new boolean[n], column = new boolean[m];
        for (int i = 0; i < n; ++i)
            row[i] = false;
        for (int i = 0; i < m; ++i)
            column[i] = false;
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        for (int i = 0; i < n; ++i) {
            if (row[i]) {
                for (int j = 0; j < m; ++j)
                    matrix[i][j] = 0;
            }
        }
        for (int i = 0; i < m; ++i) {
            if (column[i]) {
                for (int j = 0; j < n; ++j)
                    matrix[j][i] = 0;
            }
        }
    }
}

// We can use the first row and first column to record which rows and colums are zero state.
// This method uses constant space 
// Time is O(n^2), space is O(1).

public class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return;
        int m = matrix[0].length;
        boolean row0 = false, column0 = false;
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j) {
                if (matrix[i][j] == 0) {
                    if (i == 0) row0 = true;
                    if (j == 0) column0 = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        for (int i = 1; i < n; ++i) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < m; ++j)
                    matrix[i][j] = 0;
            }
        }
        for (int i = 1; i < m; ++i) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < n; ++j) 
                    matrix[j][i] = 0;
            }
        }
        if (column0) {
            for (int i = 0; i < n; ++i)
                matrix[i][0] = 0;
        }
        if (row0) {
            for (int i = 0; i < m; ++i)
                matrix[0][i] = 0;
        }
    }
}
