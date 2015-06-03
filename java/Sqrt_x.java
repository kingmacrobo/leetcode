// Binary search method
// We should round down, so if the final low^2 is greater than the x, we reduce low by one to find the answer rounded down.
// Time is O(logn), Space is O(1).
public class Solution {
    public int mySqrt(int x) {
        if (x <= 0) return 0;
        long target = x, low = 1, high = x;
        while (low < high) {
            long mid = (low+high)/2;
            if (mid*mid == target)
                return (int)mid;
            else if (mid*mid > target)
                high = mid - 1;
            else 
                low = mid + 1;
        }
        if (low * low > target)
            low--;
        return (int)low;
    }
}
