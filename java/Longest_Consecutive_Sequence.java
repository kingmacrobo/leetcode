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

// HashMap + Dp :
// Time O(n), space O(n).

public class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
        for (int a : nums) table.put(a, 0);
        int max = 0;
        for (int a : nums) {
            max = Math.max(max, findconsecutive(table, a));
        }
        return max;
    }
    public int findconsecutive(HashMap<Integer, Integer> table, int a) {
        if (!table.containsKey(a)) return 0;
        if (table.get(a) != 0) return table.get(a);
        int k = findconsecutive(table, a+1);
        table.put(a, k+1);
        return k+1;
    }
}
