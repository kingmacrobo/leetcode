// HashMap method
// Time O(n), space is the hashmap size.

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int a : nums) {
            if (set.contains(a)) return true;
            set.add(a);
        }
        return false;
    }
}
