// Dp solution
// dp[i] = max{dp[j]|j <= i-2};
// Time is O(n^2), space is O(1).

public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i) {
            if (i < 2) dp[i] = nums[i];
            else {
                int max = 0;
                for (int j = 0; j <= i-2; j++)
                    max = Math.max(max,dp[j]);
                dp[i] = max + nums[i];
            }
        }
        if (n == 1) return nums[0];
        return Math.max(dp[n-2],dp[n-1]);
    }
}
