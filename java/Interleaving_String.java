// Dp solution
// dp[a][b][c] = dp[a+1][b][c+1] || dp[a][b+1][c+1]
// Time and space both are O(n^3).

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int[][][] record = new int[s1.length()+1][s2.length()+1][s3.length()+1];
        for (int i = 0; i <= s1.length(); ++i)
            for (int j = 0; j <= s2.length(); ++j)
                Arrays.fill(record[i][j],-1);
        return isInter(s1,s2,s3,0,0,0,record) == 1;
    }
    public int isInter(String s1, String s2, String s3, int a, int b, int c, int[][][] record) {
        if (record[a][b][c] != -1) return record[a][b][c];
        if (a == s1.length() && b == s2.length() && c == s3.length())
            return record[a][b][c] = 1;
        if (s1.length()-a + s2.length()-b != s3.length()-c)
            return record[a][b][c] = 0;
        if (a < s1.length() && s1.charAt(a) == s3.charAt(c) 
            && isInter(s1,s2,s3,a+1,b,c+1,record) == 1 ||
            b < s2.length() && s2.charAt(b) == s3.charAt(c)
            && isInter(s1,s2,s3,a,b+1,c+1,record) == 1) {
                return record[a][b][c] = 1;
        }
        return record[a][b][c] = 0;
    }
}
