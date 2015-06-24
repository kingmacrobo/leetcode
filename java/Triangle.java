// DP solution
// dp[i][j] = num[i][j] + min(dp[i+1][j], dp[i+1][j+1]).
// Time is O(n^2), space is O(n^2).

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n+1][n+1];
        for (int i = n; i >= 1; --i) {
            for (int j = 1; j <= i; ++j) {
                if (i == n) {
                    dp[i][j] = triangle.get(i-1).get(j-1);
                    continue;
                }
                dp[i][j] = triangle.get(i-1).get(j-1) + Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return dp[1][1];
    }
}

// We can reduce the space to O(n) by using roll array.

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n+1];
        for (int i = n; i >= 1; --i) {
            for (int j = 1; j <= i; ++j) {
                if (i == n) {
                    dp[j] = triangle.get(i-1).get(j-1);
                    continue;
                }
                dp[j] = triangle.get(i-1).get(j-1) + Math.min(dp[j],dp[j+1]);
            }
        }
        return dp[1];
    }
}
