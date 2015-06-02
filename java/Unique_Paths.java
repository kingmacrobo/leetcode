// Dp solution
// dp[i][j] = dp[i-1][j] + dp[i][j-1]
// we can simplify the dp process by extern the grid to m+1 * n+1
// Time is O(n^2), space is O(n^2)

public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < m+1; ++i) dp[i][0] = 0;
        for (int i = 0; i < n+1; ++i) dp[0][i] = 0;
        for (int i = 1; i <= m; ++i)
            for (int j = 1; j <= n; ++j) {
                if (i == 1 && j == 1) {
                    dp[1][1] = 1;
                    continue;
                }
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        return dp[m][n];
    }
}


// Combination Solution
// result = C(m+n-2,m-1)
// Time and space are both O(1).

public class Solution {
    public int uniquePaths(int m, int n) {
        double result = 1;
        for (int i = 1; i <= m-1; ++i) {
            result = result * (n+m-1-i) / (m-i);
        }
        return (int)Math.round(result);
    }
}
