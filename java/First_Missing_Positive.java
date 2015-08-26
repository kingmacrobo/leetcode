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


// Swap Sort
// Put the nums[i] to the location of nums[i]-1.
// And then scan once to find the first mismatch loc and return loc+1.
// Time is O(n), space is O(1).

public class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            while (nums[i] != i+1 && nums[i] <= nums.length) {
                if (nums[i] == i+1 || nums[i] <= 0) break;
                int k = nums[i]-1;
                if (nums[k] == k+1) break;
                swap(nums, i, k);
            }
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i+1) return i+1;
        }
        return nums.length+1;
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
