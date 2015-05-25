// Given an array of non-negative integers, you are initially positioned at the first index of the array.

// Each element in the array represents your maximum jump length at that position.

// Your goal is to reach the last index in the minimum number of jumps.

// For example:
// Given array A = [2,3,1,1,4]

// The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)


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

// Greedy solution
// we can just find out where the longest point we can reach at each time
// time is O(n), space is O(1)
public class Solution {
    public int jump(int[] nums) {
        int steps = 0, left = 0, right = 0;
        if (nums.length == 1) return 0;
        while (left <= right) {
            steps++;
            int exright = right;
            for (int i = left ; i <= right; ++i) {
                if (i+nums[i] > exright) exright = i+nums[i];
                if (exright >= nums.length-1) return steps;
            }
            left = right + 1;
            right = exright;
        }
        return 0;
    }
}

// Another coding of the above greedy solution
public class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int steps = 1, left = 0, right = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > left) break;
            right = Math.max(right,i+nums[i]);
            if (right >= nums.length-1) return steps;
            if (i == left) {
                steps++;
                left = right;
            }
        }
        return 0;
    }
}
