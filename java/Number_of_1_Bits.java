// n & (n-1) 
// It's a bit manipulation operation, which can put the last 1 to 0 of the value;
// Time is O(logn), space is O(1).

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != (n &(n-1))) {
            n = n & (n-1);
            count++;
        }
        return count;
    }
}
