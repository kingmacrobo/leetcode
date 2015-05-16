// one pass
public class Solution {
    public int removeElement(int[] nums, int val) {
        int length = 0;
        for (int i = 0 ; i < nums.length; ++i) {
            if (nums[i] == val) continue;
            nums[length++] = nums[i];
        }
        return length;
    }
}
