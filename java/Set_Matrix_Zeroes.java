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
