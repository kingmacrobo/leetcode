// Bit Manipulation
// Using the first bit of each number to be the hashtable
// time is O(n), space is O(1).

public class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; ++i)
            if (nums[i] < 0) nums[i] = 0;
        for (int i = 0; i < nums.length; ++i) {
            int index = (nums[i] & 0x7fffffff) - 1;
            if (index >= 0 && index < nums.length) nums[index] |= 0x80000000;
        }
        for (int i = 0 ; i < nums.length; ++i)
            if (((nums[i] >> 31) & 0x1) == 0 )
                return i+1;
        return nums.length+1;
    }
}
