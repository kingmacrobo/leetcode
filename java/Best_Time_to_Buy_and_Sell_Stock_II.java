// One pass solution
// Just compare the current with the previous one, if there is a profit , we buy and sell at the two days respectively.
// Time is O(n), space is O(1).

public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int premin = prices[0], profit = 0;
        for (int i = 1; i < n; ++i) {
            if (prices[i] > premin)
                profit += prices[i] - premin;
            premin = prices[i];
        }
        return profit;
    }
}

// We can simplize it like this:

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int max = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] >= prices[i-1])
                max += prices[i] - prices[i-1];
        }
        return max;
    }
}
