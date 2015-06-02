// Dp solution
// dp[i][j] = min(dp[i-1][j],dp[i][j-1]) + grid[i][j]
// we can use roll array to reduce the space to O(n)
// Time is O(n^2), space is O(n)

public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] pre = new int[n+1], cur = new int[n+1];
        for (int i = 0 ; i < n+1; ++i) {
            pre[i] = Integer.MAX_VALUE;
        }
        pre[1] = 0;
        cur[0] = Integer.MAX_VALUE;
        for (int i = 1; i < m+1; ++i) {
            for (int j = 1; j < n+1; ++j) {
                cur[j] = Math.min(pre[j],cur[j-1]) + grid[i-1][j-1];
            }
            int[] temp = pre;
            pre = cur;
            cur = temp;
        }
        return pre[n];
    }
}
