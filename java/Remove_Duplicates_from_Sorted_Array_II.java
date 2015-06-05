// Pass the array only once
// Put the nums to the front of the array if the nums's count  doesn't  exceed 2.
// Time is O(n), space is O(1).

public class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1, len = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i-1]) {
                if (++count <= 2)
                    nums[len++] = nums[i];
            }
            else {
                count = 1;
                nums[len++] = nums[i];
            }
        }
        return nums.length == 0 ? 0 : len;
    }
}
