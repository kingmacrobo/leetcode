// Greedy method
// Time is O(n), space is O(1)

public class Solution {
    public boolean canJump(int[] nums) {
        int left = 0, right = 0;
        if (nums.length == 1) return true;
        while (left <= right) {
            int exright = right;
            for (int i = left; i <= right; ++i) {
                exright = Math.max(exright,nums[i]+i);
                if (exright >= nums.length-1) return true;
            }
            left = right+1;
            right = exright;          
        }
        return false;
    }
}
