// DP solution.
// Process two dp : the house must be robbed; the house must not be robbed, which make the problem to two house robber problems.
// Time is O(n), space is (n).

public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        return Math.max(nums[0]+solve(nums,2,nums.length-2), solve(nums,1,nums.length-1));
    }
    public int solve(int[] nums, int start, int end) {
        if (start > end) return 0;
        if (end == start) return nums[start];
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start+1] = nums[start+1];
        int preMax = dp[start], pre = dp[start+1];
        for (int i = start+2; i <= end; ++i) {
            dp[i] = preMax+nums[i];
            preMax = Math.max(pre,preMax);
            pre = dp[i];
        }
        return Math.max(dp[end],dp[end-1]);
    }
}
