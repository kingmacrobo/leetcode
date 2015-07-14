// Just counting how many 5s.
// Time is O(logn), space is O(1).

public class Solution {
    public int trailingZeroes(int n) {
        long zeros = 0, base = 5, val = (long)n;
        while(val >= base) {
            zeros += val/base;
            base *= 5;
        }
        return (int)zeros;
    }
}
