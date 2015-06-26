// Dp solution :
// local[i][j] = Max {global[i-1][j-1]+max(diff,0), local[i-1][j] + diff}
// global[i][j] = Max {global[i-1][j], local[i][j]}

// 2D dp :
// Time is O(n*k), space is O(n*k)
public class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[][] local = new int[n][k+1];
        int[][] global = new int[n][k+1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= k; ++j) {
                if (i == 0 || j == 0) {
                    local[i][j] = 0;
                    global[i][j] = 0;
                    continue;
                }
                int diff = prices[i] - prices[i-1];
                local[i][j] = Math.max(global[i-1][j-1] + Math.max(diff,0), local[i-1][j] + diff);
                global[i][j] = Math.max(local[i][j],global[i-1][j]);
            }
        }
        return global[n-1][k];
    }
}

// we can reduce the space to O(k) by rolling array.

public class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[] local = new int[k+1];
        int[] global = new int[k+1];
        for (int i = 0; i < n; ++i) {
            for (int j = k; j >= 0; --j) {
                if (i == 0 || j == 0) {
                    local[j] = 0;
                    global[j] = 0;
                    continue;
                }
                int diff = prices[i] - prices[i-1];
                local[j] = Math.max(global[j-1] + Math.max(diff,0), local[j] + diff);
                global[j] = Math.max(local[j],global[j]);
            }
        }
        return global[k];
    }
}
