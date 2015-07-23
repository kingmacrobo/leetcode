// Continuously count the number.
// Time is O(n), space is O(n);

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if (nums.length == 0) return result;
        int start = nums[0], pre = start;
        for (int i = 1; i <= nums.length; ++i) {
            if (i == nums.length || nums[i] != pre+1) {
                if (start == pre)
                    result.add(new String(start+""));
                else 
                    result.add(new String(start+"->"+pre));
                if (i < nums.length) start = pre = nums[i];
            }
            else pre++;
        }
        return result;
    }
}
