// HashMap
// Fistly, create the Hashmap of the nums
// And then, search each number in two sides to find the longest consecutive sequence.
// Time is O(n), space is the size of hashmap.

public class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> table = new HashMap<Integer,Boolean>();
        for (int i = 0; i < nums.length; ++i) 
            table.put(nums[i],true);
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (!table.get(nums[i])) continue;
            int cur = 1, val = nums[i]+1;
            while (table.containsKey(val)) {
                table.put(val,false);
                ++cur;
                val++;
            }
            val = nums[i]-1;
            while (table.containsKey(val)) {
                table.put(val,false);
                ++cur;
                val--;
            }
            max = Math.max(cur,max);
        }
        return max;
    }
}
