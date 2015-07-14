// Dp solution!
// dp[i][j] represents the initial value at (i,j) when starts from (i,j) to the end to save the princess successully!
// Time is O(n^2), space is O(n^2).

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m][n];
        for (int i = m-1; i >= 0; --i) {
            for (int j = n-1; j >= 0; --j) {
                if (i == m-1 && j == n-1) {
                    dp[i][j] = dungeon[i][j] >= 0 ? 1 : 1-dungeon[i][j];
                }
                else if (i == m-1) {
                    dp[i][j] = Math.max(dp[i][j+1] - dungeon[i][j], 1);
                }
                else if (j == n-1) {
                    dp[i][j] = Math.max(dp[i+1][j] - dungeon[i][j], 1);
                }
                else {
                    dp[i][j] = Math.min(Math.max(dp[i+1][j]-dungeon[i][j],1), Math.max(dp[i][j+1]-dungeon[i][j],1));
                }
            }
        }
        return dp[0][0];
    }
}

//We can reduce the dp space to O(n) by using rolling array!

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[] current = new int[n];
        int[] pre = new int[n];
        for (int i = m-1; i >= 0; --i) {
            for (int j = n-1; j >= 0; --j) {
                if (i == m-1 && j == n-1) {
                    current[j] = dungeon[i][j] >= 0 ? 1 : 1-dungeon[i][j];
                }
                else if (i == m-1) {
                    current[j] = Math.max(current[j+1] - dungeon[i][j], 1);
                }
                else if (j == n-1) {
                    current[j] = Math.max(pre[j] - dungeon[i][j], 1);
                }
                else {
                    current[j] = Math.min(Math.max(pre[j]-dungeon[i][j],1), Math.max(current[j+1]-dungeon[i][j],1));
                }
            }
            int[] temp = pre;
            pre = current;
            current = pre;
        }
        return pre[0];
    }
}
