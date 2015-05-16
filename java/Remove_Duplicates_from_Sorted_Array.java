// One pass solution
// time is O(n), space is O(1)
public class Solution {
    public int removeDuplicates(int[] nums) {
        int length = 0;
        for (int i = 0 ; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            nums[length++] = nums[i]; 
        }
        return length;
    }
}
