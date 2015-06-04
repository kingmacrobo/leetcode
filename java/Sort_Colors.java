// One pass solution with constant space
// Pass the array , when we come cross a 0, we swap it with the first one that we haven't set a 0 to it.
// when we come cross a 2, we swap it with the last one that we haven't set a 2 to it.

public class Solution {
    public void sortColors(int[] nums) {
        int low = 0, high = nums.length-1;
        for (int i = 0; i <= high; ++i) {
            if (nums[i] == 0) {
                nums[i] = nums[low]; 
                nums[low++] = 0;
            }
            else if (nums[i] == 2) {
                nums[i--] = nums[high];
                nums[high--] = 2;
            }
        }
    }
}
