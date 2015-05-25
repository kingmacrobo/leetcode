// DP solution
// dp[i] = max {{dp[i+j]+1| i+j < nums.len && j <= nums[j]}}
// we should add two cases to accelerate the dp speed.
// One is if it can jump to the end directly, in other words it just jump onece;
// another one is if it can jump to the end in two jumps.
// Best Time is O(n), Worst time is O(n^2), space is O(n)
public class Solution {
    public int jump(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return 0;
        int[] dp = new int[nums.length];
        for (int i = nums.length - 2; i >= 0;--i) {
            dp[i] = Integer.MAX_VALUE-1;
            int min = Integer.MAX_VALUE-1;
            for (int j = nums[i]; j >=1 ; --j) {
                if (nums[i] + i >= nums.length-1) {
                    min = 1;
                    break;
                }
                else if (dp[i+j]==1) {
                    min = 2;
                    break;
                }
                else if (min > dp[i+j]+1) min = dp[i+j]+1;
            }
            dp[i] = min;
        }
        return dp[0];
    }
}
