// One pass solution
// Record the previous minimum point.
// Time is O(n), space is O(1).

public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0)  return 0;
        int premin = prices[0], max = 0;
        for (int i = 1; i < n; ++i) {
            if (prices[i] > premin) {
                max = Math.max(max, prices[i] - premin);
            }
            else {
                premin = prices[i];
            }
        }
        return max;
    }
}
