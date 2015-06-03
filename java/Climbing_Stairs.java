// Fabonacii, dp
// dp[i] = dp[i-1] + dp[i-2]
// time is O(n), space is O(1)

public class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        if (n == 0 || n == 1) return n;
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; ++i)
            dp[i] = dp[i-1] + dp[i-2];
        return dp[n-1];
    }
}
