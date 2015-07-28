// Calculating prefix production and suffix production.
// Time is O(n), no extra space except the output array.

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length, pre = 1, after = 1;
        int[] result = new int[n];
        for (int i = 0; i < n; ++i) {
            result[i] = pre;
            pre *= nums[i];
        }
        for (int i = n-1; i >= 0; --i) {
            result[i] *= after;
            after *= nums[i];
        }
        return result;
    }
}
