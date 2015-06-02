// Dp solution as Unique_Paths.
// Time and space is both O(n^2).

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) return 0;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < m+1; ++i) dp[i][0] = 0;
        for (int i = 0; i < n+1; ++i) dp[0][i] = 0;
        for (int i = 1; i < m+1; ++i)
            for (int j = 1; j < n+1; ++j) {
                if (obstacleGrid[i-1][j-1] == 1)
                    dp[i][j] = 0;
                else if (i == 1 && j == 1)
                    dp[1][1] = 1;
                else 
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        return dp[m][n];
    }
}

// we can reduce the space to O(n) by using roll array:
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] pre = new int[n+1], cur = new int[n+1];
        for (int i = 0; i < n+1; ++i) pre[i] = 0;
        pre[1] = 1;
        cur[0] = 0;
        for (int i = 1; i < m+1; ++i) {
            for (int j = 1; j < n+1; ++j) {
                if (obstacleGrid[i-1][j-1] == 1) 
                    cur[j] = 0;
                else 
                    cur[j] = cur[j-1] + pre[j];
            }
            int[] temp = pre;
            pre = cur;
            cur = temp;
        }
        return pre[n];
    }
}
