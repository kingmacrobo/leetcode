// HashMap solution
// Time is O(n), space is the size of hashmap.

public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
        int n = nums.length;
        for (int a : nums) {
            if (!table.containsKey(a)) {
                table.put(a,1);
            }
            else 
                table.put(a,table.get(a)+1);
            if (table.get(a) > n/2) return a;
        }
        return 0;
    }
}
