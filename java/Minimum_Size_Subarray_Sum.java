// Window Solution!
// Move the window and resize the window to find the answer!
// Time is O(n), space is O(1).

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int a = 0, b = 0, sum = nums[0], min = 0;
        while (a < nums.length) {
            if (sum >= s) {
                if (a == b) return 1;
                min = min == 0 ? b-a+1 : Math.min(min,b-a+1);
                sum -= nums[a++];
            }
            else if (b == nums.length-1) sum -= nums[a++];
            else sum += nums[++b];
        }
        return min;
    }
}
