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
