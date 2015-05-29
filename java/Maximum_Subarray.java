// pass once 
// We should be careful with the case when all the elements are negatives.
// Time is O(n), space is O(1).
public class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0, biggest = Integer.MIN_VALUE, count = 0;;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < 0) {
                max = Math.max(max,sum);
                biggest = Math.max(nums[i],biggest);
                count++;
            }
            sum += nums[i];
            if (sum < 0) {
                sum = 0;
            }
        }
        if (count == nums.length)
            return biggest;
        return Math.max(max,sum);
    }
}

// A simpler solution
// Also one pass
public class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = nums[0], maxSum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            curSum = Math.max(curSum+nums[i], nums[i]);
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }
}

// Some one's dp solution
// maxSubArray(int A[], int i), which means the maxSubArray for A[0:i ] which must has A[i] as the end element.
// maxSubArray(A, i) = maxSubArray(A, i - 1) > 0 ? maxSubArray(A, i - 1) : 0 + A[i]; 

public int maxSubArray(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];
        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        return max;
} 
