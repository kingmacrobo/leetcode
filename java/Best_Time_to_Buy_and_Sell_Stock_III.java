// If we are allowed to take most two transactions, we can regard every point as the divide point,
// and find the before max profit and after max profit of one transaction, and then add them up.
// We can just compare every points' adding up, and find out the two transactions' answer.
// Time is O(n), space is O(n).

public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        int[] left = new int[n];
        int[] right = new int[n];
        int leftMin = prices[0], leftMax = 0, rightMax = prices[n-1], rightGap = 0;
        left[0] = right[n-1] = 0;
        for (int i = 1; i  < n; ++i) {
            if (prices[i] > leftMin) {
                leftMax = Math.max(leftMax, prices[i] - leftMin);
            }
            else {
                leftMin = prices[i];
            }
            left[i] = leftMax;
            if (prices[n - i - 1] < rightMax) {
                rightGap = Math.max(rightGap, rightMax - prices[n - i - 1]);
            }
            else {
                rightMax = prices[n - i - 1];
            }
            right[n - i - 1] = rightGap;
        }
        int max = 0;
        for (int i = 0; i < n; ++i) {
            max = Math.max(max, left[i]+right[i]);
        }
        return max;
    }
}
