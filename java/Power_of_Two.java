// n & (n-1) : to make the last 1 to be 0.
// Time is O(1), space is O(1).

public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n <= 0 ? false : (n & (n-1)) == 0;
    }
}
