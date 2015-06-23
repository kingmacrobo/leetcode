// DP Iteration solution
// dp[i][j] = dp[i+1][j+1] + dp[i+1][j], if s[i] == tp[j]
// dp[i][j] = dp[i+1][j], if s[i] != s[j].
// Time is O(n^2), space is O(n^2).

public class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = n; i >= 0; --i) {
            for (int j = m; j >= 0; --j) {
                dp[i][j] = 0;
                if (j == m) {
                    dp[i][j] = 1;
                    continue;
                }
                if (i == n) continue;
                if (s.charAt(i) == t.charAt(j))
                    dp[i][j] += dp[i+1][j+1];
                dp[i][j] += dp[i+1][j];
            }
        }
        return dp[0][0];
    }
}

// We can also get a recursive solution, but it will cause stackoverflow when the test case is two long.

public class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] record = new int[n][m];
        if (n == 0 || m == 0) return 0;
        for (int i = 0; i < n; ++i)
            Arrays.fill(record[i],-1);
        return dp(s,t,0,0,record);
    }
    public int dp(String s, String t, int i, int j, int[][] record) {
        if (j == t.length())
            return 1;
        if (i == s.length())
            return 0;
        if (record[i][j] != -1)
            return record[i][j];
        int result = 0;
        if (s.charAt(i) == t.charAt(j)) {
            result += dp(s,t,i+1,j+1,record);
        }
        result += dp(s,t,i+1,j,record);
        return record[i][j] = result;
    }
}
