// HashMap solution.
// Time is O(n), space is the hashmap size;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (table.containsKey(nums[i])) {
                int j = table.get(nums[i]);
                if (i-j <= k) return true;
            }
            table.put(nums[i],i);
        }
        return false;
    }
}
