// DP solution
// if s.charAt(i) == '0', dp[i] = 0, 
// if Integer.parseInt(s.substring(i,i+2)) <= 26, dp[i] = dp[i+1] + dp[i+2];
// else dp[i] = dp[i+1];
// Time and space are both O(n).

public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        if (n == 0) return 0;
        dp[n] = 1;
        dp[n-1] = s.charAt(n-1) == '0' ? 0 : 1;
        for (int i = n-2; i >= 0; --i) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            int two = Integer.parseInt(s.substring(i,i+2));
            dp[i] = dp[i+1];
            if (two <= 26) dp[i] += dp[i+2];
        }
        return dp[0];
    }
}
