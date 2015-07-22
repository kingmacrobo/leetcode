// Dp solution
// Let dp[i][j] represents the length of max square when point[i][j] is the bottom right point of the square.
// So, dp[i][j] can be calculated by dp[i-1][j-1] via judge if the side value of square[i-1][j-1] is '1'.
// Time is O(n^2), space is O(n^2);
// We can also reduce the space to O(n) by using rolling array!

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, max = 0;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || j == 0 || dp[i-1][j-1] == 0 || matrix[i][j] == '0') {
                    max = Math.max(max, dp[i][j] = matrix[i][j]-'0');
                    continue;
                }
                int k = 1;
                for (; k <= dp[i-1][j-1]; ++k) {
                    if (matrix[i][j-k] != '1' || matrix[i-k][j] != '1')
                        break;
                }
                max = Math.max(max, dp[i][j] = k);
            }
        }
        return max*max;
    }
}
