// DP solution
// dp[i] represents the minimum cuts of substring(i,end) of s.
// Time is O(n^2).

public class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] record = new int[n];
        boolean[][] isPalin = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            record[i] = -1;
            isPalin[i][i] = true;
            int k = i-1, t = i+1;
            while (k >= 0 && t < n) {
                if (s.charAt(k) == s.charAt(t))
                    isPalin[k--][t++] = true;
                else break;
            }
            k = i;
            t = i+1;
            while (k >= 0 && t < n) {
                if (s.charAt(k) == s.charAt(t))
                    isPalin[k--][t++] = true;
                else break;
            }
        }

        return dp(s,0,record,isPalin);
    }
    public int dp(String s, int start, int[] record, boolean[][] isPalin) {
        if (record[start] != -1)
            return record[start];
        if (start == s.length()-1) 
            return record[start] = 0;
       
        int min = Integer.MAX_VALUE;
        for (int i = start; i < s.length(); ++i) {
            if (isPalin[start][i]) {
                if (i == s.length()-1) {
                    return record[start] = 0;
                }
                min = Math.min(dp(s,i+1,record,isPalin)+1,min);
            }
        }
        return record[start] = min;
    }
}
